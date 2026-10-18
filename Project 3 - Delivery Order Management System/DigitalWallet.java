public class DigitalWallet {
    private String walletID;
    private String OwnerName;
    private double balance;
    private int TransactionCount = 0;

    public  DigitalWallet(String walletId, String ownerName, double balance){
        if(balance <= 0){
            // Checking Invalid Balance
            throw new IllegalArgumentException("System Message : Invalid SubTotal . . . ");
        }else{
            this.balance = balance;
        }
        this.OwnerName = ownerName;
        this.walletID = walletId;
    }

    public void WalletInfo(){
        // Printing Wallet Info
        System.out.println("===== WALLET INFO =====");
        System.out.println("Wallet ID          : "+ walletID);
        System.out.println("Owner Name         : "+ OwnerName);
        System.out.println("Total Balance      : "+ balance);
        System.out.println("Total Transactions : "+ TransactionCount);
        System.out.println();
    }

    public void ChangeUserName(String name){
        this.OwnerName = name;
        return;
    }

    public void ChangeID(String id){
        this.walletID = id;
        return;
    }

    private double calculateTransactionFee(double amount){
        // No Problems With This Function
        if(amount < 500){
            return 5.0;
        }else if ( 500 <= amount && amount <= 999.99){
            return 10.0;
        }else{
            return 15.0;
        }
    }

    public void Deposit(double num){
        // If The Value Entered is Less Than Zero Rejected, Accepted and Taken Out the Fee if True
        if(num <= 0){
            System.out.println("System Message : Invalid Balance Entered . . . ");
        }else{
            TransactionCount++;
            this.balance = this.balance + num - calculateTransactionFee(num);
            System.out.println("System Message : Amount Was Added Successfully :) ! ");
        }
    }

    public boolean Withdraw(double num){
        if(num <= 0){
            // If Invalid Value Entered
            System.out.println("System Message : Invalid Balance Entered . . . ");
            return false;
        }else if ((this.balance - num - calculateTransactionFee(num)) < 0){
            // Making Sure if covers all fees
            System.out.println("System Message : Insufficient balance, Withdraw Invalid . . . ");
            return false;
        }
        else{
            TransactionCount++;
            this.balance = this.balance - num - calculateTransactionFee(num);
            System.out.println("System Message : Amount Was Withdrawn Successfully :) !");
            return true;
        }
    }


    public void transfer(DigitalWallet x,double num){
        if (num <= 0) {
            System.out.println("System Message : Invalid Balance Entered . . . ");
            return;
        }else if(x == null || x.walletID == this.walletID ){
            System.out.println("System Message : Invalid Receiver Wallet . . . ");
        }else if( (this.balance + calculateTransactionFee(num)) < num ){
            System.out.println("System Message : Insufficient balance, Transfer Invalid . . . ");
            return;
        }else{
            x.balance = x.balance + num;
            x.TransactionCount++;
            this.balance = this.balance - num - calculateTransactionFee(num) ;
            this.TransactionCount++;
            System.out.println("System Message : Transfer Was Successful :) !");
            return;
        }
    }
}
