import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    List<Contacts> contactList = new ArrayList<>();
    ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();
    
    /**
     * method to add new contact from the console
     */
    public void addContact() {
        Contacts contacts = new Contacts();
        
        System.out.println("Enter first name");
        contacts.setFirstName(scannerForAddressBook.scannerProvider().nextLine());
        
        System.out.println("Enter last name");
        contacts.setLastName(scannerForAddressBook.scannerProvider().nextLine());
        
        System.out.println("Enter address");
        contacts.setAddress(scannerForAddressBook.scannerProvider().nextLine());
        
        System.out.println("Enter city");
        contacts.setCity(scannerForAddressBook.scannerProvider().nextLine());
        
        System.out.println("Enter state");
        contacts.setState(scannerForAddressBook.scannerProvider().nextLine());
        
        System.out.println("Enter email");
        contacts.setEmail(scannerForAddressBook.scannerProvider().nextLine());
        
        System.out.println("Enter zip");
        contacts.setZip(scannerForAddressBook.scannerProvider().nextInt());
        
        System.out.println("Enter phone number");
        contacts.setPhoneNumber(scannerForAddressBook.scannerProvider().nextLine());
        
        contactList.add(contacts);
    }
}
