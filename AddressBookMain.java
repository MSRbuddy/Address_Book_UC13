import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressBookMain extends AddressBook
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Map<String, AddressBook> addressBookMap = new HashMap<>();

        while (true)
        {
            System.out.println("\nWelcome to Address Book System");
            System.out.println("1.New Address Book\n2.Select Address Book\n3.Delete Address Book\n4.Read data in file\n5.Write data in file\n6.Exit");
            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice)
            {
                case 1:
                    System.out.print("Enter Name of new Address Book: ");
                    String bookName = sc.next();
                    sc.nextLine();
                    addressBookMap.put(bookName, new AddressBook());
                    AddressBook.addressBookOptions(addressBookMap.get(bookName));
                    break;
                case 2:
                    System.out.println("List of available Address Book : ");
                    Set<String> keys = addressBookMap.keySet();
                    for (String key : keys)
                    {
                        System.out.println(key);
                    }
                    System.out.print("Enter Address Book Name: ");
                    String name = sc.nextLine();
                    System.out.println("Current Address Book is : " + name);
                    AddressBook.addressBookOptions(addressBookMap.get(name));
                    break;
                case 3:
                    System.out.print("Enter Address Book Name: ");
                    name = sc.nextLine();
                    addressBookMap.remove(name);
                    break;
                case 4 : FileIO fileIO = new FileIO();
                    fileIO.writeData(addressBookMap);
                    break;
                case 5 :
                    System.out.println(FileIO.readData());
                    break;
                case 6:
                    sc.close();
                    System.out.println("Thank You!!");
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}