package aotr.world;

import java.awt.image.BufferedImage;

import aotr.objects.entities.Entity;
import aotr.objects.floors.Floor;
import aotr.objects.items.Item;
import aotr.objects.structures.Structure;

public class Tile {

private Floor floor;
private Structure structure;
private Entity entity;
	public Tile (Floor floorTile, Structure structure , Entity entity, Item[] items) {
		this.floor = floorTile;
		this.structure = structure;
		this.entity = entity;
		
	}
	
	
	public BufferedImage getFloorTex() {
		
		return this.floor.getTex();
		
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}


	public Entity getEntity() {
		return this.entity;		
	}
	
	public Structure getStructure() {
		return this.structure;
	}
	
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
}

