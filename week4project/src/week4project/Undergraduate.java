package week4project;

/*
Spencer Renfro
CMSC 215 7382
Date: 11-06-2024
 
This Undergraduate class extends the Student class and ands more logic for specifics on undergraduate students
and their eligibility for honor society and adds to the toString method adding the year of the student. This is done
by overriding the super methods. 
*/

public class Undergraduate extends Student {
	private String year;

	public Undergraduate(String name, double creditHours, double qualityPoints, String year) {
		super(name, creditHours, qualityPoints);
		this.year = year;
	}

	@Override
	public boolean eligibleForHonorSociety() {
		
		if(!super.eligibleForHonorSociety()) {
			return false;
		} else {
			return (year.toLowerCase().equals("junior") || year.toLowerCase().equals("senior"));
		}
		
	}

	@Override
	public String toString() {
	    return super.toString() + " Year: " + year;
	}
}