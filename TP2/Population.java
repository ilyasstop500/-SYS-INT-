import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class Population {                      // DEFINITON  DE LA CLASSE POPULATION
    public Solution[] List_Of_Solutions;
    public String name;

    Population(String _name) {                     // CONSTRUCTEUR 
        name = _name;
        List_Of_Solutions = new Solution[20];
        for (int i = 0; i < 20 ; i++) {
            List_Of_Solutions[i] = new Solution();
        }
    }

    public void ShowPopulation() {                    // METHODE AFFICHAGE DE LA POPULATION

        System.out.println("Population  :  " + name);

        for (int i = 0; i < 20; i++) {

            List_Of_Solutions[i].ShowSolution();
            System.out.println(' ');

        }

    }

    public Population Roulette() {                     // METHODE DE LA SELECTION PAR ROULETTE 
        Population newgen = new Population("generation roulette");

        BigInteger somme = new BigInteger("0");

        for (int i = 0; i < 20; i++) {

            somme = somme.add(List_Of_Solutions[i].fitness);

        }

        float[] probas = new float[20];

        for (var i = 0; i < 20; i++) {

            probas[i] = List_Of_Solutions[i].fitness.floatValue() / somme.floatValue();
            System.out.println(probas[i]);

        }

        for (var indice_solution = 0; indice_solution < 20; indice_solution++) {

            

            Random j = new Random();
            float indice = j.nextFloat();
            System.out.println(indice);
            float repere = (float) 0.0;
            for (var i = 0; i < 20; i++) {
                if (repere < indice && indice < repere + probas[i]) {
                    newgen.List_Of_Solutions[indice_solution] = List_Of_Solutions[i];
                    newgen.List_Of_Solutions[indice_solution].updateSolution(List_Of_Solutions[i].bits);
                    
                }
                repere = repere + probas[i];

            }

        }

        return newgen;

    }

    public Population Croisement(int Point_de_croisment1 , int Point_de_croisment2) {                      // METHODE DE CROISEMENT 2 POINTS

        Population newgen = new Population("generation croisement");


        Random randint = new Random() ;
        while (Point_de_croisment1 == Point_de_croisment2) {
            Point_de_croisment2 = randint.nextInt(35);

        }

        if (Point_de_croisment1 > Point_de_croisment2) {
            int storage = Point_de_croisment2;
            Point_de_croisment2 = Point_de_croisment1;
            Point_de_croisment1 = storage;

        }

        // System.out.println(Point_de_croisment1 + "   " + Point_de_croisment2);

        for (int i = 0; i < List_Of_Solutions.length; i = i + 2) {

            Solution enfant1 = new Solution();
            Solution enfant2 = new Solution();

            for (int j = 0; j < Point_de_croisment1 + 1; j++) {

                enfant1.bits[j] = List_Of_Solutions[i].bits[j];
                enfant2.bits[j] = List_Of_Solutions[i + 1].bits[j];

            }

            for (int j = Point_de_croisment1 + 1; j < Point_de_croisment2 + 1; j++) {

                enfant1.bits[j] = List_Of_Solutions[i + 1].bits[j];
                enfant2.bits[j] = List_Of_Solutions[i].bits[j];

            }

            for (int j = Point_de_croisment2 + 1; j < 35; j++) {

                enfant1.bits[j] = List_Of_Solutions[i].bits[j];
                enfant1.bits[j] = List_Of_Solutions[i].bits[j] ;
                enfant2.bits[j] = List_Of_Solutions[i + 1].bits[j];

            }

            enfant1.updateSolution(enfant1.bits);
            enfant2.updateSolution(enfant2.bits);
            newgen.List_Of_Solutions[i] = enfant1;
            newgen.List_Of_Solutions[i + 1] = enfant2;

        }

        return newgen;

    }

    public Population Mutation() {                   // METHODE DE MUTATION  1 BIT 

        Population newgen = new Population("generation mutation");
        Random rand1 = new Random() ;
         
        
        
        for (int i = 0; i < List_Of_Solutions.length; i++) {

            int indice_mutation = rand1.nextInt(35) ;
            Solution mutant = new Solution();
            mutant.updateSolution(Arrays.copyOf(List_Of_Solutions[i].bits, 35)) ;
            mutant.bits[indice_mutation]= 1 -  mutant.bits[indice_mutation]  ; // ON INVERSE LE BITS SUBISSANT LA MUTATION 
            mutant.updateSolution(mutant.bits);
            System.out.print(List_Of_Solutions[i].fitness + "            " );
            System.out.print(mutant.fitness + "        ");
            
              

            if ( mutant.fitness.compareTo(List_Of_Solutions[i].fitness) == 1 ) {
                
                newgen.List_Of_Solutions[i].updateSolution(mutant.bits);
                System.out.println("HIGHER");
            } else {
                
                newgen.List_Of_Solutions[i].updateSolution(Arrays.copyOf(List_Of_Solutions[i].bits, 35));
                System.out.println("LOWER");
            }
        }
        
        return newgen ;



    }

    public  Solution Trouver_max(String methode , int iteration) {

        Solution SolutionMax = new Solution() ;
 

        if (methode == "Croisement") {

            Random randint1 = new Random();
            Random randint2 = new Random();
            int Point_de_croisment1 = randint1.nextInt(35);
            int Point_de_croisment2 = randint2.nextInt(35);

            BigInteger max = new BigInteger("0");
            
            for (var i = 0; i < iteration; i++) {
                Croisement(Point_de_croisment1 , Point_de_croisment2) ;    
                for (int index = 0; index < List_Of_Solutions.length; index++) {

                    if (List_Of_Solutions[index].fitness.compareTo(max)==1) {
    
                    
                        SolutionMax.updateSolution(Arrays.copyOf(List_Of_Solutions[index].bits,35));
                        
                        max = BigInteger.valueOf(List_Of_Solutions[index].fitness.longValue());
                        SolutionMax.ShowSolution();
                        System.out.println(max);
                    
                    } 
                }            
            }

        }


        if (methode == "Roulette") {
            
            BigInteger max = new BigInteger("0");

            for (int i = 0; i < iteration ; i++) {
                Roulette() ;
            }
            for (int index = 0; index < List_Of_Solutions.length; index++) {

                if (List_Of_Solutions[index].fitness.compareTo(max)==1) {
    
                    
                    SolutionMax.updateSolution(Arrays.copyOf(List_Of_Solutions[index].bits,35));
                        
                    max = BigInteger.valueOf(List_Of_Solutions[index].fitness.longValue());
                    SolutionMax.ShowSolution();
                    System.out.println(max);
                    
                } 
           } 
           
           



 

            
        }


        if (methode == "Mutation") {

            BigInteger max = new BigInteger("0");

            for (var i = 0; i < iteration; i++) {
                Mutation() ;    
                for (int index = 0; index < List_Of_Solutions.length; index++) {

                    if (List_Of_Solutions[index].fitness.compareTo(max)==1) {
    
                    
                        SolutionMax.updateSolution(Arrays.copyOf(List_Of_Solutions[index].bits,35));
                        
                        max = BigInteger.valueOf(List_Of_Solutions[index].fitness.longValue());
                        SolutionMax.ShowSolution();
                        System.out.println(max);
                    
                    } 
                }            
            }

            

            
        }


        return SolutionMax ;
    }
}

