package com.codeforlife.rapidrouter.utils

import com.badlogic.gdx.Gdx
import com.codeforlife.rapidrouter.models.*
import com.github.salomonbrys.kotson.fromJson
import com.github.salomonbrys.kotson.get
import com.google.gson.Gson
import com.google.gson.JsonParser


object LevelReader {
    fun loadLevel(level: Int): LevelMap {

        val file = Gdx.files.internal("maps/level$level.json")
        val text = file.readString()
        val gson = Gson()

        val parser = JsonParser()
        val jsonObject = parser.parse(text).asJsonObject

        val origin = jsonObject.get("origin")
        val path = jsonObject.getAsJsonArray("path")

        val paths: List<PathElement> = path.map { jsonElement ->
            PathElement(Point(jsonElement["coordinate"][0].asInt, jsonElement["coordinate"][1].asInt),
                    gson.fromJson(jsonElement["connectedNodes"]))
        }

        return LevelMap(
                Origin(
                        Direction.valueOf(origin["direction"].asString),
                        Point(
                                origin["coordinate"].asJsonArray[0].asInt,
                                origin["coordinate"].asJsonArray[1].asInt
                        )
                ),
                paths = paths
        )
    }
}