package aotr.objects.structures;

import java.util.ArrayList;

import aotr.Main;
import aotr.objects.entities.Entity;

public class StructureManager {

	private Main game;
	private ArrayList<Structure> structureList;
	public StructureManager(Main game) {
		this.game = game;
		structureList = new ArrayList<Structure>();
		
		
	}

	public void createStructure(int x, int y,int z, int id) {
		Structure structure;

		
		structure = game.sIndex.getIndex(id);
		structure.setPos(x, y,z);
		
		this.structureList.add(structure);
		game.world.setStructure(x, y, z, structure);
	}
	
	public Structure getIndex(int i) {
		return structureList.get(i);
	}
	
	public Structure structureAtPosition(int x, int  y,int z) {
		
		
		return game.world.getTile(x, y, z).getStructure();
	}
	
}

