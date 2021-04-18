public class AddressBook {
    public void addContact() {
        Contacts contact = new Contacts();
        
        contact.setFirstName("Vivek");
        contact.setLastName("Kolasani");
        contact.setAddress("Near home");
        contact.setCity("Hyderabad");
        contact.setState("TS");
        contact.setEmail("vivek.kolasani@gmail.com");
        contact.setZip(102563);
        contact.setPhoneNumber("785964231");
        System.out.println(contact);
    }
}
