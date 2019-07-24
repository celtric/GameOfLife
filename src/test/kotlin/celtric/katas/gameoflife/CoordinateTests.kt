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

    private fun neighboursOf(foo: Int, bar: Int): Any { TODO() }
    private fun Any.assertSize(foo: Int) { TODO() }
    private fun Any.assertContains(foo: Int, bar: Int) { TODO() }
}
