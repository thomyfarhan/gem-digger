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
            R.drawable.crystal_red, 35, 80
        ),
        Crystal(
            R.drawable.crystal_purple, 60, 650
        ),
        Crystal(
            R.drawable.crystal_green, 85, 2560
        ),
        Crystal(
            R.drawable.crystal_blue, 155, 9870
        ),
        Crystal(
            R.drawable.crystal_orange, 275, 18760
        ),
        Crystal(
            R.drawable.crystal_aqua, 420, 49990
        ),
        Crystal(
            R.drawable.crystal_fuchsia, 880, 149990
        )
    )
}