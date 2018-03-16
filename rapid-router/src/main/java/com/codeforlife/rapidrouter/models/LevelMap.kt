package com.codeforlife.rapidrouter.models

import com.google.gson.annotations.SerializedName

data class LevelMap(@SerializedName("origin") val origin: Origin)


data class Origin(@SerializedName("direction") val direction: Direction,
                  @SerializedName("coordinate") val coordinates: List<Int>)

enum class Direction(val rotation: Int) {
    N(0), E(1), S(2), W(3)
}