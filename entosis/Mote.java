package entosis;

public class Mote extends Cell {

	public Mote() {
	}

	public Mote(float radius) {
		super(radius);
		
		c1 = papplet.color(253,203,108,125);
		c2 = papplet.color(0,0,255,125);
		strokeThickness = 1;
		strokeColor = papplet.color(0,0,255,125);
	}
	
	

}
