public class Patient extends Person {
    protected final String medicalRecordNumber;
    protected String bloodType;

    Patient (String id, String name, int age, String phone, String medicalRecordNumber, String bloodType){
        super(id, name, age, phone);
        if(medicalRecordNumber == null || !medicalRecordNumber.matches("MRN-\\d{6}")){
            throw new IllegalArgumentException("System Message : Medical Record Number Must Be Formatted As MRN-XXXXXX . . . ");
        }

    if (bloodType == null ||
    (!bloodType.equals("A+") &&
    !bloodType.equals("A-") &&
    !bloodType.equals("B+") &&
    !bloodType.equals("B-") &&
    !bloodType.equals("AB+") &&
    !bloodType.equals("AB-") &&
    !bloodType.equals("O+") &&
    !bloodType.equals("O-"))){
    throw new IllegalArgumentException("System Message : Invalid Blood Type . . .");
}
        this.medicalRecordNumber = medicalRecordNumber;
        this.bloodType = bloodType;
    }

    public double getDiscountRate(){
        if(this.age <= 12 || this.age >= 65){
            return 0.2;
        }else{
            return 0;
        }
    }
}
