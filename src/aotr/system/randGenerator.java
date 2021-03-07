package aotr.system;

import java.util.Random;

import aotr.Main;

public class randGenerator {

	public randGenerator(Main game) {
		
	}
	
	
	public int randBetween(int upper, int lower) {
		Random r = new Random();
		int num = r.nextInt((upper - lower)+1) + lower;
		return num;
	}
	
	
	
}
