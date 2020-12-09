package aotr.renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import aotr.Main;
import aotr.objects.types.world;



public class gameSpace {
private world world;
private BufferedImage square;
private Main game;

int frameWidth;
int frameHeight;


public gameSpace(Main game){
this.game = game;
frameWidth =  13;
frameHeight = 9;
}
	
public void render(Graphics g, int windowWidth, int windowHeight, Main game) {
	this.game = game;
	
	
	world = game.getWorld();
		
		
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
		

			
}

public void zoomIn() {
if(game.getGameState() == 1) {
	frameWidth = frameWidth - 2;
	frameHeight = frameHeight - 2;
}
}

public void zoomOut() {
	if(game.getGameState() == 1) {
	frameWidth = frameWidth + 2;
	frameHeight = frameHeight + 2;
	}
}


	
}
