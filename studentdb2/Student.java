import java.io.Serializable;

/**
 * Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 13 Oct 2016.
 */

public class Student implements Serializable {
    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;
    private String crushName;
    private Course faveSubject;

    public Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel, String crushName, Course faveSubject) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.crushName = crushName;
        this.faveSubject = faveSubject;
    }


    public String toString() {
        return "Student Number: " + studentNumber + "\n" +
                "Name: " + lastName + ", " + firstName + " " + middleInitial + ".\n" +
                "Program: " + course + "\n" +
                "Year Level: " + yearLevel + "\n" +
                "Crush: " + crushName + "\n" +
                "Favorite Course: " + faveSubject.toString();
    }

    // getters and setters
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }
}
