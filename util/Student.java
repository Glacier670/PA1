package util;

public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;

    // Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Setter for pid
    public void setPid(int pid) {
        this.pid = pid;
    }

    // Setter for grade (assuming Grade is a class)
    public void setGrade(Grade grade) {
        this.grade = grade;
        this.grade.setLetterGrade(); // Calculate letter grade based on the student's score
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPid() {
        return pid;
    }

    public Grade getGrade() {
        return grade;
    }
}
