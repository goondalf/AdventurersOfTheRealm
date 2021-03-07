package aotr.renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import aotr.Main;
import aotr.world.Tile;
import aotr.world.world;



public class gameSpace {
private world world;
private Main game;


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
this.frameWidth =  31;
this.frameHeight = 19;

}
	
public void render(Graphics g, int windowWidth, int windowHeight) {
	Tile tile = null;
	this.windowHeight = windowHeight;
	this.windoWidth = windowWidth;
	
	world = game.getWorld();
	
	if(game.player.getPlayerState() == 0) {
		midX = game.getPlayerX();
		midY = game.getPlayerY();
		midTex = game.getPlayerTex();
	}else if(game.player.getPlayerState() == 2) {
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
				
				
				if((relX < 0) || (relX > world.getWidth() -1) || (relY < 0) || (relY > world.getHeight()-1)) {
				
				}else {
				BufferedImage floortex = null;
				BufferedImage structureTex = null;
				BufferedImage entityTex = null;
				boolean drop = false;	
				
				
				if(game.world.getTile(relX, relY, game.player.getZ()) != null){
					tile = game.world.getTile(relX, relY, game.player.getZ());
					
				}else{
					int lowerZ = 0;	
			       while(game.world.getTile(relX, relY, game.player.getZ() - lowerZ) == null) {
						lowerZ ++;
					}
					tile = game.world.getTile(relX, relY, game.player.getZ() - lowerZ);
					drop = true;
				}
				
				floortex = tile.getFloorTex();
				structureTex = tile.getStructureTex();
				entityTex = tile.getEntityTex();
				
				
				if(floortex != null) {
				g.drawImage(floortex, screenX, screenY, squareSide, squareSide, null);	
				}
				
				if(structureTex != null) {
					g.drawImage(structureTex,  screenX, screenY, squareSide, squareSide, null);
				}
				
				if(entityTex != null) {
					g.drawImage(entityTex,  screenX, screenY, squareSide, squareSide, null);

				}
				
				if(drop == true) {
					g.drawImage(game.tManager.getImage(5, 0, 0),  screenX, screenY, squareSide, squareSide, null);
				}
				
				if(game.player.getPlayerState() == 1) {
					if(relX <= midX + 1 && relX >= midX -1 && relY <= midY + 1 && relY >= midY -1 && ((relX != midX)||(relY != midY))) {
						g.drawImage(game.player.getTadjTex(),  screenX, screenY, squareSide, squareSide, null);
					}
					
				}
				
				
				
				if(game.player.getPlayerState() == 2 && relX == game.getPlayerX() && relY == game.getPlayerY()) {
					g.drawImage(game.getPlayerTex(), screenX, screenY, squareSide, squareSide, null);	
					}
			
					

				}
			
			
			 
		}
		g.drawImage(midTex, frameWidth/2 *(squareSide), frameHeight/2 *(squareSide), squareSide, squareSide, null);
		
		}	

			
}

public void getContents(int x, int y, int z) {
	
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
