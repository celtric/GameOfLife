package celtric.katas.gameoflife.acceptance

import celtric.katas.gameoflife.Game

abstract class AcceptanceTestCase {
    val a = 1

    protected fun game(width: Int, vararg cellStates: Int): Game {
        val game = Game()

        var i = 0
        var x = 0
        var y = 0

        while (i < cellStates.size) {
            if (x == width) {
                x = 0
                y++
            }
            if (cellStates[i] == 1) {
                game.addCell(x, y)
            }
            i++
            x++
        }

        return game
    }
}
