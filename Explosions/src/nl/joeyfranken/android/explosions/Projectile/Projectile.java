package nl.joeyfranken.android.explosions.Projectile;

import java.awt.Point;

public class Projectile {
	private Point location;
	private boolean alive;
	
	public Projectile(Point location) {
		this.location = location;
		alive = true;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void die() {
		alive = false;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public Point getLocation() {
		return location;
	}
	
	public void tick() {
		
	}
}
