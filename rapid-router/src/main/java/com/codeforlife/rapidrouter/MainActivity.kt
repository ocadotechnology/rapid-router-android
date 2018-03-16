package com.codeforlife.rapidrouter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.badlogic.gdx.backends.android.AndroidFragmentApplication
import com.codeforlife.rapidrouter.fragments.BlocklyFragment
import com.codeforlife.rapidrouter.fragments.GameFragment
import com.codeforlife.rapidrouter.utils.LevelReader


class MainActivity : AppCompatActivity(), AndroidFragmentApplication.Callbacks {

    override fun exit() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val pager = findViewById<ViewPager>(R.id.view_pager)
        pager.adapter = MainViewPagerAdapter(supportFragmentManager)

        supportActionBar?.elevation = 0.0f

        val loadLevel = LevelReader.loadLevel(21, assets)
    }
}

class MainViewPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            BlocklyFragment()
        } else GameFragment()
    }

    override fun getCount() = 2

    override fun getPageTitle(position: Int) = if (position == 0) "Blockly Stage" else "Game View"

}