package entosis;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;


public class Entosis extends PApplet {
	
	private int screenX = 480;
	private int screenY = 320;
	private int backgroundColor = color(32,32,32);
	private int clickCounter = 0;
	private PVector vels[] = new PVector[10];
	
	Player player;
	ArrayList<Mote> moteList = new ArrayList<Mote>();

	public void setup() {
		
		size(screenX, screenY);
		smooth();
		
		Cell.papplet = this;
		
		player = new Player(10);
		
		for( int i = 0; i < 5; i++ ) {
			moteList.add( new Mote(random(5,15)) );
		}
		
		for ( int i=0; i<10; i++ ) {
			vels[i] = new PVector(0,0);
		}
		
	}

	public void draw() {
		
		background(backgroundColor);
		
		player.update();
		player.display();
		
		for ( Mote eachMote: moteList ) {
			eachMote.update();
			eachMote.display();
		}
		
	}
	
	public void mouseClicked() {
		clickCounter++;
		PVector sum = new PVector(0,0);
		
		vels[clickCounter%10] = new PVector(player.position.x - mouseX, player.position.y - mouseY);
		vels[clickCounter%10].normalize();
		
		for ( int i=0; i<10; i++ ) {
			sum.add(vels[i]);
		}
		
		sum.div(10); // Get average
		player.velocity = sum;
	}
	
}
