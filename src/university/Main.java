package Persistence;

import Domain.*;
import Manager.*;
import java.util.Scanner;

public class Main {

    static Scanner scanner             = new Scanner(System.in);
    static UniversityManager manager   = new UniversityManager();
    static FileManager FileManager     = new FileManager();

    public static void main(String[] args) {


        fileManager.loadData(manager);

        boolean running = true;

        while (running) {

            System.out.println("\n══════════════════════════════");
            System.out.println("       UNIVERSITY MENU        ");
            System.out.println("══════════════════════════════");
            System.out.println("1. Register Student");
            System.out.println("2. Enroll in Course");
            System.out.println("3. View Student Record");
            System.out.println("4. Generate Dean's List");
            System.out.println("5. Save and Exit");
            System.out.println("══════════════════════════════");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerStudent();
                    break;

                case "2":
                    enrollInCourse();
                    break;

                case "3":
                    viewStudentRecord();
                    break;

                case "4":
                    generateDeansList();
                    break;

                case "5":
                    fileManager.saveData(manager);
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }


    static void registerStudent() {
        System.out.print("Type (UG/GR): ");
        String type = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Student ID: ");
        String id = scanner.nextLine();

        System.out.print("GPA: ");
        double gpa = Double.parseDouble(scanner.nextLine());

        System.out.print("Department: ");
        String dept = scanner.nextLine();

        if (type.equals("UG")) {
            UndergraduateStudent ug = new UndergraduateStudent();
            ug.setName(name);
            ug.setStudentID(id);
            ug.setGPA(gpa);
            ug.setDepartment(dept);
            manager.registerStudent(ug);

        } else if (type.equals("GR")) {
            System.out.print("Total Credits: ");
            int credits = Integer.parseInt(scanner.nextLine());

            GraduateStudent gr = new GraduateStudent();
            gr.setName(name);
            gr.setStudentID(id);
            gr.setGPA(gpa);
            gr.setDepartment(dept);
            gr.setTotalCredits(credits);
            manager.registerStudent(gr);
        }
    }


    static void enrollInCourse() {
        System.out.print("Student ID: ");
        String sid = scanner.nextLine();

        System.out.print("Course Code: ");
        String code = scanner.nextLine();


        Student student = manager.getStudents().stream()
                .filter(s -> s.getStudentID().equals(sid))
                .findFirst().orElse(null);


        Course course = manager.getCourses().stream()
                .filter(c -> c.getCourseCode().equals(code))
                .findFirst().orElse(null);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        try {
            manager.enrollStudentInCourse(student, course);
        } catch (CourseFullException e) {
            System.out.println("CAUGHT: " + e.getMessage());
        } catch (StudentAlreadyEnrolledException e) {
            System.out.println("CAUGHT: " + e.getMessage());
        }
    }


    static void viewStudentRecord() {
        System.out.print("Student ID: ");
        String sid = scanner.nextLine();

        Student student = manager.getStudents().stream()
                .filter(s -> s.getStudentID().equals(sid))
                .findFirst().orElse(null);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Name       : " + student.getName());
        System.out.println("ID         : " + student.getStudentID());
        System.out.println("GPA        : " + student.getGPA());
        System.out.println("Department : " + student.getDepartment());
        System.out.println("Courses    :");
        student.getCourseGrades().forEach((course, grade) ->
                System.out.println("  - " + course.getCourseTitle()
                        + " | Grade: " + grade));
    }


    static void generateDeansList() {
        System.out.println(" Deans List (GPA > 3.5) ");
        manager.getStudents().stream()
                .filter(s -> s.getGPA() > 3.5)
                .forEach(s -> System.out.println(
                        s.getName() + " | GPA: " + s.getGPA()));
    }
}
