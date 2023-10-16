package operateurs.croisement;

import representation.Solution;

public class Croisement_2points extends Croisement{

	public Croisement_2points(Solution parent1, Solution parent2, double proba) {
		super(parent1, parent2, proba);
	}

	@Override
	public void croiser() {


		int nb_variables_decision = parent1.getNb_variables_decision();

		enfant1 = new Solution(parent1);
		enfant2 = new Solution(parent2);

		double aleatoire1 = Math.random(); 
        double aleatoire2 = Math.random();
        double aleatoire3 = Math.random();

        while (aleatoire3 == aleatoire2) {
            aleatoire2 = Math.random();

        }

        if (aleatoire2 > aleatoire3) {
            double storage = aleatoire2;
            aleatoire2 = aleatoire3;
            aleatoire3 = storage;

        }

		int point_croisement1 = -1; 
        int point_croisement2 = -1 ;

		if (aleatoire1 <= proba) {

			point_croisement1 = (int)(aleatoire2 * nb_variables_decision); 
            point_croisement2 = (int)(aleatoire3 * nb_variables_decision); 




			for (int i = 0; i < point_croisement1; i++) {
				enfant1.setVariable(i, parent1.getDoubleVariable(i));
				enfant2.setVariable(i, parent2.getDoubleVariable(i));
			}

			for (int i = point_croisement1; i < point_croisement2; i++) {
				enfant1.setVariable(i, parent2.getDoubleVariable(i));
				enfant2.setVariable(i, parent1.getDoubleVariable(i));
			}

		}

	}

}
