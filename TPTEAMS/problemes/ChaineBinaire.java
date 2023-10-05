package problemes;

import representation.Solution;

public class ChaineBinaire extends Probleme {

	public ChaineBinaire(String type, int nb_variables_decision, boolean minimisation) {
		super(type, nb_variables_decision, minimisation);
	}
	
	public ChaineBinaire(int nb_variables_decision, boolean minimisation) {
		super("Int", nb_variables_decision, minimisation);
	}
	
	public ChaineBinaire(int nb_variables_decision) {
		super("Int", nb_variables_decision, false);
	}

	@Override
	public void definirBornes() {
		
		for(int i = 0; i < nb_variables_decision; i++) {
			min[i] = 0; 
			max[i] = 1;
		}
	}

	@Override
	public void evaluer(Solution solution) {

		int[] x = new int[nb_variables_decision]; 
		
		for (int i = 0; i < nb_variables_decision; i++) {
			x[i] = solution.getIntVariable(i);
		}
		
		int decimal = 0; 
		
		for (int i = 0; i < nb_variables_decision; i++) {
			decimal += x[i] * Math.pow(2, nb_variables_decision - i -1);
		}

		solution.setF(decimal);
	}

}
