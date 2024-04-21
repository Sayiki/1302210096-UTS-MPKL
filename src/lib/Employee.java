package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private boolean isForeigner;
    private boolean gender; // true = Laki-laki, false = Perempuan
    private Family family;
    private Salary salary;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;
        this.family = new Family();
        this.salary = new Salary();
    }

    // Delegate methods to Family and Salary classes
    public void setMonthlySalary(int grade) {
        salary.setMonthlySalary(grade, isForeigner);
    }

    public void setAnnualDeductible(int deductible) {
        salary.setAnnualDeductible(deductible);
    }

    public void setAdditionalIncome(int income) {
        salary.setAdditionalIncome(income);
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        family.setSpouse(spouseName, spouseIdNumber);
    }

    public void addChild(String childName, String childIdNumber) {
        family.addChild(childName, childIdNumber);
    }

    public int getAnnualIncomeTax() {
        return salary.getAnnualIncomeTax(yearJoined, monthJoined, family);
    }
}
