package com.github.krllus.training.ui.common

import com.github.krllus.training.MainActivity
import com.github.krllus.training.R
import com.github.krllus.training.ui.fox.FoxFragment

class NavigationController constructor(mainActivity: MainActivity) {
    private val containerId = R.id.container
    private val fragmentManager = mainActivity.supportFragmentManager

    fun navigateToFox(foxId: String) {
        val foxFragment = FoxFragment.newInstance(foxId)
        fragmentManager.beginTransaction()
            .replace(containerId, foxFragment)
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }
}