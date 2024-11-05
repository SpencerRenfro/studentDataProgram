package week4project;

import java.util.ArrayList;

public class Student {
	
	protected String name;
	protected double creditHours;
	protected double qualityPoints;
	//gpa threshold
	protected static double gpaThreshold;

	
	public Student(String name, double creditHours, double qualityPoints) {
		this.name = name;
		this.creditHours = creditHours;
		this.qualityPoints = qualityPoints;	
	}
	
	public double gpa() {
		return qualityPoints / creditHours;
	}
	
	public boolean eligibleForHonorSociety() {
		double localGpa = this.qualityPoints / this.creditHours;
		if(localGpa >= ReadData.getHonorSocietyThreshold()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static ArrayList<Student> getEligibleStudents() {
		ArrayList<Student> eligibleStudents = new ArrayList<>();
		
		return eligibleStudents;
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Name: " + name 
				+ " GPA: " + String.format("%.2f",qualityPoints / creditHours) );
		
		String studentString = string.toString();
		
		return  studentString;
	}
	
}