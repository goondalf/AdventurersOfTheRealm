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

	public Tile (Floor floorTile) {
		this.floor = floorTile;
		
		
	}
	
	
	public BufferedImage getFloorTex() {
		
		return this.floor.getTex();
		
	}
	
public BufferedImage getStructureTex() {
	BufferedImage tex = null;
	if(structure != null) {
		tex = this.structure.getTex();
	}
	
	
		return tex;
		
	}
public BufferedImage getEntityTex() {
	BufferedImage tex = null;
	if(entity != null) {
		tex = this.entity.getTex();
	}
	return tex;
}

public boolean isSolid() {
	boolean solidbool = false;
	if(this.structure != null) {
	solidbool = this.structure.isSolid();
	}
	if(this.entity != null) {
    solidbool = this.entity.isSolid();
	}
	
	
	
	return solidbool;
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

