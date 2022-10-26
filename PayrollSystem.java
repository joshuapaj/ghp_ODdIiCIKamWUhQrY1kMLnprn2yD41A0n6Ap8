import java.util.Scanner;

public class PayrollSystem{
    Scanner scan = new Scanner(System.in);
    String label[] = {"ID", "First Name", "Last Name", "Position", "Service Length", "Rate/Day", "Days Worked", "Deductions", "Gross", "Monthly"};
    String empProfile[][] = {
        {"001", "002", "003"}, //ID
        {"Ahri", "Brown", "Cardio"}, //First Name
        {"Fox", "Man", "Exercise"}, //Last Name
        {"Manager", "Employee", "Manager"}, //Position
        {"3", "4", "2"}, //Length of Service (in days)
        {"300", "400", "500"}, //Rate/Day
        {"4", "3", "2"},  //Days Worked
        {"10", "300", "50"},  //Deductions
    };
    String newEmpProfile[][] = new String[8][10];
    int newEmpCount = 0;

    public void AddRecord(){
    int finished = 0, noNumber = 0;
    do{
    System.out.print("\033[H\033[2J");
    System.out.println("Add Record\n");
    System.out.print("Enter ID: ");
    String id = scan.nextLine();

    //check if there is duplicate id
    for (int a = 0; a<=2+newEmpCount; a++){
        if(a<=2){
            if (id.equals(empProfile[0][a]) || id.equals(newEmpProfile[0][a])){
                System.out.print("\033[H\033[2J");
                System.out.println("Duplicate ID Found!");
                return;
            } else {
                continue;
            }
        } else if (a>2){
            if (id.equals(newEmpProfile[0][a])){
                System.out.print("\033[H\033[2J");
                System.out.println("Duplicate ID Found!");
                return;
            } else {
                continue;
            }
        }
    }

    System.out.print("Enter first name: ");
    String fName = scan.nextLine();
    System.out.print("Enter last name: ");
    String lName = scan.nextLine();
    System.out.print("Enter position: ");
    String position = scan.nextLine();
    System.out.print("Enter length of service(days): ");
    String lenOfSer = scan.nextLine();
    System.out.print("Enter rate/day: ");
    String rateDay = scan.nextLine();
    System.out.print("Enter days worked: ");
    String daysWorked = scan.nextLine();
    System.out.print("Enter deductions: ");
    String deductions = scan.nextLine();
    
    //checks if there was an inputted letter to the input that requires a number
    for (int a = 0; a<=3; a++){
        for (int b = 0; b <= 9; b++){
            if (a == 0){
                if (lenOfSer.contains(String.valueOf(b))){
            noNumber = 0;
            break;
        } else{
            noNumber = 1;
        }
            } else if (a == 1){
                if (rateDay.contains(String.valueOf(b))){
            noNumber = 0;
            break;
        } else{
            noNumber = 1;
        }
            } else if (a == 2){
                if (daysWorked.contains(String.valueOf(b))){
            noNumber = 0;
            break;
        } else{
            noNumber = 1;
        }
            } else if (a == 3){
                if (deductions.contains(String.valueOf(b))){
            noNumber = 0;
            break;
        } else{
            noNumber = 1;
        }
            }
        }

    }

    if (noNumber == 1){
        System.out.print("\033[H\033[2J");
        System.out.println("Invalid Input");
        return;
    }

    newEmpProfile[0][newEmpCount] = id;
    newEmpProfile[1][newEmpCount] = fName;
    newEmpProfile[2][newEmpCount] = lName;
    newEmpProfile[3][newEmpCount] = position;
    newEmpProfile[4][newEmpCount] = lenOfSer;
    newEmpProfile[5][newEmpCount] = rateDay;
    newEmpProfile[6][newEmpCount] = daysWorked;
    newEmpProfile[7][newEmpCount] = deductions;

    System.out.println("\n\nAdded Record!");
    printLabel(1);
    System.out.println();
    for (int a = 0; a<=7; a++){
        System.out.printf("%-17s", newEmpProfile[a][newEmpCount]);
    }
    newEmpCount++;
    System.out.println("\n\nAdd Record Again?\n1.) Yes\n2.) No");
    int userChoice = scan.nextInt();
    scan.nextLine();
    if (userChoice == 1){
        System.out.print("\033[H\033[2J");
        continue;
    } else {
        System.out.print("\033[H\033[2J");
        finished = 1;
        return;
    }
    } while (finished == 0);

    }

    public void UpdateRecord(){
        int updateExit = 0;
        do{
        int changeValue = 0, userChoice1 = 0, noNumber = 0;
        System.out.print("\033[H\033[2J");
        System.out.println("Update Record\n");
        printLabel(1);
        displayRecords();
        displayNewEmpRecords();
        System.out.println("\n\nEnter the ID of who you want to update: ");
        String id = scan.nextLine();

        //check if the ID exists and selects it if it does
        for (int a = 0; a<=2+newEmpCount; a++){
            if(a<=2){
                if (id.equals(empProfile[0][a]) || id.equals(newEmpProfile[0][a])){
                    
                    changeValue = a;
                    break;
                } else {
                    continue;
                }
            } else if (a>2){
                if (id.equals(newEmpProfile[0][a])){
                    changeValue = a;
                    break;
                } else {
                    continue;
                }
            } else if (a == 2+newEmpCount && !id.equals(empProfile[0][a]) && !id.equals(newEmpProfile[0][a])){
                System.out.print("\033[H\033[2J");
                System.out.println("ID Not Found.");
                return;
            }
        }
        
        System.out.println("\n\nSelect what you want to update");

        for(int a = 0; a<=7; a++)
            System.out.println(a+1+".) "+label[a]);
        
        System.out.print("Choice: ");
        int choice = scan.nextInt();
        scan.nextLine();
        System.out.print("\n\nEnter new value: ");

        String newValue = scan.nextLine();
        
        //checks if there was an inputted letter to the input that requires a number
    for (int a = 0; a<=9; a++){
                if (choice-1 == 4 || choice-1 == 5 || choice-1 == 6 || choice-1 == 7){
                    if (newValue.contains(String.valueOf(a))){
                        noNumber = 0;
                        break;
                    } else{
                        noNumber = 1;
                    }
                }
    }

    if (noNumber == 1){
        System.out.print("\033[H\033[2J");
        System.out.println("Invalid Input");
        return;
    }

        empProfile[choice-1][changeValue] = newValue;
        System.out.print("\033[H\033[2J");
        System.out.println("Records has been updated.");
        printLabel(1);
        displayRecords();
        displayNewEmpRecords();

        System.out.println("\n\nUpdate Again?\n1.) Yes\n2.) No");
        System.out.print("Choice: ");
        userChoice1 = scan.nextInt();
        scan.nextLine();
        if (userChoice1 == 1){
            UpdateRecord();
        } else {
            System.out.print("\033[H\033[2J");
            updateExit = 1;
            return;
        }
    }while (updateExit == 1);
    }

    public void DeleteRecord(){
        int changeValue = 0;
        int selectArray = 0;
        System.out.print("\033[H\033[2J");
        System.out.println("Delete Record\n");
        printLabel(1);
        displayRecords();
        displayNewEmpRecords();
        System.out.println("\nEnter ID to delete: ");
        String id = scan.nextLine();

        for (int a = 0; a<=2+newEmpCount; a++){
            if(a<=2){
                if (id.equals(empProfile[0][a])){
                    selectArray = 1;
                    changeValue = a;
                    break;
                } else if (id.equals(newEmpProfile[0][a])){
                    selectArray = 2;
                    changeValue = a;
                    break;
                }else {
                    continue;
                }
            } 
            else if (a>2){
                if (id.equals(newEmpProfile[0][a])){
                    selectArray = 2;
                    changeValue = a;
                    break;
                } else {
                    continue;
                }
            } else if (a == 2+newEmpCount && !id.equals(empProfile[0][a]) && !id.equals(newEmpProfile[0][a])){
                System.out.print("\033[H\033[2J");
                System.out.println("ID Not Found.");
                return;
            }
        }

        for (int a = 0; a<=7; a++){
            if (selectArray == 1){
            empProfile[a][changeValue] = null;
            } else if (selectArray == 2){
                newEmpProfile[a][changeValue] = null;
            }
        } 
        System.out.print("\033[H\033[2J");
        System.out.println("Record has been deleted.");

    }

    public void SearchRecord(){
        int finished = 0;
        do{
        System.out.print("\033[H\033[2J");
        System.out.println("Search Record\n");
        System.out.print("Enter ID: ");
        String id = scan.nextLine();
        int idFound = 0;
        for (int a = 0; a<=2+newEmpCount; a++){
            if(a<=2){
                if (id.equals(empProfile[0][a])){
                    System.out.print("\033[H\033[2J");
                    System.out.println("ID Found!");
                    idFound = 1;
                    if (idFound == 1){
                        for (int b = 0; b<=7; b++){
                        if (b == 0){
                        printLabel(1);
                        System.out.println();
                        }
                        System.out.printf("%-17s", empProfile[b][a]);
                    }
                }
                    break;
                } else if (id.equals(newEmpProfile[0][a])){
                    System.out.print("\033[H\033[2J");
                    System.out.println("ID Found!");
                    idFound = 1;
                    if (idFound == 1){
                        for (int b = 0; b<=7; b++){
                        if (b == 0){
                        printLabel(1);
                        System.out.println();
                        }
                        System.out.printf("%-17s", newEmpProfile[b][a]);
                    }
                }
                    break;
                } else {
                    continue;
                }
            } else if (a>2){
                if (id.equals(newEmpProfile[0][a])){
                    System.out.print("\033[H\033[2J");
                    System.out.println("ID Found!");
                    idFound = 1;
                    if (idFound == 1){
                        for (int b = 0; b<=7; b++){
                        if (b == 0){
                        printLabel(1);
                        System.out.println();
                        }
                        System.out.printf("%-17s", newEmpProfile[b][a]);
                    }
                }
                    break;
                } else {
                    continue;
                }
            }
        }
        if (idFound == 0){
            System.out.println("ID not Found!");
        }
    System.out.println("\n\nSearch Again?\n1.) Yes\n2.) No");
    int choice = scan.nextInt();
    scan.nextLine();
    if (choice == 1){
        System.out.print("\033[H\033[2J");
        continue;
    } else {
        System.out.print("\033[H\033[2J");
        finished = 1;
        return;
    }
    }while (finished == 0);
    }



    public int printLabel(int n){
        if (n == 1){
        for (int a = 0; a<=7; a++){
        System.out.printf("%-17s", label[a]);
        }
    } else if (n == 2){
        for (int a = 0; a<=9; a++){
            System.out.printf("%-17s", label[a]);
        }
    }
        return 1;
     } 
     
    public void SolveSingleWage(){
        int finished = 0, grossSalary = 0, monthlySalary = 0;
        do{
        System.out.print("\033[H\033[2J");
        System.out.println("Compute Wage\n");
        System.out.print("Enter ID: ");
        String id = scan.nextLine();
        int idFound = 0;
        for (int a = 0; a<=2+newEmpCount; a++){
            if(a<=2){
                if (id.equals(empProfile[0][a])){
                    System.out.print("\033[H\033[2J");
                    grossSalary = Integer.parseInt(empProfile[5][a])*Integer.parseInt(empProfile[6][a]);
                    monthlySalary = (30*Integer.parseInt(empProfile[5][a]))-Integer.parseInt(empProfile[7][a]);
                    idFound = 1;
                    if (idFound == 1){
                        for (int b = 0; b<=9; b++){
                        if (b == 0){
                        printLabel(2);
                        System.out.println();
                        System.out.printf("%-17s", empProfile[b][a]);
                        } else if (b <= 7){
                        System.out.printf("%-17s", empProfile[b][a]);
                        } else if (b == 8){
                        System.out.printf("%-17s", String.valueOf(grossSalary));
                        } else if (b == 9){
                        System.out.printf("%-17s", String.valueOf(monthlySalary));
                        }
                    }
                }
                    break;
                } else if (id.equals(newEmpProfile[0][a])){
                    System.out.print("\033[H\033[2J");
                    grossSalary = Integer.parseInt(newEmpProfile[5][a])*Integer.parseInt(newEmpProfile[6][a]);
                    monthlySalary = (30*Integer.parseInt(newEmpProfile[5][a]))-Integer.parseInt(newEmpProfile[7][a]);
                    idFound = 1;
                    if (idFound == 1){
                        for (int b = 0; b<=9; b++){
                        if (b == 0){
                        printLabel(2);
                        System.out.println();
                        System.out.printf("%-17s", newEmpProfile[b][a]);
                        } else if (b <= 7){
                        System.out.printf("%-17s", newEmpProfile[b][a]);
                        } else if (b == 8){
                        System.out.printf("%-17s", String.valueOf(grossSalary));
                        } else if (b == 9){
                        System.out.printf("%-17s", String.valueOf(monthlySalary));
                        }
                    }
                }
                    break;
                } else {
                    continue;
                }
            } else if (a>2){
                if (id.equals(newEmpProfile[0][a])){
                    System.out.print("\033[H\033[2J");
                    grossSalary = Integer.parseInt(newEmpProfile[5][a])*Integer.parseInt(newEmpProfile[6][a]);
                    monthlySalary = (30*Integer.parseInt(newEmpProfile[5][a]))-Integer.parseInt(newEmpProfile[7][a]);
                    idFound = 1;
                    if (idFound == 1){
                        for (int b = 0; b<=9; b++){
                        if (b == 0){
                        printLabel(2);
                        System.out.println();
                        System.out.printf("%-17s", newEmpProfile[b][a]);
                        } else if (b <= 7){
                        System.out.printf("%-17s", newEmpProfile[b][a]);
                        } else if (b == 8){
                        System.out.printf("%-17s", String.valueOf(grossSalary));
                        } else if (b == 9){
                        System.out.printf("%-17s", String.valueOf(monthlySalary));
                        }
                    }
                }
                    break;
                } else {
                    continue;
                }
            }
        }
        if (idFound == 0){
            System.out.println("ID not Found!");
        }
    System.out.println("\n\nCompute Again?\n1.) Yes\n2.) No");
    int choice = scan.nextInt();
    scan.nextLine();
    if (choice == 1){
        System.out.print("\033[H\033[2J");
        continue;
    } else {
        System.out.print("\033[H\033[2J");
        finished = 1;
        return;
    }
    }while (finished == 0);
    }

    public void SolveAllWage(){
        System.out.print("\033[H\033[2J");
        System.out.println("Compute all Wages\n");
        int addSpace = 1, grossSalary = 0, monthlySalary = 0;
        printLabel(2);
        for (int a = 0; a<=2; a++){
            if (addSpace == 1){
            System.out.println();
            }
            for (int b = 0; b<=7; b++){
                if (b <= 7 && empProfile[b][a] == null){
                    addSpace = 0;
                    continue;
                } else{
                    grossSalary = Integer.parseInt(empProfile[5][a])*Integer.parseInt(empProfile[6][a]);
                    monthlySalary = (30*Integer.parseInt(empProfile[5][a]))-Integer.parseInt(empProfile[7][a]);
                        if (b <= 6){
                        System.out.printf("%-17s", empProfile[b][a]);
                        } else if (b == 7){
                        System.out.printf("%-17s%-17s%-17s", empProfile[b][a], String.valueOf(grossSalary), String.valueOf(monthlySalary));
                        }
                }
                
            }
        }
        for (int a = 0; a<=newEmpCount-1; a++){
            if (addSpace == 1){
            System.out.println();
            } 
            for (int b = 0; b<=7; b++){
                if (newEmpProfile[b][a] == null){
                    addSpace = 0;
                    continue;
                } else{
                    grossSalary = Integer.parseInt(newEmpProfile[5][a])*Integer.parseInt(newEmpProfile[6][a]);
                    monthlySalary = (30*Integer.parseInt(newEmpProfile[5][a]))-Integer.parseInt(newEmpProfile[7][a]);
                        if (b <= 6){
                        System.out.printf("%-17s", newEmpProfile[b][a]);
                        } else if (b == 7){
                        System.out.printf("%-17s%-17s%-17s", newEmpProfile[b][a], String.valueOf(grossSalary), String.valueOf(monthlySalary));
                        }
                }
            }
        }
        System.out.println("\n\nChoose: \n1.) Back");
        scan.nextLine();
        System.out.print("\033[H\033[2J");
    }

    public void displayRecords(){
        int addSpace = 1;
        for (int a = 0; a<=2; a++){
            if (addSpace == 1){
            System.out.println();
            }
            for (int b = 0; b<=7; b++){
                if (empProfile[b][a] == null){
                    addSpace = 0;
                    continue;
                } else{
                System.out.printf("%-17s", empProfile[b][a]);
                if (a == 1 && empProfile[0][2] == null)
                    addSpace = 0;
                else
                    addSpace = 1;
                }
            }
        }
    }
    

    public void displayNewEmpRecords(){
        int addSpace = 1;
        for (int a = 0; a<=newEmpCount-1; a++){
            if (addSpace == 1){
            System.out.println();
            } 
            for (int b = 0; b<=7; b++){
                if (newEmpProfile[b][a] == null){
                    addSpace = 0;
                    continue;
                } else{
                System.out.printf("%-17s", newEmpProfile[b][a]);
                if (a == newEmpCount-1)
                addSpace = 1;
                }
            }
        }
    }

    public void Title(){
        System.out.println("\n------------------");
        System.out.println("Payroll System");
        System.out.println("==================\n\n");
        }
}