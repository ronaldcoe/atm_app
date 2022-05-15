public class Main {
    
    public static void main(String[] args) {
        Teller teller = new Teller();
        Account account;
        if (teller.checkPermission()) {
            String[] accountInfo = teller.readAccount();
            account = new Account(accountInfo[0], accountInfo[1], accountInfo[2], accountInfo[3]);
        }else {
            System.out.println("You dont have permission to check this account");
        }
        
    }
}
