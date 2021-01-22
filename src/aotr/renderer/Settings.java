package aotr.renderer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import aotr.Main;

public class Settings {

	int menuselector;
	int lastState;
	
	private Main game;
	public Settings(Main game) {
		this.game = game;	
	}
	
	public void render(Graphics g,int windowWidth, int windowHeight) {
	int bezelWidth = game.getHeight()/50;
		
	g.setColor(Color.white);
	g.fillRect(0, 0, game.getWidth(), game.getHeight());
	g.setColor(Color.black);	
	g.fillRect(bezelWidth, bezelWidth, game.getWidth() -2*bezelWidth , game.getHeight()-2*bezelWidth);	
	
	g.setFont(new Font( "Times New Roman", Font.PLAIN, 5* windowHeight/100));
	g.setColor(Color.white);
	String options = "options";
	String fullscreen = "fullscreen";
	String option1 = "option1";
	String option2 = "exit";
	
	
	
	switch(this.menuselector) {
	case 0:
		options = ">" + options;
		break;
	
	case 1:
		fullscreen = ">" + fullscreen;
		break;
	case 2:
		option1 = ">" + option1;
		break;
	case 3:
		option2 = ">" + option2;
		break;

	
	}
	
	g.drawString(options, windowWidth / 15, windowHeight/10);
	g.drawString(fullscreen, windowWidth / 15, windowHeight/10*2 );
	g.drawString(option1, windowWidth / 15, windowHeight/10 *3);
	g.drawString(option2, windowWidth / 15, windowHeight/10 *4);
	
	}
	
	
	public void select() {

		if(this.game.getGameState() == 2) {	
		switch(this.menuselector) {
		case 0:
			
			break;
		case 1:
			game.toggleFullScreen();
			break;
			
		case 2:
			
			break;
		case 3:
			game.settings.toggleMenu();
			break;

		}
		}

		}


	public void toggleMenu() {
		
		if(game.gamestate != 2) {
			System.out.println("woahh");
			lastState = game.gamestate;
			this.menuselector = 0;
			game.gamestate = 2;
		}else if(game.gamestate == 2) {
			game.gameMenu = 0;
			game.gamestate = lastState;
		}
		
	}



		public void menuScrollUp() {
			if(game.getGameState() == 2) {
			if (menuselector > 0) {
				this.menuselector--;
			}else {
				this.menuselector = 3; 	
						}	
			}
		}

		public void menuScrollDown() {
			
			if(game.getGameState() == 2) {
			if (menuselector < 3) {
				this.menuselector= this.menuselector + 1;
			}else {
				this.menuselector = 0;
			}
		}
		}



		public void setMenuSelector(int input) {
			this.menuselector = input;
		}

}
	
	
