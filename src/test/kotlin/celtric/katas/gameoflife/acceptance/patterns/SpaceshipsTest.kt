package celtric.katas.gameoflife.acceptance.patterns

import celtric.katas.gameoflife.acceptance.AcceptanceTestCase
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SpaceshipsTest : AcceptanceTestCase() {

    @Test fun glider() {
        val game = game(4,
            0, a, 0, 0,
            0, 0, a, 0,
            a, a, a, 0,
            0, 0, 0, 0)

        assertEquals(game(4,
            0, 0, 0, 0,
            a, 0, a, 0,
            0, a, a, 0,
            0, a, 0, 0), game.evolve())

        assertEquals(game(4,
            0, 0, 0, 0,
            0, 0, a, 0,
            a, 0, a, 0,
            0, a, a, 0), game.evolve(2))

        assertEquals(game(4,
            0, 0, 0, 0,
            0, a, 0, 0,
            0, 0, a, a,
            0, a, a, 0), game.evolve(3))

        assertEquals(game(4,
            0, 0, 0, 0,
            0, 0, a, 0,
            0, 0, 0, a,
            0, a, a, a), game.evolve(4))
    }
}
