package aotr.objects.types;

import java.util.Random;

import aotr.Main;

public class world {

private Tile[][] worldArray;
private Tile setTile;
private Main game;
private Random rand = new Random();

public world(Main game) {
this.worldArray = new Tile[100][100];	
this.game = game;	


setTile = new Tile(game.getFloor(0),0,null);
for(int x=0; x < 100; x++) {
	for(int y=0; y < 100; y++) {
			
		worldArray[x][y] = setTile;
		
	}

}	
}


public void generateWorld() {

	
	for(int x=0; x < 100; x++) {
		for(int y=0; y < 100; y++) {
			setTile = new Tile(game.getFloor(rand.nextInt(2)),0,null);	
			worldArray[x][y] = setTile;
			
		}
		
	}	
	
}

public void loadWorld() {
	
	
}

public Tile getTile(int x, int y) {
	
	return this.worldArray[x][y];
}

}
