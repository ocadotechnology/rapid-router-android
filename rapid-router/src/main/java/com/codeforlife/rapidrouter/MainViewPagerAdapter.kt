package com.codeforlife.rapidrouter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

internal class MainViewPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            BlocklyFragment()
        } else GameFragment()
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return if (position == 0) {
            "Blockly Stage"
        } else "Game View"
    }
}
