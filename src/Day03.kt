fun main() {

    fun part1(input: List<String>): Int {
        var joltage = 0
        for (battery in input) {
            var part1 = 0
            var index = 0

            for (i in 0..<battery.length - 1) {
                val number = battery[i].toString().toInt()
                if (number > part1) {
                    part1 = number
                    index = i
                }
            }

            var part2 = 0

            for (i in index + 1..<battery.length) {
                val number = battery[i].toString().toInt()
                if (number > part2) {
                    part2 = number
                }
            }

            joltage += "$part1$part2".toInt()
        }
        return joltage
    }

    fun part2(input: List<String>): Long {
    }

    val testInput = listOf("987654321111111", "811111111111119", "234234234234278", "818181911112111")
    val input = readInput("day03")

    check(part1(testInput) == 357)
    part1(input).println()


    check(part2(testInput) == 3121910778619)
    part2(input).println()
}