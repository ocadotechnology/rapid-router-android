package com.codeforlife.rapidrouter.utils

import android.content.res.AssetManager
import com.codeforlife.rapidrouter.models.LevelMap
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import java.io.InputStreamReader

object LevelReader {
    fun loadLevel(level: Int, assets: AssetManager): LevelMap {
        val json = assets.open("maps/level$level.json")

        val allText: String = InputStreamReader(json, "UTF-8").readText()


        return Gson().fromJson(allText)
    }
}