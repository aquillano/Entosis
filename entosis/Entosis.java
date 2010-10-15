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
		
		Cell.parent = this;
		
		firstCell = new Cell(screenX/2, screenY/2, generateVelocity(), 10, color(0,255,0,125), color(0,0,255,125), 1, color(0,0,0,125));
	}

	public void draw() {
		
		//firstCell.x++;
		//firstCell.y++;
		
		background(backgroundColor);
		
		firstCell.update();
		firstCell.display();
		
	}
	
	public PVector generateVelocity() {
		
		float velocity[] = new float[2];
		
		for( int i=0; i<2; i++ ) {
			velocity[i] = 0.0f;
			while(velocity[i] == 0.0f) {
				velocity[i] = random(-2,2);
			}
		}
		return new PVector(velocity[0], velocity[1]);
	}
}
