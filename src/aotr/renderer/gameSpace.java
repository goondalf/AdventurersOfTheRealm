package aotr.renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import aotr.Main;
import aotr.objects.types.world;



public class gameSpace {
private world world;
private BufferedImage square;
BufferedImage[][] dispArray = new BufferedImage[11][11];

public gameSpace(){


}
	
public void render(Graphics g, int windowWidth, int windowHeight, Main game) {
		world = game.getWorld();
		
		
		for(int x = 0; x < 11; x++) {
			
			for(int y = 0; y < 11; y++) {
				
				if(((game.player.getX() + x - 5) < 0) || ((game.player.getX() + x - 5) > 99) || ((game.player.getY() + y - 5) < 0) || ((game.player.getY() + y - 5) > 99)) {
				square = game.fIndex.getIndex(3).getTex();	
				}else {
				
				square = world.getTile(game.player.getX() + x - 5, game.player.getY() + y - 5).getFloorTex();
				}
				g.drawImage(square, x *(windowHeight / 11), y *(windowHeight / 11), windowHeight / 11, windowHeight / 11, null);	
			
			}
			
		}
		
		g.drawImage(game.getPlayerTex(), 5 *(windowHeight / 11), 5 *(windowHeight / 11), windowHeight / 11, windowHeight / 11, null);

}
	
}
