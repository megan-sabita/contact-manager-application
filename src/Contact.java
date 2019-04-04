import java.util.*;
import java.nio.file.*;
import java.io.IOException;





public  class Contact {
    public static String directory = "data";
    public static String filename = "contact.txt";
    public static Path dataDirectory = Paths.get(directory);
    public static Path dataFile = Paths.get(directory, filename);
    public String name;
    public String phnNumber;

    public void showContact() {
int i=1;
        try {
            if (Files.notExists(dataDirectory)) {
                Files.createDirectories(dataDirectory);
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
            }
//
            List<String> lines = Files.readAllLines(dataFile);

            for (String line : lines) {
                System.out.format(" %6s %6s" ,"\n"+i,line);
                i++;
            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }



    public static void deleteContact() throws Exception {

        String directory = "data";
        String filename = "contact.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        List<String> lines = Files.readAllLines(dataFile);

        System.out.println("enter the id no you want to delete: ");

        Scanner scanner=new Scanner(System.in);

        int userInput=scanner.nextInt();
            lines.remove(userInput - 1);
            Files.write(Paths.get("data", "contact.txt"),lines);
    }


    public Contact(String directory, String filename) {
        this.directory = directory;
        this.filename=filename;
        this.name=name;
        this.phnNumber=phnNumber;

    }

    public static void addContact() throws Exception {




        String directory = "data";
        String filename = "contact.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);


       List<String> contactList = Files.readAllLines(Paths.get(directory, filename));
        System.out.println("enter your contact name and phn no: ");
        Scanner scanner=new Scanner(System.in);
        String contactInfo = scanner.nextLine();


        Files.write(
                Paths.get("data", "contact.txt"),
                Arrays.asList(contactInfo),
                StandardOpenOption.APPEND
        );

        System.out.format("  %-8s ","\n"+contactList.add(contactInfo));
        System.out.println("do you want to continue?");
        String userInput=scanner.nextLine();
        if(userInput.equalsIgnoreCase("y")|| userInput.equalsIgnoreCase("yes"));
        menu();


    }


    public String searchContact() throws Exception{
        String directory = "data";
        String filename = "contact.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        List<String> contactList = Files.readAllLines(Paths.get(directory, filename));
//        System.out.println("Enter a name.");
//
//        Scanner scanner = new Scanner(System.in);
//        String contactInfo = scanner.next();
//
//
//            if (contactList.contains(contactInfo)) {
//                System.out.println("here is what you searched for:" + contactInfo);
//            }

        int itemIndex = contactList.indexOf(contactList);
        if (itemIndex >= 0){
            return contactList.get(itemIndex);
        }
        return "not found";
        }



    public static void menu() {
        int userInput = 0;

        do {

            System.out.println("1: Show all your contacts\n" +
                    "2: Add a new contact\n" +
                    "3: Search a contact by their name\n" +
                    "4: Delete an existing contact\n" +
                    "5: Edit a contact\n" +
                    "0: Exit");
        }while (userInput != 0);
    }

    public static void main(String[] args) throws Exception {
       menu();
        Contact contact = new Contact("data","contact.txt");


        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a number between 1 to 5");
        int userInput = scanner.nextInt();
        if (userInput == 1) {
            contact.showContact();
            menu();
        }
        else if (userInput == 2) {
            contact.addContact();
            menu();
        }
        else if (userInput == 3) {

            searchContact();
            menu();
        }
        else if (userInput==4) {
//

            contact.deleteContact();
            contact.showContact();
            menu();
        }

        }


    }
