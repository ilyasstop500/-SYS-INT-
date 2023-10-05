package operateurs.croisement;

import representation.Solution;

public abstract class Croisement {
	
	protected Solution parent1;
	protected Solution parent2;
	
	protected Solution enfant1;
	protected Solution enfant2; 
	
	protected double proba; 
	
	public Croisement (Solution parent1, Solution parent2, double proba) {
		this.parent1 = parent1;
		this.parent2 = parent2;
		this.proba = proba;
	}
	
	public abstract void croiser() ;

	public Solution getEnfant1() {
		return enfant1;
	}

	public Solution getEnfant2() {
		return enfant2;
	}
	
}
