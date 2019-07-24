package celtric.katas.gameoflife.acceptance

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameTests : AcceptanceTestCase() {

    @Test fun `an empty universe does not evolve`() {
        val game = game(3,
            0, 0, 0,
            0, 0, 0)

        assertEquals(game, game.evolve())
    }

    @Test fun `a single live cell dies within an iteration`() {
        val game = game(3,
            0, 0, 0,
            0, X, 0,
            0, 0, 0)

        assertEquals(game(3,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0), game.evolve())
    }

    @Test fun `universe is not constrained to visible grid`() {
        val game = game(3,
            X, X, X,
            0, 0, 0,
            0, 0, 0)

        assertEquals(game(3,
            X, X, X,
            0, 0, 0,
            0, 0, 0), game.evolve(2))
    }
}
