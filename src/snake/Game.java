package snake;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener, KeyListener {
	Food food;
	Snake snake;
	static Game game;
	static Dimen dimen;
	boolean eatten;

	private static final long serialVersionUID = 1L;

	public Game() {
		food = new Food(dimen);
		snake = new Snake(dimen);
		setFocusable(true);
		addKeyListener(this);
		Timer timer = new Timer(20, this);
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		food.paint(g);
		snake.paint(g);

		Food head = snake.snake.get(snake.snake.size() - 1);
		if (head.getBound().intersects(food.getBound())) {
			eatten = true;
		}

		if (eatten) {
			snake.eat(food);
			food = new Food(dimen);
			eatten = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
//		snake.move(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		snake.move(e.getKeyCode());
	}

	/*
	 * This class whole the size of frame
	 */

	public static class Dimen {
		int x;
		int y;

		Dimen(int frameWidth, int frameHeigth) {
			x = frameWidth;
			y = frameHeigth;
		}
	}

	/** main method */
	public static void main(String[] args) {
		JFrame frame = new JFrame("snake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 200);
		frame.setVisible(true);
		dimen = new Dimen(frame.getWidth(), frame.getHeight());
		game = new Game();
		frame.add(game);
	}
}
