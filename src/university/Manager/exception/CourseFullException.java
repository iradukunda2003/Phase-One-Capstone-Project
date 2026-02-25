package Manager;

public class CourseFullException extends Exception {

    public CourseFullException(String courseName) {
        super("Course is full, cannot enroll in : " + courseName);
    }
}