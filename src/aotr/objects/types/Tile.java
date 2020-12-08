package aotr.objects.types;

import java.awt.image.BufferedImage;

import aotr.objects.floors.Floor;

public class Tile {

private Floor floor;
	
	public Tile (Floor floorTile, int structure ,Item[] items) {
		this.floor = floorTile;
		
		
	}
	
	
	public BufferedImage getFloorTex() {
		
		return this.floor.getTex();
		
	}
}
