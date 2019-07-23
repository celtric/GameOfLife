package celtric.katas.gameoflife

data class Coordinate(private val x: Int, private val y: Int) {

    fun neighbours(): Set<Coordinate> =
        range(x)
            .flatMap { x -> range(y).map { y -> Coordinate(x, y) } }
            .filter { coord -> this != coord }
            .toSet()

    private fun range(n: Int): Set<Int> =
        (n - 1..n + 1).toSet()

    fun isNextGenerationAlive(aliveCells: Set<Coordinate>): Boolean =
        neighbourhood(aliveCells).isNextGenerationAlive(aliveCells.contains(this))

    private fun neighbourhood(aliveCells: Set<Coordinate>): Neighbourhood =
        Neighbourhood(liveCells = neighbours().filter { aliveCells.contains(it) }.count())
}
