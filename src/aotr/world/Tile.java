package aotr.world;

import java.awt.image.BufferedImage;

import aotr.objects.entities.Entity;
import aotr.objects.floors.Floor;
import aotr.objects.items.Item;
import aotr.objects.structures.Structure;

public class Tile {

private Floor floor;
private Structure structure;

	public Tile (Floor floorTile, Structure structure , Item[] items) {
		this.floor = floorTile;
		this.structure = structure;
		
	}
	
	
	public BufferedImage getFloorTex() {
		
		return this.floor.getTex();
		
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	
	
	
	public Structure getStructure() {
		return this.structure;
	}
	
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
}

