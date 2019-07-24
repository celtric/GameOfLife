package celtric.katas.gameoflife

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RulesTests {

    @Test fun `any live cell with fewer than two live neighbours dies as if caused by underpopulation`() {
        aliveCell(withNeighbours = 0).assertDies()
        aliveCell(withNeighbours = 1).assertDies()
    }

    @Test fun `any live cell with two or three live neighbours lives on to the next generation`() {
        aliveCell(withNeighbours = 2).assertSurvives()
        aliveCell(withNeighbours = 3).assertSurvives()
    }

    @Test fun `any live cell with more than three live neighbours dies as if by overpopulation`() {
        aliveCell(withNeighbours = 4).assertDies()
        aliveCell(withNeighbours = 8).assertDies()
    }

    @Test fun `any dead cell with exactly three live neighbours becomes a live cell as if by reproduction`() {
        deadCell(withNeighbours = 3).assertBecomesAlive()
    }

    @Test fun `any dead cell remains dead if not located in a fertile neighbourhood`() {
        deadCell(withNeighbours = 2).assertRemainsDead()
        deadCell(withNeighbours = 4).assertRemainsDead()
    }

    private fun aliveCell(withNeighbours: Int): Cell = Cell(true).nextGeneration(withNeighbours)
    private fun deadCell(withNeighbours: Int): Cell = Cell(false).nextGeneration(withNeighbours)
    private fun Cell.assertDies() { assertFalse(isAlive) }
    private fun Cell.assertRemainsDead() { assertFalse(isAlive) }
    private fun Cell.assertSurvives() { assertTrue(isAlive) }
    private fun Cell.assertBecomesAlive() { assertTrue(isAlive) }
}
