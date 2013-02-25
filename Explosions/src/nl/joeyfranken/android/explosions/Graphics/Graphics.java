package nl.joeyfranken.android.explosions.Graphics;

import java.util.ArrayList;

import nl.joeyfranken.android.explosions.Level.Level;
import nl.joeyfranken.android.explosions.Projectile.Explosion;
import nl.joeyfranken.android.explosions.Projectile.Projectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Graphics {
	private ShapeRenderer renderer;
	private Level level;
	
	public Graphics(Level level) {
		this.level = level;
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		renderer = new ShapeRenderer();
	}
	
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		renderer.begin(ShapeType.FilledRectangle);
		renderer.setColor(Color.BLUE);
		renderer.filledRect(level.getPlayer().getLocation().x, level.getPlayer().getLocation().y, 20, 20);
		renderer.end();
		
		renderProjectiles();
	}
	
	private void renderProjectiles() {
		ArrayList<Projectile> projectiles = level.getProjectiles();
		for(Projectile projectile: projectiles) {
			if(projectile instanceof Explosion) {
				Explosion expl = (Explosion) projectile;
				renderer.begin(ShapeType.FilledCircle);
				renderer.setColor(Color.RED);
				renderer.filledCircle(expl.getLocation().x, expl.getLocation().y, expl.getRadius());
				renderer.end();
			}
		}
	}
	
	public void dispose() {
		renderer.dispose();
	}
}
