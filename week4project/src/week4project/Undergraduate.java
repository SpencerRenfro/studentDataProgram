package week4project;

public class Undergraduate extends Student{
	private String year;

	public Undergraduate(String name, double creditHours, double qualityPoints, String year ) {
		super(name, creditHours, qualityPoints);
		this.year = year;
	}
	
//	@Override 
//	public boolean eligibleForHonorSociety(){
//		double gpa = qualityPoints / creditHours;
//		
//		if ((year.toLowerCase().equals("junior") || year.toLowerCase().equals("senior")) && gpa >= ReadData.getHonorSocietyThreshold()){
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	
	
	@Override 
	public boolean eligibleForHonorSociety() {
	    double gpa = qualityPoints / creditHours;
	    System.out.printf("Checking eligibility for %s with GPA: %.2f, Year: %s, Threshold: %.2f%n", 
	                      name, gpa, year, ReadData.getHonorSocietyThreshold());

	    if ((year.toLowerCase().equals("junior") || year.toLowerCase().equals("senior")) && gpa >= ReadData.getHonorSocietyThreshold()) {
	        return true;
	    } else {
	        return false;
	    }
	}

	@Override public String toString() {
		StringBuilder string = new StringBuilder();
		
		string.append("Name: " + name 
				+ " GPA: " 
				+String.format("%.2f", qualityPoints / creditHours) 
				+ " Year: " + year);
		
		String studentString = string.toString();
		
		return  studentString;
	}
}