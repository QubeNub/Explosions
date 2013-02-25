package nl.joeyfranken.android.explosions.Level;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import nl.joeyfranken.android.explosions.Entity.Player;
import nl.joeyfranken.android.explosions.Projectile.Explosion;
import nl.joeyfranken.android.explosions.Projectile.Projectile;

public class Level {

	private Player player;
	private Dimension size;
	private ArrayList<Projectile> projectiles;
	
	public Level(Player player, Dimension size) {
		projectiles = new ArrayList<Projectile>();
		this.player = player;
		this.player.setLocation(new Point(size.width / 2, size.height / 2));
		this.size = size;
	}

	public void setSize(Dimension size) {
		player.setLocation(new Point(size.width / 2, size.height / 2));
		this.size = size;
	}
	
	public Dimension getSize() {
		return size;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void createExplosion(Point location) {
		Explosion explosion = new Explosion(location, 1, 30);
		projectiles.add(explosion);
	}
	
	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}
	
	public void resize(int width, int height) {
		for(Projectile projectile: projectiles) {
			Point location = projectile.getLocation();
			location.translate(Math.abs(size.width - width), Math.abs(size.height - height));
			projectile.setLocation(location);
		}
		setSize(new Dimension(width, height));
	}
	
	public void tick() {
		for(int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).isAlive()) {
				projectiles.get(i).tick();
			} else {
				projectiles.remove(i);
				i--;
			}
		}
	}
}
