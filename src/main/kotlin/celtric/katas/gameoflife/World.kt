package celtric.katas.gameoflife

data class World(private val aliveCells: Collection<Coordinate> = emptyList()) {
    fun evolve(): World {
        return World(aliveCells.filter { Cell(true).nextGeneration(numberOfNeighboursOf(it)).isAlive })
    }

    fun containsAliveCells(): Boolean {
        return !aliveCells.isEmpty()
    }

    fun with(coordinate: Coordinate): World {
        return World(aliveCells + coordinate)
    }

    fun numberOfAliveCells(): Int {
        return aliveCells.size
    }

    fun isAlive(coordinate: Coordinate): Boolean {
        return aliveCells.contains(coordinate)
    }

    fun numberOfNeighboursOf(coordinate: Coordinate): Int {
        return coordinate.neighbours().filter { aliveCells.contains(it) }.size
    }
}