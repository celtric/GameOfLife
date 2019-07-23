package celtric.katas.gameoflife

class Neighbourhood(private val liveCells: Int) {

    fun isNextGenerationAlive(currentlyAlive: Boolean): Boolean =
        if (currentlyAlive) isStable() else isFertile()

    private fun isStable(): Boolean =
        liveCells == 2 || liveCells == 3

    private fun isFertile(): Boolean =
        liveCells == 3
}
