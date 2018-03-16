package com.codeforlife.rapidrouter.utils

import com.badlogic.gdx.Gdx
import com.codeforlife.rapidrouter.models.LevelMap
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson


object LevelReader {
    fun loadLevel(level: Int): LevelMap {
        
        val file = Gdx.files.internal("maps/level$level.json")
        val text = file.readString()

        return Gson().fromJson(text)
    }
}