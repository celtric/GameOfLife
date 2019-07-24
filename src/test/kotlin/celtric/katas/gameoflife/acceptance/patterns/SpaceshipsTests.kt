package celtric.katas.gameoflife.acceptance.patterns

import celtric.katas.gameoflife.acceptance.AcceptanceTestCase
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SpaceshipsTests : AcceptanceTestCase() {

    @Test fun glider() {
        val game = game(4,
            0, X, 0, 0,
            0, 0, X, 0,
            X, X, X, 0,
            0, 0, 0, 0)

        assertEquals(game(4,
            0, 0, 0, 0,
            X, 0, X, 0,
            0, X, X, 0,
            0, X, 0, 0), game.evolve())

        assertEquals(game(4,
            0, 0, 0, 0,
            0, 0, X, 0,
            X, 0, X, 0,
            0, X, X, 0), game.evolve(2))

        assertEquals(game(4,
            0, 0, 0, 0,
            0, X, 0, 0,
            0, 0, X, X,
            0, X, X, 0), game.evolve(3))

        assertEquals(game(4,
            0, 0, 0, 0,
            0, 0, X, 0,
            0, 0, 0, X,
            0, X, X, X), game.evolve(4))
    }
}
