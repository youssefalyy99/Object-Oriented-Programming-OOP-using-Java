public class DigitalWalletMain {
    public static void main(String[] args) {
        DigitalWallet wal1 = new DigitalWallet("123-456-789", "Youssef Aly", 100);
        DigitalWallet wal2 = new DigitalWallet("987-654-321", "John Doe", 100);
        wal1.WalletInfo();

        // 1. Valid Deposit
        wal1.Deposit(120);
        wal1.WalletInfo();

        // 2. Invalid Deposit
        wal1.Deposit(-120);

        // 3. Valid Withdrawal
        wal1.Withdraw(20);
        wal1.WalletInfo();

        // 4. Invalid Withdrawal
        wal1.Withdraw(-20);

        // 5. Insufficient balance
        wal1.Withdraw(1000);
        
        // 6. Successful transfer
        wal1.transfer(wal2, 50);
        wal1.WalletInfo();
        wal2.WalletInfo();

        // 7. Failed transfer
        wal1.transfer(wal2, 1000);
        wal1.transfer(wal2,-1000);
        wal1.WalletInfo();
        wal2.WalletInfo();

        // 8. Transfer to null
        wal1.transfer(null, 50);
        
        // 9. Transfer to the same wallet
        wal1.transfer(wal1, 50);
    }
}
