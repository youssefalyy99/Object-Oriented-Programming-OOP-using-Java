public class DeliveryOrder {
    private String OrderID;
    private String CustomerName;
    private String DeliveryAddress;
    private String PaymentStatus;
    private String PaymentMethod;
    private int NumberOfItems;
    private double Subtotal;
    private DigitalWallet wallet;

    private boolean paid;
    private boolean delivered;

    // Orders Made by Cash
    public DeliveryOrder( String orderId , String customerName, String deliveryAddress, int itemCount, double subtotal){
        if(subtotal <= 0){ throw new IllegalArgumentException("System Message : Invalid SubTotal . . . "); }
        if(itemCount <= 0){ throw new IllegalArgumentException("System Message : Invalid Item Count . . . ");}
        this.OrderID = orderId;
        this.CustomerName = customerName;
        this.DeliveryAddress = deliveryAddress;
        this.NumberOfItems = itemCount;
        this.Subtotal = subtotal;
        this.PaymentMethod = "Cash";
        this.PaymentStatus = "Not Paid";
        this.paid = false;
        this.delivered = false;
    } 

    // Order Made By Wallet
    public DeliveryOrder( String orderId, String customerName, String deliveryAddress, int itemCount, double subtotal, DigitalWallet wallet){
        if(subtotal <= 0){ throw new IllegalArgumentException("System Message : Invalid SubTotal . . . "); }
        if(itemCount <= 0){ throw new IllegalArgumentException("System Message : Invalid Item Count . . . ");}
        this.OrderID = orderId;
        this.CustomerName = customerName;
        this.DeliveryAddress = deliveryAddress;
        this.NumberOfItems = itemCount;
        this.Subtotal = subtotal;
        this.PaymentMethod = "Wallet";
        this.PaymentStatus = "Not Paid";
        this.paid = false;
        this.delivered = false;
        this.wallet = wallet;
    }


    // Method 1 : View Order Important Details
    public void ViewOrder(){
        System.out.println("====== ORDER DETAILS ======");
        System.out.println("Order ID         : "+ this.OrderID);
        System.out.println("Customer Name    : "+ this.CustomerName);
        System.out.println("Delivery Address : "+ this.DeliveryAddress);
        System.out.println("Item Count       : "+ this.NumberOfItems);
        System.out.println("Payment Method   : "+ this.PaymentMethod);
        System.out.println("Order Statues    : "+ this.PaymentStatus);
        System.out.println("Subtotal         : "+ this.Subtotal);
        System.out.println("Delivery Fees    : "+ CalculateDeliveryCost(this.Subtotal));
        System.out.println("Total Fees       : "+ ( CalculateDeliveryCost(this.Subtotal) + this.Subtotal));
        System.out.println();
    }

    // Method 2 : Modify Things That Are Allowed To Change
    public void ChangeUserName(String name){
        this.CustomerName = name;
        return;
    }
    public void ChangeDeliveryAddress(String name){
        this.DeliveryAddress = name;
        return;
    }

    // Method 3 : Calculate delivery cost.
    private double CalculateDeliveryCost(double Subtotal){
        if( Subtotal < 500){
            return 50.0;
        }else if ( 500 <=  Subtotal &&  Subtotal <= 999.99){
            return 30.0;
        }else{
            return 10.0;
        }
    }

    // Method 4 : Corfirm Payment (Wallet / Cash)
    public void ConfirmPayment(){
        if(wallet != null){
            if(paid == false){
                if( wallet.Withdraw(this.Subtotal) ){
                    paid = true;
                    this.PaymentStatus = "Payment Done";
                    System.out.println("System Message : Order Was Paid Successfully By Wallet :) !");
                }
            }else{
                System.out.println("System Message : Order Was already Paid For . . .");
            }
        }else{
            paid = true;
            this.PaymentStatus = "Payment Done";
            System.out.println("System Message : Order Was Paid Successfully By Cash :) !");
        }
    }

    // Method 5 : Delivery Statues
    public void GetDeliveryStatues(){
        if(paid == true && delivered == false){
            delivered = true;
            System.out.println("System Message : Order Is Delivered :) !");
        }else if(delivered == true){
            System.out.println("System Message : Order Is Already Delivered :) !");
        }else{
            delivered = false;
            System.out.println("System Message : Order Is Not Delivered (Not Paid) . . .");
        }
    }
}