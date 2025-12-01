fun main() {
    fun part1(input: List<String>): Int {
        var dial = 50
        var zeroCount = 0
        for (rotation in input) {
            val direction = rotation[0]
            val angle = rotation.substring(1).toInt()

            for (x in 1..angle ) {
                if (direction == 'L') {
                    if (dial == 0) {
                        dial = 100
                    }
                    dial--
                } else if (direction == 'R') {
                    if (dial == 100) {
                        dial = 0
                    }
                    dial++
                }
            }
            if (dial == 0 || dial == 100) {
                zeroCount++
            }
        }
        return zeroCount
    }

    fun part2(input: List<String>): Int {
        var dial = 50
        var zeroCount = 0
        for (rotation in input) {
            val direction = rotation[0]
            val angle = rotation.substring(1).toInt()

            for (x in 1..angle ) {
                if (direction == 'L') {
                    if (dial == 0) {
                        dial = 100
                    }
                    dial--
                } else if (direction == 'R') {
                    if (dial == 100) {
                        dial = 0
                    }
                    dial++
                }
                if (dial == 0 || dial == 100) {
                    zeroCount++
                }
            }
        }
        return zeroCount
    }

    val testInput = readInput("day01-test")
    val input = readInput("day01")

    check(part1(testInput) == 3)
    println(part1(input))

    check(part2(testInput) == 6)
    println(part2(input))
}