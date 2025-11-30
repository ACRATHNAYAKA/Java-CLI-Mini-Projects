import java.util.Scanner;

public class OmniConvertCLI {

    static String [] MAIN_MENU = {"[01]. Length Converter", "[02]. Weight Converter", "[03]. Temperature Converter", "[04]. Currency Converter", "[05]. Exit"};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean appRunning = true;

        while (appRunning){
            clearScrean();
            drawHader();
            drawMainMenu();
            appRunning = performAction(getChoice());
        }
    }

    public static void drawHader(){
        System.out.println("===========================================================");
        System.out.println("                      OmniCovert CLI                       ");
        System.out.println("===========================================================");
    }

    private static void clearScrean(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void drawMainMenu(){
        System.out.println("Select Category To Process:");
        for(String item: MAIN_MENU){
            System.out.println(item);

        }
    }

    private static int getChoice(){
        System.out.println("Enter Your Choice : ");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice>5 || choice<1){
            System.out.println("Invalid Input.....");
            System.out.println("Enter Your Choice : ");
            choice = Integer.parseInt(scanner.nextLine());
        }
        return choice;
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
