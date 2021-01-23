package aotr.renderer.InGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import aotr.Main;

public class ActionMenu {
private int menuScroll;
private Main Game;

	public ActionMenu(Main game) {
	this.menuScroll = 1;
	this.Game = game;
	}

	public void toggle() {
		if(this.Game.gamestate == 1 && this.Game.gameMenu == 0 && Game.player.getPlayerState() == 0) {
			this.Game.gameMenu = 2;	
			this.menuScroll = 1;
			}else if(this.Game.gamestate == 1 && this.Game.gameMenu == 2) {
			this.Game.gameMenu = 0;	
			}	
		
	}
	
	
	public void Render(Graphics g, int windowWidth, int windowHeight){
		int cornerX = windowHeight/6;
		int cornerY = windowHeight/6;
		int menuWidth = windowHeight/5;
		int menuHeight = windowHeight/4;
		
		
		g.setColor(Color.black);
		g.fillRect(cornerX, cornerY,  menuWidth,  menuHeight);
		g.setColor(Color.white);
		g.drawRect(cornerX, cornerY, menuWidth,  menuHeight);
		
		g.setFont(new Font("SansSerif", Font.PLAIN, windowHeight / 40 ));
		
		String a = new String("interact");
		String b = new String("ability");
		String c = new String("run");
		
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


public void scroll(int scroll) {
if(this.Game.getGameState() == 1 && this.Game.gameMenu == 2) {
	if(menuScroll >= 3 && scroll == 1) {
		this.menuScroll = 1;
	}else if(menuScroll <= 1 && scroll == -1 ) {
		this.menuScroll = 3;
	}else {
		this.menuScroll += scroll;
	}	
}
}

public void select() {
if(this.Game.getGameState() == 1 && this.Game.gameMenu == 2) {	
	switch(this.menuScroll) {
	case 1:
		this.Game.player.setPlayerState(1);
		break;
	case 2:
		break;
	case 3:
		break;
}	
this.Game.gameMenu = 0;

}
}



}
