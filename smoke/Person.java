package Assignments;

public class Person {
    String firstName;
    String lastName;
    char gender;
    String maritalStatus;
    static int totalPersons = 0;

    // Below is the Default constructor
    public Person() {
        
    }

    // Below is the Parameterized constructor
    public Person(String firstName, String lastName, char gender, String maritalStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    // Below are Getter and Setter methods 
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    
    
}