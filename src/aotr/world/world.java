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


for(int x=0; x < worldWidth; x++) {
	for(int y=0; y < worldHeight; y++) {
			
		this.worldArray[x][y][1] = new Tile(game.fIndex.getIndex(0));
		
	}

}	
}


public void generateWorld() {
this.game.gamestate = 10;
	this.game.player.setX(15);
	this.game.player.setY(15);

	for(int x=0; x < worldWidth; x++) {
		for(int y=0; y < worldHeight; y++) {
			setTile = new Tile(game.getFloor(game.rand.randBetween(2,1)));	
			this.worldArray[x][y][1] = setTile;
			
		}
		}
	
	this.worldArray[10][10][2] = new Tile(game.getFloor(0));
	
	game.eManager.spawnEntity(16, 16,1, 0);
	game.sManager.createStructure(10, 10,1, 0);
	
	
	
	this.game.gamestate = 1;	
}

public void loadWorld() {
	
	
}


public static void setEntity(int x, int y, int z,Entity entity) {
	worldArray[x][y][z].setEntity(entity);
}

public void setStructure(int x, int y, int z,Structure structure) {
	worldArray[x][y][z].setStructure(structure);
}


public Tile getTile(int x, int y,int z) {
	
	return worldArray[x][y][z];
}


public Structure getStructure(int x, int y,int z) {
	return game.sManager.structureAtPosition(x, y,z);
}

public boolean isTileSolid(int x, int y,int z) {
	boolean solidbool = false;
	solidbool = this.worldArray[x][y][z].isSolid();
	if(game.player.getX() == x && game.player.getY() == y && game.player.getZ() == z) {
		solidbool = true;
	}
	return solidbool;
}


public int getWidth() {
	return this.worldHeight;
}

public int getHeight() {
	return this.worldWidth;
}

}
