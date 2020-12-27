package aotr.resources.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class textureProcessor {

	private BufferedImage texture;
	private BufferedImage output;
	public textureProcessor(BufferedImage sheet) {
		this.texture = sheet;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
	    BufferedImage img = this.texture.getSubimage((col * 32)-32, (row*32)-32, width, height);
		return deepCopy(img);
		
	}
	
	public BufferedImage changeImageColor(BufferedImage image, Color color,Color color2) {
		output = image;
		
		 for (int i = 0; i < output.getWidth(); i++) {
		        for (int j = 0; j < output.getHeight(); j++) {
		        	
		            if (output.getRGB(i, j) == color.getRGB()) {
		                output.setRGB(i, j, color2.getRGB());
		            }
		            else {
		          
		            }
		        }
		    }
		
		return deepCopy(output);
	}
	
	public static BufferedImage deepCopy(BufferedImage source){
	    BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
	    Graphics g = b.getGraphics();
	    g.drawImage(source, 0, 0, null);
	    g.dispose();
	    return b;
	}
}



