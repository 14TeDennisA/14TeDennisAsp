import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Dummy implements Entity {

    private final ImageIcon image = new ImageIcon("bin/baaa.jpg"); 

    protected Point position;

    protected Pasture pasture;
   
    public Dummy(Pasture pasture) {
	this.pasture = pasture;
    }

    public Dummy(Pasture pasture, Point position) {
	this.pasture   = pasture;
	this.position  = position;
    }
    
    public Point getPosition() { return position; }

    
    public void setPosition(Point newPosition) { 
    	if(newPosition.getX()< this.pasture.getWidth() && newPosition.getX() >=0  && newPosition.getY()< this.pasture.getHeight() && newPosition.getY()>=0){
    		position = newPosition; 
    		/// KOLLA KOLLISION IGEN FÖR SAKER ÄR LÖST OM MAN DELAR MED BREDDEN PÅ BANAN WOOO(fuck me -simon 2k17)
    		      	
    	}
    }

    
    public void tick() {
    	

    	//setPosition(new Point((int)getPosition().getX()+ThreadLocalRandom.current().nextInt(-1, 1 + 1),(int)getPosition().getY()+ ThreadLocalRandom.current().nextInt(-1, 1 + 1)));
    	
    	System.out.println(this.pasture.mouseX );
    	System.out.println((this.position.getX()) * 30);
    	
    	
    }

    public String type() {
	return "Dummy";
    }
    
    public ImageIcon getImage() { return image; }

   
}
