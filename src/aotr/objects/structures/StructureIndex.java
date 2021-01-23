package aotr.objects.structures;


import java.util.ArrayList;

import aotr.Main;


public class StructureIndex  {
	private ArrayList<Structure> sIndex = new ArrayList<Structure>();
	private Structure structure;
	private Main game;
public StructureIndex(Main game)  {
	this.game = game;
	for(int i = 0; i < 4; i++) {
	switch(i) {
	case 0:	
		structure = new Structure("Wood Door",i,game.tManager.getImage(4, 0, 0),true,game);
	break;
	case 1:
		structure = new Structure("Wood Wall",i,game.tManager.getImage(3, 0, 0),true,game);
	break;
	}
	sIndex.add(structure);
	}

}

public Structure getIndex(int i){

	
	Structure structure = new Structure(sIndex.get(i).getName(), sIndex.get(i).getID(),sIndex.get(i).getTex(), sIndex.get(i).isSolid(),this.game);
	return structure;
}


}
