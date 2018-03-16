package com.codeforlife.rapidrouter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.badlogic.gdx.backends.android.AndroidFragmentApplication
import com.codeforlife.rapidrouter.gdx.GdxGameAdapter

class GameFragment : AndroidFragmentApplication() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initializeForView(GdxGameAdapter())
    }
}
