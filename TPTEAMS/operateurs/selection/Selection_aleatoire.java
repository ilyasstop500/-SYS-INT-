package operateurs.selection;

import java.util.ArrayList;

import representation.Solution;

public class Selection_aleatoire extends Selection {

	public Selection_aleatoire(ArrayList<Solution> population) {
		super(population);
	}

	@Override
	public Solution selectionner() {
		
		int index = (int)(Math.random() * population.size());
		
		return population.get(index);
	}
}
