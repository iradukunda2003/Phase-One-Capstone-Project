package Manager;

import Domain.Student;
import Domain.Course;
import Domain.UndergraduateStudent;
import Domain.GraduateStudent;

import java.util.ArrayList;
import java.util.List;

public class UniversityManager {

    private List<Student> students = new ArrayList<>();

    private List<Course> courses = new ArrayList<>();


    private static final int MAX_CAPACITY = 3;

    public List<Student> getStudents() { return students; }
    public List<Course>  getCourses()  { return courses; }


    public void registerStudent(Student student) {
        students.add(student);
        System.out.println("Student registered: " + student.getName());
    }


    public void createCourse(Course course) {
        courses.add(course);
        System.out.println("Course created: " + course.getCourseTitle());
    }


    public void enrollStudentInCourse(Student student, Course course)
            throws CourseFullException, StudentAlreadyEnrolledException {


        if (course.getRoster().size() >= MAX_CAPACITY) {
            throw new CourseFullException(course.getCourseTitle());
        }


        if (student.getCourseGrades().containsKey(course)) {
            throw new StudentAlreadyEnrolledException(
                    student.getName(), course.getCourseTitle());
        }


        course.setRoster(student);
        student.setCourseGrades(course, 0.0);
        System.out.println(student.getName()
                + " enrolled in " + course.getCourseTitle());
    }


    public double getAverageGPA(String department) {
        return students.stream()
                .filter(s -> s.getDepartment().equals(department))
                .mapToDouble(s -> s.getGPA())
                .average()
                .orElse(0.0);
    }


    public Student getTopStudent() {
        return students.stream()
                .max((s1, s2) -> Double.compare(s1.getGPA(), s2.getGPA()))
                .orElse(null);
    }
}