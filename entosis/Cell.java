package entosis;

import processing.core.PApplet;

public class Cell {
	
	protected float x;
	protected float y;
	
	protected float velocityX;
	protected float velocityY;
	
	protected float radius;
	protected int c1;
	protected int c2;
	protected int strokeThickness;
	protected int strokeColor;
	
	public static PApplet parent;

	public Cell() {	// generic constructor
	}
	
	public Cell(float x, float y, float velocityX, float velocityY, float radius,
			int c1, int c2, int strokeThickness, int strokeColor) {
		super();
		this.x = x;
		this.y = y;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.radius = radius;
		this.c1 = c1;
		this.c2 = c2;
		this.strokeThickness = strokeThickness;
		this.strokeColor = strokeColor;
	}

	public void update() {
		x += velocityX;
		y += velocityY;
		
		if( x+radius/2 > 480 || x-radius/2 < 0.0f ) { // How replace 480 with screenX from main class? // Have to pass in with every new Cell created?
			velocityX *= -1;
		}
		
		if ( y+radius/2 > 320 || y-radius/2 < 0.0f ) {
			velocityY *= -1;
		}
	}
	
	public void display() {
		// Generates gradient and displays ellipse
		float px = 0, py = 0, angle = 0;

		// calculate differences between color components 
		float deltaR = parent.red(c2) - parent.red(c1);
		float deltaG = parent.green(c2) - parent.green(c1);
		float deltaB = parent.blue(c2) - parent.blue(c1);
		// hack to ensure there are no holes in gradient
		// needs to be increased, as radius increases
		float gapFiller = 8.0f;
		
		for (int i=0; i< radius; i++){
		  for (float j=0; j<360; j+=1.0/gapFiller){
		    px = x+parent.cos(parent.radians(angle))*i;
		    py = y+parent.sin(parent.radians(angle))*i;
		    angle+=1.0/gapFiller;
		    int c = parent.color(
		    (parent.red(c1)+(i)*(deltaR/radius)),
		    (parent.green(c1)+(i)*(deltaG/radius)),
		    (parent.blue(c1)+(i)*(deltaB/radius)) 
		      );
		    parent.set(parent.parseInt(px), parent.parseInt(py), c);
		  }
		}
		// adds smooth edge 
		// hack anti-aliasing
		parent.noFill();
		parent.stroke(strokeColor);
		parent.strokeWeight(strokeThickness);
		parent.ellipse(x, y, radius*2, radius*2);
	}

}
