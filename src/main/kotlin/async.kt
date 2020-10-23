import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main(){

    runBlocking {
        val firstDeferred = GlobalScope.async { getFirstValue() }
        val secondDeferred= GlobalScope.async {getSecondValue() }

        println("Doing something here..")
        delay(1000L)
        println("Waiting for values: ")

        val firstValue = firstDeferred.await()
        val secondValue = secondDeferred.await()

        println("The total of is ${ firstValue + secondValue}")

    }
}

suspend fun getFirstValue(): Int{

    delay(1000L)
    val value = Random.nextInt(100);
    println("Returning first value $value")

    return value
}

suspend fun getSecondValue(): Int{
    delay(2000L)
    val value = Random.nextInt(100)
    println("Returning Second Value $value")

    return value
}