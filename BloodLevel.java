/**
 * 
 * @author Kayla Weselowski 
 * program to calculate free copper based on different units of measurement for serum copper
 * and ceruloplasmin in the blood
 * pertinent for patients with Wilson's Disease
 *
 */
public class BloodLevel {
	//private class level var types
	private double cp; //ceruloplasmin value
	private double cu; //copper value
	private double result; //free copper value

	//no need for constructor use provided default
	
	//method to access ceruloplasmin value
	public double getCpValue() {
		return cp;
	}
	
	//method to set ceruloplasmin value
	public void setCpValue(double ceruloplasmin) {
		cp = ceruloplasmin;
	}

	//method to access copper value
	public double getCuValue() {
		return cu;
	}
	
	//method to set cu value
	public void setCuValue(double serumCopper) {
		cu = serumCopper;
	}

	//method to access free copper value
	public double getResult() {
		return result;
	}

	//method to calculate free copper level based on selected units of measurement
	public void freeCopper(double cu, double cp, int unitSet) {

		if (unitSet == 1)
			result = ((getCuValue()) - (getCpValue() * 3.0));

		else
			result = ((getCuValue() * 6.3546) - (getCpValue() * 3.0 / 10.0));
	}

	//method to display entered values and calculated free copper result
	public String displayResults(int unitSet) {
		if (unitSet == 1)
			return "Serum Copper: " + this.getCuValue() + " mcg/dl \nCeruloplasmin: " + getCpValue()
					+ " mg/dl \nFree Copper Result: " + result;

		else
			return "Serum Copper: " + this.getCuValue() + " umol/L \nCeruloplasmin: " + getCpValue()
					+ " mg/L \nFree Copper Result: " + result + " ug/dl";

	}

	//method to display evaluation of calculated result based on specified range 
	public String displayEvaluation() {
		if (getResult() > 15) {
			return "------------------\nYour free copper level is ABOVE the recommended range of 5-15 ug/dl.\nPlease consult with your doctor.";
		} else if (getResult() < 5) {
			return "------------------\nYour free copper level is BELOW the recommended range of 5-15 ug/dl.\nPlease consult with your doctor.";
		}

		else
			return "------------------\nYour free copper is at a good level and within the recommended range of 5-15 ug/dl.";
	}

}
