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
private int worldWidth;
private int worldHeight;

public world(Main game, int worldWidth, int worldHeight) {
this.worldArray = new Tile[worldWidth][worldHeight];	
this.game = game;	
this.worldWidth = worldWidth;
this.worldHeight = worldHeight;

setTile = new Tile(game.getFloor(0),null,null);
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
			setTile = new Tile(game.getFloor(rand.nextInt(2)),null,null);	
			this.worldArray[x][y] = setTile;
			
		}
		}
	
	
	game.eManager.spawnEntity(16, 16, 0);
	game.eManager.spawnEntity(17, 17, 0);
	
	this.worldArray[10][10].setStructure(game.sIndex.getIndex(0));
	this.worldArray[9][10].setStructure(game.sIndex.getIndex(2));
	this.worldArray[11][10].setStructure(game.sIndex.getIndex(3));
	this.worldArray[9][11].setStructure(game.sIndex.getIndex(1));
	this.worldArray[11][11].setStructure(game.sIndex.getIndex(13));
	this.worldArray[9][12].setStructure(game.sIndex.getIndex(4));
	this.worldArray[10][12].setStructure(game.sIndex.getIndex(0));
	this.worldArray[11][12].setStructure(game.sIndex.getIndex(5));
	this.worldArray[10][11].setFloor(game.getFloor(4));
	
	this.game.gamestate = 1;	
}

public void loadWorld() {
	
	
}

public Tile getTile(int x, int y) {
	
	return this.worldArray[x][y];
}


public int getWidth() {
	return this.worldHeight;
}

public int getHeight() {
	return this.worldWidth;
}

}
