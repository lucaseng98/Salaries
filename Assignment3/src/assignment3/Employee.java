package assignment3;

public class Employee {

    // ATTRIBUTES
    private String name;
    protected double grossSalary;
    protected double netSalary;
    private String ID;
    private double rawSalary;

    // CONSTANTS

    final private double TAXES = 0.9;

    // CONSTRUCTOR

    Employee(String ID, String name, double grossSalary) {
        this.ID = ID;
        this.name = name;
        this.grossSalary = ((int)(grossSalary * 100.0)) / 100.0;
        this.netSalary = ((int)(grossSalary - (grossSalary * (1-TAXES)) * 10.0)/10.0);
        this.rawSalary = rawSalary;
    }

    // GETTERS

    public String getName(){
        return this.name;
    }

    public String getID(){
        return this.ID;
    }

    public double getGrossSalary() {
        return this.grossSalary;
    }
    public double getNetSalary() {
        double netSalary = grossSalary - (grossSalary * (1-TAXES));
        return ((int) (netSalary * 10.0)) / 10.0;
    }
    //((int) (netSalary * 10.0)) / 10.0;
    //double netSalary = grossSalary - (grossSalary * (1-TAXES));

    // SETTERS

    public void setName(String name){
        this.name = name;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public void setGrossSalary(double grossSalary) {
        grossSalary = ((int) (grossSalary * 100.0)) / 100.0;
        this.grossSalary = grossSalary;
    }
    public void setNetSalary(double netSalary){
        this.netSalary = grossSalary;
    }

    // METHODS

    public String toString() {
        return String.format("%s's gross salary is %.2f SEK per month.", this.name, this.grossSalary);
    }

    public boolean equals(Object otherObject) {
        boolean isEquals = false;
        if(this == otherObject){
            return true;
        } else if (otherObject == null) {
            return false;
        } else if (otherObject instanceof Employee){
            Employee otherEmployee = (Employee) otherObject;
            boolean sameID = this.ID.equals(otherEmployee.ID);
            isEquals = sameID;
        } else {
            isEquals = false;
        }
        return isEquals;
    }

}

