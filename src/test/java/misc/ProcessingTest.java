package misc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import processing.core.PApplet;

public class ProcessingTest extends PApplet {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ProcessingTest.class);

	public static void main(String args[]) {
//		PApplet.main(new String[] { ImportProcessingCore.ProcessingTest.class.getName() });
		PApplet.main("UsingProcessing");
	}

	private boolean e;
	private float i;
	private int j;

	@Override
	public void settings() {
		size(600, 600);

	}

	@Override
	public void setup() {
//		background(0);
		size(400, 400);
		background(190, 255, 255);
		strokeWeight(30);
		stroke(0, 0, 0, 50);
		int a = 0;
		int b = 10;
		int c = 7;
		int d = random(8, 16, 20);
		if (a == 0)
			;
		System.out.println(1);
	}

	private int random(int i, int j, int k) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw() {
		fill(random(255), random(255), random(255), random(255));
		rect(200, 200, 300, 400);
	}

}