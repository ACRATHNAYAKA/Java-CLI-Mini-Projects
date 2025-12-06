import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;

public class OmniConvertCLI {
    static String [] TEMPERATURE_UNITS = {"Celsius","Fahrenheit","Kelvin"};
    static String [] WEIGHT_UNITS = {"Milligram(mg)","Gram(g)","Kilogram(kg)","Metric Ton","Ounce(oz)","Pound(lb)","Stone(st)","US Ton"};
    static String [] LENGTH_UNITS = {"Millimeters(mm)","Centimeters(cm)","Meters(m)","Kilometers(km)","Inches(in)","Feet(ft)","Yard(yd)"," Miles(mi)"};
    static String [] MAIN_MENU = {"[1] Length Converter", "[2] Weight Converter", "[3] Temperature Converter", "[4] Exit"};
    static Scanner scanner = new Scanner(System.in);
    static DecimalFormat decimalFormat = new DecimalFormat("0.00");

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

    private static void drawWightConverterHader(){
        System.out.println("===========================================================");
        System.out.println("                     Weight Converter                      ");
        System.out.println("===========================================================");
    }

    private static void drawTemperatureConverterHader(){
        System.out.println("===========================================================");
        System.out.println("                     Temperature Converter                      ");
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

    private static void drawWeightConverterMenu(){
        System.out.println("Available Units : ");
        System.out.println();
        System.out.println("[1] "+WEIGHT_UNITS[0]+"           [5] "+WEIGHT_UNITS[4]);
        System.out.println("[2] "+WEIGHT_UNITS[1]+"                 [6] "+WEIGHT_UNITS[5]);
        System.out.println("[3] "+WEIGHT_UNITS[2]+"            [7] "+WEIGHT_UNITS[6]);
        System.out.println("[4] "+WEIGHT_UNITS[3]+"              [8] "+WEIGHT_UNITS[7]);
        System.out.println();
        System.out.println("===========================================================");
    }

    private static void drawTemperatureConverterMenu(){
        System.out.println("Available Units : ");
        System.out.println();
        System.out.println("[1] "+TEMPERATURE_UNITS[0]);
        System.out.println("[2] "+TEMPERATURE_UNITS[1]);
        System.out.println("[3] "+TEMPERATURE_UNITS[2]);
        System.out.println();
        System.out.println("===========================================================");
    }

    private static int getMainMenuChoice(){
        System.out.println("===========================================================");
        System.out.print("Enter Your Choice(1-4) : ");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice>4 || choice<1){
            System.out.println("Invalid Input.");
            System.out.print("Enter Your Choice : ");
            choice = Integer.parseInt(scanner.nextLine());
        }
        return choice;
    }

    private static int getUnit(int step, String message,int minChoice ,int maxChoice){

        System.out.println("Step "+step+message);
        String inputMessage = "Enter the Unit ID(1-8) : ";
        System.out.print(inputMessage);
        int userChoice = Integer.parseInt(scanner.nextLine());

        while (userChoice<minChoice || userChoice >maxChoice){
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

    private static double getTemperature(int convertFrom){
        System.out.println("Step "+ 3 + ": Enter Value To Convert");
        System.out.print("Amount : ");
        double amount = Double.parseDouble(scanner.nextLine());

        double minValue = 0;
        switch (convertFrom){
            case 1:
                minValue = -273.15;
                break;
            case 2:
                minValue = -459.67;
                break;
            case 3:
                minValue = 0;
                break;
        }

        while (amount<minValue){
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
                return true;
            case 2:
                weightConverter();
                return true;
            case 3:
                temperatureConverter();
                return true;
            case 4:
                goodBye();
                return false;
            default:
                return true;

        }

    }

    public static int askNextStep(String unitType){
        System.out.println("_____________________________________________________");
        System.out.println("What's Next?");
        System.out.println("[1] New "+unitType+" Conversion");
        System.out.println("[2] Back To Main Menu");
        System.out.println("[0] Exit");

        System.out.print("Enter Your Choice : ");
        int choice = Integer.parseInt(scanner.nextLine());

        while (choice<0 || choice>2){
            System.out.println("Invalid Input.");
            System.out.print("Enter Your Choice : ");
            choice = Integer.parseInt(scanner.nextLine());
        }
        return choice;
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
                return amount*1609.344;
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
        int userChoice;
        do {
            clearScrean();
            drawLengthConverterHader();
            drawLengthConverterMenu();
            int convertFrom = getUnit(1, ": Convert From Which Unit?", 1, 8);
            int convertTo = getUnit(2, ": Convert To Which Unit?", 1, 8);
            double amount = getAmount();

            double lengthInMeter = lengthConvertToMeter(convertFrom, amount);
            double result = lengthConvertFromMeter(convertTo, lengthInMeter);

            String formatResult = decimalFormat.format(result);

            clearScrean();
            drawLengthConverterHader();
            System.out.println();
            System.out.println("Calculating.....");
            System.out.println("[ " + LENGTH_UNITS[convertFrom - 1] + " >> " + LENGTH_UNITS[convertTo - 1] + " ] ");
            System.out.println("Result : " + formatResult + " " + LENGTH_UNITS[convertTo - 1]);

             userChoice = askNextStep("Length");

            if (userChoice == 0) {
                goodBye();
                System.exit(0);
            }
        }while (userChoice ==1);

    }

    private static double weightToKilogram(int convertFrom, double amount){
        switch (convertFrom){
            case 1:
                return amount/1000000;
            case 2:
                return amount/1000;
            case 3:
                return amount;
            case 4:
                return amount/0.001;
            case 5:
                return amount/35.274;
            case 6:
                return amount/2.20462;
            case 7:
                return amount/0.157473;
            case 8:
                return amount/0.00110231;
            default:
                return 0;
        }
    }

    private static double weightFromKilogram(int convertTo, double weightInKilogram){
        switch (convertTo){
            case 1:
                return weightInKilogram*1000000;
            case 2:
                return weightInKilogram*1000;
            case 3:
                return weightInKilogram;
            case 4:
                return weightInKilogram*0.001;
            case 5:
                return weightInKilogram*35.274;
            case 6:
                return weightInKilogram*2.20462;
            case 7:
                return weightInKilogram*0.157473;
            case 8:
                return weightInKilogram*0.00110231;
            default:
                return 0;
        }
    }

    private static void weightConverter(){

        int userChoice;
        do {
            clearScrean();
            drawWightConverterHader();
            drawWeightConverterMenu();
            int convertFrom = getUnit(1, ": Convert From Which Unit?", 1, 8);
            int convertTo = getUnit(2, ": Convert To Which Unit?", 1, 8);
            double amount = getAmount();

            double weightInKilogram = weightToKilogram(convertFrom, amount);
            double result = weightFromKilogram(convertTo, weightInKilogram);

            String formatResult = decimalFormat.format(result);

            clearScrean();
            drawWightConverterHader();
            System.out.println();
            System.out.println("Calculating.....");
            System.out.println("[ " + WEIGHT_UNITS[convertFrom - 1] + " >> " + WEIGHT_UNITS[convertTo - 1] + " ] ");
            System.out.println("Result : " + formatResult + " " + WEIGHT_UNITS[convertTo - 1]);

            userChoice = askNextStep("Wight");

            if(userChoice == 0){
                goodBye();
                System.exit(0);
            }
        }while (userChoice == 1);
    }

    private static double temperatureConvertToCelsius(int convertFrom, double amount){
        switch (convertFrom){
            case 1:
                return amount;
            case 2:
                return (amount - 32) * 5.0 / 9;
            case 3:
                return (amount - 273.15);
            default:
                return 0;
        }
    }

    private static double temperatureConvertFromCelsius(int convertTo, double temperatureInCelsius){
        switch (convertTo){
            case 1:
                return temperatureInCelsius;
            case 2:
                return (temperatureInCelsius * 9.0 / 5) + 32;
            case 3:
                return temperatureInCelsius + 273.15;
            default:
                return 0;
        }
    }

    private static void temperatureConverter(){

        int userChoice;
        do {
            clearScrean();
            drawTemperatureConverterHader();
            drawTemperatureConverterMenu();
            int convertFrom = getUnit(1, ": Convert From Which Unit?", 1, 3);
            int convertTo = getUnit(2, ": Convert To Which Unit?", 1, 3);
            double amount = getTemperature(convertFrom);

            double temperatureInCelsius = temperatureConvertToCelsius(convertFrom, amount);
            double temperature = temperatureConvertFromCelsius(convertTo, temperatureInCelsius);

            String formatTemperature = decimalFormat.format(temperature);

            clearScrean();
            drawTemperatureConverterHader();
            System.out.println("Calculating.....");
            System.out.println("[ " + TEMPERATURE_UNITS[convertFrom - 1] + " >> " + TEMPERATURE_UNITS[convertTo - 1] + " ] ");
            System.out.println("Result : " + formatTemperature + " " + TEMPERATURE_UNITS[convertTo - 1]);

            userChoice = askNextStep("Temperature");

            if (userChoice == 0){
                goodBye();
                System.exit(0);
            }
        }while (userChoice == 1);
    }


    private static void goodBye(){
        clearScrean();
        System.out.println("            Thank You For Using OmniConvertCLI              ");
        System.out.println("               -Developed By AC Rathnayaka-                  ");

    }

}
