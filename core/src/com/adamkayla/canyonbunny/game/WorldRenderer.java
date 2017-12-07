package com.adamkayla.canyonbunny.game;

import com.adamkayla.canyonbunny.Constants;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class WorldRenderer implements Disposable {

	private OrthographicCamera camera;
	private WorldController worldController;
	private SpriteBatch batch;
	
	
	public WorldRenderer(WorldController worldController) {
		
		this.worldController = worldController;
		init();
	}

	private void init() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Constants.VIEW_PORT_WIDTH, Constants.VIEW_PORT_HEIGHT);
		camera.position.set(0, 0, 0);
		camera.update();
	}
	
	public void render() {
		renderWorld(batch);
	}
	
	

	private void renderWorld(SpriteBatch batch2) {
		worldController.cameraHelper.applyTo(camera);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		worldController.level.render(batch2);
		batch.end();
		
	}

	public void resize(int width, int height) {
		camera.viewportWidth = (Constants.VIEW_PORT_HEIGHT/height) * width;
		camera.update();
	}


	@Override
	public void dispose() {
		batch.dispose();

	}

}
