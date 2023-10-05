package representation;

public class Gene {

	double value;
	double min; 
	double max; 

	public Gene() {
		value = -1;	
		min = 0; 
		max = 100;
	}

	public Gene(double value) {
		this.value = value;
		min = 0; 
		max = 100;
	}

	public Gene(double min, double max) {
		this.value = -1;
		this.min = min; 
		this.max = max;
	}


	public Gene(double value, double min, double max) {
		this.value = value;
		this.min = min; 
		this.max = max;
	}
	
	public Gene(Gene g) {
		this.value = g.getDoubleValue(); 
		this.min = g.getMin(); 
		this.max = g.getMax();
	}

	public double getDoubleValue() {
		return value;
	}
	
	public int getIntValue() {
		return (int) Math.round(value);
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public void setValue(double value) {
		this.value = value;
	}


}
