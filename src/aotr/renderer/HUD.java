package aotr.renderer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import aotr.Main;
import aotr.resources.graphics.textureProcessor;

public class HUD {

	int topLcorner;
	int topRcorner;
	int bLcorner;
	int bRcorner;
	int hudwidth;
	int hudheight;
	
	
	
	
Main game;	
	public HUD(Main game) {
		this.game = game;
	}

	
	public void render(Graphics g, int windowWidth, int windowHeight, Main game) {
		this.game = game;
		topLcorner = windowHeight;
		hudwidth = windowWidth / 10;
		g.setColor(Color.white);
	//	g.fillRect(topLcorner, 10, windowWidth - topLcorner, windowHeight);
		
		//g.fillRect(windowHeight, 5, 5, windowHeight - 10);
		//g.fillRect(windowWidth - 10, 5, 5, windowHeight - 10);
		//g.fillRect(windowHeight, 5, 50, 10);
		//g.fillRect(windowHeight, 0, 5, windowHeight);
		
		
		
		
		
		
	}
	
	
}

