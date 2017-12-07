package com.adamkayla.canyonbunny;

import com.adamkayla.canyonbunny.game.Assets;
import com.adamkayla.canyonbunny.game.WorldController;
import com.adamkayla.canyonbunny.game.WorldRenderer;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

public class CanyonBunny implements ApplicationListener {
	public static final String TAG = CanyonBunny.class.getName();
	
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	private boolean paused;

	@Override
	public void create() {
	//set log level to debug
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Assets.instance.init(new AssetManager());
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);
		paused = false;
	}

	@Override
	public void resize(int width, int height) {
		worldRenderer.resize(width, height);
		
	}
	@Override
	public void render() {
		if (!paused) {
			// update the game world by the time that has passed since the last rendered frame
			worldController.update(Gdx.graphics.getDeltaTime());
			Gdx.gl.glClearColor(0x64 / 255.0f, 0x95 / 255.0f, 0xed / 255.0f, 0xff / 255.0f);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			worldRenderer.render();
		}
		
	}

	@Override
	public void pause() {
		paused = true;
		
	}

	@Override
	public void resume() {
		paused = false;
		
	}

	@Override
	public void dispose() {
		worldRenderer.dispose();
		Assets.instance.dispose();
	}
	
	
	
}
