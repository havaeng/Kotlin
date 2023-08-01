package NumbersCLI

import kotlin.random.Random

fun main(args: Array<String>) {
    println("Welcome! Please make a choice: ")

    do {
        val firstNumber = Random.nextInt(1,99)
        val secondNumber = Random.nextInt(1,99)
        val thirdNumber = Random.nextInt(1,99)
        val fourthNumber = Random.nextInt(1,99)
        val fifthNumber = Random.nextInt(1,99)


        println("\nPlease make a choice. Your numbers are: " +
                "$firstNumber " +
                "$secondNumber " +
                "$thirdNumber " +
                "$fourthNumber " +
                "$fifthNumber")
        println("" +
                "1 - Calculate the sum\n" +
                "2 - Calculate the average \n" +
                "3 - Find min and max\n" +
                "4 - Exit program\n" +
                "Input: ")

        val choice: Int? = readLine()?.toIntOrNull()

        when(choice){
            1 -> {
                println("Sum: " + calcSum(firstNumber,secondNumber, thirdNumber, fourthNumber, firstNumber))
            }
            2 -> {
                println("Average: " + calAvg(firstNumber,secondNumber, thirdNumber, fourthNumber, firstNumber))
            }
            3 -> {
                println(findMinAndMax(firstNumber,secondNumber, thirdNumber, fourthNumber, firstNumber))
            }
            4 -> {
                println("Bye!")
            }
            else -> {
                "Wrong input. Try again."
            }
        }
    } while (choice != 4)
}

fun calcSum(first : Int, second : Int, third : Int, fourth : Int, fifth : Int) : Int {
    return first + second + third + fourth + fifth
}

fun calAvg(first : Int, second : Int, third : Int, fourth : Int, fifth : Int) : Int {
    return (first + second + third + fourth + fifth) / 5
}

fun findMinAndMax(first : Int, second : Int, third : Int, fourth : Int, fifth : Int) : String {
    var minimum = 100
    var maximum = 0
    val list: ArrayList<Int> = ArrayList()
    list.add(first)
    list.add(second)
    list.add(third)
    list.add(fourth)
    list.add(fifth)

    for (i in list)
        if (i > maximum)
            maximum = i

    for (i in list)
        if (i < minimum)
            minimum = i

    return "Minimum: $minimum\nMaximum: $maximum";
}

fun addSparkles(string: String): String {
    return string.plus(" is the new thing")
}
