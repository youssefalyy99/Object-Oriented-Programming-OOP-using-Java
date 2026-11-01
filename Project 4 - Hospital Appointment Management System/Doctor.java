public class Doctor extends Person {
    protected String specialty;
    protected Double consultationFee;

    Doctor (String id, String name, int age, String phone, String specialty, double consultationFee){
        super(id, name, age, phone);
        if(this.age < 25){
            throw new IllegalArgumentException("System Message : Doctors Must Be +25 Of Age . . . ");
        }
        if(specialty == null){
            throw new IllegalArgumentException("System Message : Specialty Cannot Be Null . . . ");
        }
        if( consultationFee < 0 || consultationFee > 10000 ){
            throw new IllegalArgumentException("System Message : Invalid Consultation Fee ( Range Between 0 - 10,000 ). . . ");
        }
        this.specialty = specialty;
        this.consultationFee = consultationFee;
    }

    public void updateProfessionalInfo(String specialty, double fee){
        if(specialty == null){
            throw new IllegalArgumentException("System Message : Specialty Cannot Be Null . . . ");
        }
        if(fee < 0 || fee > 10000 ){
            throw new IllegalArgumentException("System Message : Invalid Consultation Fee ( Range Between 0 - 10,000 ). . . ");
        }

        this.specialty = specialty;
        this.consultationFee = fee;
    }
    
}
