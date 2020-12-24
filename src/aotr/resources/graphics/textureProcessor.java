package aotr.resources.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class textureProcessor {

	private BufferedImage image;

	public textureProcessor(BufferedImage sheet) {
		this.image = sheet;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage img = image.getSubimage((col * 32)-32, (row*32)-32, width, height);
		return img;
		
	}
	
	public BufferedImage changeImageColor(BufferedImage image, Color color,Color color2) {
		
		
		 for (int i = 0; i < image.getWidth(); i++) {
		        for (int j = 0; j < image.getHeight(); j++) {
		        	
		            if (image.getRGB(i, j) == color.getRGB()) {
		                image.setRGB(i, j, color2.getRGB());
		            }
		            else {
		          
		            }
		        }
		    }
		
		return image;
	}
	
}
