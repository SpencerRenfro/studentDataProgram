package week4project;

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
		StringBuilder string = new StringBuilder();

		string.append("Name: " + name + " GPA: " + String.format("%.2f", qualityPoints / creditHours)
				+ " Degree Seeking: " + degreeSeeking);

		String studentString = string.toString();

		return studentString;
	}
}