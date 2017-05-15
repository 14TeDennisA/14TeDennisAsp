package spel;
import java.awt.*;
public class Ball {

	
	private int d = 50;
	private int x = 0;
	private int y = 0;
	private int moveX = 3;
	private int moveY = 3;
	Color ballColor = new Color(0xE73AC0);
	private Game game;
	
	public Ball(Game game){
		this.game = game;
	}
	
	
	void moveBall(){
		if(x + moveX < 0)
			moveX = 3;
		if(x + moveX > game.getWidth()  - d)
			moveX = -3;
		if(y + moveY < 0)
			moveY = 3;
		if(y + moveY > game.getHeight() - d)
			moveY = -3;
		
		
		x += moveX;
		y += moveY;
	}

	public void paint(Graphics2D g){
	g.setColor(ballColor);
	g.fillOval(x,y,d,d);
	}
	
}