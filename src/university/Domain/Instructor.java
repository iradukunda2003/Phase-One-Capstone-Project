package Domain;

public class instructor extends Person {
    private String employeeID;
    private String department;

    public String getEmployeeID() {
        return employeeID;
    }

    public String getDepartment() {
        return department;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public void displayInfo() {
        System.out.println("employeeID    : " + getName());
        System.out.println("department : " + getDepartment());
    }
}

