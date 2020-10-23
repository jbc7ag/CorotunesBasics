import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){

    runBlocking {
        var job1 = launch {

            //delay(3000L)
            println("job1 launched")

            var job2 = launch{
                println("job2 launched")
                delay(3000L)
                println("job2 finishing")

            }
            job2.invokeOnCompletion { println("job2 completed") }

            var job3 = launch{
                println("job3 launched")
                delay(3000L)
                println("job3 finishing")

            }
            job3.invokeOnCompletion { println("job3 completed") }

        }

        job1.invokeOnCompletion {
            println("job1 Completed")
        }


        delay(500L)
        println("job1 will be cancelled")
        job1.cancel()


    }
}