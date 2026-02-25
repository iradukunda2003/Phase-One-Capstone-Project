package Domain;

import java.util.Map;
import java.util.HashMap;

public class Student extends Person {

    private String studentID;
    private Double GPA;
    private String department;

    private Map<Course, Double> courseGrades = new HashMap<>();


    public String getStudentID()  { return studentID; }
    public Double getGPA()        { return GPA; }
    public String getDepartment() { return department; }

    public void setStudentID(String studentID)   { this.studentID = studentID; }
    public void setGPA(Double GPA)               { this.GPA = GPA; }
    public void setDepartment(String department) { this.department = department; }


    public Map<Course, Double> getCourseGrades() {
        return courseGrades;
    }


    public void setCourseGrades(Course course, Double grade) {
        courseGrades.put(course, grade);
    }

    @Override
    public void displayInfo() {
        System.out.println("Student    : " + getName());
        System.out.println("Student ID : " + getStudentID());
        System.out.println("GPA        : " + getGPA());
        System.out.println("Department : " + getDepartment());
    }
}