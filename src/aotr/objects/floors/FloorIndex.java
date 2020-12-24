package aotr.objects.floors;

import java.awt.Color;
import java.awt.image.BufferedImage;

import aotr.resources.graphics.textureProcessor;



public class FloorIndex {

private Floor[] fIndex = new Floor[10];

private Floor grass;
private Floor stone;
private Floor blank;
private textureProcessor tile;
private BufferedImage tex;



//stores data for all floor types in an array
public FloorIndex(BufferedImage texture) {
	tile = new textureProcessor(texture);
	
	for(int i = 0; i < 10; i++) {	
	switch(i) {
	case 0:
		tex = tile.grabImage(1, 12, 32, 32);
		tex = tile.changeImageColor(tex,Color.white,new Color(0,200,0));
		grass = new Floor(tex, "grass");
		fIndex[i] = grass;
		break;
	case 1:
		tex = tile.grabImage(3, 12, 32, 32);
		tex = tile.changeImageColor(tex, Color.white,Color.gray);
		stone = new Floor(tex, "stone");
		fIndex[i] = stone;
		break;
	case 3:
		tex = tile.grabImage(12, 14, 32, 32);
		tex = tile.changeImageColor(tex, Color.white,Color.BLACK);
		blank = new Floor(tex, "blank");
		fIndex[i] = blank;
		break;
	
		
	}	
	}	
	}



//returns floor object at position in array
public Floor getIndex(int i) {
	return fIndex[i];
	
}


	
}
