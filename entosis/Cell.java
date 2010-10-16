package entosis;

import processing.core.PApplet;
import processing.core.PVector;

public class Cell {
	
	protected PVector position;
	
	protected PVector velocity;
	
	protected float radius;
	protected int c1;
	protected int c2;
	protected int strokeThickness;
	protected int strokeColor;
	
	public static PApplet papplet;

	public Cell() {	// generic constructor
	}
	
	public Cell(float radius) {
		super();
		this.position = generateRandPVector(0, papplet.height);
		this.velocity = generateRandPVector(-2, 2);
		this.radius = radius;
	}

	public void update() {
		position.x += velocity.x;
		position.y += velocity.y;
		
		if( position.x+radius > 480 || position.x-radius < 0.0f ) { // How replace 480 with screenX from main class? // Have to pass in with every new Cell created?
			velocity.x *= -1;
		}
		
		if ( position.y+radius > 320 || position.y-radius < 0.0f ) {
			velocity.y *= -1;
		}
	}
	
	public void display() {
		// Generates gradient and displays ellipse
		float px = 0, py = 0, angle = 0;

		// calculate differences between color components 
		float deltaR = papplet.red(c2) - papplet.red(c1);
		float deltaG = papplet.green(c2) - papplet.green(c1);
		float deltaB = papplet.blue(c2) - papplet.blue(c1);
		// hack to ensure there are no holes in gradient
		// needs to be increased, as radius increases
		float gapFiller = 8.0f;
		
		for (int i=0; i< radius; i++){
		  for (float j=0; j<360; j+=1.0/gapFiller){
		    px = position.x+papplet.cos(papplet.radians(angle))*i;
		    py = position.y+papplet.sin(papplet.radians(angle))*i;
		    angle+=1.0/gapFiller;
		    int c = papplet.color(
		    (papplet.red(c1)+(i)*(deltaR/radius)),
		    (papplet.green(c1)+(i)*(deltaG/radius)),
		    (papplet.blue(c1)+(i)*(deltaB/radius)) 
		      );
		    papplet.set(papplet.parseInt(px), papplet.parseInt(py), c);
		  }
		}
		// adds smooth edge 
		// hack anti-aliasing
		papplet.noFill();
		papplet.stroke(strokeColor);
		papplet.strokeWeight(strokeThickness);
		papplet.ellipse(position.x, position.y, radius*2, radius*2);
	}
	
	public PVector generateRandPVector( float min, float max ) {
		
		float velocity[] = new float[2];
		
		for( int i=0; i<2; i++ ) {
			velocity[i] = 0.0f;
			while(velocity[i] == 0.0f) {
				velocity[i] = papplet.random(min, max);
			}
		}
		return new PVector(velocity[0], velocity[1]);
	}

}
