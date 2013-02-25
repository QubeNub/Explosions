package nl.joeyfranken.android.explosions.Projectile;

import java.awt.Point;

public class Explosion extends Projectile {
	private int radius, maxRadius;
	
	public Explosion(Point location, int radius, int maxRadius) {
		super(location);
		this.maxRadius = maxRadius;
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}
	
	@Override
	public void tick() {
		increaseRadius(1f);
	}
	
	public void increaseRadius(float increment) {
		if(radius + increment >= maxRadius) {
			radius = 1;
			die();
		} else {
			radius += increment;
		}
	}
}
