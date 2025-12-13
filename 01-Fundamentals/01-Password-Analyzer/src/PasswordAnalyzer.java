import java.io.Console;
import java.util.Random;
import java.util.Scanner;


public class PasswordAnalyzer {

    public static Scanner scanner = new Scanner(System.in);
    public static String password = "";

    public static boolean hasLowerCase = false;
    public static boolean hasUpperCase = false;
    public static boolean hasNumbers = false;
    public static boolean hasSymbol = false;
    public static boolean hasSpace = false;


    static String[] MENU_ITEMS = {"[1] Check Password Strength","[2] Generate Strong Password","[3] Security Tips","[4] Exit"};


    public static void main(String[] args) {
        boolean appRunning = true;

        while (appRunning) {
            clearScrean();
            drawHeader();
            drawMenu();
            appRunning = performAction(getChoice());
        }
    }

    static void drawHeader() {
        System.out.println("=====================================================");
        System.out.println("           SMART PASSWORD STRENGTH ANALYZER          ");
        System.out.println("=====================================================");
    }

    static void drawHeaderForCheckPassword() {
        System.out.println("=====================================================");
        System.out.println("           SMART PASSWORD STRENGTH ANALYZER          ");
        System.out.println("               -Check Password Strength-             ");
        System.out.println("=====================================================");
    }

    static void drawHeaderForGeneratePassword(){
        System.out.println("=====================================================");
        System.out.println("           SMART PASSWORD STRENGTH ANALYZER          ");
        System.out.println("              -Generate Strong Password-             ");
        System.out.println("=====================================================");
    }

    static void drawHeaderForSecurityTips(){
        System.out.println("=====================================================");
        System.out.println("           SMART PASSWORD STRENGTH ANALYZER          ");
        System.out.println("                    -Security Tips-                  ");
        System.out.println("=====================================================");
    }

    private static void clearScrean(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void drawMenu(){
        for (String menuItem : MENU_ITEMS) {
            System.out.println(menuItem);
        }
    }

    static int getChoice(){

        System.out.print("Enter your choice (1-4): ");
        int choice = Integer.parseInt(scanner.nextLine());

        while(choice<1 || choice>4){
            System.out.println("Invalid Input");
            System.out.print("Enter your choice (1-4): ");
            choice = Integer.parseInt(scanner.nextLine());
        }
        return choice;
    }

    static boolean performAction(int choice){
        switch (choice){
            case 1:
                checkPasswordStrength();
                return askNextStep();

            case 2:
                GenerateStrongPassword();
                return askNextStep();

            case 3:
                securityTips();
                return askNextStep();

            case 4:
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


    static void checkPasswordStrength(){
        hasLowerCase = false;
        hasUpperCase = false;
        hasNumbers = false;
        hasSymbol = false;
        hasSpace = false;
        clearScrean();
        Console console = System.console();

        drawHeaderForCheckPassword();

        if (console == null){
            System.out.print("Enter Your Password : ");
            password = scanner.nextLine();
        }
        else {
            char[] cdmPassword = console.readPassword("Enter Your Password : ");
            password = new String(cdmPassword);
        }
        System.out.println("Analyse Your Password.......");
        System.out.println();
        clearScrean();

        System.out.println("=====================================================");
        System.out.println("                         RESULT                      ");
        System.out.println("-----------------------------------------------------");

        System.out.println("Your Password : "+password);

        passwordScore();
        estimatedCrackTime();
        checkPassed();
    }

    public static void estimatedCrackTime(){

        String estimateCrackTime;
        int poolSize = 0;

        if (hasLowerCase){
            poolSize+=26;
        }
        if (hasUpperCase){
            poolSize+=26;
        }
        if(hasNumbers){
            poolSize+=10;
        }
        if (hasSymbol){
            poolSize+=33;
        }

        double combinations = Math.pow(poolSize,password.length());
        double guessesPerSecond = 1000_000_000.0;
        double seconds = combinations/guessesPerSecond;

        double minute = 60;
        double hour = minute*60;
        double day = hour*24;
        double years = day*365;

        if(seconds<1){
            estimateCrackTime = "Instantly";
        }
        else if (seconds<minute) {
            estimateCrackTime = String.format("%.2f seconds",seconds);
        }
        else if(seconds<hour){
            estimateCrackTime = String.format("%.2f minutes",seconds/minute);
        }
        else if (seconds<day) {
            estimateCrackTime = String.format("%.2f hours",seconds/hour);
        }
        else if (seconds<years){
            estimateCrackTime = String.format("%.2f days",seconds/day);
        }
        else if (seconds/years >1000_000) {
            estimateCrackTime = "Centuries";
        }
        else {
            estimateCrackTime = String.format("%.2f years", seconds / years);
        }

        System.out.println("Estimated Crack Time : "+estimateCrackTime);
    }

    public static void passwordScore(){

        int score = 0;
        String status = "";

        int passwordLength;


        passwordLength = password.length();
        int lengthScore = passwordLength*4;
        if(lengthScore>40){
            lengthScore = 40;
        }
        score+=lengthScore;

        for (char checkItem : password.toCharArray()){
            if (Character.isDigit(checkItem)){
                hasNumbers = true;
            }

            else if (Character.isUpperCase(checkItem)){
                hasUpperCase = true;
            }

            else if(Character.isLowerCase(checkItem)){
                hasLowerCase = true;
            }

            else if (Character.isWhitespace(checkItem)){
                hasSpace = true;
            }
            else {
                hasSymbol =true;
            }
        }

        if(hasLowerCase) {
            score += 10;
        }
        if(hasUpperCase) {
            score += 10;
        }
        if (hasNumbers){
            score += 15;
        }
        if(hasSymbol) {
            score += 15;
        }

        if(hasLowerCase && hasUpperCase && hasNumbers && hasSymbol && lengthScore>=32){
            score +=10;
        }

        if (score<=70){
            status = "Week";
        }
        else if (score<=80){
            status = "Medium";
        }
        else if(score<=85){
            status = "Strong";
        }
        else if (score<=100) {
            status = "Very Strong";
        }

        System.out.println();
        System.out.println("Strength Score : "+score+"%");
        System.out.println("Validate : "+status);


    }

    public static void checkPassed(){
        System.out.println();
        System.out.println("Check Passed:");
        System.out.println("Length "+password.length()+" Characters");
        if (hasLowerCase){
            System.out.println("✓ Contains Lowercase Letters");
        }
        if (hasUpperCase){
            System.out.println("✓ Contains Uppercase Letters");
        }
        if (hasNumbers){
            System.out.println("✓ Contains Numbers");
        }
        if(hasSymbol){
            System.out.println("✓ Contains Special Characters");
        }
        System.out.println();
        System.out.println("Pro Tip : Add 3+ random words → becomes UNBREAKABLE!");
        System.out.println("Example : I-Drink-BlackMilk-At-10PM");
        System.out.println();

    }


    static void GenerateStrongPassword(){
        String symbols = "@#$%&*!^-";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        int suggestionCount = 5;

        clearScrean();
        drawHeaderForGeneratePassword();

        System.out.print("Enter Your Random Words Separate By Space : ");
        String randomWords = scanner.nextLine();

        System.out.println("Just Second.....");
        clearScrean();

        drawHeaderForGeneratePassword();
        System.out.println("Here are 5 Supper Suggestions:");
        System.out.println();
        String[] randomWordsArray = randomWords.split(" ");

        for (int j = 0; j<suggestionCount; j++) {
            for (int i = 0; i < randomWordsArray.length; i++) {
                password.append(randomWordsArray[i]);
                if (i < randomWordsArray.length - 1)
                    password.append(symbols.charAt(random.nextInt(symbols.length())));
            }
            password.append(random.nextInt(100));

            int index = j+1;
            System.out.println("["+index+"]. "+password);
            password.setLength(0);

        }

        System.out.println();
        System.out.println("Just Copy And Use It.....");


    }

    static void securityTips(){
        clearScrean();
        drawHeaderForSecurityTips();

        System.out.println("[01] Length is Power: A 15-character sentence is harder to crack than \"P@ssw0rd1\"");
        System.out.println("[02] The Golden Rule: One Site = One Password. Never recycle old passwords!");
        System.out.println("[03] No Personal Info: Hackers guess names and birthdays first. Keep them out.");
        System.out.println("[04] Double Defense: Enable 2FA (Two-Factor Auth) to stop hackers even if they have your key.");
        System.out.println("[05] Use Tools: Don't trust your memory. Use a Password Manager (like Bitwarden).");

        System.out.println();
        System.out.println("Your security is in your hands. Stay vigilant! ");
        System.out.println();


    }

    static void goodBye(){
        clearScrean();
        System.out.println("Thank you for using Smart Password Analyzer!");
        System.out.println("Stay safe and hack-proof!");

    }

}
