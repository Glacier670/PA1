package util;

public class Grade {
    private int score;
    private String letterGrade;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade() {
        if (score >= 97) {
            letterGrade = "A+";
        } else if (score >= 93) {
            letterGrade = "A";
        } else if (score >= 90) {
            letterGrade = "A-";
        } else if (score >= 87) {
            letterGrade = "B+";
        } else if (score >= 83) {
            letterGrade = "B";
        } else if (score >= 80) {
            letterGrade = "B-";
        } else if (score >= 77) {
            letterGrade = "C+";
        } else if (score >= 73) {
            letterGrade = "C";
        } else if (score >= 70) {
            letterGrade = "C-";
        } else if (score >= 67) {
            letterGrade = "D+";
        } else if (score >= 63) {
            letterGrade = "D";
        } else if (score >= 60) {
            letterGrade = "D-";
        } else {
            letterGrade = "F";
        }
    }
}
