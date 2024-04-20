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
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;
    private String spouseName;
    private String spouseIdNumber;
    private String[] childNames;
    private String[] childIdNumbers;

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
        this.childNames = new String[0];
        this.childIdNumbers = new String[0];
    }

    public void setMonthlySalary(int grade) {
        if (grade == 1) {
            monthlySalary = 3000000;
            if (isForeigner) {
                monthlySalary = (int) (3000000 * 1.5);
            }
        } else if (grade == 2) {
            monthlySalary = 5000000;
            if (isForeigner) {
                monthlySalary = (int) (5000000 * 1.5);
            }
        } else if (grade == 3) {
            monthlySalary = 7000000;
            if (isForeigner) {
                monthlySalary = (int) (7000000 * 1.5);
            }
        }
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        this.childNames = addToArray(this.childNames, childName);
        this.childIdNumbers = addToArray(this.childIdNumbers, childIdNumber);
    }

    public int getAnnualIncomeTax() {
        int monthWorkingInYear = getMonthWorkingInYear();
        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, !spouseIdNumber.equals(""), childIdNumbers.length);
    }

    private int getMonthWorkingInYear() {
        LocalDate date = LocalDate.now();
        if (date.getYear() == yearJoined) {
            return date.getMonthValue() - monthJoined;
        } else {
            return 12;
        }
    }

    private static String[] addToArray(String[] array, String value) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        return newArray;
    }
}