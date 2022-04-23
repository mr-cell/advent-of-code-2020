fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { PasswordEntry.of(it) }
            .count { entry ->
                entry.password.count { it == entry.character } in entry.range
            }
    }

    fun part2(input: List<String>): Int {
        return input
            .map { PasswordEntry.of(it) }
            .count {
                (it.password[it.range.first - 1] == it.character) xor
                        (it.password[it.range.last - 1] == it.character)
            }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    val result = part1(testInput)
    println(result)
    println("=========")
    check(result == 2)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

data class PasswordEntry(
    val range: IntRange,
    val character: Char,
    val password: String,
) {
    companion object {
        private val pattern = """^(\d+)-(\d+) (\w): (.+)$""".toRegex()

        fun of(input: String): PasswordEntry {
            val (min, max, letter, password) = pattern.find(input)!!.destructured
            return PasswordEntry(min.toInt()..max.toInt(), letter.first(), password)
        }
    }
}