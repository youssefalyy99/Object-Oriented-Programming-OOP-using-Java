public class DeliveryOrderMain {
    public static void main(String[] args) {
        DigitalWallet JoeWallet = new DigitalWallet("123-456-789", "Youssef Aly", 1000);
        DigitalWallet NoMoneyWallet = new DigitalWallet("999-999-999", "Brad Bitt", 10);
        DeliveryOrder order1 = new DeliveryOrder("ORD123", "Youssef Aly", "123 La La Land Street", 3, 150.0, JoeWallet);
        
        // 1. Access important order information
        order1.ViewOrder();

        // 2. Modify information that is allowed to change
        
        order1.ChangeDeliveryAddress("123 Diagonal Alley Street");
        order1.ChangeUserName("Harry Potter");
        order1.ViewOrder();

        // 3. Pay for the order - The order should be paid only after successful payment
        JoeWallet.WalletInfo();
        order1.ConfirmPayment();
        JoeWallet.WalletInfo();
        order1.ViewOrder();

        // 4. Deliver the order
        order1.GetDeliveryStatues();
        order1.GetDeliveryStatues();


        // ======================= (Order - Payment) Information Section ======================= \\
        
        // 1. Item count must be valid
        // DeliveryOrder order2 = new DeliveryOrder("ORD124", "John Doe", "456 Spider-Man Street", -3, 150.0, JoeWallet);

        // 2. Subtotal cannot be negative
        // DeliveryOrder order2 = new DeliveryOrder("ORD124", "John Doe", "456 Spider-Man Street", 3, -150.0, JoeWallet);

        // 3. Successful payment changes the order to be paid.
        DeliveryOrder order3 = new DeliveryOrder("ORD125", "Jane Doe", "456 Spider-Man Street", 3, 150.0);
        order3.ViewOrder();
        order3.ConfirmPayment();
        order3.ViewOrder();

        // 4. A failed payment must leave the order unpaid.
        DeliveryOrder order4 = new DeliveryOrder("ORD126", "Brad Pitt", "456 Smith Street", 3, 150.0, NoMoneyWallet);
        order4.ConfirmPayment();
        order4.ViewOrder();

        // 5. An unpaid order cannot be delivered.
        order4.GetDeliveryStatues();
}
}