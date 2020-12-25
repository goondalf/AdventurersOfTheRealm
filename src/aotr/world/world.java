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

public world(Main game) {
this.worldArray = new Tile[100][100];	
this.game = game;	


setTile = new Tile(game.getFloor(0),null,null,null);
for(int x=0; x < 100; x++) {
	for(int y=0; y < 100; y++) {
			
		this.worldArray[x][y] = setTile;
		
	}

}	
}


public void generateWorld() {

	
	for(int x=0; x < 100; x++) {
		for(int y=0; y < 100; y++) {
			setTile = new Tile(game.getFloor(rand.nextInt(2)),null,null,null);	
			this.worldArray[x][y] = setTile;
			
		}
	
	this.worldArray[10][10].setStructure(game.sIndex.getIndex(0));
		
	}	
	
}

public void loadWorld() {
	
	
}

public Tile getTile(int x, int y) {
	
	return this.worldArray[x][y];
}

}
