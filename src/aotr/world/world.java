package aotr.world;

import java.util.Random;

import aotr.Main;
import aotr.objects.structures.Structure;

public class world {

private Tile[][] worldArray;
private Tile setTile;
private Main game;
private Random rand = new Random();
private Structure setStructure;
public final int worldWidth = 1000;
public final int worldHeight = 1000;


public world(Main game) {
this.worldArray = new Tile[worldWidth][worldHeight];	
this.game = game;	


setTile = new Tile(game.getFloor(0),null,null,null);
for(int x=0; x < worldWidth; x++) {
	for(int y=0; y < worldHeight; y++) {
			
		this.worldArray[x][y] = setTile;
		
	}

}	
}


public void generateWorld() {

	
	for(int x=0; x < worldWidth; x++) {
		for(int y=0; y < worldHeight; y++) {
			setTile = new Tile(game.getFloor(rand.nextInt(2)),null,null,null);	
			this.worldArray[x][y] = setTile;
			
		}
	
	this.worldArray[10][10].setStructure(game.sIndex.getIndex(0));
	this.worldArray[9][10].setStructure(game.sIndex.getIndex(2));
	this.worldArray[11][10].setStructure(game.sIndex.getIndex(3));
	this.worldArray[9][11].setStructure(game.sIndex.getIndex(1));
	this.worldArray[11][11].setStructure(game.sIndex.getIndex(1));
	this.worldArray[9][12].setStructure(game.sIndex.getIndex(4));
	this.worldArray[10][12].setStructure(game.sIndex.getIndex(0));
	this.worldArray[11][12].setStructure(game.sIndex.getIndex(5));
	this.worldArray[10][11].setFloor(game.getFloor(4));
	}	
	
}

public void loadWorld() {
	
	
}

public Tile getTile(int x, int y) {
	
	return this.worldArray[x][y];
}

}
