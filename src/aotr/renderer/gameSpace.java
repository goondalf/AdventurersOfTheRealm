package aotr.renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import aotr.Main;
import aotr.objects.player.Look;
import aotr.world.world;



public class gameSpace {
private world world;
private BufferedImage square;
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
	
		 
		for(int x = 0; x < frameWidth; x++) {
			
			for(int y = 0; y < frameHeight; y++) {
				
				if(((midX + x - frameWidth/2) < 0) || ((midX + x - frameWidth/2) > 99) 
						|| ((midY + y - frameHeight/2) < 0) || ((midY + y - frameHeight/2) > 99)) {
				square = game.fIndex.getIndex(3).getTex();	
				}else {
				
				square = world.getTile(midX + x - frameWidth/2, midY + y - frameHeight/2).getFloorTex();
				
				
				}
				g.drawImage(square, x *(windowHeight / frameHeight), y *(windowHeight / frameHeight), windowHeight / frameHeight, windowHeight / frameHeight, null);	
				
				if(game.player.lookbool == true && (midX + x - frameWidth/2) == game.getPlayerX() && (midY + y - frameHeight/2) == game.getPlayerY()) {
					g.drawImage(game.getPlayerTex(), x *(windowHeight / frameHeight), y *(windowHeight / frameHeight), windowHeight / frameHeight, windowHeight / frameHeight, null);	
					}
			}
			
		}
		g.drawImage(midTex, frameWidth/2 *(windowHeight / frameHeight), frameHeight/2 *(windowHeight / frameHeight), windowHeight / frameHeight, windowHeight / frameHeight, null);
		
		

			
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
