import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.IndexOutOfBoundsException

fun main(){

    runBlocking {

        //Launch
        val myHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception handled: ${throwable.localizedMessage}")

        }

        val job = GlobalScope.launch(myHandler) {
            println("Throwing an exception from Job")
            throw IndexOutOfBoundsException("IndexOutOfBoundsException thrown")
        }
        job.join()

        //Async

        val deferred = GlobalScope.async {
            println("Throwing an exception from async")
            throw ArithmeticException("Exception thrown")
        }

        try {
            deferred.await()
        }catch (e: ArithmeticException){
            println("Caught ArithmeticException: ${e.localizedMessage}")
        }


    }
}