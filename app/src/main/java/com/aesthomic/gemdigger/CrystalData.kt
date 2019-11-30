package com.aesthomic.gemdigger

object CrystalData {

    val listCrystals: MutableList<Crystal>
        get() {
            val list = mutableListOf<Crystal>()
            list.addAll(crystalData)
            return list
        }

    private val crystalData = arrayOf (
        Crystal(
            R.drawable.crystal_lime, 5, 0
        ),
        Crystal(
            R.drawable.crystal_red, 35, 17
        ),
        Crystal(
            R.drawable.crystal_purple, 60, 43
        ),
        Crystal(
            R.drawable.crystal_green, 85, 101
        ),
        Crystal(
            R.drawable.crystal_blue, 155, 204
        ),
        Crystal(
            R.drawable.crystal_orange, 275, 501
        ),
        Crystal(
            R.drawable.crystal_aqua, 420, 1007
        ),
        Crystal(
            R.drawable.crystal_fuchsia, 880, 2525
        )
    )
}