fun main() {

    fun part1(input: List<String>): Int {
        var paperRollCount = 0

        val positions = arrayOf(
            Pair(-1, -1),
            Pair(-1, 0),
            Pair(0, -1),
            Pair(1, -1),
            Pair(1, 0),
            Pair(1, 1),
            Pair(0, 1),
            Pair(-1, 1)
        )

        for (i in 0 until input.size) {
            for (j in 0 until input.first().length) {
                if (input[i][j] != '@') {
                    continue
                }

                var currentRollCount = 0
                for (position in positions) {
                    val newI = i + position.first
                    val newJ = j + position.second
                    if (newI < 0 || newI >= input.size || newJ < 0 || newJ >= input.size) {
                        continue
                    }
                    if (input[newI][newJ] == '@') {
                        currentRollCount++
                    }
                }

                if (currentRollCount < 4) {
                    paperRollCount++
                }
            }
        }
        return paperRollCount
    }

    fun part2(input: List<String>): Int {
        var overallRollsRemoved = 0

        val positions = arrayOf(
            Pair(-1, -1),
            Pair(-1, 0),
            Pair(0, -1),
            Pair(1, -1),
            Pair(1, 0),
            Pair(1, 1),
            Pair(0, 1),
            Pair(-1, 1)
        )

        var currentRollsRemoved: Int

        var inputCharArr = Array(input.size) { CharArray(input.first().length) }

        for (i in 0 until input.size) {
            for (j in 0 until input.first().length) {
                inputCharArr[i][j] = input[i][j]
            }
        }

        do {
            currentRollsRemoved = 0
            for (i in 0 until input.size) {
                for (j in 0 until input.first().length) {
                    if (inputCharArr[i][j] != '@') {
                        continue
                    }

                    var currentRollCount = 0
                    for (position in positions) {
                        val newI = i + position.first
                        val newJ = j + position.second
                        if (newI < 0 || newI >= input.size || newJ < 0 || newJ >= input.size) {
                            continue
                        }
                        if (inputCharArr[newI][newJ] == '@') {
                            currentRollCount++
                        }
                    }

                    if (currentRollCount < 4) {
                        inputCharArr[i][j] = 'x'
                        currentRollsRemoved++
                    }
                }
            }

            overallRollsRemoved += currentRollsRemoved
        } while (currentRollsRemoved > 0)

        return overallRollsRemoved
    }

    val testInput = listOf(
        "..@@.@@@@.",
        "@@@.@.@.@@",
        "@@@@@.@.@@",
        "@.@@@@..@.",
        "@@.@@@@.@@",
        ".@@@@@@@.@",
        ".@.@.@.@@@",
        "@.@@@.@@@@",
        ".@@@@@@@@.",
        "@.@.@@@.@."
    )
    val input = readInput("day04")

    check(part1(testInput) == 13)
    part1(input).println()


    check(part2(testInput) == 43)
    part2(input).println()
}