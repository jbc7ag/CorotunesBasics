import kotlinx.coroutines.*

fun main(){

    runBlocking {

       /* launch(Dispatchers.Main) {
            println("Main Dispatcher. Thread: ${Thread.currentThread().name}")
        }*/

        launch(Dispatchers.IO) {
            println("IO Dispatcher. Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default Dispatcher. Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined Dispatcher 1. Thread: ${Thread.currentThread().name}")
            delay(100L)
            println("Unconfined Dispatcher 2. Thread: ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("myThread")) {
            println("newSingleThreadContext. Thread: ${Thread.currentThread().name}")
        }
    }
}