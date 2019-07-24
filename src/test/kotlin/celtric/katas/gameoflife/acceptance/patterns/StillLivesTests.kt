package celtric.katas.gameoflife.acceptance.patterns

import celtric.katas.gameoflife.acceptance.AcceptanceTestCase
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StillLivesTests : AcceptanceTestCase() {

    @Test fun block() {
        val game = game(4,
            0, 0, 0, 0,
            0, a, a, 0,
            0, a, a, 0,
            0, 0, 0, 0)

        assertEquals(game(4,
            0, 0, 0, 0,
            0, a, a, 0,
            0, a, a, 0,
            0, 0, 0, 0), game.evolve())
    }

    @Test fun beehive() {
        val game = game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, a, a, 0, 0,
            0, a, 0, 0, a, 0,
            0, 0, a, a, 0, 0,
            0, 0, 0, 0, 0, 0)

        assertEquals(game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, a, a, 0, 0,
            0, a, 0, 0, a, 0,
            0, 0, a, a, 0, 0,
            0, 0, 0, 0, 0, 0), game.evolve())
    }
}
