package week4project;
import java.io.File;
import java.util.ArrayList;

public class Project2 {

	public static void main(String[] args) {
		
		ReadData readData = new ReadData();

		
		ArrayList<Student> studentList = new ArrayList<>(ReadData.getStudentList());
		
		ReadData.printStudents();
		ReadData.setHonorSocietyThreshold();
		
		
		
		double studentGpaAverage = ReadData.getAverageGpa();
		double honorSocietyThreshold = ReadData.getHonorSocietyThreshold();
		
		System.out.println("\nAVG: " +  String.format("%.2f",studentGpaAverage) );
		System.out.println("Honor Society Threshold: " + String.format("%.2f",honorSocietyThreshold));
		ReadData.printElibibleHonorSocietStudents();

	}

}


// questions to ask: if the override methods can use something like a spread operator to copy the original method and add on to it. 
// if the way i am importing the file matches the description for the assignment