/*
  Created by Albores, Allyssa; Serato, Jay Vince; Sotto, Wina Gen on 13 Oct 2016.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;

public class StudentTesting {
    private static final String FILE_NAME = "studentDatabase.txt";

    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        List<Student> studentList = new ArrayList<>();
        int choice;
        boolean hasSaved = false;

        /*
        String sCurrentLine;
        BufferedReader br = null;
        */

        /*
        try {
            br = new BufferedReader(new FileReader("db.txt"));
            while ((sCurrentLine = br.readLine()) != null){
                if (sCurrentLine.toCharArray()[0] >= '0' && sCurrentLine.toCharArray()[0] <= '9'){
                    String firstName = br.readLine();
                    String tempMiddleInitial = br.readLine();
                    char middleInitial = tempMiddleInitial.toCharArray()[0];
                    String lastName = br.readLine();
                    String course = br.readLine();
                    String tempYearLevel = br.readLine();
                    int yearLevel = tempYearLevel.toCharArray()[0] - '0';

                    studentList.add(new Student(sCurrentLine, firstName, middleInitial, lastName, course, yearLevel));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */

        // Storing all Students unto the list
        try {
            fis = new FileInputStream(FILE_NAME);
            try {
                ois = new ObjectInputStream(fis);
                //System.out.println(ois.read());
                if (ois.read() == -1) {
                    studentList = (List<Student>) ois.readObject();
                }
            } catch (EOFException e) {
                // do nothing
            }
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        do {
            boolean hasDeleted = false;
            boolean hasFound = false;

            System.out.println("Menu: \n" +
                    " 1. Register information \n" +
                    " 2. Retrieve information \n" +
                    " 3. Delete information \n" +
                    " 4. Save information profile \n" +
                    " 5. Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // Register information
                    System.out.print("Student Number: ");
                    String studentNumber = sc.nextLine();
                    checker(studentNumber, studentList);
                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Middle Initial: ");
                    String tempMiddleInitial = sc.nextLine();
                    char middleInitial = tempMiddleInitial.toCharArray()[0];
                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    System.out.print("Year Level: ");
                    String tempYearLevel = sc.nextLine();
                    int yearLevel = Integer.parseInt(tempYearLevel);
                    System.out.print("Who is your crush? ");
                    String crushName = sc.nextLine();
                    System.out.print("What is your favorite course's name? ");
                    String courseName = sc.nextLine();
                    System.out.print("What is your favorite course's description? ");
                    String courseDescription = sc.nextLine();
                    Course faveSubject = new Course(courseName, courseDescription);

                    studentList.add(new Student(studentNumber, firstName, middleInitial, lastName, course, yearLevel, crushName, faveSubject));
                    System.out.println("Student added!");
                    hasSaved = false;
                    break;
                case 2: // Retrieve information
                    System.out.print("Search Student Number: ");
                    String toFind = sc.next();

                    // Find on the list
                    for(Student stud : studentList) {
                        if (stud.getStudentNumber().equals(toFind)) {
                            System.out.println(stud);
                            hasFound = true;
                            break;
                        }
                    }
                    if (!(hasFound)) {
                        System.out.println("Student " + toFind + " is not in the roster.");
                    }
                    break;
                case 3: // Delete information
                    System.out.print("Delete Student Number: ");
                    String tempStudentNumber = sc.next();
                    for(Student stu : studentList){
                        if (stu.getStudentNumber().equals(tempStudentNumber)) {
                            studentList.remove(stu);
                            System.out.println("Student deleted!");
                            hasDeleted = true;
                            break;
                        }
                    }
                    if (!(hasDeleted)) {
                        System.out.println("Error! " + tempStudentNumber + " is not in the database.");
                    }
                    break;
                case 4: // Save information profile
                    /*try {
                        File file = new File("db.txt");

                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        FileWriter fw = new FileWriter(file);
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (Student stud1 : studentList) {
                            bw.write(stud1.getStudentNumber());
                            bw.newLine();
                            bw.write(stud1.getFirstName());
                            bw.newLine();
                            bw.write(stud1.getMiddleInitial());
                            bw.newLine();
                            bw.write(stud1.getLastName());
                            bw.newLine();
                            bw.write(stud1.getCourse());
                            bw.newLine();
                            bw.write(stud1.getYearLevel());
                            bw.newLine();
                        }
                        bw.close();
                        hasSaved = true;
                        System.out.println("Done!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/
                    try {
                        fos = new FileOutputStream(FILE_NAME);
                        oos = new ObjectOutputStream(fos);

                        oos.writeObject(studentList);

                        hasSaved = true;
                        System.out.println("Done!");
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    int willSave = 1;
                    if (!(hasSaved || studentList.isEmpty())) {
                        System.out.println("Warning! You have not saved your profile/s. Do you still wish to exit? \n" +
                        " 1. Yes \n" +
                        " 2. No");
                        willSave = sc.nextInt();
                    }
                    if (willSave == 2){
                        break;
                    }
                    else {
                        System.out.println("Thank you for using our software!");
                    }
                    try {
                        if (fos != null) fos.close();
                        if (fis != null) fis.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input!");
            }
        } while (choice != 5);
    }

    private static void checker(String studentNumber, List<Student> studentList) {
        for(Student s : studentList){
            if (s.getStudentNumber().equals(studentNumber)) {
                throw new IllegalArgumentException("Student Number already exists in list.");
            }
        }
    }
}
