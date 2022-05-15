import java.io.BufferedWriter;
import java.io.FileWriter;

public class Account {

    private String accountBalance;
    private String accountNumber;
    private String accountPin;
    private String accountHolder;
    Screen screen = new Screen();

    public Account(String number, String pin, String holder, String balance) {
        accountBalance = balance;
        accountNumber = number;
        accountPin = pin;
        accountHolder = holder;

    }

    // Get the account balance
    public String getBalance() {
        return accountBalance;
    }

    // Withdraw Money
    public void withdrawMoney() {
        int balance = Integer.parseInt(accountBalance);
        int amount = screen.getInput("How much you want to withdraw?: ");

        // Check if the user have enough funds to perform the transaction
        while (amount > balance) {
            System.out.println("Unsufficient funds");
            amount = screen.getInput("How much you want to withdraw?: ");
        }

        // Set new balance for acocunt object
        accountBalance = Integer.toString(balance -= amount);

        // Save the new balance in the account.txt file
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(accountNumber+".txt"));
            bw.write(accountNumber + "," + accountPin + "," + accountHolder + "," + accountBalance);
            bw.close();
        }catch(Exception ex) {
            System.out.println("Something went wrong");;
        }
        

        
    }

    // Make a deposit
    public void depositMoney() {
        int balance = Integer.parseInt(accountBalance);
        int amount = screen.getInput("How much you want to deposit? ");
        accountBalance =  Integer.toString(balance += amount);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(accountNumber+".txt"));
            bw.write(accountNumber + "," + accountPin + "," + accountHolder + "," + accountBalance);
            bw.close();
        }catch(Exception ex) {
            System.out.println("Something went wrong");
        }
    }
}