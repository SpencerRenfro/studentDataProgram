package week4project;

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
		StringBuilder string = new StringBuilder();

		string.append(
				"Name: " + name + " GPA: " + String.format("%.2f", qualityPoints / creditHours) + " Year: " + year);

		String studentString = string.toString();

		return studentString;
	}
}