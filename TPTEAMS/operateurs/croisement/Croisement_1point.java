package operateurs.croisement;

import representation.Solution;

public class Croisement_1point extends Croisement{

	public Croisement_1point(Solution parent1, Solution parent2, double proba) {
		super(parent1, parent2, proba);
	}

	@Override
	public void croiser() {


		int nb_variables_decision = parent1.getNb_variables_decision();

		enfant1 = new Solution(parent1);
		enfant2 = new Solution(parent2);

		double aleatoire = Math.random(); 

		int point_croisement = -1; 

		if (aleatoire <= proba) {

			point_croisement = (int)(Math.random() * nb_variables_decision); 



			for (int i = 0; i < point_croisement; i++) {
				enfant1.setVariable(i, parent1.getDoubleVariable(i));
				enfant2.setVariable(i, parent2.getDoubleVariable(i));
			}

			for (int i = point_croisement; i < nb_variables_decision; i++) {
				enfant1.setVariable(i, parent2.getDoubleVariable(i));
				enfant2.setVariable(i, parent1.getDoubleVariable(i));
			}

		}

	}

}
