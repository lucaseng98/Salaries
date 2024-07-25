package assignment3;

public class Intern extends Employee{

    final private int INTERNBONUS = 1000;

    private int gpa;
    private int rawSalary;
    Intern(String ID, String name, double grossSalary, int gpa) {
        super(ID, name, grossSalary);
        this.gpa = gpa;
        this.rawSalary = rawSalary;
        getInternGrossSalary(grossSalary);

    }

    public int getGpa(){
        return this.gpa;
    }

    public void setGpa(int gpa){
        this.gpa = gpa;
    }
    @Override
    public double getNetSalary() {
        return getGrossSalary();
    }

    public void getInternGrossSalary(double internGrossSalary) {
        super.setGrossSalary(internGrossSalary);
        double internTotalSalary = 0;
        switch(gpa) {
            case 1,2,3,4,5 -> internTotalSalary = internGrossSalary * 0;
            case 6,7 -> internTotalSalary = internGrossSalary;
            case 8,9,10 -> internTotalSalary =internGrossSalary + INTERNBONUS;
        }
        this.grossSalary = internTotalSalary;
    }
    @Override
    public String toString() {
       return String.format("%s's gross salary is %.2f SEK per month. GPA: %s", this.getName(), this.getGrossSalary(), this.getGpa());
    }



}
