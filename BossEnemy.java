package Shooter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

@SuppressWarnings("serial")
public class BossEnemy extends Enemy {

	int phase = 0;// 0==moves into position 2==suppression fire
	Random rand;

	boolean release = false;

	public BossEnemy() {
		rand = new Random();
		this.setRect(((Math.random() * Shooter.width / 2) + this.width), (-2 * 200), 200, 200);
		heat = new Missile[5];
		this.health = 700;
		this.dy = (int) (this.mag * (0.0001));
		this.col = Color.yellow;
		Shooter.s.setVolume(5, (float) 6.0206);
		Shooter.s.play(5);
	}

	public void update() {
		if (inPosition() && this.phase == 0) {
			this.phase = 1;
			dy = 0;
			dx = -2;
			release = true;
		}

		if (this.phase == 0) {
			dy = 1;
			super.update();
		}
		if (this.phase == 1) {

			if (this.x + this.width >= Shooter.width) {
				dx *= -1;
			}
			if (this.x <= 0) {
				dx = 2;
			}
			for (int i = 0; i < heat.length; i++) {
				if (heat[i] == null) {
					heat[i] = new HeatseekingMissile((int) (this.x + (this.width * i / (heat.length - 1))),
							(int) (this.y + this.height));
					break;
				}
			}
			for (int i = 0; i < heat.length; i++) {
				if (heat[i] != null) {
					heat[i].update();
					if (heat[i].outBounds())
						heat[i] = null;
				}
			}

			super.update();
		}

	}

	public boolean inPosition() {
		return (this.y + this.height >= (int) (Shooter.height * 0.40));
	}

	public void draw(Graphics2D win) {
		for (int i = 0; i < heat.length; i++) {
			if (heat[i] != null)
				heat[i].draw(win);
		}
		super.draw(win);
	}

}
