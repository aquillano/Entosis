package entosis;

import processing.core.PVector;

public class Player extends Cell {

	public Player(float radius) {
		super(radius);
		
		position = new PVector(papplet.width/2, papplet.height/2);
		velocity = new PVector(0, 0);
		c1 = papplet.color(0,255,0,125);
		c2 = papplet.color(0,0,255,125);
		strokeThickness = 1;
		strokeColor = papplet.color(0,0,255,125);
		
	}

}
