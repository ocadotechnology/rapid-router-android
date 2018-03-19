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
                val rotation = calculateRotation(it.coordinates, it.connectedNodes, paths)
                if (isTurn) {
                    road.add(Turn(it.coordinates, rotation))
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

    private fun calculateRotation(currentElement: Point, connectedNodes: List<Int>, paths: List<PathElement>): Int {
        val previousPath = paths[connectedNodes[0]].coordinates
        val nextPath = paths[connectedNodes[1]].coordinates

        return if (currentElement.x < previousPath.x) {
            // going from right side
            if (previousPath.y < nextPath.y && currentElement.x == nextPath.x && currentElement.y == previousPath.y) {
                return 4
            } else if (previousPath.y > nextPath.y && currentElement.x == previousPath.x && currentElement.y == nextPath.y) {
                return 2
            } else if (previousPath.y < nextPath.y && currentElement.x == previousPath.x && currentElement.y == nextPath.y) {
                return 3
            } else {
                return 1
            }
        } else {
            if (previousPath.y > nextPath.y && currentElement.x == previousPath.x && currentElement.y == nextPath.y) {
                return 2
            } else if (previousPath.y < nextPath.y && currentElement.x == nextPath.x && currentElement.y == previousPath.y) {
                return 3
            } else if (previousPath.y > nextPath.y && currentElement.x == nextPath.x && currentElement.y == previousPath.y) {
                return 4
            }
            return 1
        }
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
data class Turn(val point: Point, val rotation: Int) : RoadBlock()
data class Straight(val point: Point) : RoadBlock()
data class Junction(val point: Point) : RoadBlock()
data class Crossroad(val point: Point) : RoadBlock()