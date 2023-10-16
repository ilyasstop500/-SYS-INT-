package operateurs.selection;

import java.util.ArrayList;
import java.util.Random;

import representation.Solution;

public class Roulette_biaisé extends Selection {

    public Roulette_biaisé(ArrayList<Solution> population) {
		super(population);
	}

    @Override
	public Solution selectionner() {
		double somme = 0.0 ;
        int index = 0 ;
		for (int i = 0; i < population.size(); i++) {

            somme = somme + population.get(i).getF() ;

        }

        double[] probas = new double[population.size()];

        for (var i = 0; i < 20; i++) {
            probas[i] = population.get(i).getF() / somme;            
        }

        Random j = new Random();
        double indice = j.nextDouble();
        double repere = 0.0 ;

        for (var i = 0; i < 20; i++) {
            if (repere < indice && indice < repere + probas[i]) {
                index = i ;
                
            }
            repere = repere + probas[i];

        }
        return population.get(index);

    


        


		
		
	}

    
}
