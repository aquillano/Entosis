package entosis;

import processing.core.PApplet;


public class Entosis extends PApplet {
	
	private int screenX = 480;
	private int screenY = 320;
	private int backgroundColor = color(64,64,64);
	
	Cell firstCell;

	public void setup() {
		
		size(screenX, screenY);
		smooth();
		
		Cell.parent = this;
		
		firstCell = new Cell(screenX/2, screenY/2, generateVelocity(), generateVelocity(), 10, color(0,255,0,125), color(0,0,255,125), 1, color(0,0,0,125));
		
	}

	public void draw() {
		
		//firstCell.x++;
		//firstCell.y++;
		
		background(backgroundColor);
		
		firstCell.update();
		firstCell.display();
		
	}
	
	public float generateVelocity() {
		
		float velocity = 0.0f;
		
		while(velocity == 0.0f) {
			velocity = random(-2,2);
		}
		return velocity;
	}
}
