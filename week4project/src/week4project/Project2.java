package week4project;
import java.io.File;
import java.util.ArrayList;

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
