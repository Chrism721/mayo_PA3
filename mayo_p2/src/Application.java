
public class Application {
    public static void main(String[] args){

        //creating instances of class SavingsAccount
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        //interest rate is 4%
        SavingsAccount.modifyInterestRate(0.04);

        //calculating 12 months of interest for saver 1 and printing
        System.out.println("----- Saver 1's Saving Balance -----");
        for(int i = 1; i <= 12; i++){
            saver1.calculateMonthlyInterest();
            System.out.print("Month " + i + " savings balance: $");
            System.out.printf("%.2f\n", saver1.getSavingsBalance());
        }
        System.out.println();

        //calculating 12 months of interest for saver 2 and printing
        System.out.println("----- Saver 2's Saving Balance -----");
        for(int i = 1; i <= 12; i++){
            saver2.calculateMonthlyInterest();
            System.out.print("Month " + i + " savings balance: $");
            System.out.printf("%.2f\n", saver2.getSavingsBalance());
        }
        System.out.println();

        //interest rate is 5%
        SavingsAccount.modifyInterestRate(0.05);

        //calculating next months interest and balances for both savers
        saver1.calculateMonthlyInterest();
        System.out.printf("Saver 1's savings balance after the new interest rate is: $%.2f\n", saver1.getSavingsBalance());
        saver2.calculateMonthlyInterest();
        System.out.printf("Saver 2's savings balance after the new interest rate is: $%.2f\n", saver2.getSavingsBalance());


    }
}
