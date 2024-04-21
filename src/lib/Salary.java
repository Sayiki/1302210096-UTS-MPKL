package lib;

import java.time.LocalDate;

public class Salary {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public void setMonthlySalary(int grade, boolean isForeigner) {
        int baseSalary;
        switch (grade) {
            case 1:
                baseSalary = 3000000;
                break;
            case 2:
                baseSalary = 5000000;
                break;
            case 3:
                baseSalary = 7000000;
                break;
            default:
                baseSalary = 0;
        }
        monthlySalary = isForeigner ? (int) (baseSalary * 1.5) : baseSalary;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public int getAnnualIncomeTax(int yearJoined, int monthJoined, Family family) {
        LocalDate date = LocalDate.now();
        int monthWorkingInYear = (date.getYear() == yearJoined) ? date.getMonthValue() - monthJoined : 12;

        TaxFunction.MaritalStatus maritalStatus = family.getSpouseIdNumber().isEmpty() ? TaxFunction.MaritalStatus.SINGLE : TaxFunction.MaritalStatus.MARRIED;
        int nontaxableIncome = TaxFunction.calculateNontaxableIncome(maritalStatus, family.getNumberOfChildren());
        int totalIncome = (monthlySalary + otherMonthlyIncome) * monthWorkingInYear;
        return TaxFunction.calculateTax(totalIncome, annualDeductible, nontaxableIncome);
    }
}