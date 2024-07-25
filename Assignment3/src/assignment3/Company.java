package assignment3;

import java.util.ArrayList;
import java.util.HashMap;

public class Company {

    private static final String EOL = System.lineSeparator();

    private HashMap <String, Employee> employees;
    private ArrayList <Employee> employeeOrderList;

    public Company() {
        employees = new HashMap<String, Employee>();
        employeeOrderList = new ArrayList<Employee>();
    }

    // GETTERS
    public HashMap<String, Employee> getHashMap() {
        return this.employees;
    }

    // METHODS

    public String createEmployee(String ID, String name, double grossSalary){
        Employee employee = new Employee(ID, name, grossSalary);
        this.employees.put(ID, employee);
        this.employeeOrderList.add(employee);

        return String.format("Employee %s was registered successfully.", ID);
    }
    public String createEmployee(String ID, String name, double grossSalary, String degree){
        Employee employee = new Manager(ID, name, grossSalary, degree);
        this.employees.put(ID, employee);
        this.employeeOrderList.add(employee);

        return String.format("Employee %s was registered successfully.", ID);
    }

    public String createEmployee(String ID, String name, double grossSalary, String degree, String department){
        Employee employee = new Director(ID, name, grossSalary, degree, department);
        this.employees.put(ID, employee);
        this.employeeOrderList.add(employee);

        return String.format("Employee %s was registered successfully.", ID);
    }

    public String createEmployee(String ID, String name, double grossSalary, int gpa){
        Employee employee = new Intern(ID, name, grossSalary, gpa);
        this.employees.put(ID, employee);
        this.employeeOrderList.add(employee);

        return String.format("Employee %s was registered successfully.", ID);
    }



    public String printEmployee(String ID) {

        return employees.get(ID).toString();
    }
   public double getNetSalary(String ID) {
       return employees.get(ID).getNetSalary();
   }

    public String removeEmployee(String ID) {
        employees.remove(ID);
        return String.format("Employee %s was successfully removed.", ID);
    }

    public String retrieveEmployee(String ID) {
        return employees.get(ID).toString();
    }

    public String updateEmployeeName(String ID, String newName) {

         this.employees.get(ID).setName(newName);
         return String.format("Employee %s was updated successfully", ID);
    }

    public String updateGrossSalary(String ID, double newGrossSalary) {

        this.employees.get(ID).setGrossSalary(newGrossSalary);
        return String.format("Employee %s was updated successfully", ID);
    }
    public String updateManagerDegree (String ID, String newDegree) {
        Employee retrievedEmployee = employees.get(ID);
        ((Manager) retrievedEmployee).setDegree(newDegree);

        return String.format("Employee %s was updated successfully", ID);
    }

    public String updateDirectorDept(String ID, String newDepartment) {
        Employee retrievedEmployee = employees.get(ID);
        ((Director) retrievedEmployee).setDepartment(newDepartment);

        return String.format("Employee %s was updated successfully", ID);
    }

    public String updateInternGPA(String ID, int newGPA) {
        Employee retrievedEmployee = employees.get(ID);
        ((Intern) retrievedEmployee).setGpa(newGPA);

        return String.format("Employee %s was updated successfully", ID);
    }

    public double calculateTotalGross(String ID, double totalGrossSalaries) {
        for(Employee employee : employees.values()) {
            totalGrossSalaries = totalGrossSalaries + this.employees.get(ID).getGrossSalary();
        }
        return totalGrossSalaries;
    }

    public double getTotalNetSalary() {
        double totalNetSalaries = 0;
        for(int i = 0; i < employeeOrderList.size(); i ++) {
           totalNetSalaries =  totalNetSalaries + employeeOrderList.get(i).getNetSalary();

        }
        return ((int)(totalNetSalaries *100.0))/100.0;
    }

   //public double getTotalNetSalary(String ID, double totalNetSalaries) {
   //    for(Employee employee : employees.values()) {
   //        totalNetSalaries = totalNetSalaries + this.employees.get(ID).getNetSalary();
   //    }
   //    return totalNetSalaries;
   //}

    public String printSortedEmployees() throws Exception {
        if(employees.isEmpty()) {
            throw new NoEmployeesRegistered();
        } else {
            String message = "Employees sorted by gross salary (ascending order):" + EOL;
            ArrayList<Employee> sortedGrossSalaryList = new ArrayList<>();


            for (Employee employee : employees.values()) {
                int index = 0;
                if (sortedGrossSalaryList.isEmpty()) {
                    sortedGrossSalaryList.add(employee);
                } else {
                    while (index < sortedGrossSalaryList.size() && employee.getGrossSalary() > sortedGrossSalaryList.get(index).getGrossSalary()) {
                        index++;
                    }
                    sortedGrossSalaryList.add(index, employee);
                }
            }

            for (Employee employee : sortedGrossSalaryList) {
                message = message + String.format("%s" + EOL, employee);
            }
            return message;
        }
    }

    public int calculateTotalEmployees(String ID, int totalEmployees) {
        for(Employee employee : employees.values()) {
            totalEmployees = totalEmployees + employees.size();
        }
        return totalEmployees;
    }

    public String printAllEmployees() {
            String message = "All registered employees:" + EOL;

            for (int i = 0; i < employeeOrderList.size(); i++) {
                message = message + String.format(employeeOrderList.get(i).toString() + EOL);

            }
            return message;


    }

    public void





}


