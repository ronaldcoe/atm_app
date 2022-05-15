import java.text.NumberFormat;

public class Main {
    
    public static void main(String[] args) {
        Teller teller = new Teller();
        Account account;
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
       

        // Display welcome message and options
        int option = 0;
        while(option != 5){
            
            option = teller.getOption();
            switch(option) {

                // Create a new Account
                case 1:
                    teller.createAccount();                    
                    break;

                // Check balance
                case 2:
                    if (teller.checkPermission()) { // First, check if the user have permission to acces the account
                        String[] accountInfo = teller.readAccount();
                        account = new Account(accountInfo[0], accountInfo[1], accountInfo[2], accountInfo[3]);
                        System.out.println("Your account balance is: " + defaultFormat.format(Integer.parseInt(account.getBalance())));
                    }else {
                        System.out.println("\nYou dont have permission to check this account");
                    }
                    break;

                // Make a deposit    
                case 3:
                    if (teller.checkPermission()) {
                        String[] accountInfo = teller.readAccount();
                        account = new Account(accountInfo[0], accountInfo[1], accountInfo[2], accountInfo[3]);
                        account.depositMoney();
                        System.out.println("Your account balance is: " + defaultFormat.format(Integer.parseInt(account.getBalance())));
                    }else {
                        System.out.println("You dont have permission to check this account");
                    }
                    break;

                // Withdraw money
                case 4:
                if (teller.checkPermission()) {
                    String[] accountInfo = teller.readAccount();
                    account = new Account(accountInfo[0], accountInfo[1], accountInfo[2], accountInfo[3]);
                    account.withdrawMoney();
                    System.out.println("Your balance is: $"+account.getBalance());
                }else {
                    System.out.println("You dont have permission to check this account");
                }
                break;   
                
                // Quit the program
                case 5:
                    teller.sayQuitMessage();
                    break;
            }
            
        }
    }
}
