import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//using hashmap
public class OnlineReservationSys_OIBSIP{
    private Map<String, String> users; //for storing username and password
    private Map<String, String> reservations; // for reservation details
    
    public OnlineReservationSystem() {
        users = new HashMap<>();
        reservations = new HashMap<>();
    }
    
    public void run() {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
           
            System.out.println("**ONLINE RESERVATION SYSTEM**");
        
            System.out.println("Please Select" + "\n");
            System.out.println("1. Register ");
            System.out.println("2. Login ");
            System.out.println("3. Exit ");
     
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1:
                    register_user(sc);
                    break;
                case 2:
                    login(sc);
                    break;
                case 3:
                                                
                    System.out.println("\n" + "Exited");
                    return;
                default:
                   
                    System.out.println("\n" + "Invalid choice,Plz try again later");
                    break;
            }
            
            System.out.println();
        }
    }
    
    private void register_user(Scanner sc) {
  
        System.out.println("** REGISTRATION**");
    
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        
        if (users.containsKey(username)) {
            System.out.println("\n" + "Username already exists.");
            return;
        }
        
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        users.put(username, password);
        System.out.println("\n" + "Registration successful... You can now log in...");
    }
    
    private void login(Scanner sc) {
        
        System.out.println("Please LOGIN here <3");
        
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("\n" + "Login successful...");
            reservationMenu(sc, username);
        } else {
            System.out.println("\n" + "Invalid credentials...");
        }
    }
    
    private void reservationMenu(Scanner sc, String username) {
        while (true) {
           
            System.out.println("**HOME PAGE**");
       
            System.out.println("Please Select One Options" + "\n");
            System.out.println("1. Make a reservation");
            System.out.println("2. Cancel a reservation ");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    make_Reserv(sc, username);
                    break;
                case 2:
                    cancel_Reserv(sc, username);
                    break;
                case 3:
                   
                    System.out.println( "Logged OUT");
                    return;
                default:
                    
                    System.out.println("\n" + "Invalid choice. Try again.");
                    break;
            }
            
            System.out.println();
        }
    }
    
    private void make_Reserv(Scanner sc, String username) {
       
        System.out.print("Enter reservation Info: ");
        String reservationDetails = sc.nextLine();
        
        if (reservations.containsKey(username)) {
            System.out.println("\n" + "You already have a reservation. Cancel it first to make a new one...");
            return;
        }
        
        reservations.put(username, reservationDetails);
        System.out.println("Reservation alloted !Thank you!");
    }
    
    private void cancel_Reserv(Scanner sc, String username) {
        if (reservations.containsKey(username)) {
          
            System.out.println("Your current reservation: " + reservations.get(username));//getting username 
            System.out.print("Do you want to cancel this reservation? (Y/N): ");
            String confirmation = sc.nextLine();
            
            if (confirmation.equalsIgnoreCase("Y")) {//using equalsIsIgnoreCase for checking entered Y or N
                reservations.remove(username);
                System.out.println("\n" + "Reservation cancelled!");
            } else {
                System.out.println("\n" + "Reservation not cancelled");
            }
        } else {
            System.out.println("\n" + "You don't have any reservations");
        }
    }
    
    public static void main(String[] args) {
        OnlineReservationSys_OIBSIP oibsip = new OnlineReservationSys_OIBSIP();
        oibsip.run();
    }
}