package nl.joeyfranken.android.explosions.Entity;

import java.awt.Dimension;
import java.awt.Point;

public class Entity {

	private Point location;
	private Dimension size;
	
	public Entity(Dimension size) {
		this.size = size;
	}

	public void setLocation(Point location) {
		this.location = location;
	}
	
	public Point getLocation() {
		Point location = new Point(this.location.x - (size.width / 2), this.location.y - (size.height / 2));
		return location;
	}
	
	public Dimension getSize() {
		return size;
	}
}
