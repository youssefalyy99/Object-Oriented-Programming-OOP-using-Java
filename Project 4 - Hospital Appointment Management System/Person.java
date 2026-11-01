import java.util.ArrayList;

public class Person {
    protected String name;
    protected final String id;
    protected String phone;
    protected int age;
    protected ArrayList<Integer> Schedule = new ArrayList<>(5);

    Person (String id, String name, int age, String phone){
        if(age > 100 || age < 0)
            {throw new IllegalArgumentException("System Message : Invalid Age (Range From 1 - 100) . . .");}
        if( phone.length() != 11 )
            {throw new IllegalArgumentException("System Message : Phone Number Must Be 11 - Characters. . .");}
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public void updatePersonalInfo(String name,int age,String phone){
        if(age > 100 || age < 0)
            {throw new IllegalArgumentException("System Message : Invalid Age (Range From 1 - 100) . . .");}
        if( phone.length() != 11 )
            {throw new IllegalArgumentException("System Message : Phone Number Must Be 11 - Characters. . .");}
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

}