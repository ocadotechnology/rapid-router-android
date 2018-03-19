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
                val isTurn = isTurn(it.connectedNodes, paths)
                if (isTurn) {
                    road.add(Turn(it.coordinates))
                } else {
                    road.add(Straight(it.coordinates))
                }
            }
            if (it.connectedNodes.size == 3) {
                road.add(Junction(it.coordinates))
            }
            if (it.connectedNodes.size == 4) {
                road.add(Crossroad(it.coordinates))
            }

        }

        return road
    }

    private fun isTurn(connectedNodes: List<Int>, paths: List<PathElement>): Boolean {
        val previousPath = paths[connectedNodes[0]].coordinates
        val nextPath = paths[connectedNodes[1]].coordinates

        return !(previousPath.x == nextPath.x || previousPath.y == nextPath.y)
    }

}

sealed class RoadBlock
data class Start(val point: Point) : RoadBlock()
data class Finish(val point: Point) : RoadBlock()
data class Turn(val point: Point) : RoadBlock()
data class Straight(val point: Point) : RoadBlock()
data class Junction(val point: Point) : RoadBlock()
data class Crossroad(val point: Point) : RoadBlock()