import java.util.*;
import java.nio.file.*;
import java.io.IOException;





public  class Contact {
    public String directory = "data";
    public String filename = "contact.txt";
    public Path dataDirectory = Paths.get(directory);
    public Path dataFile = Paths.get(directory, filename);

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
        String contactName;
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
//        List<String> contactList = Files.readAllLines(Paths.get(directory, filename));
        List<String> lines = Files.readAllLines(dataFile);
        System.out.println("enter the id no you want to delete: ");
        Scanner scanner=new Scanner(System.in);
        int userInput=scanner.nextInt();
        for(int i=0;i<lines.size();i++) {
            if(lines.contains(userInput)) {
                lines.remove(userInput - 1);
            }else{
                System.out.println("we don't have this id number");
            }

        }

        Files.write(Paths.get("data", "contact.txt"),lines);

    }


    public Contact(String directory, String filename) {
        this.directory = directory;
        this.filename=filename;

    }

    public static void addContact() throws Exception {
        String directory = "data";
        String filename = "contact.txt";
        String contactName;
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
       List<String> contactList = Files.readAllLines(Paths.get(directory, filename));
        System.out.println("enter your contact name and phn no: ");
        Scanner scanner=new Scanner(System.in);
        String contactInfo = scanner.nextLine();




        Files.write(
                Paths.get("data", "contact.txt"),
                Arrays.asList( contactInfo),
                StandardOpenOption.APPEND
        );

        System.out.format("  %-8s ","\n"+contactList.add(contactInfo));
//        Contact.showContact();

    }


    public static void main(String[] args) throws Exception {
        System.out.println("1: Show all your contacts\n" +
                "2: Add a new contact\n" +
                "3: Search a contact by their name\n" +
                "4: Delete an existing contact\n" +
                "5: Edit a contact\n" +
                "0: Exit");
        Contact contact = new Contact("data","contact.txt");


        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a number between 1 to 5");
        int userInput = scanner.nextInt();
        if (userInput == 1) {


            contact.showContact();
        }
            else if (userInput == 2) {

                Contact contacts = new Contact("data","contact.txt");
                Contact.addContact();
            Contact contacts1 = new Contact("data","contact.txt");
                contacts1.showContact();

            }
            else if(userInput==4){
            Contact contacts1 = new Contact("data","contact.txt");
                Contact.deleteContact();
                contact.showContact();
        }

        }


    }
