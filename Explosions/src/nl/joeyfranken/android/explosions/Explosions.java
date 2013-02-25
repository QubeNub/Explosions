package nl.joeyfranken.android.explosions;

import java.awt.Dimension;
import java.awt.Point;

import nl.joeyfranken.android.explosions.Entity.Player;
import nl.joeyfranken.android.explosions.Graphics.Graphics;
import nl.joeyfranken.android.explosions.Level.Level;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class Explosions implements ApplicationListener {
	
	public Graphics graphics;
	public Level level; 
	
	@Override
	public void create() {		
		level = new Level(
					new Player(new Dimension(25, 25)), 
					new Dimension(
						Gdx.graphics.getWidth(), 
						Gdx.graphics.getHeight()));
		graphics = 	new Graphics(level);
	}

	@Override
	public void dispose() {
		graphics.dispose();
	}

	@Override
	public void render() {
		level.tick();
		if(Gdx.input.justTouched()) {
			level.createExplosion(new Point(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()));
		}
		graphics.render();
	}

	@Override
	public void resize(int width, int height) {
		level.resize(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
