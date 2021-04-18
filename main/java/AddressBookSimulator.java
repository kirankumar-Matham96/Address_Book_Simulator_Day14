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
            System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.Exit");
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
                default:
                    isExit = true;
                    System.out.println("Thanks for using Address Book Simulator!");
                    scannerForAddressBook.scannerProvider().close();//closing scanner
            }
        }
    }
}
