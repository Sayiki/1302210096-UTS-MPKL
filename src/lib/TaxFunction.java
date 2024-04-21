package lib;

public class TaxFunction {
	
	private static final int SINGLE_PERSON_NONTAXABLE_INCOME = 54000000;
    private static final int MARRIED_NONTAXABLE_INCOME_ADDITION = 4500000;
    private static final int CHILD_NONTAXABLE_INCOME_ADDITION = 1500000;
    private static final double TAX_RATE = 0.05;

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        int nontaxableIncome = SINGLE_PERSON_NONTAXABLE_INCOME;
        if (isMarried) {
            nontaxableIncome += MARRIED_NONTAXABLE_INCOME_ADDITION;
        }
        nontaxableIncome += Math.min(numberOfChildren, 3) * CHILD_NONTAXABLE_INCOME_ADDITION;

        int totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        int tax = (int) Math.round(TAX_RATE * (totalIncome - deductible - nontaxableIncome));
        return Math.max(tax, 0);
    }
	
}
