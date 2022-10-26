import java.util.Scanner;

public class PayrollSystemMain{
    public static void main(String[] args){
    System.out.print("\033[H\033[2J");
    int loginAdmin = 0;
    int finished = 0;
    //objects
    Scanner scan = new Scanner(System.in);
    PayrollLogin login = new PayrollLogin();
    PayrollSystem pSys = new PayrollSystem();

    loginAdmin = login.UserLogin();
    
    do{
    pSys.Title();
    System.out.println("\n1.) Display Records\n2.) Compute Employee Wage\n3.) Exit");
    int userChoice1 = scan.nextInt();
    scan.nextLine();
    System.out.print("\033[H\033[2J");
    switch (userChoice1){
        case 1:{
    System.out.print("Display Records\n");
    pSys.printLabel(1);
    pSys.displayRecords();
    pSys.displayNewEmpRecords();
    if (loginAdmin == 1){
        System.out.println("\n\nChoose: \n1.) Update Record\n2.) Search Record\n3.) Add Record\n4.) Delete Record\n5.) Back\n");
    } else {
        System.out.println("\n\nChoose: \n1.) Search Record\n2.) Back\n");
    }
    System.out.print("\nChoice: ");
    int userChoice2 = scan.nextInt();
    System.out.print("\033[H\033[2J");
    scan.nextLine();
    System.out.print("\033[H\033[2J");
    if (loginAdmin == 1){
    switch(userChoice2){
        case 1: {
            pSys.UpdateRecord();
        }
        break;

        case 2:{
            pSys.SearchRecord();
        }
        break;

        case 3: {
            pSys.AddRecord();
        }
        break;

        case 4: {
            pSys.DeleteRecord();
        }
        break;

        default: {
            break;
        }
    }
} else {
    switch(userChoice2){
        case 1: {
            pSys.SearchRecord();
        }
        break;
        
        default: {
            break;
        }
    }
}
} 
break;

    case 2: {
        System.out.print("Compute Employee Wage\n");
        System.out.println("\n\nChoose: \n1.) Enter an ID\n2.) Compute All Wages\n3.) Back\n");
        System.out.print("\nChoice: ");
        int userChoice2 = scan.nextInt();
        scan.nextLine();
        System.out.print("\033[H\033[2J");
        switch(userChoice2){
            case 1: {
                pSys.SolveSingleWage();
            }
            break;

            case 2:{
                pSys.SolveAllWage();
            }
            break;

            default:{
                break;
            }
        }
        break;  
    }
    default :{
        finished = 1;
        break;
    }
}
}while(finished == 0);
System.out.print("\033[H\033[2J");
pSys.Title();
System.out.println("\nThank you for using the system!");
System.out.println("System willl now exit...");
System.exit(0);
    }
}