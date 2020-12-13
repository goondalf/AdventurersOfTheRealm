package aotr.world;

import java.awt.image.BufferedImage;

import aotr.objects.entities.Entity;
import aotr.objects.floors.Floor;
import aotr.objects.items.Item;
import aotr.objects.structures.Structure;

public class Tile {

private Floor floor;
	
	public Tile (Floor floorTile, Structure structure , Entity entity, Item[] items) {
		this.floor = floorTile;
		
		
	}
	
	
	public BufferedImage getFloorTex() {
		
		return this.floor.getTex();
		
	}
}
