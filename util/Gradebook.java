package util;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Gradebook {
	// Initialize the ArrayList to store students
	private static ArrayList<Student> listOfStudents = new ArrayList<>();

	// Add a student to the list
	public static void addStudent(Student student) {
		listOfStudents.add(student);
	}

	// Calculate the average grade
	public static double calculateAvg() {
		if (listOfStudents == null || listOfStudents.isEmpty()) {
			// Handle the case when there are no students or the list is null
			return 0.0; // Return an appropriate default value or handle as needed
		}

		double totalScore = 0.0;

		for (Student student : listOfStudents) {
			totalScore += student.getGrade().getScore(); // Access the grade for each student
		}

		return totalScore / listOfStudents.size();
	}

	// Calculate the median grade
	public static double calculateMed() {
		if (listOfStudents == null || listOfStudents.isEmpty()) {
			// Handle the case when there are no students or the list is null
			return 0.0;
		}

		// Create an ArrayList to store student scores
		ArrayList<Integer> scores = new ArrayList<>();

		for (Student student : listOfStudents) {
			scores.add(student.getGrade().getScore()); // Add each student's score to the list
		}

		// Sort the scores
		Collections.sort(scores);

		int size = scores.size();
		if (size % 2 == 0) {
			// If the list has an even number of elements, calculate the average of the two middle elements
			int middle1 = scores.get(size / 2 - 1);
			int middle2 = scores.get(size / 2);
			return (double) (middle1 + middle2) / 2;
		} else {
			// If the list has an odd number of elements, return the middle element
			return scores.get(size / 2);
		}
	}
	//calculates the lowest score in the class
	public static int calculateMin() {
		if (listOfStudents == null || listOfStudents.isEmpty()) {
			// Handle the case when there are no students or the list is null
			return -1; // Return a negative value to indicate no valid grade found
		}

		int minScore = Integer.MAX_VALUE; // Initialize to a large value

		for (Student student : listOfStudents) {
			int studentScore = student.getGrade().getScore(); // Access the grade for each student
			if (studentScore < minScore) {
				minScore = studentScore;
			}
		}

		return minScore;
	}
	//calculates the highest score in the class
	public static int calculateMax() {
		if (listOfStudents == null || listOfStudents.isEmpty()) {
			// Handle the case when there are no students or the list is null
			return -1; // Return a negative value to indicate no valid grade found
		}

		int maxScore = Integer.MIN_VALUE; // Initialize to a small value

		for (Student student : listOfStudents) {
			int studentScore = student.getGrade().getScore(); // Access the grade for each student
			if (studentScore > maxScore) {
				maxScore = studentScore;
			}
		}

		return maxScore;
	}
	//Takes the PID as an input and outputs the student's score
	public static int getGradeByPid(int pid) {
		for (Student student : listOfStudents) {
			if (student.getPid() == pid) {
				return student.getGrade().getScore();
			}
		}

		// If no student with the provided PID is found, return a value to indicate that
		return -1; // You can choose a different sentinel value if needed
	}
	//Takes the PID as an input and then asks what the user wants to change the grade to, and then changes it.
	public static void updateGradeByPid(int pid) {
		Scanner scanner = new Scanner(System.in);

		for (Student student : listOfStudents) {
			if (student.getPid() == pid) {
				System.out.print("Enter the new grade for " + student.getFirstName() + " " + student.getLastName() + ": ");
				int newGrade = scanner.nextInt();

				// Update the grade for the matching student
				student.getGrade().setScore(newGrade);
				student.getGrade().setLetterGrade(); // Recalculate the letter grade if needed
				System.out.println("Grade updated successfully.");
				return; // Exit the loop after updating the grade
			}
		}

		// If no student with the provided PID is found
		System.out.println("Student with PID " + pid + " not found.");
	}
	//Prints the list of all student info with either number or letter grades
	public static void printStudentList() {
		System.out.println("First Name\tLast Name\tPID\tScore");

		for (Student student : listOfStudents) {
			String firstName = student.getFirstName();
			String lastName = student.getLastName();
			int pid = student.getPid();
			int score = student.getGrade().getScore();

			System.out.println(firstName + "\t" + lastName + "\t" + pid + "\t" + score);
		}
	}
	public static void printStudentListLetters() {
		System.out.println("First Name\tLast Name\tPID\tScore");

		for (Student student : listOfStudents) {
			String firstName = student.getFirstName();
			String lastName = student.getLastName();
			int pid = student.getPid();
			String score = student.getGrade().getLetterGrade();

			System.out.println(firstName + "\t" + lastName + "\t" + pid + "\t" + score);
		}
	}
}
