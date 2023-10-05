package operateurs.mutation;

import representation.Solution;

public abstract class Mutation {
	
	protected Solution solution;
		
	protected double proba; 
	
	public Mutation (double proba) {
		this.proba = proba;
	}
	
	public abstract Solution muter(Solution solution) ;

	public Solution getSolution() {
		return solution;
	}
	
}
