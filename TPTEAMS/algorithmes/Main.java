package algorithmes;

import problemes.ChaineBinaire;
import problemes.Probleme;
import representation.Solution;

public class Main {

	public static void main(String[] args) {
		
		int taille_population = 50; 
		int nb_generations = 2000; 
		
		double probaCroisement = .8; 
		double probaMutation = 0.1;
		
		int nbBits = 16;
		Probleme probleme; 
		probleme = new ChaineBinaire(nbBits); 
		
		Algorithme_genetique algo = new Algorithme_genetique(probleme, taille_population, nb_generations, probaCroisement, probaMutation); 
		Solution best = algo.executer();
		
		System.out.println("Resultat: " + best);
		
	}

}
