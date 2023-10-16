package operateurs.mutation;
import java.util.Random;

import representation.Solution;

public class Mutation_npoints extends Mutation {

    public Mutation_npoints(double proba) {
        super(proba);
    }

    @Override
    public Solution muter(Solution solution) {
        
		Random test = new Random() ;
	    for (int i = 0; i < solution.getChromosome().length; i++) {

			if (test.nextDouble() <= proba ) {
                
                solution.setVariable(i, 1-solution.getIntVariable(i) );
				
			}

		}

        return solution;

        
    }

   
}
