
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import java.util.Scanner;

public class FinTrackCLI {


    private static final String FILE_PATH = "01-Fundamentals\\03-Personal-Finance-Tracker\\data\\records.txt";

    private static double balance;
    private static double totalIncome;
    private static double totalExpenses;

    private static int id = 1;


    private static final  Scanner scanner = new Scanner(System.in);

    private static final String [] INCOME_TYPE = {"Salary / Wages","Freelancing / Side Hustle","Business Profit","Allowance / Pocket Money","Gifts / Awards","Investments","Selling Items","Bonus","Rental Income","Others"};
    private static final String [] EXPENSES_TYPE = {"Food & Dining","Transport / Fuel","Housing / Rent","Education / Books","Shopping / Clothing","Bills & Utilities","Health / Medical","Entertainment","Personal Care","Others"};
    private static final String [] MIAN_MENU = {"Add Income", "Add Expenses","Get Report","Exit"};

    private static final String [] CATEGORY = new String[100];
    private static final String [] DATE = new String[100];
    private static final int [] IDS = new int[100];
    private static final String[] TYPE = new String[100];
    private static final double [] AMOUNT = new double[100];

    private static int recordCounter = 0;


    public static void main(String[] args) throws IOException {
        loadData();
        boolean appRunning = true;

        while (appRunning){
            clearScrean();
            drawHeader("Fin Track CLI");
            summer("example");
            drawMainMenu();
            appRunning = performAction();



        }
    }

    private static int getUserChoiceMainMenu(){
        System.out.print("Enter Your Choice(1-4) :");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice<1 || choice>4){
            System.out.println("Invalid Input.");
            System.out.print("Enter Your Choice(1-4) :");
            choice = Integer.parseInt(scanner.nextLine());
        }
        return choice;
    }

    private static boolean performAction() throws IOException {
        int choice = getUserChoiceMainMenu();
        switch (choice){
            case 1:
                addIncome();
                return true;
            case 2:
                addExpense();
                return true;
            case 3:
                getReport();
                return true;
            case 4:
                goodBye();
                return false;
            default:
                return true;
        }
    }

    private static void  addExpense() throws IOException {
        clearScrean();
        drawHeader("Add Expenses");
        drawExpensesMenu();
        String type = "Expense";
        int userChoiceCategory = getUserChoice();
        double amount = getAmount();


        saveRecord(EXPENSES_TYPE[userChoiceCategory-1],amount, type);
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
        String type = "Income";
        int userChoiceCategory =  getUserChoice();
        double amount = getAmount();

        saveRecord(INCOME_TYPE[userChoiceCategory-1],amount,type);

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
        System.out.println("+----------+------------------+----------------------------+------------+-----------------+");
        System.out.println("|    ID    |       DATE       |      CATEGORY              |   TYPE     |      AMOUNT     |");
        System.out.println("+----------+------------------+----------------------------+------------+-----------------+");
    }

    private static void addItemToTable(){
        for (int i = 0; recordCounter>i; i++) {
            int recordID = IDS[i];
            String recordDate = DATE[i];
            String recordCategory = CATEGORY[i];
            String recordType = TYPE[1];
            double recordAmount = AMOUNT[1];
            System.out.println("|     " + recordID + "    |    " + recordDate + "    |    " + recordCategory + "           |  " + recordType + "   |  " + recordAmount + " ");
            System.out.println("+----------+------------------+----------------------------+------------+-----------------+");
        }
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
        String balanceStatus ;
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


    private static void saveRecord(String category, double amount, String type) throws IOException {
        File file = new File(FILE_PATH);

        FileWriter fileWriter = new FileWriter(file, true);
        LocalDate date = LocalDate.now();
        String record = id+","+ date + "," + category + "," +type+","+ amount + "\n";
        fileWriter.write(record);
        fileWriter.close();
        id++;

        System.out.println("Record Saved Successfully");

    }

    private static void loadData() throws FileNotFoundException {
        File file = new File(FILE_PATH);


        if (file.exists()){
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()){
                String record = fileScanner.nextLine();

                String [] parts = record.split(",");

                if (parts.length == 5 && recordCounter<100){
                    IDS[recordCounter] = Integer.parseInt(parts[0]);
                    DATE[recordCounter] = parts[1];
                    CATEGORY[recordCounter] = parts[2];
                    TYPE[recordCounter] = parts[3];
                    AMOUNT[recordCounter] = Double.parseDouble(parts[4]);

                    if (parts[3].equals("Income")) {
                        totalIncome += Double.parseDouble(parts[4]);
                    } else {
                        totalExpenses += Double.parseDouble(parts[4]);
                    }

                    recordCounter++;
                }
            }
            fileScanner.close();

            balance = totalIncome -totalExpenses;
        }

        else {
            System.out.println("File Missing");
        }


    }


}
