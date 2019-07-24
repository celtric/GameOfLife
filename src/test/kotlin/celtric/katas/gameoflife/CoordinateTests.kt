package celtric.katas.gameoflife

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CoordinateTests {

    @Test fun `neighbouring coordinates can be derived given a coordinate`() {
        val neighbours = neighboursOf(0, 0)

        neighbours.assertSize(8)
        neighbours.assertContains(-1, -1)
        neighbours.assertContains( 0, -1)
        neighbours.assertContains( 1, -1)
        neighbours.assertContains(-1,  0)
        neighbours.assertContains( 1,  0)
        neighbours.assertContains(-1,  1)
        neighbours.assertContains( 0,  1)
        neighbours.assertContains( 1,  1)
    }

    //---[ To remove before starting kata ]---------------------------------------------//

    private class Neighbours(private val coordinates: Collection<Coordinate>) {

        fun assertSize(expected: Int) {
            assertEquals(expected, coordinates.size)
        }

        fun assertContains(x: Int, y: Int) {
            assertTrue(coordinates.contains(Coordinate(x, y)))
        }
    }

    private fun neighboursOf(x: Int, y: Int): Neighbours =
        Neighbours(Coordinate(x, y).neighbours())
}
