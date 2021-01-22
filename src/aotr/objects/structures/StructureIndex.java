package aotr.objects.structures;

import java.awt.Color;
import java.awt.image.BufferedImage;

import aotr.Main;
import aotr.resources.graphics.textureProcessor;
import aotr.world.Tile;

public class StructureIndex  {
	private Structure[] sIndex = new Structure[20];
	private BufferedImage tex;
	private Structure structure;
	private textureProcessor texP;
	private Main game;
public StructureIndex(BufferedImage texture,Main game)  {
	this.game = game;
	texP = new textureProcessor(texture);
	for(int i = 0; i < 20; i++) {
		switch(i) {
		//horizontal wood wall
		case 0:
			tex = texP.grabImage(14, 13, 32, 32);
			structure = new Structure("Wood Wall", 1, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),true,game);
			sIndex[i] = structure;
			break;
		//	vertical wood wall
		case 1:
			tex = texP.grabImage(11, 12, 32, 32);
			structure = new Structure("Wood Wall", 1, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),true,game);
			sIndex[i] = structure;
			break;
		//wood wall top L corner
		case 2:
			tex = texP.grabImage(10, 13, 32, 32);
			structure = new Structure("Wood Wall", 1, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),true,game);
			sIndex[i] = structure;
			break;
		//	wood wall top R corner
		case 3:
			tex = texP.grabImage(12, 12, 32, 32);
			structure = new Structure("Wood Wall", 1, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),true,game);
			sIndex[i] = structure;
			break;
		//wood wall bottom L corner
		case 4:
			tex = texP.grabImage(9, 13, 32, 32);
			structure = new Structure("Wood Wall", 1, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),true,game);
			sIndex[i] = structure;
			break;
		//wood wall bottom R corner
		case 5:
			tex = texP.grabImage(13, 12, 32, 32);
			structure = new Structure("Wood Wall", 1, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),true,game);
			sIndex[i] = structure;
			break;
		//four way
		case 6:
			tex = texP.grabImage(15, 13, 32, 32);
			structure = new Structure("Wood Wall", 1, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),true,game);
			sIndex[i] = structure;
			break;	
		//left,up,right	
		case 7:
			tex = texP.grabImage(11, 13, 32, 32);
			structure = new Structure("Wood Wall", 1, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),true,game);
			sIndex[i] = structure;
			break;		
		//up right down
		case 8:
			tex = texP.grabImage(13, 13, 32, 32);
			structure = new Structure("Wood Wall", 1, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),true,game);
			sIndex[i] = structure;
			break;	
	    //left right down
		case 9:
			tex = texP.grabImage(12, 13, 32, 32);
			structure = new Structure("Wood Wall", 1, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),true,game);
			sIndex[i] = structure;
			break;
			 //left right down
		case 10:
			tex = texP.grabImage(12, 13, 32, 32);
			structure = new Structure("Wood Wall", 1, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),true,game);
			sIndex[i] = structure;
			break;	
			
		//wooden door closed
		case 13:
			tex = texP.grabImage(16, 16, 32, 32);
			structure = new Structure("Wood Door", i, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),true,game);
			sIndex[i] = structure;
			break;
		//wooden door open
		case 14:
			tex = texP.grabImage(16, 15, 32, 32);
			structure = new Structure("Wood Door", i, texP.changeImageColor(tex, Color.white, new Color(139,29,19)),false,game);
			sIndex[i] = structure;
			break;
		
		}
		
	}

}

public Structure getIndex(int i){

	
	Structure structure = new Structure(sIndex[i].getName(), sIndex[i].getID(), sIndex[i].getTex(), sIndex[i].isSolid(),this.game);
	return structure;
}


}
