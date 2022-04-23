fun main() {
    fun part1(input: List<String>): Int {
        val entries = input.map { it.toInt() }.sorted()
        return entries
            .mapIndexedNotNull { idx, a ->
                entries
                    .drop(idx + 1)
                    .dropWhile { a + it < 2020 }
                    .take(1)
                    .firstOrNull { a + it == 2020 }
                    ?.let { a * it }
            }.first()
    }

    fun part2(input: List<String>): Int {
        val entries = input.map { it.toInt() }.sorted()
        return entries.mapIndexedNotNull { idx, a ->
            val restEntries = entries.drop(idx + 1)
            restEntries.mapIndexedNotNull { idx2, b ->
                restEntries.drop(idx2 + 1)
                    .dropWhile { a + b + it < 2020 }
                    .take(1)
                    .firstOrNull { a + b + it == 2020 }
                    ?.let { a * b * it }
            }.firstOrNull()
        }.first()
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
