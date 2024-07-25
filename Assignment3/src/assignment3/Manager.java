package assignment3;

public class Manager extends Employee{

    final private double TAXES = 0.9;
    final private double BSCBONUS = 0.10;
    final private double MSCBONUS = 0.20;
    final private double PHDBONUS = 0.35;
    protected String degree;
    private double rawSalary;


    Manager(String ID, String name, double grossSalary, String degree) {
        super(ID, name, grossSalary);
        this.degree = degree;
        this.rawSalary = rawSalary;
        getGrossSalary(grossSalary);

    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }



        public void getGrossSalary(double managerGrossSalary) {
        super.setGrossSalary(managerGrossSalary);
        double degreeBonus = 0;
        switch (degree) {
            case "BSc" -> degreeBonus = managerGrossSalary * BSCBONUS;
            case "MSc" -> degreeBonus = managerGrossSalary * MSCBONUS;
            case "PhD" -> degreeBonus = managerGrossSalary * PHDBONUS;
        }
        this.grossSalary += ((int)(degreeBonus * 100.0)) / 100.0 ;
    }

    @Override
    public String toString() {
        return String.format("%s %s's gross salary is %.2f SEK per month." , this.getDegree(), this.getName(), this.getGrossSalary());
    }
    @Override
    public double getNetSalary() {
        double netSalary = grossSalary - (grossSalary * (1-TAXES));
        return ((int) (netSalary * 100.0)) / 100.0;
    }




}
