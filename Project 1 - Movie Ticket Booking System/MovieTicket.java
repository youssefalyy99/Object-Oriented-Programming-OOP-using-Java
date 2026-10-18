public class MovieTicket {
    private String TicketID;
    private String MovieName;
    private String CustomerName;
    private String SeatNumber;
    private double TicketPrice;
    private String BookingStatus;
    private double DiscountPercentage;

    private double BookingFee;

    // Constructor
    public MovieTicket(String ticketId, String movieName, String customerName, String seatNumber, double price){
        
        if(price <= 0){
            // A ticket with a price of 0 cannot be created.
            throw new IllegalArgumentException("System Message : Invalid Price Entered . . . ");
        }

        this.TicketID = ticketId;
        this.SeatNumber = seatNumber; 
        this.CustomerName = customerName;
        this.MovieName = movieName;
        this.TicketPrice = price;

        // Default Defintions
        this.DiscountPercentage = 0.0; //Start with 0% discount
        this.BookingFee = 0.0; //Start with 0% discount
        this.BookingStatus = "Not Booked"; // Start as not booked.
    }

    public void GetTicketInfo(){
        System.out.println("======= TICKET INFO =======");
        System.out.println("Ticket ID :           " +this.TicketID);
        System.out.println("Customer Name :       " +this.CustomerName);
        System.out.println("Movie Name :          " +this.MovieName);
        System.out.println("Seat Number :         " +this.SeatNumber);
        System.out.println("Booking Status :      " +this.BookingStatus);
        System.out.println("======= BILLING INFO =======");
        System.out.println("Ticket Price :        " +this.TicketPrice);
        System.out.println("Discount Percentage : " +this.DiscountPercentage);
        System.out.println("Price After Discount :" +(this.TicketPrice + (this.TicketPrice*this.DiscountPercentage)));
        System.out.println("Booking Fee :         " +this.BookingFee);
        System.out.println("Total Fee :           " +((this.TicketPrice + (this.TicketPrice*this.DiscountPercentage)) + this.BookingFee));
        System.out.println();
        return;
    }

    public void BookTicket(){
        if(this.BookingStatus != "Booked"){
            this.BookingStatus = "Booked";
            //  A booked ticket receives a 10% booking fee.
            this.BookingFee = this.TicketPrice * 0.1;
            System.out.println("SYSTEM MESSAGE : Ticked Booked Successfully");
        }else{
            System.out.println("SYSTEM MESSAGE : Ticket Already Booked . . .");
        }
        return;
    }

    public void CancelBooking(){
        this.BookingStatus = "Cancelled";
        this.BookingFee = 0.0;
        return;
    }

    public void HoldTicket(){
        this.BookingStatus = "On Hold";
        this.BookingFee = 0.0;
        return;
    }

    public void ApplyDiscount(double DiscPct){
        //The discount percentage must be valid and must be applied before the booking fee.
        if(DiscPct < 0 || DiscPct > 0.5 ){
            System.out.println("SYSTEM MESSAGE : Invalid Discount Percentage . . .");
            System.out.println("SYSTEM MESSAGE : Discount Percentage Lies Between 0% And 50% . . .");
        }else{
            this.DiscountPercentage = DiscPct;
        }
        return;
    }

    public void ChangeSeat(String Seat){
        if (this.BookingStatus == "Booked" || this.BookingStatus == "Cancelled"){
            // A booked ticket cannot change its seat
            System.out.println("SYSTEM MESSAGE : Booked/Cancelled Tickets Cannot Change Seats . . .");
            return;
        }else{
            this.SeatNumber = Seat;
            System.out.println("SYSTEM MESSAGE : Seat Changed Successfully");
            return;
        }
    }
}
