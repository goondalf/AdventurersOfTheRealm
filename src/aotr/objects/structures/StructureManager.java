package aotr.objects.structures;

import java.util.ArrayList;

import aotr.Main;
import aotr.objects.entities.Entity;

public class StructureManager {

	private Main game;
	private ArrayList<Structure> structureList;
	private int[][] structureLayer;
	public StructureManager(Main game) {
		this.game = game;
		structureList = new ArrayList<Structure>();
		structureLayer = new int[game.getWorldWidth()][game.getWorldHeight()];
		
		for(int x = 0; x < game.getWorldWidth(); x++) {
			for(int y = 0; y < game.getWorldWidth(); y++) {
				structureLayer[x][y] = -1;
			}
		}
		
	}

	public void createStructure(int x, int y, int id) {
		Structure structure;

		
		structure = game.sIndex.getIndex(id);
		structure.setPos(x, y);
		
		this.structureList.add(structure);
		this.structureLayer[x][y] = structureList.size()-1;
	}
	
	public Structure getIndex(int i) {
		return structureList.get(i);
	}
	
	public Structure structureAtPosition(int x, int  y) {
		Structure structure;
		structure = null;
		if(this.structureLayer[x][y] != -1) {
			structure = structureList.get(structureLayer[x][y]);
		}
		return structure;
	}
	
}

