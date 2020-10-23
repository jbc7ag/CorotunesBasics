import kotlinx.coroutines.*

fun main(){

    runBlocking {
        launch(CoroutineName("myCoroutine")) {
            print("This is run from ${coroutineContext.get(CoroutineName)}")
        }
    }
}