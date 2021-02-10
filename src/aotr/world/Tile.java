package aotr.world;

import java.awt.image.BufferedImage;


import aotr.objects.floors.Floor;
import aotr.objects.items.Item;


public class Tile {

private Floor floor;
<<<<<<< HEAD
private Structure structure;
private int entity;
=======
>>>>>>> parent of a8470dc (3d)


	public Tile (Floor floorTile, Item[] items) {
		this.floor = floorTile;
		this.entity = -1;
		
	}
	
	
	public BufferedImage getFloorTex() {
		
		return this.floor.getTex();
		
	}
<<<<<<< HEAD
	
public BufferedImage getStructureTex() {
	BufferedImage tex = null;
	if(structure != null) {
		tex = this.structure.getTex();
	}
	
	
		return tex;
		
	}
//public BufferedImage getEntityTex() {
//	BufferedImage tex = null;
//	if(entity != null) {
//		tex = this.entity.getTex();
//	}
//	return tex;
//}


	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	public void setEntity(int entity) {
		this.entity = entity;
	}
	
	public int getEntity() {
		
		return entity;
	}
=======

>>>>>>> parent of a8470dc (3d)
	
	
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
}

