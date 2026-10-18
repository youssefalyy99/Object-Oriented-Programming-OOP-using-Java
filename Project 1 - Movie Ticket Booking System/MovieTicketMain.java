public class MovieTicketMain {
    public static void main(String[] args) {
        // Test 1 "MovieTicket"

        // 1. Normal Ticket
        MovieTicket tix = new MovieTicket("123ABC", "Pride And Prejudice", "Youssef Aly", "A1", 20.00);
        tix.GetTicketInfo();

        // 2. Ticket With Negative Price
        //MovieTicket tix1 = new MovieTicket("123ABC", "Pride And Prejudice", "Youssef Aly", "A1", -20.00);

        // 3. Ticket With Zero Price
        //MovieTicket tix2 = new MovieTicket("123ABC", "Pride And Prejudice", "Youssef Aly", "A1", 0);

        // 4. Ticket With A Valid Discount
        tix.ApplyDiscount(0.3);
        tix.GetTicketInfo();

        // 5. Ticket With Invalid Discount
        tix.ApplyDiscount(0.6);
        tix.GetTicketInfo();

        // 6. Valid Booking
        tix.BookTicket();
        tix.GetTicketInfo();

        // 7. Repeated Booking
        tix.BookTicket();

        // 8. Changing seats while booked
        tix.ChangeSeat("A2");
        tix.HoldTicket();
        tix.ChangeSeat("A2");
        tix.GetTicketInfo();

        // 9. Cancelling a booking
        tix.CancelBooking();
        tix.GetTicketInfo();

        // 10. Changing Seats While Cancelled
        tix.ChangeSeat("A3");
        tix.GetTicketInfo();
    }
}
