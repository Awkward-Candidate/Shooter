package Shooter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

@SuppressWarnings("serial")
public class Powerup extends Rectangle {
	int dy;
	int speed = 8;
	Random rand;
	Color col;// green for health, blue for shield

	public Powerup() {
		super();
		rand = new Random();
		dy = speed;
		// System.out.print("Made\n");
	}

	public void generate() {
		// System.out.print("Generated\n");
		super.x = (int) ((Math.random() * Shooter.width / 2) + this.width);// I should use a better algorithm
		super.y = (int) (Shooter.height * 0.10);
		super.width = 50;
		super.height = 50;
	}

	public void update() {
		// System.out.print("updating\n");
		if (this.intersects(Screen.gplay.getBounds())) {
			// do something if it is a health powerup,
			if (this instanceof HealthPack) {
				Screen.gplay.health.width = Screen.gplay.getBounds().width;// s gets a health boost
			}
			if (this instanceof ShieldPack) {
				Screen.gplay.shieldactive = true;
				Screen.gplay.shieldhealth = Screen.gplay.getBounds().width;
			}

			this.translate(0, Shooter.height);// will be set to null

		}

		this.translate(0, dy);// move down otherwise

	}

	public boolean outBounds() {// checks if the box has moved out of the screen
		return (this.y > Shooter.width);
	}

	public void draw(Graphics2D win) {
		// System.out.print("Drawing\n");
		win.setColor(col);
		win.fill(this);
	}

}
