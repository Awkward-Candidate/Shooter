package Shooter;

import java.awt.Color;
import java.awt.Graphics2D;
import Utilities.GDV5;
import Utilities.SoundDriver;

@SuppressWarnings("serial")
public class Shooter extends GDV5 {
	Screen screen;
	static final int width = 1230;
	static final int height = 850;
	static final int Gamestate1 = 1, Gamestate2 = 2, Gamestate3 = 3, Gamestate4 = 4, Gamestate5 = 5; // 1 ==start
																										// screen,
																										// 2==gameplay,
	// 3==endscreen
	static int state = Gamestate1; // 4=you won! screen
	static int level = 1;
	static int score = 0;
	static String[] sounds;
	static SoundDriver s;
	static boolean endless = false;

	public Shooter() {
		super();
		sounds = new String[6];
		sounds[0] = "Sounds/LaserSound.wav";
		sounds[1] = "Sounds/MissileSound.wav";
		sounds[2] = "Sounds/StartSound.wav";
		sounds[3] = "Sounds/BackgroundSound.wav";
		sounds[4] = "Sounds/ExplosionSound.wav";
		sounds[5] = "Sounds/StarWars.wav";
		s = new SoundDriver(sounds, this);
		screen = new Screen();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shooter game = new Shooter();
		game.setTitle("game");
		game.setSize(Shooter.width, Shooter.height);
		game.setBackground(Color.black);
		game.start();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

		screen.update();
		// System.out.print(score+"\n");
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		screen.draw(win);
	}

}
