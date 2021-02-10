package aotr.world;

import java.util.Random;

import aotr.Main;
import aotr.objects.entities.Entity;
import aotr.objects.structures.Structure;

public class world {

private static Tile[][][] worldArray;
private Tile setTile;
private Main game;
private Random rand = new Random();

private int worldWidth;
private int worldHeight;

public world(Main game, int worldWidth, int worldHeight, int worldDepth) {
this.worldArray = new Tile[worldWidth][worldHeight][worldDepth];	
this.game = game;	
this.worldWidth = worldWidth;
this.worldHeight = worldHeight;

setTile = new Tile(game.getFloor(0));
for(int x=0; x < worldWidth; x++) {
	for(int y=0; y < worldHeight; y++) {
			for(int z=0; z < worldDepth; z++) {
		this.worldArray[x][y][z] = setTile;
			}
	}

}	
}


public void generateWorld() {
this.game.gamestate = 10;
	this.game.player.setX(15);
	this.game.player.setY(15);

	for(int x=0; x < worldWidth; x++) {
		for(int y=0; y < worldHeight; y++) {
			setTile = new Tile(game.getFloor(rand.nextInt(2)));	
			this.worldArray[x][y][1] = setTile;
			
		}
		}
	
	
	game.eManager.spawnEntity(12, 12,1, 0);
	
	
	this.worldArray[10][10][2] = new Tile(game.getFloor(0));
	

	game.sManager.createStructure(10, 10,1, 0);
	
	
	
	this.game.gamestate = 1;	
	
	   System.gc();
}

public void loadWorld() {
	
	
}







public Tile getTile(int x, int y,int z) {
	
	return worldArray[x][y][z];
}

public Entity getEntity(int x, int y, int z) {
	Entity entity = null;
	if(worldArray[x][y][z].getEntity() != -1) {
		entity = game.eManager.getIndex(worldArray[x][y][z].getEntity());
	}
	
	return entity;
}

public void setStructure(int x, int y, int z, Structure structure) {
	worldArray[x][y][z].setStructure(structure);
}

public Structure getStructure(int x, int y,int z) {
	return game.sManager.structureAtPosition(x, y,z);
}


public int getWidth() {
	return this.worldHeight;
}

public int getHeight() {
	return this.worldWidth;
}

}
