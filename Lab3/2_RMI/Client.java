import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;  // Import the Scanner class to read input

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object for input

        try {
            // Get the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote object
            StringConcat stub = (StringConcat) registry.lookup("ConcatService");

            // Prompt user for input
            System.out.println("Enter first string:");
            String s1 = scanner.nextLine();  // Read user input for the first string

            System.out.println("Enter second string:");
            String s2 = scanner.nextLine();  // Read user input for the second string

            // Call the remote method
            String response = stub.concatenate(s1, s2);
            System.out.println("Concatenated string: " + response);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
         finally {
            scanner.close();  // Close the scanner
        }
    }
}



/*
 * Interface defn
 * Stub & Skeleton
 * Serialization
 * Client Server TCP
 * Security
 * Remote Exception
 */