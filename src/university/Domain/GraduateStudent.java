package Domain;

public class GraduateStudent extends Student {

    private double costPerCredit = 1200.00;

    private double researchFee = 2500.00;

    private int totalCredits;


    public double getCostPerCredit() {
        return costPerCredit;
    }

    public double getResearchFee() {
        return researchFee;
    }

    public int getTotalCredits() {
        return totalCredits;
    }


    public void setCostPerCredit(double costPerCredit) {
        this.costPerCredit = costPerCredit;
    }

    public void setResearchFee(double researchFee) {
        this.researchFee = researchFee;
    }


    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }


    public double calculateTuition() {
        return (costPerCredit * totalCredits) + researchFee;
    }

    @Override
    public void displayInfo() {
        System.out.println("Type         : Graduate Student");
        System.out.println("Name         : " + getName());
        System.out.println("Student ID   : " + getStudentID());
        System.out.println("GPA          : " + getGPA());
        System.out.println("Department   : " + getDepartment());
        System.out.println("Credits      : " + totalCredits);
        System.out.println("Research Fee : $" + researchFee);
        System.out.println("Tuition      : $" + calculateTuition());
    }
}