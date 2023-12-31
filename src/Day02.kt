fun main() {
    fun parse (input: List<String>) = input.map{ it ->
        val (game, sets) = it.split(":")
        val id = game.split(" ")[1].toInt()

        sets.split(";").map { set ->
            val red = "(\\d+) red".toRegex().find(set)?.groupValues?.get(1)?.toInt() ?: 0
            val green = "(\\d+) green".toRegex().find(set)?.groupValues?.get(1)?.toInt() ?: 0
            val blue = "(\\d+) blue".toRegex().find(set)?.groupValues?.get(1)?.toInt() ?: 0

            mapOf("red" to red, "green" to green, "blue" to blue)

        }.let { set ->

            val red = set.maxBy { it["red"] ?: 0 }["red"]?:0
            val green = set.maxBy { it["green"] ?: 0 }["green"]?:0
            val blue = set.maxBy { it["blue"] ?: 0 }["blue"]?:0

            id to (red * green * blue)
        }
    }

    fun part1(input: List<String>): Int {
        val limits = mapOf("blue" to 14, "green" to 13, "red" to 12)
        return input.filter { s ->
            s.substringAfter(": ").split("; ").forEach { result ->
                result.split(", ").forEach { cube ->
                    val color = cube.substringAfter(" ")
                    val count = cube.substringBefore(" ").toInt()
                    if (checkNotNull(limits[color]) < count) return@filter false
                }
            }
            true
        }.sumOf { it.substringAfter("Game ").substringBefore(":").toInt() }
    }
    fun part2(input: List<String>):Int =
        parse(input).sumOf { it.second }

    val input = readInput("Day02_test/input0")

    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}