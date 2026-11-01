public class Main {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("       HOSPITAL SYSTEM TESTING");
        System.out.println("======================================");

        testPersonAndDoctor();
        testPatient();
        testAppointmentValidation();
        testSuccessfulBooking();
        testDoctorConflict();
        testPatientConflict();
        testDoctorFullSchedule();
        testPatientFullSchedule();
        testCancellation();

        System.out.println("\n======================================");
        System.out.println("       TESTING COMPLETED");
        System.out.println("======================================");
    }

    // ==========================================
    // 1. PERSON AND DOCTOR TESTS
    // ==========================================

    public static void testPersonAndDoctor() {

        System.out.println("\n========== PERSON & DOCTOR TESTS ==========");

        Doctor doc = new Doctor(
            "D001", "Ahmed", 35, "01234567890",
            "Cardiology", 500
        );

        System.out.println("Doctor Created Successfully");

        doc.updatePersonalInfo("Ahmed Ali", 36, "01123456789");
        doc.updateProfessionalInfo("Neurology", 700);

        System.out.println("Personal Information Updated");
        System.out.println("Professional Information Updated");

        System.out.println("New Name: " + doc.name);
        System.out.println("New Specialty: " + doc.specialty);
        System.out.println("New Fee: " + doc.consultationFee);

        try {
            new Doctor("D002", "Test", 20, "01234567890",
                       "Surgery", 500);
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Doctor age validation");
        }

        try {
            doc.updateProfessionalInfo("Surgery", 15000);
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Consultation fee validation");
        }
    }

    // ==========================================
    // 2. PATIENT TESTS
    // ==========================================

    public static void testPatient() {

        System.out.println("\n========== PATIENT TESTS ==========");

        Patient p1 = new Patient(
            "P001", "Youssef", 20, "01234567890",
            "MRN-123456", "A+"
        );

        Patient child = new Patient(
            "P002", "Ali", 10, "01123456789",
            "MRN-654321", "O+"
        );

        Patient senior = new Patient(
            "P003", "Hassan", 70, "01012345678",
            "MRN-111111", "B-"
        );

        System.out.println("Patient Created Successfully");

        System.out.println("Normal Patient Discount: " +
                           p1.getDiscountRate() * 100 + "%");

        System.out.println("Child Discount: " +
                           child.getDiscountRate() * 100 + "%");

        System.out.println("Senior Discount: " +
                           senior.getDiscountRate() * 100 + "%");

        try {
            new Patient("P004", "Test", 30, "01234567890",
                        "INVALID", "A+");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Medical record validation");
        }

        try {
            new Patient("P005", "Test", 30, "01234567890",
                        "MRN-123456", "INVALID");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Blood type validation");
        }
    }

    // ==========================================
    // 3. APPOINTMENT VALIDATION TESTS
    // ==========================================

    public static void testAppointmentValidation() {

        System.out.println("\n========== APPOINTMENT VALIDATION ==========");

        Doctor doc = new Doctor(
            "D010", "Doctor", 40, "01234567890",
            "Surgery", 500
        );

        Patient pat = new Patient(
            "P010", "Patient", 30, "01123456789",
            "MRN-222222", "AB+"
        );

        try {
            new Appointment(doc, pat, 32, 9, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Invalid day");
        }

        try {
            new Appointment(doc, pat, 10, 9, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Invalid minute interval");
        }

        try {
            new Appointment(doc, pat, 10, 17, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Invalid hour");
        }

        try {
            new Appointment(null, pat, 10, 9, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Null doctor");
        }

        try {
            new Appointment(doc, null, 10, 9, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Null patient");
        }
    }

    // ==========================================
    // 4. SUCCESSFUL BOOKING
    // ==========================================

    public static void testSuccessfulBooking() {

        System.out.println("\n========== SUCCESSFUL BOOKING ==========");

        Doctor doc = new Doctor(
            "D020", "Doctor", 40, "01234567890",
            "Cardiology", 500
        );

        Patient pat = new Patient(
            "P020", "Patient", 30, "01123456789",
            "MRN-333333", "A+"
        );

        Appointment apt = new Appointment(doc, pat, 5, 9, 0);

        boolean result = apt.book();

        System.out.println("Booking Result: " + result);
        System.out.println("Doctor Schedule Size: " + doc.Schedule.size());
        System.out.println("Patient Schedule Size: " + pat.Schedule.size());

        apt.getAppointmentDetails();

        System.out.println("Trying to book the same appointment again:");
        System.out.println("Result: " + apt.book());
    }

    // ==========================================
    // 5. DOCTOR CONFLICT
    // ==========================================

    public static void testDoctorConflict() {

        System.out.println("\n========== DOCTOR CONFLICT TEST ==========");

        Doctor doc = new Doctor(
            "D030", "Doctor", 40, "01234567890",
            "Cardiology", 500
        );

        Patient p1 = new Patient(
            "P030", "Patient 1", 30, "01123456789",
            "MRN-444444", "A+"
        );

        Patient p2 = new Patient(
            "P031", "Patient 2", 25, "01012345678",
            "MRN-555555", "O+"
        );

        Appointment apt1 = new Appointment(doc, p1, 5, 9, 0);
        Appointment apt2 = new Appointment(doc, p2, 5, 9, 15);

        System.out.println("First Booking: " + apt1.book());
        System.out.println("Second Booking: " + apt2.book());
    }

    // ==========================================
    // 6. PATIENT CONFLICT
    // ==========================================

    public static void testPatientConflict() {

        System.out.println("\n========== PATIENT CONFLICT TEST ==========");

        Doctor d1 = new Doctor(
            "D040", "Doctor 1", 40, "01234567890",
            "Cardiology", 500
        );

        Doctor d2 = new Doctor(
            "D041", "Doctor 2", 45, "01123456789",
            "Neurology", 600
        );

        Patient pat = new Patient(
            "P040", "Patient", 30, "01012345678",
            "MRN-666666", "B+"
        );

        Appointment apt1 = new Appointment(d1, pat, 5, 10, 0);
        Appointment apt2 = new Appointment(d2, pat, 5, 10, 15);

        System.out.println("First Booking: " + apt1.book());
        System.out.println("Second Booking: " + apt2.book());
    }

    // ==========================================
    // 7. DOCTOR FULL SCHEDULE
    // ==========================================

    public static void testDoctorFullSchedule() {

        System.out.println("\n========== DOCTOR FULL SCHEDULE ==========");

        Doctor doc = new Doctor(
            "D050", "Doctor", 40, "01234567890",
            "Surgery", 500
        );

        for (int i = 0; i < 6; i++) {

            Patient pat = new Patient(
                "P05" + i, "Patient", 30, "01123456789",
                "MRN-12345" + i, "A+"
            );

            Appointment apt = new Appointment(
                doc, pat, 5, 9 + i / 2, (i % 2) * 30
            );

            System.out.println("Appointment " + (i + 1) +
                               ": " + apt.book());
        }

        System.out.println("Doctor Schedule Size: " + doc.Schedule.size());
    }

    // ==========================================
    // 8. PATIENT FULL SCHEDULE
    // ==========================================

    public static void testPatientFullSchedule() {

        System.out.println("\n========== PATIENT FULL SCHEDULE ==========");

        Patient pat = new Patient(
            "P060", "Patient", 30, "01234567890",
            "MRN-777777", "AB-"
        );

        for (int i = 0; i < 6; i++) {

            Doctor doc = new Doctor(
                "D06" + i, "Doctor", 40, "01123456789",
                "Surgery", 500
            );

            Appointment apt = new Appointment(
                doc, pat, 5, 9 + i / 2, (i % 2) * 30
            );

            System.out.println("Appointment " + (i + 1) +
                               ": " + apt.book());
        }

        System.out.println("Patient Schedule Size: " + pat.Schedule.size());
    }

    // ==========================================
    // 9. CANCELLATION
    // ==========================================

    public static void testCancellation() {

        System.out.println("\n========== CANCELLATION TESTS ==========");

        Doctor doc = new Doctor(
            "D070", "Doctor", 40, "01234567890",
            "Cardiology", 500
        );

        Patient pat = new Patient(
            "P070", "Patient", 30, "01123456789",
            "MRN-888888", "O-"
        );

        Appointment apt = new Appointment(doc, pat, 5, 12, 0);

        System.out.println("Booking: " + apt.book());

        System.out.println("Doctor Schedule Before Cancellation: " +
                           doc.Schedule.size());

        System.out.println("Patient Schedule Before Cancellation: " +
                           pat.Schedule.size());

        System.out.println("Cancellation: " + apt.cancel());

        System.out.println("Doctor Schedule After Cancellation: " +
                           doc.Schedule.size());

        System.out.println("Patient Schedule After Cancellation: " +
                           pat.Schedule.size());

        System.out.println("Trying to cancel again: " + apt.cancel());
        System.out.println("Trying to book again: " + apt.book());

        Appointment newApt = new Appointment(doc, pat, 5, 14, 0);

        System.out.println("Cancelling a New Appointment: " +
                           newApt.cancel());
    }
}
