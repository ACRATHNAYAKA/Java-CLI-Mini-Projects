import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class FinTrackCLI {
    private static double balance;
    private static double totalIncome;
    private static double totalExpenses;

    static Scanner scanner = new Scanner(System.in);

    static String [] INCOME_TYPE = {"Salary / Wages","Freelancing / Side Hustle","Business Profit","Allowance / Pocket Money","Gifts / Awards","Investments","Selling Items","Bonus","Rental Income","Others"};
    static String [] EXPENSES_TYPE = {"Food & Dining","Transport / Fuel","Housing / Rent","Education / Books","Shopping / Clothing","Bills & Utilities","Health / Medical","Entertainment","Personal Care","Others"};

    private static String [] MIAN_MENU = {"Add Income", "Add Expenses","Get Report","Exit"};
    public static void main(String[] args) {
        boolean appRunning = true;

        while (appRunning){
            clearScrean();
            drawHeader("FinTrackCLI");
            dashBord("asdfasf");
            drawMainMenu();

            addExpense();
            appRunning = false;
        }
    }

    private static void  addExpense(){
        clearScrean();
        drawHeader("Add Expenses");
        drawExpensesMenu();
        int userChoiceCategory = getUserChoice();
        double amount = getAmount();
        LocalDate date = LocalDate.now();
    }

    private static void goodBye(){
        clearScrean();
        System.out.println("            Thank You For Using FinTrack CLI             ");
        System.out.println("              -Developed By AC Rathnayaka-                  ");
    }

    private static void addIncome(){
        clearScrean();
        drawHeader("Add Income");
        drawIncomeMenu();
        int userChoiceCategory =  getUserChoice();
        double amount = getAmount();
        LocalDate date = LocalDate.now();

    }

    private static double getAmount(){
        System.out.print("Step 02: Enter Amount : ");
        double amount = Double.parseDouble(scanner.nextLine());

        while (amount<0){
            System.out.println("Invalid Input");
            System.out.print("Step 02: Enter Amount : ");
            amount = Double.parseDouble(scanner.nextLine());
        }

        return amount;
    }

    private static int getUserChoice(){
        System.out.print("Step 01: Select Categories(1-10) : ");
        int userChoice = Integer.parseInt(scanner.nextLine());

        while (userChoice<1 || userChoice >10){
            System.out.println("Invalid Input ");
            System.out.print("Step 01: Select Input Categories(1-10) : ");
            userChoice = Integer.parseInt(scanner.nextLine());
        }

        return userChoice;
    }

    private static void drawIncomeMenu(){
        System.out.println("___________________ Income Categories ____________________");
        System.out.println("[1] "+INCOME_TYPE[0]+"                     "+"[6] "+INCOME_TYPE[5]);
        System.out.println("[2] "+INCOME_TYPE[1]+"          "+"[7] "+INCOME_TYPE[6]);
        System.out.println("[3] "+INCOME_TYPE[2]+"                    "+"[8] "+INCOME_TYPE[7]);
        System.out.println("[4] "+INCOME_TYPE[3]+"           "+"[9] "+INCOME_TYPE[8]);
        System.out.println("[5] "+INCOME_TYPE[4]+"                     "+"[10] "+INCOME_TYPE[9]);
        System.out.println("__________________________________________________________");
    }

    private static void drawExpensesMenu(){
        System.out.println("___________________ Expense Categories ____________________");
        System.out.println("[1] "+EXPENSES_TYPE[0]+"            "+"[6] "+EXPENSES_TYPE[5]);
        System.out.println("[2] "+EXPENSES_TYPE[1]+"         "+"[7] "+EXPENSES_TYPE[6]);
        System.out.println("[3] "+EXPENSES_TYPE[2]+"           "+"[8] "+EXPENSES_TYPE[7]);
        System.out.println("[4] "+EXPENSES_TYPE[3]+"        "+"[9] "+EXPENSES_TYPE[8]);
        System.out.println("[5] "+EXPENSES_TYPE[4]+"      "+"[10] "+EXPENSES_TYPE[9]);
        System.out.println("__________________________________________________________");
    }

    private static void drawMainMenu(){
        int i = 1;
        for (String item: MIAN_MENU){
            System.out.println("["+i+"] "+item);
            i+=1;
        }
    }

    private static void dashBord(String userName) {
        LocalDate date = LocalDate.now();
        System.out.println("user : " + userName + "         " + "Date : " + date);
        System.out.println("__________________________________________________________");
        String balanceStatus = "";
        double balanceScore = balance / totalIncome * 100;
        if (balanceScore >= 75)
            balanceStatus = "Healthy";
        else if (balanceScore >= 40)
            balanceStatus = "Normal";
        else
            balanceStatus = "Week";

        System.out.println("Total Income   : "+totalIncome);
        System.out.println("Total Expenses : "+totalExpenses);
        System.out.println("Net Balance    : "+balance+" ["+balanceStatus+"] ");
        System.out.println("__________________________________________________________");

    }

    private static void finAlerts(){

    }

    private static void clearScrean(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void drawHeader(String headerName){
        System.out.println("==========================================================");
        System.out.println("                "+headerName+"                            ");
        System.out.println("==========================================================");
    }


    private static void writeIncome(){

    }

    private static void readIncome(){

    }
}
