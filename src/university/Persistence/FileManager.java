package Persistence;

import Domain.*;
import Manager.UniversityManager;
import java.io.*;

public class FileManager {

    private static final String STUDENTS_FILE = "students.txt";
    private static final String COURSES_FILE  = "courses.txt";


    public void saveData(UniversityManager manager) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENTS_FILE));

            for (Student s : manager.getStudents()) {

                if (s instanceof UndergraduateStudent) {

                    writer.write("UG," + s.getName() + ","
                            + s.getStudentID() + ","
                            + s.getGPA() + ","
                            + s.getDepartment());
                    writer.newLine();

                } else if (s instanceof GraduateStudent) {
                    GraduateStudent grauate = (GraduateStudent) s;

                    writer.write("GR," + s.getName() + ","
                            + s.getStudentID() + ","
                            + s.getGPA() + ","
                            + s.getDepartment() + ","
                            + gr.getTotalCredits());
                    writer.newLine();
                }
            }
            writer.close();
            System.out.println("Students saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(COURSES_FILE));

            for (Course c : manager.getCourses()) {

                writer.write(c.getCourseCode() + ","
                        + c.getCourseTitle() + ","
                        + c.getCreditUnits());
                writer.newLine();
            }
            writer.close();
            System.out.println("Courses saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }


    public void loadData(UniversityManager manager) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(STUDENTS_FILE));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] p = line.split(",");


                if (p[0].equals("UG")) {
                    UndergraduateStudent ug = new UndergraduateStudent();
                    ug.setName(p[1]);
                    ug.setStudentID(p[2]);
                    ug.setGPA(Double.parseDouble(p[3]));
                    ug.setDepartment(p[4]);
                    manager.registerStudent(ug);
                }


                if (p[0].equals("GR")) {
                    GraduateStudent gr = new GraduateStudent();
                    gr.setName(p[1]);
                    gr.setStudentID(p[2]);
                    gr.setGPA(Double.parseDouble(p[3]));
                    gr.setDepartment(p[4]);
                    gr.setTotalCredits(Integer.parseInt(p[5]));
                    manager.registerStudent(gr);
                }
            }
            reader.close();
            System.out.println("Students loaded successfully.");

        } catch (IOException e) {
            System.out.println("No saved students found.");
        }


        try {
            BufferedReader reader = new BufferedReader(new FileReader(COURSES_FILE));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] p = line.split(",");
                Course c = new Course();
                c.setCourseCode(p[0]);
                c.setCourseTitle(p[1]);
                c.setCreditUnits(Integer.parseInt(p[2]));
                manager.createCourse(c);
            }
            reader.close();
            System.out.println("Courses loaded successfully.");

        } catch (IOException e) {
            System.out.println("No saved courses found.");
        }
    }
}
