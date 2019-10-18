
public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(){
        this.savingsBalance = 0; //initialized default savings balance
    }

    public SavingsAccount(double userSavings){
        this.savingsBalance = userSavings; //assigning value to savings balance
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public void calculateMonthlyInterest(){
        double monthlyInterest = 0;
        monthlyInterest = savingsBalance * annualInterestRate / 12.00;
        savingsBalance += monthlyInterest; //
    }

    public static void modifyInterestRate(double newVal){
        annualInterestRate = newVal;
    }

}
