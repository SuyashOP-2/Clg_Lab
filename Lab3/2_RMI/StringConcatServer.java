import java.rmi.Remote; // Remote, To invoke from Not local method.
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;

// Define the remote interface
interface StringConcat extends Remote {
    String concatenate(String s1, String s2) throws RemoteException;
}
// Implement the server that uses the interface
public class StringConcatServer extends UnicastRemoteObject implements StringConcat {
    public StringConcatServer() throws RemoteException {
        super();
    }
    @Override
    public String concatenate(String s1, String s2) throws RemoteException {
        return s1 + s2;
    }

    public static void main(String[] args) {

        try {
            LocateRegistry.createRegistry(1099); // Start RMI registry on the default port 1099
            StringConcatServer server = new StringConcatServer();
            

            java.rmi.Naming.rebind("ConcatService", server);
            System.out.println("Service is bound and ready for use...");
        
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
