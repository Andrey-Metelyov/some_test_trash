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