package week4project;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;

public class ReadData {
	private Scanner input;

	private static boolean fileFound;

	private static ArrayList<Student> totalStudentList = new ArrayList<>();
	private static ArrayList<Student> graduateList = new ArrayList<>();
	private static ArrayList<Student> undergraduateList = new ArrayList<>();

	private static double honorSocietyThreshold;

	// for calculating average gpa
	private static double totalGpaSum;
	private static double totalStudentGpaAverage;

	// for eligible honor society students
	private static ArrayList<Student> honorSocietyStudentList = new ArrayList<>();

	public ReadData() {
		File file = new File("students.txt");

		try {
			input = new Scanner(file);
			fileFound = true;
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
			fileFound = false;
			System.out.println("Program will now terminate...");
			System.exit(1);
		}

		if (fileFound) {

			while (input.hasNext()) {
				String inputLine = input.nextLine();
				String[] fileData = inputLine.split(" ");
				String name = fileData[0];
				// variables used for creating iteration data, used for making a new Student
				// object
				double creditHours = Double.parseDouble(fileData[1]);
				double qualityPoints = Double.parseDouble(fileData[2]);
				String typeStudent = fileData[3];

				Student student = new Student(name, creditHours, qualityPoints);
				totalGpaSum += student.gpa();
				totalStudentList.add(student);

				// Create a new Student object and add it to the list
				if (typeStudent.toLowerCase().equals("freshman") || typeStudent.toLowerCase().equals("sophomore")
						|| typeStudent.toLowerCase().equals("junior") || typeStudent.toLowerCase().equals("senior")) {
					Undergraduate undergradStudent = new Undergraduate(name, creditHours, qualityPoints, typeStudent);
					undergraduateList.add(undergradStudent);

				} else if (typeStudent.toLowerCase().equals("masters")
						|| typeStudent.toLowerCase().equals("doctorate")) {
					Graduate gradStudent = new Graduate(name, creditHours, qualityPoints, typeStudent);
					graduateList.add(gradStudent);
				}

			}

			input.close();
			setAverageGpa();
			setHonorSocietyThreshold();
			setEligibleHonorSocietyStudents();
		}

	}

	public static ArrayList<Student> getStudentList() {
		return totalStudentList;
	}

	public ArrayList<Student> getGraduateList() {
		return this.graduateList;
	}

	public ArrayList<Student> getUndergraduateList() {
		return this.undergraduateList;
	}

	public static void setAverageGpa() {
		if (totalStudentList.size() != 0) {
			totalStudentGpaAverage = totalGpaSum / totalStudentList.size();

		}

	}

	public static double getAverageGpa() {
		return totalStudentGpaAverage;
	}

	public static void setEligibleHonorSocietyStudents() {
		// checking if undergrad is eligible for honor society membership
		for (Student Student : totalStudentList) {
			if (Student.eligibleForHonorSociety()) {
				honorSocietyStudentList.add(Student);
			}
		}

	}

	public static void printElibibleHonorSocietStudents() {
		System.out.println("\nStudents eligible for honor society:");
		for (Student Student : honorSocietyStudentList) {
			System.out.println(Student.toString());
		}
	}

	public static void printStudents() {
		System.out.println("\n\nGraduate students");
		for (Student Student : graduateList) {
			System.out.println(Student);
		}
		System.out.println("\nUndergraduate Students");
		for (Student Student : undergraduateList) {
			System.out.println(Student);
		}
		System.out.println("\nAll Students");
		for (Student Student : totalStudentList) {
			System.out.println(Student);
		}
	}

	public static void setHonorSocietyThreshold() {
		honorSocietyThreshold = ((getAverageGpa() + 4.0) / 2);
	}

	public static double getHonorSocietyThreshold() {
		return honorSocietyThreshold;
	}
}
