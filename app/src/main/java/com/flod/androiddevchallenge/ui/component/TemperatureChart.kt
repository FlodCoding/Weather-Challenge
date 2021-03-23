package com.flod.androiddevchallenge.ui.component

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.AndroidPath
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * unfinished, maybe can more flexible
 */
@Composable
fun TemperatureChart(
    modifier: Modifier = Modifier,

    /*Pair first is x axis index, second is y axis value*/
    list: List<Pair<String, Number>>,
    textStyle: TextStyle = MaterialTheme.typography.body2,
    scaleX: Dp = 60.dp,
    linePadding: Dp = 20.dp,
    lineColor: Color = Color(0xFFbdbdbd),
    /*(from = 0.0, to = 1.0)*/
    smoothness: Float = 0.5f,
    innerSpacer: Dp = 10.dp
) {


    val density = LocalDensity.current.density
    val scaleXPx = density * scaleX.value
    val textPaddingPx = density * linePadding.value

    val min = list.minByOrNull { it.second.toFloat() }?.second?.toFloat() ?: return
    val max = list.maxByOrNull { it.second.toFloat() }?.second?.toFloat() ?: return
    if ((max - min) <= 0f) return


    val path = AndroidPath()
    val paint = Paint()

    val textSizePx = with(LocalDensity.current) { textStyle.fontSize.toPx() }
    paint.isAntiAlias = true
    paint.textSize = textSizePx
    paint.color = textStyle.color.takeOrElse { LocalContentColor.current }.toArgb()


    val innerSpacerPx = density * innerSpacer.value
    val offsetX = textSizePx + innerSpacerPx
    val offsetY = textPaddingPx + textSizePx + innerSpacerPx

    Layout(modifier = modifier.horizontalScroll(rememberScrollState()),
        content = {
            Canvas(
                modifier = Modifier.fillMaxSize()
            ) {


                var lastX = 0f
                var lastY = 0f
                var lastControlX = 0f
                var lastControlY = 0f


                val curveHeight = size.height - (offsetY) * 2
                val bottomTextY = size.height - innerSpacerPx

                list.onEachIndexed { index, pair ->
                    val fractionY = (max - pair.second.toFloat()) / (max - min)
                    val x = index * scaleXPx + offsetX
                    val y = fractionY * curveHeight + offsetY

                    when (index) {
                        0 -> {
                            //first point
                            path.moveTo(x - textSizePx, y)

                            lastControlX = scaleXPx * smoothness
                            lastControlY = y

                        }
                        list.size - 1 -> {
                            //last point

                            val controlX = x - (x - lastX) * smoothness
                            path.cubicTo(lastControlX, lastControlY, controlX, y, x + textSizePx, y)


                        }
                        else -> {
                            //mid point

                            val next = list[index + 1]
                            val nextFractionY = (max - next.second.toFloat()) / (max - min)
                            val nextX = x + scaleXPx + offsetY
                            val nextY = nextFractionY * curveHeight + offsetY

                            val k = (nextY - lastY) / (nextX - lastX)
                            val b = y - k * x

                            val controlX = x - (x - lastX) * smoothness
                            val controlY = k * controlX + b
                            if (y == lastY) {
                                path.lineTo(x, y)
                            } else {
                                path.cubicTo(lastControlX, lastControlY, controlX, controlY, x, y)
                            }



                            lastControlX = x + scaleXPx * smoothness
                            lastControlY = k * lastControlX + b

                        }
                    }


                    //drawText
                    drawIntoCanvas {

                        val topY = y - textPaddingPx
                        //val bottomY = y + textPaddingPx + textSizePx

                        val topOffsetX = paint.measureText(pair.second.toString()) / 2
                        val bottomOffsetX = paint.measureText(pair.first) / 2

                        it.nativeCanvas.drawText("${pair.second.toInt()}°", x - topOffsetX, topY, paint)
                        it.nativeCanvas.drawText(pair.first, x - bottomOffsetX, bottomTextY, paint)

                    }


                    lastX = x
                    lastY = y
                }


                drawPath(path = path, color = lineColor, style = Stroke(5f))


            }
        }) { measurables, constraints ->
        val width = (list.size - 1) * scaleXPx + offsetX * 2
        layout(width.toInt(), constraints.maxHeight) {
            val placeable = measurables[0].measure(constraints)
            placeable.place(0, 0)
        }
    }
}