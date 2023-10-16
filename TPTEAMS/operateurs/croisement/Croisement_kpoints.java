package operateurs.croisement;

import representation.Solution;
import problemes.UniqueRng;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Croisement_kpoints extends Croisement{
    int nbr_croisment ;
	public Croisement_kpoints(Solution parent1, Solution parent2, double proba , int k) {
		super(parent1, parent2, proba);
        nbr_croisment = k ; 
	}

	@Override
	public void croiser() {


		int nb_variables_decision = parent1.getNb_variables_decision();
       
		enfant1 = new Solution(parent1);
		enfant2 = new Solution(parent2);

        double aleatoire1 = Math.random(); 

        UniqueRng indice = new UniqueRng(nbr_croisment) ;

        List<Integer> kpoints = new ArrayList() ;
        for (int i = 0; i < nbr_croisment; i++) {
            kpoints.add(indice.next());
        }

        Collections.sort(kpoints); 

        if (aleatoire1 <= proba) {

            int borne_inf = 0 ;
            int jsp = 0 ;

            for (int i = 0; i < kpoints.size(); i++) {

                if ( i%2==0) {

                    for (int j = borne_inf; j < kpoints.get(i) ; j++) {
				        enfant1.setVariable(j, parent1.getDoubleVariable(j));
				        enfant2.setVariable(j, parent2.getDoubleVariable(j));
                        jsp = 0 ;
                        
			        }

                }
                
                else {
                    for (int j = borne_inf; j < kpoints.get(i) ; j++) {
				        enfant1.setVariable(j, parent2.getDoubleVariable(j));
				        enfant2.setVariable(j, parent1.getDoubleVariable(j));
                        jsp = 1 ;

			        }

                }

                borne_inf = kpoints.get(i) ;
                
            }


            if (jsp == 0) {
                for (int j = borne_inf; j < nb_variables_decision ; j++) {
				        enfant1.setVariable(j, parent2.getDoubleVariable(j));
				        enfant2.setVariable(j, parent1.getDoubleVariable(j));
			    }     
            }

            else { 
                for (int j = borne_inf; j < nb_variables_decision ; j++) {
				        enfant1.setVariable(j, parent2.getDoubleVariable(j));
				        enfant2.setVariable(j, parent1.getDoubleVariable(j));
                }
            }

            



		}



		




			

	}

}


