package celtric.katas.gameoflife

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CoordinateTests {

    @Test fun `neighbouring coordinates can be derived given a coordinate`() {
        val neighbours = neighboursOf(0, 0)

        assertEquals(8, neighbours.size)
        assertTrue(neighbours.containsAll(listOf(
            Pair(-1, -1),
            Pair( 0, -1),
            Pair( 1, -1),
            Pair(-1,  0),
            Pair( 1,  0),
            Pair(-1,  1),
            Pair( 0,  1),
            Pair( 1,  1))))
    }

    private fun neighboursOf(x: Int, y: Int): Collection<Pair<Int, Int>> =
        Coordinate(x, y).neighbours().map { Pair(it.x, it.y) }
}
