import java.io.File
import java.io.IOException
import java.util.*
import kotlin.contracts.contract


fun getListOfNumbersFromTxt(): MutableList<List<Int>> {
    val numberList = mutableListOf<List<Int>>();
    try {
        val scanner = Scanner(File("./src/Day01.txt"));
        while (scanner.hasNext()) {
            val line : String = scanner.nextLine();
            val liste = mutableListOf(line);
            val listForNumberEachLine = mutableListOf<Int>();
            for (elem in liste) {
                val c = elem.toCharArray();
                for (char in c) {
                    if (char.isDigit()) {
                        listForNumberEachLine.add(char - '0');
                    }
                }
            }
            numberList.add(listForNumberEachLine);

        }
        return numberList;


    } catch (e : IOException) {
        e.printStackTrace();
    }
    return numberList;
}

fun getTotalSum(liste: MutableList<List<Int>>) : Int {
    var sum = 0
    for (subList in liste) {
        when {
            subList.isEmpty() -> continue // Skip if the sublist is empty
            subList.size == 1 -> sum += subList[0] // Add the single digit if only one digit is present
            else -> {
                val first = subList.first()
                val last = subList.last()
                sum += "$first$last".toInt() // Concatenate first and last digits
            }
        }
    }
    return sum
}
fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day01")
    println(part1(input))
    val listeTest = listOf(1, 2, 3, 4)
    val doubleList = mutableListOf(listeTest);
    doubleList.add(mutableListOf(1, 2))
    doubleList.add(mutableListOf(1))
    print(getTotalSum(getListOfNumbersFromTxt()))

}
