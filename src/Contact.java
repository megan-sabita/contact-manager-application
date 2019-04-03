import java.util.*;
import java.nio.file.*;
import java.io.IOException;




public  class Contact {
   public  String directory = "data";
  public  String filename = "contact.txt";
   public  Path dataDirectory = Paths.get(directory);
    public Path dataFile = Paths.get(directory, filename);

    public  void showContact() {

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
                System.out.print(line);
            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println("finished");
    }



    public static void addContact() throws Exception{
//        String directory = "data";
//        String filename = "contact.txt";
//        Path dataDirectory = Paths.get(directory);
//        Path dataFile = Paths.get(directory, filename);
        Files.write(
                    Paths.get("data", "contact.txt"),
                    Arrays.asList("megan-12345678", "sabita-459734686","XYZ-11223344"),
                    StandardOpenOption.APPEND
            );
//        Contact.showContact();

    }

    public static void deleteContact() throws Exception{



    }


    public static void main(String[] args) throws Exception{
        Contact contact = new Contact();
//        List<String> contacts = new ArrayList<>();
        contact.showContact();
        contact.addContact();
        contact.showContact();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a number between 1 to 5");
        int userInput = scanner.nextInt();
//        if (userInput == 1) {


            contact.showContact();
////            if(userInput==2){
////
////                Contact.addContact();
//////
//            }

        }
    }

//}

