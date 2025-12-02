fun main() {
    fun part1(input: String): Long {
        val ranges = input.split(",")
        var invalidIdsSum = 0L

        for (range in ranges) {
            val splitRange = range.split("-")
            val start = splitRange.first().toLong()
            val end = splitRange.last().toLong()

            for (i in start..end) {
                val strNumber = i.toString()
                val part1 = strNumber.take(strNumber.length / 2)
                val part2 = strNumber.substring(strNumber.length / 2, strNumber.length)

                if (part1 == part2) {
                    invalidIdsSum += i
                }
            }
        }
        return invalidIdsSum
    }

    fun part2(input: String): Long {
        val ranges = input.split(",")
        var invalidIdsSum = 0L

        for (range in ranges) {
            val splitRange = range.split("-")
            val start = splitRange.first().toLong()
            val end = splitRange.last().toLong()

            for (i in start..end) {
                val strNumber = i.toString()

                for (j in 1..strNumber.length / 2) {
                    val sequence = strNumber.take(j)

                    var numberToCompare = ""
                    for (k in 1..strNumber.length / j) {
                        numberToCompare += sequence
                    }

                    if (strNumber == numberToCompare) {
                        invalidIdsSum += i
                        break
                    }
                }
            }
        }

        return invalidIdsSum
    }

    val testInput = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"
    val input = readInput("day02")[0]

    check(part1(testInput) == 1227775554L)
    part1(input).println()

    check(part2(testInput) == 4174379265L)
    part2(input).println()
}