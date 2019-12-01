package com.aesthomic.gemdigger

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.aesthomic.gemdigger.databinding.ActivityMainBinding

const val KEY_TOTAL_EARNS = "total_earns_key"
const val KEY_TOTAL_GEMS = "total_gems_key"
const val KEY_CURRENT_CRYSTAL = "current_crystal_key"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var listCrystals = CrystalData.listCrystals
    private var totalEarns = 0
    private var totalGems = 0
    private var currentCrystal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Check SDK Version for enabling transparent Status Bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }

        savedInstanceState?.let { bundle: Bundle ->
            totalEarns = bundle.getInt(KEY_TOTAL_EARNS, 0)
            totalGems = bundle.getInt(KEY_TOTAL_GEMS, 0)
            currentCrystal = bundle.getInt(KEY_CURRENT_CRYSTAL, 0)
        }

        setViewsToCurrent()

        binding.ivMainCrystal.setOnClickListener { updateCurrentState() }
    }

    private fun updateCurrentState() {
        totalGems++
        totalEarns += listCrystals[currentCrystal].price

        if (currentCrystal+1 < listCrystals.size &&
                listCrystals[currentCrystal+1].startsAt <= totalEarns) {
            currentCrystal++
        }

        setViewsToCurrent()
    }

    private fun setViewsToCurrent() {
        binding.totalEarns = getString(R.string.tv_main_earnings_text, totalEarns)
        binding.totalGems = if (totalGems > 1) {
            getString(R.string.tv_main_gems_text, totalGems, "Gems")
        } else {
            getString(R.string.tv_main_gems_text, totalGems, "Gem")
        }

        binding.ivMainCrystal.setImageResource(listCrystals[currentCrystal].imageId)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_TOTAL_GEMS, totalGems)
        outState.putInt(KEY_TOTAL_EARNS, totalEarns)
        outState.putInt(KEY_CURRENT_CRYSTAL, currentCrystal)
        super.onSaveInstanceState(outState)
    }
}
