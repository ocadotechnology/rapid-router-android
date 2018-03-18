package com.codeforlife.rapidrouter.models

import com.google.gson.annotations.SerializedName

data class LevelMap(
    @SerializedName("origin") val origin: Origin,
    @SerializedName("path") val paths: List<PathElement>
) {

    fun startingPoint(): Point = paths.first().coordinates

    fun finishingPoint(): Point = paths.last().coordinates
}

data class Origin(
    @SerializedName("direction") val direction: Direction,
    @SerializedName("coordinate") val coordinates: Point
)

enum class Direction(val rotation: Int) {
    N(0), E(3), S(2), W(1)
}

data class PathElement(
    @SerializedName("coordinate") val coordinates: Point,
    @SerializedName("connectedNodes") val connectedNodes: List<Int>
)

data class Point(val x: Int, val y: Int)