package Domain;

import java.util.List;
import java.util.ArrayList;

public class Course {

    private String courseCode;
    private String courseTitle;
    private int    creditUnits;

    private List<Student> roster = new ArrayList<>();

    public String getCourseCode()  { return courseCode; }
    public String getCourseTitle() { return courseTitle; }
    public int    getCreditUnits() { return creditUnits; }

    public void setCourseCode(String courseCode)   { this.courseCode = courseCode; }
    public void setCourseTitle(String courseTitle) { this.courseTitle = courseTitle; }
    public void setCreditUnits(int creditUnits)    { this.creditUnits = creditUnits; }

    public List<Student> getRoster() {
        return roster;
    }

    public void setRoster(Student student) {
        roster.add(student);
    }
}