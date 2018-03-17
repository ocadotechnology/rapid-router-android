package com.codeforlife.rapidrouter.utils

import com.codeforlife.rapidrouter.models.PathElement
import com.codeforlife.rapidrouter.models.Point

object RoadBuilder {
    fun build(paths: List<PathElement>, startingPoint: Point, endingPoint: Point): MutableList<RoadBlock> {

        val road = mutableListOf<RoadBlock>()

        paths.forEach {
            if (it.coordinates == startingPoint) {
                road.add(Start(it.coordinates))
            }
            if (it.coordinates == endingPoint) {
                road.add(Finish(it.coordinates))
            }
            if (it.connectedNodes.size == 2) {
                road.add(Straight(it.coordinates))
            }

        }

        return road
    }

}

sealed class RoadBlock
data class Start(val point: Point) : RoadBlock()
data class Finish(val point: Point) : RoadBlock()
data class Turn(val point: Point) : RoadBlock()
data class Straight(val point: Point) : RoadBlock()