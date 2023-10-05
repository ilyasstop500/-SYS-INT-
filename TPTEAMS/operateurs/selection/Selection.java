package operateurs.selection;

import java.util.ArrayList;

import representation.Solution;

public abstract class Selection {
	
	protected ArrayList<Solution> population; 

	public Selection(ArrayList<Solution> population) {
		this.population = population;
	} 
	
	public abstract Solution selectionner();
	
}
