package com.codeforlife.rapidrouter

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.badlogic.gdx.backends.android.AndroidFragmentApplication

class MainActivity : AppCompatActivity(), AndroidFragmentApplication.Callbacks {
    override fun exit() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val pager = findViewById<ViewPager>(R.id.view_pager)
        pager.adapter = MainViewPagerAdapter(supportFragmentManager)

        supportActionBar?.elevation = 0.0f

    }
}
