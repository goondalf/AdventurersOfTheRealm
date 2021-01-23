package aotr.objects.floors;


import java.awt.image.BufferedImage;
import java.util.ArrayList;

import aotr.Main;




public class FloorIndex {

private ArrayList<Floor> fIndex = new ArrayList<Floor>();

private Floor floor;
//private textureProcessor tile;
//private static BufferedImage tex;



//stores data for all floor types in an array
public FloorIndex (Main game) {

	
	for(int i = 0; i < 10; i++) {	
		
		switch(i) {
	case 0:
		
		floor = new Floor(game.tManager.getImage(1, 0, 0), "grass");
		break;
	case 1:
		
		floor = new Floor(game.tManager.getImage(1, 1, 0), "stone");
		break;
	case 3:
		
		floor = new Floor(game.tManager.getImage(1, 1, 0), "blank");
		break;
	case 4:
		
		floor = new Floor(game.tManager.getImage(1, 2, 0), "Wood Floor");
		break;
		}
		fIndex.add(floor);
	}	
	}



//returns floor object at position in array
public Floor getIndex(int i) {
	Floor floor = fIndex.get(i);
	return floor;
	
}


	
}
