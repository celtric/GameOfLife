package celtric.katas.gameoflife

class Cell(val isAlive: Boolean) {
    fun nextGeneration(withNeighbours: Int): Cell {
        if (isAlive && withNeighbours < 2) {
            return Cell(false)
        }
        if (isAlive && (2..3).contains(withNeighbours)) {
            return Cell(true)
        }
        if (isAlive && withNeighbours > 3) {
            return Cell(false)
        }
        if (!isAlive && withNeighbours == 3) {
            return Cell(true)
        }
        return Cell(false)
    }
}