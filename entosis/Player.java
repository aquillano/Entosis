package entosis;

import processing.core.PVector;

public class Player extends Cell {

	public Player(float radius, int c1, int c2, int strokeThickness,
			int strokeColor) {
		super(radius, c1, c2, strokeThickness, strokeColor);
		
		position = new PVector(papplet.width/2, papplet.height/2);
		velocity = new PVector(0, 0);
		
	}

}
