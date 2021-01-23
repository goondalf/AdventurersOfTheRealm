package aotr.resources.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import aotr.Main;


public class textureManager {
private ArrayList<BufferedImage[][]> loadedImages;
private BufferedImage image;

	private Main game;
	public textureManager(Main game) {
		this.game = game;
		loadedImages = new ArrayList<BufferedImage[][]>();
	}
	
	
	public void loadImage(String path) throws IOException {
		image = ImageIO.read(getClass().getResource(path));
		BufferedImage[][] tileArray = new BufferedImage[image.getWidth()/32][image.getWidth()/32];
		loadedImages.add(tileArray);
		
		
		for(int x = 0; x < image.getWidth()/32;x++) {
			for(int y = 0; y < image.getWidth()/32; y++) {
			loadedImages.get(loadedImages.size()-1)[x][y] = deepCopy(image.getSubimage(x * 32, y*32, 32, 32));
			}}
	}
	
	
	public BufferedImage getImage(int i,int x,int y) {
		return loadedImages.get(i)[x][y];
	}
	
	public BufferedImage copyImage(int i,int x,int y) {
		return deepCopy(loadedImages.get(i)[x][y]);
	}
	
	
	public BufferedImage changeImageColor(BufferedImage image, Color color,Color color2) {
		BufferedImage input = image;
		
		 for (int i = 0; i < input.getWidth(); i++) {
		        for (int j = 0; j < input.getHeight(); j++) {
		        	
		            if (input.getRGB(i, j) == color.getRGB()) {
		                input.setRGB(i, j, color2.getRGB());
		            }
		            else {
		          
		            }
		        }
		    }
		
		return deepCopy(input);
	}
	
	
	public static BufferedImage deepCopy(BufferedImage source){
	    BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
	    Graphics g = b.getGraphics();
	    g.drawImage(source, 0, 0, null);
	    g.dispose();
	    return b;
	}
	
}

