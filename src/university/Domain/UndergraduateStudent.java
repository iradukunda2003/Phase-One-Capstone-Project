package Domain;

public class UndergraduateStudent extends Student {

    private double flatRate = 15000.00;

    public double getFlatRate() {
        return flatRate;
    }

    public void setFlatRate(double flatRate) {
        this.flatRate = flatRate;
    }

    public double calculateTuition() {
        return flatRate;
    }

    @Override
    public void displayInfo() {
        System.out.println("Type       : Undergraduate Student");
        System.out.println("Name       : " + getName());
        System.out.println("Student ID : " + getStudentID());
        System.out.println("GPA        : " + getGPA());
        System.out.println("Department : " + getDepartment());
        System.out.println("Tuition    : $" + calculateTuition());
    }
}
