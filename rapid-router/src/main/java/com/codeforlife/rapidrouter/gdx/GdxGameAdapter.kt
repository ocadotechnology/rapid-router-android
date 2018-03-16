package com.codeforlife.rapidrouter.gdx

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.codeforlife.rapidrouter.models.LevelMap
import com.codeforlife.rapidrouter.utils.LevelReader


class GdxGameAdapter : ApplicationAdapter() {
    private lateinit var batch: SpriteBatch
    private lateinit var img: Texture
    private lateinit var camera: OrthographicCamera
    private lateinit var grassBatch: SpriteBatch
    private lateinit var grassImg: Texture

    private lateinit var endBatch: SpriteBatch
    private lateinit var endSprite: Sprite
    private lateinit var endImg: Texture

    lateinit var car: Sprite

    private lateinit var levelMap: LevelMap
    private val blockSize = 128

    override fun create() {
        camera = OrthographicCamera()
        camera.setToOrtho(false, 1920f, 1080f)
        batch = SpriteBatch()

        img = Texture("tiles/van.png")
        car = Sprite(img, blockSize, blockSize)

        grassBatch = SpriteBatch()
        grassImg = Texture("tiles/country/grass.png")

        levelMap = LevelReader.loadLevel(1)

        endBatch = SpriteBatch()
        endImg = Texture("tiles/road/dead_end.png")
        endSprite = Sprite(endImg, blockSize, blockSize)

    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        camera.update()

        drawGrass()

        endBatch.projectionMatrix = camera.combined
        endBatch.begin()
        endSprite.setPosition(levelMap.origin.coordinates.x.toFloat() * blockSize, levelMap.origin.coordinates.y.toFloat() * blockSize)
        endSprite.rotation = 90f
        endSprite.draw(endBatch)
        endBatch.end()

        drawCar()
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
