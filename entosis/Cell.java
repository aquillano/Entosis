package entosis;

import processing.core.PApplet;

public class Cell {
	
	protected float x;
	protected float y;
	
	protected float velocityX;
	protected float velocityY;
	
	protected float size;
	protected int color;
	protected int strokeThickness;
	protected int strokeColor;
	
	public static PApplet parent;

	public Cell() {	// generic constructor
	}
	
	public Cell(float x, float y, float velocityX, float velocityY, float size,
			int color, int strokeThickness, int strokeColor) {
		super();
		this.x = x;
		this.y = y;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.size = size;
		this.color = color;
		this.strokeThickness = strokeThickness;
		this.strokeColor = strokeColor;
	}

	public void update() {
		x += velocityX;
		y += velocityY;
		
		if( x+size/2 > 480 || x-size/2 < 0.0f ) { // How replace 480 with screenX from main class? // Have to pass in with every new Cell created?
			velocityX *= -1;
		}
		
		if ( y+size/2 > 320 || y-size/2 < 0.0f ) {
			velocityY *= -1;
		}
	}
	
	public void display() {
		parent.fill(color);
		parent.stroke(strokeColor);
		parent.strokeWeight(strokeThickness);
		parent.ellipse(x, y, size, size);
	}

}
