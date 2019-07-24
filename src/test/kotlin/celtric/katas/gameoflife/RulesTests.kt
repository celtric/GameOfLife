package celtric.katas.gameoflife

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RulesTests {

    @Test fun `any live cell with fewer than two live neighbours dies as if caused by underpopulation`() {
        assertFalse(Neighbourhood(liveCells = 0).isNextGenerationAlive(true))
        assertFalse(Neighbourhood(liveCells = 1).isNextGenerationAlive(true))
    }

    @Test fun `any live cell with two or three live neighbours lives on to the next generation`() {
        assertTrue(Neighbourhood(liveCells = 2).isNextGenerationAlive(true))
        assertTrue(Neighbourhood(liveCells = 3).isNextGenerationAlive(true))
    }

    @Test fun `any live cell with more than three live neighbours dies as if by overpopulation`() {
        assertFalse(Neighbourhood(liveCells = 4).isNextGenerationAlive(true))
        assertFalse(Neighbourhood(liveCells = 8).isNextGenerationAlive(true))
    }

    @Test fun `any dead cell with exactly three live neighbours becomes a live cell as if by reproduction`() {
        assertTrue(Neighbourhood(liveCells = 3).isNextGenerationAlive(false))
    }

    @Test fun `any dead cell remains dead if not located in a fertile neighbourhood`() {
        assertFalse(Neighbourhood(liveCells = 2).isNextGenerationAlive(false))
        assertFalse(Neighbourhood(liveCells = 4).isNextGenerationAlive(false))
    }
}
