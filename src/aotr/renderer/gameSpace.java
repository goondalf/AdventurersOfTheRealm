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


int frameWidth;
int frameHeight;
int frameRatioW;
int frameRatioH;
int windowHeight;
int windoWidth;


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
		for(int x = 0; x < frameWidth; x++) {
			
			for(int y = 0; y < frameHeight; y++) {
				
				if(((game.player.getX() + x - frameWidth/2) < 0) || ((game.player.getX() + x - frameWidth/2) > 99) 
						|| ((game.player.getY() + y - frameHeight/2) < 0) || ((game.player.getY() + y - frameHeight/2) > 99)) {
				square = game.fIndex.getIndex(3).getTex();	
				}else {
				
				square = world.getTile(game.player.getX() + x - frameWidth/2, game.player.getY() + y - frameHeight/2).getFloorTex();
				}
				g.drawImage(square, x *(windowHeight / frameHeight), y *(windowHeight / frameHeight), windowHeight / frameHeight, windowHeight / frameHeight, null);	
			
			}
			
		}
		g.drawImage(game.getPlayerTex(), frameWidth/2 *(windowHeight / frameHeight), frameHeight/2 *(windowHeight / frameHeight), windowHeight / frameHeight, windowHeight / frameHeight, null);
		
		}else if(game.player.lookbool == true) {
			for(int x = 0; x < frameWidth; x++) {
				
				for(int y = 0; y < frameHeight; y++) {
					
					if(((game.player.look.getX() + x - frameWidth/2) < 0) || ((game.player.look.getX() + x - frameWidth/2) > 99) 
							|| ((game.player.look.getY() + y - frameHeight/2) < 0) || ((game.player.look.getY() + y - frameHeight/2) > 99)) {
					square = game.fIndex.getIndex(3).getTex();	
					}else {
					
					square = world.getTile(game.player.look.getX() + x - frameWidth/2, game.player.look.getY() + y - frameHeight/2).getFloorTex();
					
					
					
					}
					
					
					
					g.drawImage(square, x *(windowHeight / frameHeight), y *(windowHeight / frameHeight), windowHeight / frameHeight, windowHeight / frameHeight, null);	
					
					if(game.player.getX() == (game.player.look.getX() + x - frameWidth/2 )&& game.player.getY() == (game.player.look.getY() + y - frameHeight/2 )) {
						g.drawImage(game.getPlayerTex(), x *(windowHeight / frameHeight), y *(windowHeight / frameHeight), windowHeight / frameHeight, windowHeight / frameHeight, null);	
						}
					
				}
			}
			
			g.drawImage(game.player.look.getTex(), frameWidth/2 *(windowHeight / frameHeight), frameHeight/2 *(windowHeight / frameHeight), windowHeight / frameHeight, windowHeight / frameHeight, null);	
			
		}

			
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
