package celtric.katas.gameoflife.acceptance.patterns

import celtric.katas.gameoflife.acceptance.AcceptanceTestCase
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OscillatorsTests : AcceptanceTestCase() {

    @Test fun blinker() {
        val game = game(3,
            0, X, 0,
            0, X, 0,
            0, X, 0)

        assertEquals(game(3,
            0, 0, 0,
            X, X, X,
            0, 0, 0), game.evolve())

        assertEquals(game(3,
            0, X, 0,
            0, X, 0,
            0, X, 0), game.evolve(2))
    }

    @Test fun toad() {
        val game = game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, X, X, X, 0,
            0, X, X, X, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0)

        assertEquals(game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, X, 0, 0,
            0, X, 0, 0, X, 0,
            0, X, 0, 0, X, 0,
            0, 0, X, 0, 0, 0,
            0, 0, 0, 0, 0, 0), game.evolve())

        assertEquals(game(6,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, X, X, X, 0,
            0, X, X, X, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0), game.evolve(2))
    }
}
