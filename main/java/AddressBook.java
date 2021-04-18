import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    List<Contacts> contactList = new ArrayList<>();
    ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();
    
    @Override
    public String toString() {
        return "ContactManager{" + "contactList=" + contactList + '}';
    }
    
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
    
    /**
     * edits the contact details of selected name
     */
    public void editDetails() {
        String name = getName();
        if(isContactExist(name) == true) {
            Contacts contact = getContact(name);
            boolean isExit = false;
            while(!isExit) {
                System.out.println("Select option:" + "\n" + "1.first name" + "\n" + "2.last name" +
                                                      "\n" + "3.address" + "\n" + "4.city" + "\n" +
                                                      "5.state" + "\n" + "6.email" + "\n" + "7.zip" +
                                                      "\n" + "8.phone number" + "\n" + "9.exit");
                switch(scannerForAddressBook.scannerProvider().nextInt()) {
                    case 1:
                        System.out.println("Enter new first name to change: ");
                        contact.setFirstName(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    case 2:
                        System.out.println("Enter new last name to change: ");
                        contact.setLastName(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    case 3:
                        System.out.println("Enter new address to change: ");
                        contact.setAddress(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    case 4:
                        System.out.println("Enter new city to change: ");
                        contact.setCity(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    case 5:
                        System.out.println("Enter new state to change: ");
                        contact.setState(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    case 6:
                        System.out.println("Enter new email to change: ");
                        contact.setEmail(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    case 7:
                        System.out.println("Enter new zip to change: ");
                        contact.setZip(scannerForAddressBook.scannerProvider().nextInt());
                        break;
                    case 8:
                        System.out.println("Enter new phone number to change: ");
                        contact.setPhoneNumber(scannerForAddressBook.scannerProvider().nextLine());
                        break;
                    default:
                        System.out.println("Thank you!");
                        isExit = true;
                }
            }
        } else {
            System.out.println("Contact does not exists!");
        }
    }
    
    /**
     * to remove contact
     *
     * @param contact object of Contact class
     */
    public void deleteContact(Contacts contact) {
        contactList.remove(contact);
        System.out.println(contactList);
    }
    
    /**
     * asks the user for name and returns it
     *
     * @return
     */
    private String getName() {
        System.out.println("Enter contact name");
        return scannerForAddressBook.scannerProvider().nextLine();
    }
    
    /**
     * To find if contact exists or not
     *
     * @param name first or last name of the contact
     * @return true/false
     */
    private boolean isContactExist(String name) {
        boolean existance;
        existance = contactList.stream()
                               .anyMatch(personElement ->
                                         personElement.getFirstName().equals(name) ||
                                         personElement.getLastName().equals(name));
        return existance;
    }
    
    /**
     * To search the contact
     *
     * @param name first or last name of the contact
     * @return object of the Contact (Contact it self)
     */
    private Contacts getContact(String name) {
        Contacts foundContact = contactList.stream()
                                           .filter(contact ->
                                                   contact.getFirstName().equals(name) ||
                                                   contact.getLastName().equals(name))
                                           .findFirst().orElse(null);
        return foundContact;
    }
    
    /**
     * to access the book
     */
    public void accessAddressBook() {
        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select option: \n1.Add Contact\n2.Edit Contact\n" +
                                                "3.Delete Contact\n4.Exit");
            int option = scannerForAddressBook.scannerProvider().nextInt();
            switch(option) {
                case 1:
                    if(!isContactExist(getName())) {
                        addContact();
                    } else {
                        System.out.println("Contact already exists!");
                    }
                    break;
                case 2:
                    if(isContactExist(getName())) {
                        editDetails();
                    } else {
                        System.out.println("Contact does not exists!");
                    }
                    break;
                case 3:
                    String name = getName();
                    if(isContactExist(name)) {
                        Contacts contact = getContact(name);
                        deleteContact(contact);
                    } else {
                        System.out.println("Contact does not exists!");
                    }
                    break;
                default:
                    System.out.println("Thanks!");
                    isExit = true;
            }
        }
    }
}
