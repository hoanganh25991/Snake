package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import snake.Game.Dimen;

public class Snake {
	int snakeX, snakeY;
	ArrayList<Food> snake;

	public Snake(Dimen d) {
		snake = new ArrayList<Food>();
		Food f = new Food(d);
		snake.add(f);
		snakeX = f.x;
		snakeY = f.y;
	}

	public void paint(Graphics g) {
		g.setColor(Color.blue);
		for (int i = 0; i < snake.size(); i++) {
			Food f = snake.get(i);
			g.fillRect(f.x, f.y, Food.width, Food.height);
		}
	}

	public void eat(Food f) {
		snake.add(f);
	}

	public void move(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			snakeX += Food.width;
			break;
		case KeyEvent.VK_LEFT:
			snakeX -= Food.width;
			break;
		case KeyEvent.VK_UP:
			snakeY -= Food.height;
			break;
		case KeyEvent.VK_DOWN:
			snakeY += Food.height;
			break;
		}
		snake.remove(0);
		Food f = new Food(snakeX, snakeY);
		snake.add(f);
		System.out.println(snakeX + "," + snakeY);
	}

}
