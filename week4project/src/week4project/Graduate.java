package week4project;


/*
Spencer Renfro
CMSC 215 7382
Date: 11-06-2024
 
The Graduate class extends the Student class and adds logic to the eligibleForHonorSociety method, 
requiring the student to be seeking a master's degree. It also overrides the toString method to 
include the degree the student is pursuing. This is accomplished by overriding the super method 
in the Student class.
*/
public class Graduate extends Student {

	private String degreeSeeking;

	public Graduate(String name, double creditHours, double qualityPoints, String degreeSeeking) {
		super(name, creditHours, qualityPoints);
		this.degreeSeeking = degreeSeeking;
	}

	@Override
	public boolean eligibleForHonorSociety() {
		if (!super.eligibleForHonorSociety()) {
			return false;
		} else {
			return (degreeSeeking.toLowerCase().equals("masters"));
		}
	}

	@Override
	public String toString() {
		return super.toString() + " Degree Seeking: " + degreeSeeking;
	}
}