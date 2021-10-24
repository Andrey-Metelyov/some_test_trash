package threadtest

fun main() {
    println("Hello Main")

    val helloThread2 = HelloThread2()
    helloThread2.start()

    val helloThread1 = HelloThread1()
    helloThread1.start()
}

class HelloThread1 : Thread() {
    override fun run() {
        println("Hello from Thread-1")
        val helloThread2 = HelloThread2()
        helloThread2.start()
    }
}

class HelloThread2 : Thread() {
    override fun run() {
        Thread.sleep(1000)
        println("Hello from Thread-2")
    }
}