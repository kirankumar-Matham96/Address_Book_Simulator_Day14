import java.util.Objects;

/**
 * POJO for contacts
 * POJO stands for "Plain Old Java Object" — it's a pure data structure that has fields
 * with getters and possibly setters, and may override some methods
 * from Object (e.g. equals) or some other interface like Serializable,
 * but does not have behavior of its own.
 */
public class Contacts {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String email;
    private int zip;
    private String phoneNumber;
    
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
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getZip() {
        return zip;
    }
    
    public void setZip(int zip) {
        this.zip = zip;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString()
    {
        return "Contact{" + "\n" + "FIRST_NAME = " + firstName + "\n"+ "LAST_NAME = " + lastName + "\n" + "ADDRESS = " + address + "\n"+ "CITY = " + city + "\n"+
                "STATE = " + state + "\n" + "EMAIL = " + email + "\n" +
                "ZIP = " + zip + "\n" + "PHONE_NUMBER = " + phoneNumber + "\n" + '}';
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Contacts contact = (Contacts) obj;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName,contact.lastName);
    }
}
