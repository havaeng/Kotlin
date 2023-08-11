/**
 * A simple multithreaded program that checks if the given input number is a prime number.
 */

package primeNumberFinder

// Keyword "object" in Kotlin == Singleton
object PrimeChecker {
    fun isPrime(n : Int) : Boolean {
        if (n <= 1) return false
        for (i in 2 until n)
            if (n % i == 0) return false
        return true
    }
}

fun main()  {
    val start = 1
    val end = 100000
    val threadCount = 4
    val primes: ArrayList<Int> = ArrayList()
    val startTime = System.currentTimeMillis()

    println("Checking for primes between $start and $end...")

    val numbersPerCore = (end - start + 1) / threadCount
    // MutableListOf ??
    val threads = mutableListOf<Thread>()

    for (i in 0 until threadCount){
        val numbersGroupStart = start + i * numbersPerCore

        //Tricky
        val numbersGroupEnd = if (i == threadCount - 1) end else numbersGroupStart + numbersPerCore

        val thread = Thread {
            for (n in numbersGroupStart..numbersGroupEnd) {
                if (PrimeChecker.isPrime(n)) {
                    synchronized(primes) {
                        primes.add(n)
                    }
                }
            }
        }
        threads.add(thread)
        thread.start()
    }

    for (thread in threads) thread.join()

    primes.sort()

    var primeCount = 0

    /*
    for (i in primes) {
        print("$i ")
        primeCount++

        if (primeCount % 10 == 0){
            println()
        }
    }
    */
    val endTime = System.currentTimeMillis()

    println("\nPrimes found: ${primes.size} \nTime lapsed: ${endTime - startTime}")
}