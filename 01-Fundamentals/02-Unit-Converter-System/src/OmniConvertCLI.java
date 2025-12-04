import java.text.DecimalFormat;
import java.util.Scanner;

public class OmniConvertCLI {
    static String [] LENGTH_UNITS = {"Millimeters(mm)","Centimeters(cm)","Meters(m)","Kilometers(km)","Inches(in)","Feet(ft)","Yard(yd)"," Miles(mi)"};
    static String [] MAIN_MENU = {"[1] Length Converter", "[2] Weight Converter", "[3] Temperature Converter", "[4] Currency Converter", "[5] Exit"};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean appRunning = true;

        while (appRunning){
            clearScrean();
            drawMainHader();
            drawMainMenu();
            appRunning = performAction(getMainMenuChoice());
        }
    }

    private static void drawMainHader(){
        System.out.println("===========================================================");
        System.out.println("                      OmniCovert CLI                       ");
        System.out.println("===========================================================");

    }

    private static void drawLengthConverterHader(){
        System.out.println("===========================================================");
        System.out.println("                     Length Converter                      ");
        System.out.println("===========================================================");
    }

    private static void clearScrean(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void drawMainMenu(){
        System.out.println("Select Category To Process:");
        System.out.println();
        for(String item: MAIN_MENU){
            System.out.println(item);

        }
        System.out.println();
    }

    private static void drawLengthConverterMenu(){
        System.out.println("Available Units : ");
        System.out.println();
        System.out.println("[1] "+LENGTH_UNITS[0]+"        [5] "+LENGTH_UNITS[4]);
        System.out.println("[2] "+LENGTH_UNITS[1]+"        [6] "+LENGTH_UNITS[5]);
        System.out.println("[3] "+LENGTH_UNITS[2]+"              [7] "+LENGTH_UNITS[6]);
        System.out.println("[4] "+LENGTH_UNITS[3]+"         [8] "+LENGTH_UNITS[7]);
        System.out.println();
        System.out.println("===========================================================");
    }

    private static int getMainMenuChoice(){
        System.out.println("===========================================================");
        System.out.print("Enter Your Choice(1-4) : ");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice>5 || choice<1){
            System.out.println("Invalid Input.");
            System.out.print("Enter Your Choice : ");
            choice = Integer.parseInt(scanner.nextLine());
        }
        return choice;
    }

    private static int getUnit(int step, String message){

        System.out.println("Step "+step+message);
        String inputMessage = "Enter the Unit ID(1-8) : ";
        System.out.print(inputMessage);
        int userChoice = Integer.parseInt(scanner.nextLine());

        while (userChoice<1 || userChoice >8){
            System.out.println("Invalid Input.");
            System.out.print(inputMessage);
            userChoice = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("-----------------------------------------------------------");
        return userChoice;
    }

    private static double getAmount(){
        System.out.println("Step "+ 3 + ": Enter Value To Convert");
        System.out.print("Amount : ");
        double amount = Double.parseDouble(scanner.nextLine());

        while (amount<0){
            System.out.println("Invalid Input.");
            System.out.print("Amount : ");
            amount = Double.parseDouble(scanner.nextLine());
        }
        return amount;
    }

    private static boolean performAction (int choice){
        switch (choice){
            case 1:
                lengthConverter();
                return askNextStep();
            case 2:
                weightConverter();
                return askNextStep();
            case 3:
                temperatureConverter();
                return askNextStep();
            case 4:
                currencyConverter();
                return askNextStep();
            case 5:
                goodBye();
                return false;
            default:
                return true;

        }

    }

    public static boolean askNextStep(){System.out.println("_____________________________________________________");
        System.out.println("What's Next?");
        System.out.println("[1] New length Conversion");
        System.out.println("[2] Back To Main Menu");
        System.out.println("[0] Exit");

        while (true) {
            System.out.print("Enter Your Choice : ");
            int choice = Integer.parseInt(scanner.nextLine());

            while (choice<0 || choice>2 ){
                System.out.print("Invalid Input");
                System.out.print("Enter Your Choice : ");
                choice = Integer.parseInt(scanner.nextLine());
            }

            if (choice == 1) {
                lengthConverter();
            }
            else if (choice == 2){
                return true;
            }
            else if (choice == 0) {
                return false;
            }
            else {
                System.out.println("Invalid Input");
            }
        }
    }

    private static double lengthConvertToMeter(int fromUnit, double amount){
        switch (fromUnit){
            case 1:
                return amount/1000;
            case 2:
               return amount/100;
            case 3:
                return amount;
            case 4:
                return amount*1000;
            case 5:
                return amount*0.0254;
            case 6:
                return amount*0.3048;
            case 7:
                return amount*0.9411;
            case 8:
                return amount/1609.344;
            default:
                return 0;
        }
    }

    private static double lengthConvertFromMeter(int targetUnit, double lengthInMeter){
        switch (targetUnit){
            case 1:
                return lengthInMeter*1000;
            case 2:
                return lengthInMeter*100;
            case 3:
                return lengthInMeter;
            case 4:
                return lengthInMeter/1000;
            case 5:
                return lengthInMeter/0.0254;
            case 6:
                return lengthInMeter/0.3048;
            case 7:
                return lengthInMeter/0.9411;
            case 8:
                return lengthInMeter/1609.344;
            default:
                return 0;
        }
    }

    private static void lengthConverter(){
        clearScrean();
        drawLengthConverterHader();
        drawLengthConverterMenu();
        int convertFrom = getUnit(1, ": Convert From Which Unit?");
        int convertTo = getUnit(2, ": Convert To Which Unit?");
        double amount = getAmount();

        double lengthInMeter = lengthConvertToMeter(convertFrom,amount);
        double result = lengthConvertFromMeter(convertTo,lengthInMeter);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formatResult = decimalFormat.format(result);

        clearScrean();
        System.out.println();
        System.out.println("Calculating.....");
        System.out.println("[ "+LENGTH_UNITS[convertFrom-1]+" >> "+LENGTH_UNITS[convertTo-1]+" ] ");
        System.out.println("Result : "+formatResult+" "+LENGTH_UNITS[convertTo-1]);

    }

    private static void weightConverter(){

    }

    private static void temperatureConverter(){

    }

    private static void currencyConverter(){

    }

    private static void goodBye(){
        clearScrean();
        System.out.println("            Thank You For Using OmniConvertCLI              ");
        System.out.println("               -Developed By AC Rathnayaka-                  ");

    }

}
