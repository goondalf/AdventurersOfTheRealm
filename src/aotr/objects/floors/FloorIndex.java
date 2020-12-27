package aotr.objects.floors;

import java.awt.Color;
import java.awt.image.BufferedImage;

import aotr.resources.graphics.textureProcessor;



public class FloorIndex {

private Floor[] fIndex = new Floor[10];

private Floor floor;
//private textureProcessor tile;
//private static BufferedImage tex;



//stores data for all floor types in an array
public FloorIndex (BufferedImage texture) {
BufferedImage tex = texture;	
	
	for(int i = 0; i < 10; i++) {	
		
		textureProcessor tile = new textureProcessor(tex);
		switch(i) {
	case 0:
		//tex = tile.grabImage(1, 12, 32, 32);
		//floor = new Floor(tile.changeImageColor(tile.grabImage(1, 12, 32, 32),Color.white,new Color(0,200,0)), "grass");
		fIndex[i] = new Floor(tile.changeImageColor(tile.grabImage(1, 12, 32, 32),Color.white,new Color(0,200,0)), "grass");
		break;
	case 1:
		//tex = tile.grabImage(3, 12, 32, 32);
		//floor = new Floor(tile.changeImageColor(tile.grabImage(3, 12, 32, 32), Color.white,Color.gray), "stone");
		fIndex[i] = new Floor(tile.changeImageColor(tile.grabImage(3, 12, 32, 32), Color.white,Color.gray), "stone");
		break;
	case 3:
		//tex = tile.grabImage(12, 13, 32, 32);
		//floor = new Floor(tile.changeImageColor(tile.grabImage(12, 13, 32, 32), Color.white,Color.BLACK), "blank");
		fIndex[i] = new Floor(tile.changeImageColor(tile.grabImage(12, 13, 32, 32), Color.white,Color.BLACK), "blank");
		break;
	case 4:
		//tex = tile.grabImage(3, 12, 32, 32);
		//floor = new Floor(tile.changeImageColor(tile.grabImage(3, 12, 32, 32), Color.white,new Color(139,70,19)), "Wood Floor");
		fIndex[i] = new Floor(tile.changeImageColor(tile.grabImage(3, 12, 32, 32), Color.white,new Color(139,70,19)), "Wood Floor");
		break;
	
		
	}	
	}	
	}



//returns floor object at position in array
public Floor getIndex(int i) {
	return fIndex[i];
	
}


	
}
