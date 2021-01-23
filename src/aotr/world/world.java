package aotr.world;

import java.util.Random;

import aotr.Main;
import aotr.objects.structures.Structure;

public class world {

private Tile[][] worldArray;
private Tile setTile;
private Main game;
private Random rand = new Random();
private int worldWidth;
private int worldHeight;

public world(Main game, int worldWidth, int worldHeight) {
this.worldArray = new Tile[worldWidth][worldHeight];	
this.game = game;	
this.worldWidth = worldWidth;
this.worldHeight = worldHeight;

setTile = new Tile(game.getFloor(0),null);
for(int x=0; x < worldWidth; x++) {
	for(int y=0; y < worldHeight; y++) {
			
		this.worldArray[x][y] = setTile;
		
	}

}	
}


public void generateWorld() {
this.game.gamestate = 10;
	this.game.player.setX(15);
	this.game.player.setY(15);

	for(int x=0; x < worldWidth; x++) {
		for(int y=0; y < worldHeight; y++) {
			setTile = new Tile(game.getFloor(rand.nextInt(2)),null);	
			this.worldArray[x][y] = setTile;
			
		}
		}
	
	
	game.eManager.spawnEntity(16, 16, 0);
	game.eManager.spawnEntity(17, 17, 0);
	game.sManager.createStructure(10, 10, 0);
	
	this.worldArray[11][11].setFloor(game.fIndex.getIndex(4));
	
	this.game.gamestate = 1;	
}

public void loadWorld() {
	
	
}

public Tile getTile(int x, int y) {
	
	return this.worldArray[x][y];
}


public Structure getStructure(int x, int y) {
	return game.sManager.structureAtPosition(x, y);
}


public int getWidth() {
	return this.worldHeight;
}

public int getHeight() {
	return this.worldWidth;
}

}
