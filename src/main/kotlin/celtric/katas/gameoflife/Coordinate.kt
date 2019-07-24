package celtric.katas.gameoflife

data class Coordinate(val x: Int, val y: Int) {
    fun neighbours(): Collection<Coordinate> {
        return listOf(
            Coordinate(x - 1, y - 1),
            Coordinate(x - 0, y - 1),
            Coordinate(x + 1, y - 1),
            Coordinate(x - 1, y - 0),
            Coordinate(x + 1, y - 0),
            Coordinate(x - 1, y + 1),
            Coordinate(x - 0, y + 1),
            Coordinate(x + 1, y + 1))
    }
}