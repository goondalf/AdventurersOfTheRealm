package aotr.world;

import java.awt.image.BufferedImage;


import aotr.objects.floors.Floor;
import aotr.objects.items.Item;


public class Tile {

private Floor floor;


	public Tile (Floor floorTile, Item[] items) {
		this.floor = floorTile;
		
		
	}
	
	
	public BufferedImage getFloorTex() {
		
		return this.floor.getTex();
		
	}

	
	
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
}

