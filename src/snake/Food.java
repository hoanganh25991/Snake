package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import snake.Game.Dimen;

public class Food {
	final static int width = 10;
	final static int height = 10;
	Random rand;
	Dimen d;
	int x, y;

	public Food(Dimen g) {
		this.d = g;
		rand = new Random();
		x = (rand.nextInt(d.x) / 10) * 10;
		y = (rand.nextInt(d.y) / 10) * 10;
	}

	public Food(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
	}

	public Rectangle getBound() {
		return new Rectangle(x, y, width, height);
	}
}
