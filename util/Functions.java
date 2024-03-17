package util;

import java.util.ArrayList;

public class Functions {

    // Initialize an ArrayList to store students
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Gradebook gradebook = new Gradebook(); // Create an instance of Gradebook

    // Assuming you have a Student class with appropriate setters and getters
    public static void amendStudentList(String x) {
        Student student = parseStudent(x); // Parse and create a student object

        if (student != null) {
            gradebook.addStudent(student); // Add the student to the gradebook
        }
    }

    private static Student parseStudent(String input) {
        String[] s = input.split(" ");

        if (s.length == 4) {
            String firstName = s[0];
            String lastName = s[1];
            String pidString = s[2];
            String gradeString = s[3];
            Grade g1 = new Grade();

            try {
                g1.setScore(Integer.parseInt(gradeString));
            } catch (NumberFormatException e) {
                System.out.println("Invalid grade format.");
                return null; // Exit the method if the grade is invalid
            }

            if (isValidName(firstName) && isValidName(lastName) && isValidPid(pidString) && isValidGrade(gradeString)) {
                Student student = new Student();
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setPid(Integer.parseInt(pidString));
                student.setGrade(g1);
                return student;
            } else {
                System.out.println("Invalid input format or values.");
            }
        } else {
            System.out.println("Incorrect Format");
        }
        return null;
    }

    public static boolean isValidName(String name) {
        return name.matches("[A-Z][a-zA-Z]*");
    }

    public static boolean isValidPid(String pid) {
        return pid.matches("[1-9][0-9]{6}");
    }

    public static boolean isValidGrade(String grade) {
        int number;
        try {
            number = Integer.parseInt(grade);
        } catch (NumberFormatException e) {
            return false; // Return false if the input is not a valid integer
        }
        return number >= 0 && number <= 100;
    }

    public static String getAnswer(String x) {
        if ("Calculate Average".equals(x)) {
            double v = gradebook.calculateAvg(); // Calculate average from the gradebook instance
            return String.valueOf(v);
        }
        else if ("Calculate Median".equals(x)) {
            double v = gradebook.calculateMed(); // Calculate median from the gradebook instance
            return String.valueOf(v);
        }
        return null;
    }
}
