import java.util.*;
//first module to display a registration window
class Registration_Window{
    static void register(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your name : ");
        atm_interface_OIBSIP.name=sc.nextLine();
        System.out.print("Enter username : ");
        atm_interface_OIBSIP.user=sc.nextLine();
        while(true){
            System.out.print("Enter password : ");
            atm_interface_OIBSIP.pass=sc.nextLine();
            System.out.print("Verify password : ");
            String reenter=sc.nextLine();
            if(reenter.equals(atm_interface_OIBSIP.pass)){
                System.out.println("Password matched<3 You good to go.");
                break;
            }
            else{
                System.out.println("Password Mismatched ..Try again later");
            }
        }
        System.out.print("Enter your Account number : ");
        atm_interface_OIBSIP.accnumber=sc.nextLine();
        System.out.println("\n" + "REGISTRATION SUCCESSFULL");
       
        atm_interface_OIBSIP.prompt();
    }
}
//second module login window
class Login_Window{
    static void login(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your username : ");
        String loguser=sc.nextLine();
        System.out.print("Enter your password : ");
        String logpass=sc.nextLine();
        System.out.print("Enter your Account number : ");
        String logacn=sc.nextLine();
        if(loguser.equals(atm_interface_OIBSIP.user) && logpass.equals(atm_interface_OIBSIP.pass) && logacn.equals(atm_interface_OIBSIP.accnumber)){
            System.out.println("\n" + "LOGIN SUCCESSFULLY...!");
            }
        else{
            System.out.println("\n" + "Incurrect details...! Please try again...");
            atm_interface_OIBSIP.login();
        }
    }
}
//main class here showed are option about logins and regsitrations
public class atm_interface_OIBSIP{
    public static String name;
    public static String user;
    public static String pass;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();
    public static int balance = 57000, withdraw, deposit, transfer;
    public static String receiver, acnum;
        
    public static void register(){
       
        Scanner sc=new Scanner(System.in);
        System.out.println("**HELLO**");
        System.out.println("Plz Register yourself here ");
        System.out.println("***********");
        System.out.println("Select Option :");
        System.out.println(" 1  Register");
        System.out.println(" 2  Exit");
        System.out.println("***********");
        System.out.print("Enter option: ");
        int choice =sc.nextInt();
        if (choice==1){
                Registration_Window.register();
        }
        else {
            if(choice==2){
                System.out.println("\n" + " Transactions Succesfull....");
                System.exit(0);
            }
            else{
                System.out.println("\n" + "Select a Valid Option !");
                register();
            }
        }
    }
    
    public static void login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("***********");
        System.out.println("HELOO");
        System.out.println("**LOGIN**");
        System.out.println("***********");
        System.out.println("Select Option :");
        System.out.println(" 1  Login");
        System.out.println(" 2  Exit");
        System.out.println("***********");
        System.out.print("Enter option: ");
        int choice =sc.nextInt();
        if (choice==1){
                Login_Window.login();
        }
        else {
            if(choice==2){
                System.out.println("\n" + "Transactions Succesfull");
                System.exit(0);
            }
            else{
                System.out.println("\n" + "Select a value only from the given options...!");
                login();
            }
        }
    }
    
    public static void transaction(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n" + "Transaction History  ");
        int k=0;
        if(atm_interface_OIBSIP.balance>0)
        {
            for(int i=0;i<(atm_interface_OIBSIP.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(atm_interface_OIBSIP.history.get(k)+" ");
                    k++;
                }
                System.out.println("/-");
            }
            System.out.println();
        }
        else {
            System.out.println("Your account is empty.!!!");
            System.out.println();
        }        
    }
    
    public static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.print("\n" + "Enter money to be withdrawn: ");
        withdraw = sc.nextInt();
        if (atm_interface_OIBSIP.balance >= withdraw)
        {
        	atm_interface_OIBSIP.balance = atm_interface_OIBSIP.balance - withdraw;
            System.out.println("\n" + "Transaction Successful<3");
            atm_interface_OIBSIP.history.add("Withdrawn:  Rs.");
            atm_interface_OIBSIP.history.add(Integer.toString(withdraw));
            System.out.println("Amount Rs." + withdraw + "withdrawed successfully");
            System.out.println("Please collect your money...");
        }
        else
        {
            System.out.println("\n" + "Insufficient Balance:(");
        }
        System.out.println();
    }
    
    public static void deposite(){
        Scanner sc=new Scanner(System.in);
        System.out.print("\n" + "Enter Amount to deposite: ");
        deposit = sc.nextInt();
        atm_interface_OIBSIP.balance = atm_interface_OIBSIP.balance + deposit;
        atm_interface_OIBSIP.history.add("Deposited:  Rs.");
        atm_interface_OIBSIP.history.add(Integer.toString(deposit));
        System.out.println("\n" + "Amount Rs." + deposit + "deposit successful!");
        System.out.println("Your money has been successfully deposited.");
        System.out.println();
    }
    
    public static void transfer_money(){
        Scanner sc=new Scanner(System.in);
        System.out.print("\n" + "Enter the username of the receiving body: ");
        receiver=sc.next();
        System.out.print("Enter the account number of the receiving body: ");
        acnum=sc.next();
        System.out.print("Enter the amount to be transferred: ");
        transfer=sc.nextInt();
        if(transfer<=atm_interface_OIBSIP.balance){
        	atm_interface_OIBSIP.balance = atm_interface_OIBSIP.balance - transfer;
            System.out.println("\n" + "Transaction Successful...!!!");
            atm_interface_OIBSIP.history.add("Transferred:  Rs.");
            atm_interface_OIBSIP.history.add(Integer.toString(transfer));
            System.out.println("Amount Rs." + transfer + " transferred successfull");
        }
        else{
            System.out.println("\n" + "Insufficient balance ");
        }
        System.out.println();
    }
    
    static void prompt(){
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            
            System.out.println("ATM Machine for OASIS,\nHey, Welcome "+atm_interface_OIBSIP.name+"!");
           
            System.out.println(" 1 Check Balance.");
            System.out.println(" 2 Withdraw Money.");
            System.out.println(" 3 Diposit Money.");
            System.out.println(" 4 Transfer Money.");
            System.out.println(" 5 Transaction History.");
            System.out.println(" 6 Exit.");
            System.out.println("");
            System.out.print("Please choose the option ");
            try
            {
                int n = sc.nextInt();
                switch(n)
                {
                    case 1:
                        System.out.println("\n" + "Total available balance: " + balance);
                        System.out.println();
                        break; 
    
                        
                    case 2:
                        withdraw();
                        break;
    
                    case 3:
                        deposite();
                        break;
    
                    case 4:
                        transfer_money();
                        break;
                        
                    case 5:
                    	transaction();
                        break;
                    case 6:
                        login();
                        break;
    
                    default:
                        System.out.println("\n" + "Hey,invalid choice ..plz try again later");
                        System.out.println();
                        break;
                }
            }
            catch(InputMismatchException e)
            {
                System.err.println("\n" + "Invalid choice.!");
                prompt();
            }
        }
    }

    public static void main(String[] args) {
        register();
    }
}