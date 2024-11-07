package week4project;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;

/*
Spencer Renfro
CMSC 215 7382
Date: 11-06-2024
 
This class takes a file object as a parameter, tries to create a pathway to the file, if it does exist 
the class proceeds to iterate over the properly formatted data, creates 4 ArrayLists, 
calculates the average gpa of all students, sets the threshold for honor society, and iterates over the student list
using the method in the Student class eligibleForHonorSociety to add eligible students to honorSocietyStudentList

*/

public class ReadData {
	private Scanner input;
	
	//ArrayLists
	private static ArrayList<Student> totalStudentList = new ArrayList<>();
	private static ArrayList<Student> graduateList = new ArrayList<>();
	private static ArrayList<Student> undergraduateList = new ArrayList<>();
	private static ArrayList<Student> honorSocietyStudentList = new ArrayList<>();

	private static double honorSocietyThreshold;
	private static double totalGpaSum;
	private static double totalStudentGpaAverage;



	public ReadData(File file) {
		

		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
			System.err.println("\nProgram will now terminate...");
			
			System.exit(1);
		}

		while (input.hasNext()) {
			String inputLine = input.nextLine();
			String[] fileData = inputLine.split(" ");
			String name = fileData[0];
			double creditHours = Double.parseDouble(fileData[1]);
			double qualityPoints = Double.parseDouble(fileData[2]);
			String typeStudent = fileData[3].toLowerCase();

			Student student;
			if (typeStudent.equals("freshman") || typeStudent.equals("sophomore") || typeStudent.equals("junior")
					|| typeStudent.equals("senior")) {
				student = new Undergraduate(name, creditHours, qualityPoints, typeStudent);
				undergraduateList.add(student);
				totalStudentList.add(student);
				totalGpaSum += student.gpa();
			} else if (typeStudent.equals("masters") || typeStudent.equals("doctorate")) {
				student = new Graduate(name, creditHours, qualityPoints, typeStudent);
				graduateList.add(student);
				totalStudentList.add(student);
				totalGpaSum += student.gpa();
			}
		}

		input.close();
		setAverageGpa();
		setHonorSocietyThreshold();
		setEligibleHonorSocietyStudents(); 
	}

	public ArrayList<Student> getStudentList() {
		return totalStudentList;
	}

	public ArrayList<Student> getGraduateList() {
		return graduateList;
	}

	public ArrayList<Student> getUndergraduateList() {
		return undergraduateList;
	}

	private static void setAverageGpa() {
		if (!totalStudentList.isEmpty()) {
			totalStudentGpaAverage = totalGpaSum / totalStudentList.size();
		}
	}

	public static double getAverageGpa() {
		return totalStudentGpaAverage;
	}

	public static void setEligibleHonorSocietyStudents() {
		for (Student student : totalStudentList) {
			if (student.eligibleForHonorSociety()) {
				honorSocietyStudentList.add(student);
			}
		}
	}

	public static void printEligibleHonorSocietyStudents() {
		System.out.println("\nStudents eligible for honor society:");
		for (Student student : honorSocietyStudentList) {
			System.out.println(student);
		}
	}

	public void printStudents() {
		System.out.println("\nGraduate students:");
		for (Student student : graduateList) {
			System.out.println(student);
		}
		System.out.println("\nUndergraduate students:");
		for (Student student : undergraduateList) {
			System.out.println(student);
		}
		System.out.println("\nAll students:");
		for (Student student : totalStudentList) {
			System.out.println(student);
		}
	}

	private static void setHonorSocietyThreshold() {
		honorSocietyThreshold = (getAverageGpa() + 4.0) / 2;
	}

	public static double getHonorSocietyThreshold() {
		return honorSocietyThreshold;
	}
}
