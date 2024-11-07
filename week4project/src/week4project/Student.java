package week4project;

import java.util.ArrayList;


/*
Spencer Renfro
CMSC 215 7382
Date: 11-06-2024
 
This student class takes parameters for String name, double credit hours, double quality points, methods contained in this class
will calculate gpa, print the name, gpa and quality points, and return true or false if a student is eligible for honor society.

The methods eligibleForHonorSociety and toString are super methods that are overridden with more data added to them in 
the Undergraduate and Graduate class
*/
public class Student {
	
	private String name;
	private double creditHours;
	private double qualityPoints;

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
		double localGpa = this.gpa();
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