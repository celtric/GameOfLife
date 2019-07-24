package celtric.katas.gameoflife.acceptance

import celtric.katas.gameoflife.World

abstract class AcceptanceTestCase {
    val X = 1

    protected fun game(columns: Int, vararg deadOrAlive: Int): World = World(emptyList())

    protected fun World.evolve(times: Int): World {
        TODO()
    }
}
