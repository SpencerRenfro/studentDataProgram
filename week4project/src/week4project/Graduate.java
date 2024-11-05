package week4project;

public class Graduate extends Student {

	private String degreeSeeking;
	
	public Graduate(String name, double creditHours, double qualityPoints, String degreeSeeking) {
		super(name, creditHours, qualityPoints);
		this.degreeSeeking = degreeSeeking;
	}
	
	@Override 
	public boolean eligibleForHonorSociety() {
		double gpa = qualityPoints / creditHours;
		if( degreeSeeking.toLowerCase().equals("masters") && gpa >= ReadData.getHonorSocietyThreshold()  ) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override public String toString() {
		StringBuilder string = new StringBuilder();
		
		string.append("Name: " + name
				+ " GPA: "
				+ String.format("%.2f",qualityPoints / creditHours)
				+ " Degree Seeking: " + degreeSeeking);
		
		String studentString = string.toString();
		
		return  studentString;
	}
}