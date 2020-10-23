import kotlinx.coroutines.*

fun main(){

    GlobalScope.launch {
        delay(1000)
        println("World!")
    }

    print("Hello, ")
    Thread.sleep(2000)
}
