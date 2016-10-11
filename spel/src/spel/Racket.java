package spel;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Racket {
	
	private int width = 70;
	private int height = 10;
	private int x = 350;
	private int y = 700;
	private int moveX = 0;
	private Game game;
	
	public Racket(Game game){
		this.game = game;
		
	}
	
	public void paint(Graphics2D g){
		g.setColor(Color.orange);
		g.fillRect(x, y, width, height);
	}
	
	void move(){
		if(x + moveX > 0 && x + moveX < game.getWidth() - 70)
			x += moveX;
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			moveX = -2;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			moveX = 2;
	}

	public void keyReleased(KeyEvent e) {
		
	}
}
