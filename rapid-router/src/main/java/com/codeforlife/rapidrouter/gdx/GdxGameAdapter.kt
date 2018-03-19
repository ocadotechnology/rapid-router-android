package com.codeforlife.rapidrouter.gdx

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.codeforlife.rapidrouter.models.LevelMap
import com.codeforlife.rapidrouter.utils.*


class GdxGameAdapter : ApplicationAdapter() {
    private lateinit var batch: SpriteBatch
    private lateinit var img: Texture
    private lateinit var camera: OrthographicCamera
    private lateinit var grassBatch: SpriteBatch
    private lateinit var grassImg: Texture

    private lateinit var endBatch: SpriteBatch
    private lateinit var endSprite: Sprite
    private lateinit var endImg: Texture

    private lateinit var straightImg: Texture
    private lateinit var straightSprite: Sprite

    private lateinit var turnImg: Texture
    private lateinit var turnSprite: Sprite

    private lateinit var junctionImg: Texture
    private lateinit var junctionSprite: Sprite

    private lateinit var crossroadImg: Texture
    private lateinit var crossroadSprite: Sprite

    val redCol = Color(0.9f, 0.42f, 0.42f, 1f)

    lateinit var car: Sprite

    private lateinit var levelMap: LevelMap
    private val blockSize = 128
    lateinit var road: List<RoadBlock>

    override fun create() {
        camera = OrthographicCamera()
        camera.setToOrtho(false, 1920f, 1080f)
        batch = SpriteBatch()

        img = Texture("tiles/van.png")
        car = Sprite(img, blockSize, blockSize)

        grassBatch = SpriteBatch()
        grassImg = Texture("tiles/country/grass.png")

        levelMap = LevelReader.loadLevel(18)
        road = RoadBuilder.build(levelMap.paths, levelMap.startingPoint(), levelMap.endingPoint)

        endBatch = SpriteBatch()
        endImg = Texture("tiles/road/dead_end.png")
        endSprite = Sprite(endImg, blockSize, blockSize)

        straightImg = Texture("tiles/road/straight.png")
        straightSprite = Sprite(straightImg, blockSize, blockSize)

        turnImg = Texture("tiles/road/turn.png")
        turnSprite = Sprite(turnImg, blockSize, blockSize)

        junctionImg = Texture("tiles/road/t_junction.png")
        junctionSprite = Sprite(junctionImg, blockSize, blockSize)

        crossroadImg = Texture("tiles/road/crossroads.png")
        crossroadSprite = Sprite(crossroadImg, blockSize, blockSize)

    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        camera.update()

        drawGrass()

        drawRoad()

        drawCar()
    }

    private fun drawRoad() {
        endBatch.projectionMatrix = camera.combined

        road.forEach {
            when (it) {
                is Start -> {
                    endBatch.begin()
                    endSprite.setPosition(levelMap.startingPoint().x.toFloat() * blockSize, levelMap.startingPoint().y.toFloat() * blockSize)
                    endSprite.rotation = it.rotation * 90f
                    endSprite.draw(endBatch)
                    endBatch.end()
                }
                is Finish -> {
                    endBatch.begin()
                    endSprite.setPosition(levelMap.endingPoint.x.toFloat() * blockSize, levelMap.endingPoint.y.toFloat() * blockSize)
                    endSprite.rotation = it.rotation * 90f
                    endSprite.draw(endBatch)
                    endBatch.end()
                }
                is Straight -> {
                    endBatch.begin()
                    straightSprite.setPosition(it.point.x.toFloat() * blockSize, it.point.y.toFloat() * blockSize)
                    straightSprite.rotation = it.rotation * 90f
                    straightSprite.draw(endBatch)
                    endBatch.end()
                }
                is Turn -> {
                    endBatch.begin()
                    endBatch.color = redCol
                    turnSprite.setPosition(it.point.x.toFloat() * blockSize, it.point.y.toFloat() * blockSize)
                    turnSprite.rotation = it.rotation * 90.0f
                    turnSprite.draw(endBatch)
                    endBatch.end()
                }
                is Junction -> {
                    endBatch.begin()
                    junctionSprite.setPosition(it.point.x.toFloat() * blockSize, it.point.y.toFloat() * blockSize)
                    junctionSprite.rotation = 90f
                    junctionSprite.draw(endBatch)
                    endBatch.end()
                }
                is Crossroad -> {
                    endBatch.begin()
                    crossroadSprite.setPosition(it.point.x.toFloat() * blockSize, it.point.y.toFloat() * blockSize)
                    crossroadSprite.rotation = 90f
                    crossroadSprite.draw(endBatch)
                    endBatch.end()
                }
            }
        }

    }

    private fun drawCar() {
        batch.projectionMatrix = camera.combined
        batch.begin()
        car.setPosition(levelMap.origin.coordinates.x.toFloat() * blockSize, levelMap.origin.coordinates.y.toFloat() * blockSize)
        car.rotation = (levelMap.origin.direction.rotation * 90).toFloat()
        car.draw(batch)
        batch.end()
    }

    private fun drawGrass() {
        grassBatch.projectionMatrix = camera.combined
        grassBatch.begin()

        // because 1920 / 128 = 16 and 1080 / 128 = 8.something
        for (w in 0..16) {
            for (h in 0..9) {
                grassBatch.draw(grassImg, w.toFloat() * blockSize, h.toFloat() * blockSize)
            }
        }

        grassBatch.end()
    }

    override fun dispose() {
        batch.dispose()
        img.dispose()
    }
}
