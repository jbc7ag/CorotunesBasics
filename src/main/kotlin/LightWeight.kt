import kotlinx.coroutines.*

fun main(){

    runBlocking {
        repeat(1_000_000){
            launch {
                print(".")
            }
        }
    }
}