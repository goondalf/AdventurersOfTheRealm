package aotr.objects.structures;

import java.awt.Color;
import java.awt.image.BufferedImage;

import aotr.resources.graphics.textureProcessor;
import aotr.world.Tile;

public class StructureIndex {
	private Structure[] sIndex = new Structure[10];
	private BufferedImage tex;
	private Structure structure;
	private textureProcessor texP;
public StructureIndex(BufferedImage texture) {
	
	texP = new textureProcessor(texture);
	for(int i = 0; i < 10; i++) {
		switch(i) {
		case 0:
			tex = texP.grabImage(14, 13, 32, 32);
			structure = new Structure("horizontal wood wall", i, texP.changeImageColor(tex, Color.white, Color.BLUE));
			sIndex[i] = structure;
			break;
			
		case 1:
			
			break;
		
		
		}
		
	}

}

public Structure getIndex(int i) {
	return sIndex[i];
}


}
