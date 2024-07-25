package assignment3;

public class Director extends Manager {

    final private int DIRECTORBONUS = 5000;
    final private double BSCBONUS = 0.10;
    final private double MSCBONUS = 0.20;
    final private double PHDBONUS = 0.35;
    final private double TAXLVL1 = 0.1;
    final private double TAXLVL2 = 0.2;
    final private double TAXLVL3 = 0.4;

    private String department;
    private double rawSalary;


    Director(String ID, String name, double grossSalary, String degree, String department) {
        super(ID, name, grossSalary, degree);
        this.department = department;
        this.rawSalary = rawSalary;
        getDirectorGrossSalary(grossSalary);

    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void getDirectorGrossSalary(double directorGrossSalary) {
        super.setGrossSalary(directorGrossSalary);
        double degreeBonus = 0;
        switch (this.degree) {
            case "BSc" -> degreeBonus = (directorGrossSalary * BSCBONUS);
            case "MSc" -> degreeBonus = (directorGrossSalary * MSCBONUS);
            case "PhD" -> degreeBonus = (directorGrossSalary * PHDBONUS);
        }
        this.grossSalary += degreeBonus + DIRECTORBONUS;
    }

    @Override
    public String toString() {
        return String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s", getDegree(), getName(), getGrossSalary(),getDepartment());
    }

     @Override
     public double getNetSalary() {
        double directorNetSalary = 0;
        if (this.getGrossSalary() < 30000) {
            directorNetSalary = this.getGrossSalary() -(this.getGrossSalary() * TAXLVL1);
        } else if (this.getGrossSalary() >= 30000 && this.getGrossSalary() <= 50000) {
            directorNetSalary = this.getGrossSalary() - (this.getGrossSalary() * TAXLVL2);
        } else if (this.getGrossSalary() > 50000) {
            double taxlvl3Salary = this.getGrossSalary() - 30000;
            directorNetSalary = this.getGrossSalary() - (taxlvl3Salary * TAXLVL3) - (30000 * TAXLVL2);
        }
        return directorNetSalary;
    }
}


