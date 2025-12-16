import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class FinTrackCLI {
    private static String INCOME_FILE_PATH = "01-Fundamentals\\03-Personal-Finance-Tracker\\data\\income.txt";
    private static String EXPENCE_FILE_PATH = "01-Fundamentals\\03-Personal-Finance-Tracker\\data\\expenses.txt";

    private static double balance;
    private static double totalIncome;
    private static double totalExpenses;

    private static int id;
    private static String date;
    private static String category;
    private static double amount;
    private static String type;

    private static Scanner scanner = new Scanner(System.in);

    private static String [] INCOME_TYPE = {"Salary / Wages","Freelancing / Side Hustle","Business Profit","Allowance / Pocket Money","Gifts / Awards","Investments","Selling Items","Bonus","Rental Income","Others"};
    private static String [] EXPENSES_TYPE = {"Food & Dining","Transport / Fuel","Housing / Rent","Education / Books","Shopping / Clothing","Bills & Utilities","Health / Medical","Entertainment","Personal Care","Others"};
    private static String [] MIAN_MENU = {"Add Income", "Add Expenses","Get Report","Exit"};

    public static void main(String[] args) throws IOException {
        boolean appRunning = true;

        while (appRunning){
            clearScrean();
            drawHeader("FinTrackCLI");
            summer("asdfasf");
            drawMainMenu();
            addExpense();
            appRunning = false;
        }
    }

    private static void  addExpense() throws IOException {
        clearScrean();
        drawHeader("Add Expenses");
        drawExpensesMenu();
        int userChoiceCategory = getUserChoice();
        double amount = getAmount();

        saveRecord(EXPENSES_TYPE[userChoiceCategory-1],amount,EXPENCE_FILE_PATH);
    }

    private static void goodBye(){
        clearScrean();
        System.out.println("            Thank You For Using FinTrack CLI             ");
        System.out.println("              -Developed By AC Rathnayaka-                  ");
    }

    private static void addIncome() throws IOException {
        clearScrean();
        drawHeader("Add Income");
        drawIncomeMenu();
        int userChoiceCategory =  getUserChoice();
        double amount = getAmount();

        saveRecord(INCOME_TYPE[userChoiceCategory-1],amount,INCOME_FILE_PATH);

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

    private static void getReport(){
        clearScrean();
        drawHeader("FINANCIAL STATEMENT - FULL REPORT");
        summer("a");
        drawTableHader();
        addItemToTable();


    }

    private static void drawTableHader(){
        System.out.println("+----------+------------------+---------------------------------+------------+-----------------+");
        System.out.println("|    ID    |       DATE       |      CATEGORY                   |   TYPE     |      AMOUNT     |");
        System.out.println("+----------+------------------+---------------------------------+------------+-----------------+");
    }

    private static void addItemToTable(){
        System.out.println("|    "+id+"    | "+date+" | "+category+" | "+type+" |  "+amount+" |");
    }

    private static void drawMainMenu(){
        int i = 1;
        for (String item: MIAN_MENU){
            System.out.println("["+i+"] "+item);
            i+=1;
        }
    }

    private static void summer(String userName) {
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


    private static void clearScrean(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void drawHeader(String headerName){
        System.out.println("==========================================================");
        System.out.println("                "+headerName+"                            ");
        System.out.println("==========================================================");
    }


    private static void saveRecord(String category, double amount, String filePath ) throws IOException {
        File file = new File(filePath);
        if (!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        LocalDate date = LocalDate.now();
        String record = id+","+ date + "," + category + "," + amount + "\n";
        fileWriter.write(record);
        fileWriter.close();

        System.out.println("Record Saved Successfully");

    }

    private static void readIncome(){

    }
}
