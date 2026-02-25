package Manager;

public class StudentAlreadyEnrolledException extends Exception {

    public StudentAlreadyEnrolledException(String studentName, String courseName) {
        super(studentName + " is already enrolled in : " + courseName);
    }
