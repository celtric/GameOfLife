package celtric.katas.gameoflife

data class Game(private val aliveCells: MutableSet<Coordinate> = emptySet<Coordinate>().toMutableSet()) {

    fun addCell(x: Int, y: Int) {
        aliveCells.add(Coordinate(x, y))
    }

    fun isAlive(x: Int, y: Int): Boolean =
        aliveCells.contains(Coordinate(x, y))

    fun evolve(times: Int): Game =
        if (times == 1) evolve() else evolve(times - 1).evolve()

    fun evolve(): Game = aliveCells
        .flatMap { c -> c.neighbours() }
        .filter { c -> c.isNextGenerationAlive(aliveCells) }
        .toMutableSet()
        .let { Game(it) }
}
