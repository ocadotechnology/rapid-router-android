package com.codeforlife.rapidrouter.gdx

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.codeforlife.rapidrouter.models.Direction
import com.codeforlife.rapidrouter.models.LevelMap
import com.codeforlife.rapidrouter.utils.LevelReader
import timber.log.Timber
import com.badlogic.gdx.graphics.OrthographicCamera



class GdxGameAdapter : ApplicationAdapter() {
    lateinit var batch: SpriteBatch
    lateinit var img: Texture
    lateinit var camera: OrthographicCamera
    lateinit var grassBatch: SpriteBatch
    lateinit var grassImg: Texture

    lateinit var levelMap: LevelMap
    val blockSize = 64

    override fun create() {
        camera = OrthographicCamera()
        camera.setToOrtho(false, 1920f, 1080f)
        batch = SpriteBatch()
        img = Texture("tiles/van.png")

        grassBatch = SpriteBatch()
        grassImg = Texture("tiles/country/grass.png")

        levelMap = LevelReader.loadLevel(1)
        Timber.d("level map is: $levelMap")

    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        camera.update()

        batch.projectionMatrix = camera.combined
        grassBatch.projectionMatrix = camera.combined

        grassBatch.begin()

        for (w in 0..31) {
            for (h in 0..17) {
                grassBatch.draw(grassImg, w.toFloat() * blockSize, h.toFloat() * blockSize)
            }
        }

        grassBatch.end()

        batch.begin()
        batch.draw(img, levelMap.origin.coordinates[0].toFloat() * blockSize, levelMap.origin.coordinates[1].toFloat() * blockSize)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        img.dispose()
    }

}
