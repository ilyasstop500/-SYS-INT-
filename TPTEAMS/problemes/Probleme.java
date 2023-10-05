package problemes;

import representation.Solution;

public abstract class Probleme {

	protected int nb_variables_decision; 
	protected boolean minimisation;
	protected String type;
	
	protected double min[]; 
	protected double max[];
	
	public Probleme(String type, int nb_variables_decision, boolean minimisation) {
		this.type = type;
		this.nb_variables_decision = nb_variables_decision; 
		this.minimisation = minimisation;
		
		min = new double[nb_variables_decision];
		max = new double[nb_variables_decision];
		
		definirBornes();
	} 
	
	public abstract void definirBornes();
	
	public abstract void evaluer(Solution solution);

	public int getNb_variables_decision() {
		return nb_variables_decision;
	}

	public void setNb_variables_decision(int nb_variables_decision) {
		this.nb_variables_decision = nb_variables_decision;
	}

	public boolean isMinimisation() {
		return minimisation;
	}

	public void setMinimisation(boolean minimisation) {
		this.minimisation = minimisation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double[] getMin() {
		return min;
	}

	public void setMin(double[] min) {
		this.min = min;
	}

	public double[] getMax() {
		return max;
	}

	public void setMax(double[] max) {
		this.max = max;
	}
	
	
}
