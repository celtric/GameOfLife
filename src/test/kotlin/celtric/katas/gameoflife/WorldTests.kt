package celtric.katas.gameoflife

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WorldTests {

    @Test fun `a world starts empty`() {
        world().assertContainsNoAliveCells()
    }

    @Test fun `an empty world stays empty`() {
        world().evolve().assertContainsNoAliveCells()
    }

    @Test fun `new cells can be manually added`() {
        val world = world().with(Coordinate(0, 0))

        world.assertContainsAliveCells(1)
        world.assertContainsAliveCells(Coordinate(0, 0))
    }

    @Test fun `a world knows how many alive neighbours a given cell has`() {
        val world = world()
            .with(Coordinate(0, 0))
            .with(Coordinate(1, 0))
            .with(Coordinate(2, 0))

        world.assertCoordinateHasNeighbours(Coordinate(1, 0), 2)
    }

    @Test fun `evolution rules are applied in each generation`() {
        val firstGeneration = world()
            .with(Coordinate(0, 0))
            .with(Coordinate(1, 0))
            .with(Coordinate(2, 0))

        val secondGeneration = firstGeneration.evolve()

        secondGeneration.assertContainsAliveCells(3)
        secondGeneration.assertContainsAliveCells(Coordinate(1, -1))
        secondGeneration.assertContainsAliveCells(Coordinate(1, 0))
        secondGeneration.assertContainsAliveCells(Coordinate(1, 1))
    }

    private fun world(): World {
        return World()
    }

    private fun World.assertContainsNoAliveCells() {
        assertFalse(world().containsAliveCells())
    }

    private fun World.assertContainsAliveCells(expected: Int) {
        assertEquals(expected, numberOfAliveCells())
    }

    private fun World.assertContainsAliveCells(expected: Coordinate) {
        assertTrue(isAlive(expected))
    }

    private fun World.assertCoordinateHasNeighbours(coordinate: Coordinate, numberOfNeighbours: Int) {
        assertEquals(numberOfNeighbours, numberOfNeighboursOf(coordinate))
    }
}
