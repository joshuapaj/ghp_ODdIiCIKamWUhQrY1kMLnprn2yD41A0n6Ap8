import java.util.Scanner;

public class PayrollLogin{
    String username="admin", password="1234"; //admin user&pass
    String username1="employee", password1="4321"; //employee user&pass
    int attempts = 3;
    int admin = 0;
    Scanner scan = new Scanner(System.in);


    PayrollSystem pSys = new PayrollSystem();
    public int UserLogin(){
    do{
    pSys.Title();
    System.out.print("Enter username: ");
    String user = scan.nextLine();
    System.out.print("Enter password: ");
    String pass = scan.nextLine();
    if (user.equals(username) && pass.equals(password)){
        System.out.print("\033[H\033[2J");
        System.out.println("Login Successful HR!");
        admin = 1;
        break;
    } else if (user.equals(username1) && pass.equals(password1)){
        System.out.print("\033[H\033[2J");
        System.out.println("Login Successful Employee!");
        admin = 0;
        break;
    }else{
        System.out.print("\033[H\033[2J");
        attempts--;
        System.out.println("Incorrect usename or password.");
        System.out.println("Attempts remaining: "+attempts);
        if (attempts == 0){
            System.out.println("Ran out of attempts");
            System.out.println("System will now exit");
            System.exit(0);
        }
    }
}while(attempts != 0);
    return admin;
    }
}