package aotr.renderer.InGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import aotr.Main;

public class PauseMenu {
private int menuScroll;
private Main Game;

	public PauseMenu(Main game) {
	this.menuScroll = 1;
	this.Game = game;
	}

	public void toggle() {
		if(this.Game.gamestate == 1 && this.Game.gameMenu == 0 && this.Game.player.getPlayerState() == 0) {
			this.Game.gameMenu = 1;	
			this.menuScroll = 1;
			}else if(this.Game.gamestate == 1 && this.Game.gameMenu == 1) {
			this.Game.gameMenu = 0;	
			}	
		
	}
	
	public void Render(Graphics g, int windowWidth, int windowHeight){
		int cornerX = windowHeight/10;
		int cornerY = windowHeight/10;
		int menuWidth = windowHeight/5;
		int menuHeight = windowHeight/4;
		
		
		g.setColor(Color.black);
		g.fillRect(cornerX, cornerY,  menuWidth,  menuHeight);
		g.setColor(Color.white);
		g.drawRect(cornerX, cornerY, menuWidth,  menuHeight);
		
		g.setFont(new Font("SansSerif", Font.PLAIN, windowHeight / 40 ));
		
		String a = new String("return to game");
		String b = new String("options");
		String c = new String("exit");
		
		
		switch(menuScroll) {
		case 1:
			a = ">"+a;
			break;
			
		case 2:
			b = ">"+b;
			break;
			
		case 3:
			c = ">"+c;
			break;
	
		
		
		}
		
		g.drawString(a, cornerX, cornerY + windowHeight/40);
		g.drawString(b, cornerX, cornerY + 2*windowHeight/40);
		g.drawString(c, cornerX, cornerY + 3*windowHeight/40);
	}
	
	
	public void select() {
		if(this.Game.getGameState() == 1 && this.Game.gameMenu == 1) {	
		switch(menuScroll) {
		case 1:
			Game.gameMenu = 0;
			break;
			
		case 2:
			Game.settings.toggleMenu();
			break;
			
		case 3:
			
			break;
		
		}
		}
	}


public void scroll(int scroll) {
if(this.Game.getGameState() == 1 && this.Game.gameMenu == 1) {
	if(menuScroll >= 3 && scroll == 1) {
		this.menuScroll = 1;
	}else if(menuScroll <= 1 && scroll == -1 ) {
		this.menuScroll = 3;
	}else {
		this.menuScroll += scroll;
	}
	
	
}
	
	
}

}
