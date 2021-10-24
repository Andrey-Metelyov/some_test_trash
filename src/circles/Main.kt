package circles

import java.awt.Color
import java.awt.image.BufferedImage

fun drawCircles(): BufferedImage {
    val height: Int = 200
    val width: Int = 200
    val image = BufferedImage(height, width, BufferedImage.TYPE_INT_RGB)
    val graphics = image.createGraphics()
    val coord = arrayOf(
        Triple(50, 50, Color.RED),
        Triple(50, 75, Color.YELLOW),
        Triple(75, 50, Color.GREEN),
        Triple(75, 75, Color.BLUE))
    graphics.color = Color.RED
    for (el in coord) {
        val x = el.first
        val y = el.second
        val c = el.third
        graphics.color = c
        graphics.drawOval(x, y, 100, 100)
    }
    return image
}

fun drawLines(): BufferedImage {
    val height: Int = 200
    val width: Int = 200
    val image = BufferedImage(height, width, BufferedImage.TYPE_INT_RGB)
    val graphics = image.createGraphics()
    val coord = arrayOf(
        Pair(arrayOf(0, 0, 200, 200), Color.RED),
        Pair(arrayOf(200, 0, 0, 200), Color.GREEN)
    )
    for (el in coord) {
        val x1 = el.first[0]
        val y1 = el.first[1]
        val x2 = el.first[2]
        val y2 = el.first[3]
        val c = el.second
        graphics.color = c
        graphics.drawLine(x1, y1, x2, y2)
    }
    return image
}