package entosis;

import processing.core.PApplet;
import processing.core.PVector;


public class Entosis extends PApplet {
	
	private int screenX = 480;
	private int screenY = 320;
	private int backgroundColor = color(64,64,64);
	
	Cell firstCell;

	public void setup() {
		
		size(screenX, screenY);
		smooth();
		
		Cell.papplet = this;
		
		firstCell = new Player(10, color(0,255,0,125), color(0,0,255,125), 1, color(0,0,0,125));
	}

	public void draw() {
		
		//firstCell.x++;
		//firstCell.y++;
		
		background(backgroundColor);
		
		firstCell.update();
		firstCell.display();
		
	}
	
	public void mouseClicked() {
		firstCell.velocity = new PVector(firstCell.position.x - mouseX, firstCell.position.y - mouseY);
		firstCell.velocity.normalize();
	}
}
