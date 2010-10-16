package entosis;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;


public class Entosis extends PApplet {
	
	private int screenX = 480;
	private int screenY = 320;
	private int backgroundColor = color(64,64,64);
	
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
		player.velocity = new PVector(player.position.x - mouseX, player.position.y - mouseY);
		player.velocity.normalize();
	}
}
