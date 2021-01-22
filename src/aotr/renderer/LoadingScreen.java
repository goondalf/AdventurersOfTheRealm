package aotr.renderer;

import java.awt.Font;
import java.awt.Graphics;

import aotr.Main;


public class LoadingScreen {
	private Main game;
	private int i;
	public LoadingScreen() {
	this.i = 0;	
	String loadstring = "Loading";
	}

	
	public void render(Graphics g, int windowWidth, int windowHeight) {
	
	
	g.setFont(new Font("SansSerif", Font.PLAIN, windowHeight / 10 ));
	String loadstring = "Loading";
	String dots = ".";
	if(i == 0) {
	 dots = ".";
	 i++;
	}else if(i == 1) {
	 dots = "..";
	 i++;
	}else if(i == 2) {
		dots = "...";
		i=0;
	}
	
	g.drawString(loadstring + dots, windowWidth/3, windowHeight/3);
	
	}
}
