package com.aesthomic.gemdigger

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.aesthomic.gemdigger.databinding.ActivityMainBinding

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
}
