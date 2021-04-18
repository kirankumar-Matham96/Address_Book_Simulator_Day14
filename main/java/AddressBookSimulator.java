import java.util.HashMap;
import java.util.Map;

/**
 * main class
 */
public class AddressBookSimulator {
    Map<String, AddressBook> booksMap = new HashMap<>();
    
    public static void main(String[] args) {
        ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();
        AddressBookSimulator addressBookSimulator = new AddressBookSimulator();
        
        System.out.println("Welcome to address book simulator!");
        
        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.Search contact by first/last name" +
                                               "\n4.Search contact by city/state\n5.Find number of contacts" +
                                               "\n6.Exit");
            int option = scannerForAddressBook.scannerProvider().nextInt();
            switch(option) {
                case 1:
                    System.out.println("Enter the name of new book");
                    String bookName = scannerForAddressBook.scannerProvider().nextLine();
                    addressBookSimulator.booksMap.put(bookName, new AddressBook());
                    break;
                case 2:
                    System.out.println("Enter the name of the book to access it");
                    Object bookName1 = scannerForAddressBook.scannerProvider().nextLine();
                    if(addressBookSimulator.booksMap.containsKey(bookName1)) {
                        AddressBook addressBook = addressBookSimulator.booksMap.get(bookName1);
                        addressBook.accessAddressBook();
                    }
                    break;
                case 3:
                    System.out.println("Enter the first/last name to search");
                    String contactName = scannerForAddressBook.scannerProvider().nextLine();
                    addressBookSimulator.booksMap.entrySet().forEach(entry -> {
                        System.out.println(entry.getKey());
                        System.out.println(entry.getValue().getContactList().stream()
                                .filter(contact -> contact.getFirstName().equals(contactName) ||
                                        contact.getLastName().equals(contactName))
                                .findFirst().orElse(null));
                    });
                    break;
                case 4:
                    System.out.println("Enter the city/state name to search");
                    String placeName = scannerForAddressBook.scannerProvider().nextLine();
                    addressBookSimulator.booksMap.entrySet().forEach(entry -> {
                        System.out.println(entry.getKey());
                        System.out.println(entry.getValue().getContactList().stream()
                                .filter(contact -> contact.getCity().equals(placeName) ||
                                        contact.getState().equals(placeName))
                                .findFirst().orElse(null));
                    });
                    break;
                case 5:
                    System.out.println("Enter the city/state name to search number of contacts");
                    String placeName2 = scannerForAddressBook.scannerProvider().nextLine();
                    addressBookSimulator.booksMap.entrySet().forEach(entry -> {
                        System.out.println(entry.getKey());
                        System.out.println("same cities or states: " + entry.getValue().getContactList().stream()
                                .filter(contact -> contact.getCity().equals(placeName2) ||
                                        contact.getState().equals(placeName2))
                                .count());
                    });
                    break;
                default:
                    isExit = true;
                    System.out.println("Thanks for using Address Book Simulator!");
                    scannerForAddressBook.scannerProvider().close();//closing scanner
            }
        }
    }
}
