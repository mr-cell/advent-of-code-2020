fun main() {
    fun part1(input: List<String>): Int {
        val entries = input.map { it.toInt() }
        for ((index, entry) in entries.withIndex()) {
            for (candidate in entries.drop(index + 1)) {
                if (entry + candidate == 2020) {
                    return entry * candidate
                }
            }
        }
        return 0
    }

    fun part2(input: List<String>): Int {
        val entries = input.map { it.toInt() }
        for ((index, entry) in entries.withIndex()) {
            val restEntries = entries.drop(index + 1)
            for ((candidateIndex, candidate1) in restEntries.withIndex()) {
                for (candidate2 in restEntries.drop(candidateIndex + 1)) {
                    if (entry + candidate1 + candidate2 == 2020) {
                        return entry * candidate1 * candidate2
                    }
                }
            }
        }
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    val result = part1(testInput)
    println(result)
    println("=========")
    check(result == 514579)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
