package representation;

public class Solution {

	private String type;
	private int nb_variables_decision; 
	private Gene[] chromosome;

	private double f; 

	public Solution(String type, int nb_variables_decision) {
		this.type = type;
		this.nb_variables_decision = nb_variables_decision; 

		chromosome = new Gene[nb_variables_decision];
		
	} 
	
	public Solution(Solution solution) {
		this.type = solution.getType();
		this.nb_variables_decision = solution.getNb_variables_decision(); 

		chromosome = new Gene[nb_variables_decision]; 
		
		if (type.equalsIgnoreCase("Int")) {
			for (int i = 0; i < nb_variables_decision; i++) {
				this.setVariable(i, solution.getIntVariable(i));
			}
		} else {
			for (int i = 0; i < nb_variables_decision; i++) {
				this.setVariable(i, solution.getDoubleVariable(i));
			}
		}
	} 


	public int getNb_variables_decision() {
		return nb_variables_decision;
	}

	public void setNb_variables_decision(int nb_varibles_decision) {
		this.nb_variables_decision = nb_varibles_decision;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	public Gene[] getChromosome() {
		return chromosome;
	}

	public void setChromosome(Gene[] chromosome) {
		this.chromosome = chromosome;
	}

	public double getDoubleVariable(int i) {
		return chromosome[i].getDoubleValue();
	}

	public int getIntVariable(int i) {
		return chromosome[i].getIntValue();
	}

	public void setVariable (int i, double value) {
		//chromosome[i].setValue(value);
		chromosome[i] = new Gene(value);
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String toString() {

		String s = ""; 

		if (type.equalsIgnoreCase("int")) {

			for (int i = 0; i < nb_variables_decision; i++) {
				s += getIntVariable(i) + " ";
			}
		} else {
			for (int i = 0; i < nb_variables_decision; i++) {
				s += getDoubleVariable(i) + " ";
			}
		}

		s += "(" + f + ")";

		return s;
	}

}
