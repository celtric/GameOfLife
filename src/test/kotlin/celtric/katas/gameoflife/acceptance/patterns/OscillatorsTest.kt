package celtric.katas.gameoflife.acceptance.patterns

import celtric.katas.gameoflife.acceptance.AcceptanceTestCase
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OscillatorsTest : AcceptanceTestCase() {

    @Test fun blinker() {
        val game = game(3,
            0, a, 0,
            0, a, 0,
            0, a, 0)

        assertEquals(game(3,
            0, 0, 0,
            a, a, a,
            0, 0, 0), game.evolve())

        assertEquals(game(3,
            0, a, 0,
            0, a, 0,
            0, a, 0), game.evolve(2))
    }

    @Test fun toad() {
        val game = game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, a, a, a, 0,
            0, a, a, a, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0)

        assertEquals(game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, a, 0, 0,
            0, a, 0, 0, a, 0,
            0, a, 0, 0, a, 0,
            0, 0, a, 0, 0, 0,
            0, 0, 0, 0, 0, 0), game.evolve())

        assertEquals(game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, a, a, a, 0,
            0, a, a, a, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0), game.evolve(2))
    }
}
