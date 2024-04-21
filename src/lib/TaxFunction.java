package lib;

public class TaxFunction {

	
	/**
	Metode calculateTax menghitung pajak penghasilan tahunan yang harus dibayar oleh seorang karyawan. 
	Pajak dihitung sebagai 5% dari pendapatan bersih tahunan (gaji dan pendapatan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi potongan) 
	dikurangi penghasilan tidak kena pajak.
	Penghasilan tidak kena pajak adalah:
	Rp 54.000.000 jika karyawan belum menikah dan tidak memiliki anak
	Rp 54.000.000 ditambah Rp 4.500.000 jika karyawan sudah menikah
	Rp 54.000.000 ditambah Rp 4.500.000 per anak hingga anak ketiga jika karyawan memiliki anak
	 */
	
	private static final int SINGLE_PERSON_NONTAXABLE_INCOME = 54000000;
    private static final int MARRIED_NONTAXABLE_INCOME_ADDITION = 4500000;
    private static final int CHILD_NONTAXABLE_INCOME_ADDITION = 1500000;
    private static final double TAX_RATE = 0.05;

    enum MaritalStatus {
        SINGLE,
        MARRIED
    }

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, MaritalStatus maritalStatus, int numberOfChildren) {
        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        int nontaxableIncome = SINGLE_PERSON_NONTAXABLE_INCOME;
        if (maritalStatus == MaritalStatus.MARRIED) {
            nontaxableIncome += MARRIED_NONTAXABLE_INCOME_ADDITION;
        }
        nontaxableIncome += Math.min(numberOfChildren, 3) * CHILD_NONTAXABLE_INCOME_ADDITION;

        int totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        int tax = (int) Math.round(TAX_RATE * (totalIncome - deductible - nontaxableIncome));
        return Math.max(tax, 0);
    }
	
}
