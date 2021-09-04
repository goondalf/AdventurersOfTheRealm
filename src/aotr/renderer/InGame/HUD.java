package aotr.renderer.InGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


import aotr.Main;


public class HUD {

	int topLcornerx;
	int topLcornery;
	int bLcorner;
	int bRcorner;
	int hudwidth;
	int hudheight;
	
   public boolean hudVisibility;

	
	
Main game;	
	public HUD(Main game) {
		this.game = game;
		this.hudVisibility = true;
	}

	
	public void render(Graphics g, int windowWidth, int windowHeight, Main game) {
		if(this.hudVisibility == true) {
		this.game = game;
		topLcornerx = game.tiles.getWidth() + windowHeight/120;
		topLcornery = windowHeight/120;
		hudwidth = windowWidth - topLcornerx - windowHeight/120;
		hudheight = windowHeight - topLcornery*2;
		
		g.setColor(Color.white);
		g.fillRect(topLcornerx, topLcornery, hudwidth, hudheight);
		g.setColor(Color.black);
		g.fillRect(topLcornerx + topLcornery, topLcornery*2, hudwidth-topLcornery*2, hudheight-topLcornery*2);
		
		g.setColor(Color.white);
		g.setFont(new Font("SansSerif", Font.PLAIN, windowHeight / 40 ));
		g.drawString("health:" + game.player.stats.getHealth(), topLcornerx+ topLcornery, hudheight/20);
		
		}
		
	}
	
	
}

