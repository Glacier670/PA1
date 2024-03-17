package main;

import util.*;
import java.util.Scanner;

import static util.Gradebook.*;

public class Main {

    public static void main(String[] args) {
        boolean exit = false; // Initialize exit to false
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to my grade book!\n" +
                "Please enter the information of all the students using the following format:\n" +
                "“firstName lastName PID grade”.\n" +
                "Press Enter when you want to input the next student and type DONE when you are finished inputting all the students.\n");

        Gradebook gradebook = new Gradebook(); // Create a gradebook instance

        while (true) {
            String input = keyboard.nextLine();

            if (input.equalsIgnoreCase("DONE")) {
                break; // Exit the student input loop when "DONE" is entered
            }

            // Parse and add students to the gradebook
            Student student = parseStudent(input);
            if (student != null) {
                gradebook.addStudent(student); // Add the student to the gradebook
            }
        }

        while (!exit) { // Check for the exit condition
            System.out.println("""

                    ---------------------------------------------------------------------------------------------------
                    List of commands:
                    (Please input the number associated with the command to proceed.)
                    ---------------------------------------------------------------------------------------------------
                    1. Calculate Average Grade
                    2. Calculate Average Grade Letter
                    3. Calculate Median Grade
                    4. Calculate Median Grade Letter
                    5. Calculate Minimum Score
                    6. Calculate Minimum Score Letter
                    7. Calculate Maximum Score
                    8. Calculate Maximum Score Letter
                    9. Get Number Score by PID
                    10. Get Letter Score by PID
                    11. Change Score by PID
                    12. Tab Scores
                    13. Tab letters
                    14. Quit
                    """);

            String command = keyboard.nextLine();

            switch (command.toLowerCase()) {
                case "1":
                    double avg = gradebook.calculateAvg();
                    System.out.println("Class Average: " + avg);
                    break;
                case "2":
                    double avgLetter = gradebook.calculateAvg();
                    System.out.println("Class Average: " + convertToLetter(avgLetter));
                    break;
                case "3":
                    double median = gradebook.calculateMed();
                    System.out.println("Class Median: " + median);
                    break;
                case "4":
                    double medianLetter = gradebook.calculateMed();
                    System.out.println("Class Median: " + convertToLetter(medianLetter));
                    break;
                case "5":
                    int min = calculateMin();
                    System.out.println("Class Lowest: " + min);
                    break;
                case "6":
                    int minLetter = calculateMin();
                    System.out.println("Class Lowest: " + convertToLetter(minLetter));
                    break;
                case "7":
                    int max = calculateMax();
                    System.out.println("Class Highest: " + max);
                    break;
                case "8":
                    int maxLetter = calculateMax();
                    System.out.println("Class Highest: " + convertToLetter(maxLetter));
                    break;
                case "9":
                    System.out.println("Enter the PID of the score you would like to access.");
                    String pidInput = keyboard.nextLine();
                    System.out.println("Student's Score: " + getGradeByPid(Integer.parseInt(pidInput)));
                    break;
                case "10":
                    System.out.println("Enter the PID of the score you would like to access.");
                    String pidInputLetter = keyboard.nextLine();
                    System.out.println("Student's Score: " + convertToLetter(getGradeByPid(Integer.parseInt(pidInputLetter))));
                    break;
                case "11":
                    System.out.println("Enter the PID of the score you would like to access.");
                    int pidInputInt = Integer.parseInt(keyboard.nextLine());
                    updateGradeByPid(pidInputInt);
                    break;
                case "12":
                    Gradebook.printStudentList();
                    break;
                case "13":
                    Gradebook.printStudentListLetters();
                    break;
                case "14":
                case "quit":
                    System.out.println("Goodbye!");
                    exit = true; // Set exit to true to exit the loop
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    // Helper method to parse student information from input
    private static Student parseStudent(String input) {
        String[] s = input.split(" ");
        if (s.length == 4) {
            String firstName = s[0];
            String lastName = s[1];
            String pidString = s[2];
            String gradeString = s[3];

            if (Functions.isValidName(firstName) && Functions.isValidName(lastName) &&
                    Functions.isValidPid(pidString) && Functions.isValidGrade(gradeString)) {
                Student student = new Student();
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setPid(Integer.parseInt(pidString));
                Grade grade = new Grade();
                grade.setScore(Integer.parseInt(gradeString));
                student.setGrade(grade);
                return student;
            } else {
                System.out.println("Invalid input format or values.");
            }
        } else {
            System.out.println("Incorrect Format");
        }
        return null;
    }

    // Converts the grade to letter form, reiterated for different types of variables
    private static String convertToLetter(String x) {
        double score = Double.parseDouble(x);
        if (score >= 97) {
            return "A+";
        } else if (score >= 93) {
            return "A";
        } else if (score >= 90) {
            return "A-";
        } else if (score >= 87) {
            return "B+";
        } else if (score >= 83) {
            return "B";
        } else if (score >= 80) {
            return "B-";
        } else if (score >= 77) {
            return "C+";
        } else if (score >= 73) {
            return "C";
        } else if (score >= 70) {
            return "C-";
        } else if (score >= 67) {
            return "D+";
        } else if (score >= 63) {
            return "D";
        } else if (score >= 60) {
            return "D-";
        } else {
            return "F";
        }
    }
    private static String convertToLetter(double score) {
        if (score >= 97) {
            return "A+";
        } else if (score >= 93) {
            return "A";
        } else if (score >= 90) {
            return "A-";
        } else if (score >= 87) {
            return "B+";
        } else if (score >= 83) {
            return "B";
        } else if (score >= 80) {
            return "B-";
        } else if (score >= 77) {
            return "C+";
        } else if (score >= 73) {
            return "C";
        } else if (score >= 70) {
            return "C-";
        } else if (score >= 67) {
            return "D+";
        } else if (score >= 63) {
            return "D";
        } else if (score >= 60) {
            return "D-";
        } else {
            return"F";
        }
    }
    private static String convertToLetter(int score) {
        if (score >= 97) {
            return "A+";
        } else if (score >= 93) {
            return "A";
        } else if (score >= 90) {
            return "A-";
        } else if (score >= 87) {
            return "B+";
        } else if (score >= 83) {
            return "B";
        } else if (score >= 80) {
            return "B-";
        } else if (score >= 77) {
            return "C+";
        } else if (score >= 73) {
            return "C";
        } else if (score >= 70) {
            return "C-";
        } else if (score >= 67) {
            return "D+";
        } else if (score >= 63) {
            return "D";
        } else if (score >= 60) {
            return "D-";
        } else {
            return"F";
        }
    }
}
