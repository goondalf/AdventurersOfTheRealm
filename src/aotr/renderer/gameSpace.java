package aotr.renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import aotr.Main;
import aotr.objects.player.Look;
import aotr.world.Tile;
import aotr.world.world;



public class gameSpace {
private world world;
private BufferedImage floorTex;
private Main game;
private Tile tile;

BufferedImage midTex;


int frameWidth;
int frameHeight;
int frameRatioW;
int frameRatioH;
int windowHeight;
int windoWidth;
int midX;
int midY;
int relX;
int relY;
int screenX;
int screenY;
int squareSide;

public gameSpace(Main game){
this.game = game;
frameWidth =  31;
frameHeight = 19;

}
	
public void render(Graphics g, int windowWidth, int windowHeight, Main game) {
	this.game = game;
	this.windowHeight = windowHeight;
	this.windoWidth = windowWidth;
	
	world = game.getWorld();
	
	if(game.player.lookbool == false) {
		midX = game.getPlayerX();
		midY = game.getPlayerY();
		midTex = game.getPlayerTex();
	}else if(game.player.lookbool == true) {
		midX = game.player.look.getX();
		midY = game.player.look.getY();
		midTex = game.player.look.getTex(); 
	}
	squareSide = windowHeight/frameHeight;
		for(int x = 0; x < frameWidth; x++) {
			
			for(int y = 0; y < frameHeight; y++) {
				relX = (midX + x - frameWidth/2);
				relY = (midY + y - frameHeight/2);
				screenX = x * (windowHeight / frameHeight);
				screenY = y * (windowHeight / frameHeight);
				
				
				if((relX < 0) || (relX > 99) || (relY < 0) || (relY > 99)) {
				floorTex = game.fIndex.getIndex(3).getTex();	
				}else {
				floorTex = world.getTile(relX, relY).getFloorTex();
				tile = world.getTile(relX, relY);
				g.drawImage(floorTex, screenX, screenY, squareSide, squareSide, null);	
				
				
				if(tile.getStructure() != null) {
					g.drawImage(tile.getStructure().getTex(),  screenX, screenY, squareSide, squareSide, null);
				}
				
				
				if(game.player.lookbool == true && relX == game.getPlayerX() && relY == game.getPlayerY()) {
					g.drawImage(game.getPlayerTex(), screenX, screenY, squareSide, squareSide, null);	
					}
			
					

				}
			
			}
			 
		}
		g.drawImage(midTex, frameWidth/2 *(squareSide), frameHeight/2 *(squareSide), squareSide, squareSide, null);
		
		

			
}

public void zoomIn() {
if(game.getGameState() == 1 && frameWidth > 7) {
	frameWidth = frameWidth - 3;
	frameHeight = frameHeight - 2;
}
}

public void zoomOut() {
	if(game.getGameState() == 1 && frameWidth < 31) {
	frameWidth = frameWidth + 3;
	frameHeight = frameHeight + 2;
	}
}


public int getWidth() {

return (frameWidth * (windowHeight/frameHeight));	
	
}

public void getHeight() {
	
	
	
}

	
}
