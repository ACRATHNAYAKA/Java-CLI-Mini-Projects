import java.util.Scanner;

public class OmniConvertCLI {

    static String [] MAIN_MENU = {"[01]. Length Converter", "[02]. Weight Converter", "[03]. Temperature Converter", "[04]. Currency Converter", "[05]. Exit"};
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
        System.out.println("[1] Millimeters(mm)        [5] Inches(in)");
        System.out.println("[2] Centimeters(cm)        [6] Feet(ft)");
        System.out.println("[3] Meters(m)              [7] Yard(yd)");
        System.out.println("[4] Kilometers(km)         [8] Miles(mi)");
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

    public static boolean askNextStep(){
        System.out.println("_____________________________________________________");
        System.out.println(" [1]. Home                                 [0]. Exit" );
        System.out.println("_____________________________________________________");
        System.out.println();

        while (true) {
            System.out.print("Enter Your Choice : ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
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


    private static void lengthConverter(){
        clearScrean();
        drawLengthConverterHader();
        drawLengthConverterMenu();
        int ConvertFromUnit = getUnit(1,": Convert From Which Unit?");
        int ConvertToUnit = getUnit(2,": Convert To Which Unit?");

    }

    private static void weightConverter(){

    }

    private static void temperatureConverter(){

    }

    private static void currencyConverter(){

    }

    private static void goodBye(){

    }

}
