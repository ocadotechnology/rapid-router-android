package com.codeforlife.rapidrouter.gdx

import com.codeforlife.rapidrouter.models.PathElement
import com.codeforlife.rapidrouter.models.Point
import com.codeforlife.rapidrouter.utils.RoadBuilder
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.atLeastOnce
import com.nhaarman.mockito_kotlin.spy
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.junit.Assert.assertEquals
import org.mockito.Mockito.verify


//fun <T> any(): T {
//    Mockito.any<T>()
//    return uninitialized()
//}
//fun <T> uninitialized(): T = null as T

class RoadBuilderTest : Spek({


    describe("A road builder") {

        val paths: List<PathElement> = arrayListOf(
                PathElement(Point(0, 3), arrayListOf(1)),
                PathElement(Point(1, 3), arrayListOf(0, 2)),
                PathElement(Point(2, 3), arrayListOf(1))
        )


//        roadBuilderSpy.build(paths, Point(0, 3), arrayListOf(Point(2, 3)))

        val roadBuilderSpy = spy(RoadBuilder())

        roadBuilderSpy.build(paths, Point(0, 3), arrayListOf(Point(2, 3)))
//        given("paths elements", body = {
//            it("should be true") {

        verify(roadBuilderSpy, atLeastOnce()).calculateStartFinish(any(), any(), any())

        assertEquals(true, true)
//            }
//        })
    }


})
