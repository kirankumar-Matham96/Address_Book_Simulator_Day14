import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * main class
 */
public class AddressBookSimulator {
    Map<String, AddressBook> booksMap = new HashMap<>();
    Map<String, List<List<Contacts>>> cityPersonMap = new HashMap<>();
    Map<String, List<List<Contacts>>> statePersonMap = new HashMap<>();
    
    public static void main(String[] args) {
        ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();
        AddressBookSimulator addressBookSimulator = new AddressBookSimulator();
        
        System.out.println("Welcome to address book simulator!");
        
        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.Search contact by first/last name" +
                                               "\n4.Search contact by city/state\n5.Show the contacts by city" +
                                               "\n6.Show the contacts by state\n7.Exit");
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
                    System.out.println("Enter the city/state name to search contact");
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
                    System.out.println("Enter the city name to search contacts");
                    String city = scannerForAddressBook.scannerProvider().nextLine();
                    List<List<Contacts>> listOfCityContactsList = new ArrayList<>();
                    List<Contacts> cityContactList;
                    for(Map.Entry<String, AddressBook> entry : addressBookSimulator.booksMap.entrySet()) {
                        cityContactList = entry.getValue().getContactList().stream()
                                                          .filter(contact ->
                                                                  contact.getCity().equals(city))
                                                          .collect(Collectors.toList());
                        listOfCityContactsList.add(cityContactList);
                    }
                    addressBookSimulator.cityPersonMap.put(city,listOfCityContactsList);
                    System.out.println("from case 5: "+addressBookSimulator.cityPersonMap);
                    break;
                case 6:
                    System.out.println("Enter the state name to search contacts");
                    String state = scannerForAddressBook.scannerProvider().nextLine();
                    List<List<Contacts>> listOfStateContactsList = new ArrayList<>();
                    List<Contacts> satetContactList;
                    for(Map.Entry<String, AddressBook> entry : addressBookSimulator.booksMap.entrySet()) {
                        satetContactList = entry.getValue().getContactList().stream()
                                                           .filter(contact ->
                                                                   contact.getState().equals(state))
                                                           .collect(Collectors.toList());
                        listOfStateContactsList.add(satetContactList);
                    }
                    addressBookSimulator.statePersonMap.put(state,listOfStateContactsList);
                    System.out.println("from case 6: "+addressBookSimulator.statePersonMap);
                    break;
                default:
                    isExit = true;
                    System.out.println("Thanks for using Address Book Simulator!");
                    scannerForAddressBook.scannerProvider().close();//closing scanner
            }
        }
        System.out.println("city map: "+addressBookSimulator.cityPersonMap);
        System.out.println("state map: "+addressBookSimulator.statePersonMap);
    }
}
