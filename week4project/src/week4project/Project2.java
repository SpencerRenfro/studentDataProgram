package week4project;
import java.io.File;
import java.util.ArrayList;


/*
Spencer Renfro
CMSC 215 7382
Date: 11-06-2024
 
This class is responsible for calling all of the other classes in the proper sequence, it creates a File object,
creates an instance of the ReadData class, and calls the static and non static methods to print the students, 
get the gpa average, and honor society threshold and prints those to the console and lastly prints the honor society students.
*/
public class Project2 {

	public static void main(String[] args) {
		
		File file = new File("students.txt");
		
		ReadData readData = new ReadData(file);		
		ArrayList<Student> studentList = new ArrayList<>(readData.getStudentList());
		
		
		readData.printStudents();	
		
		double studentGpaAverage = ReadData.getAverageGpa();
		double honorSocietyThreshold = ReadData.getHonorSocietyThreshold();
		
		
		System.out.println("\nAVG GPA of students: " +  String.format("%.2f",studentGpaAverage) );
		System.out.println("Honor Society Threshold: " + String.format("%.2f",honorSocietyThreshold));
		ReadData.printEligibleHonorSocietyStudents();
	}

}
