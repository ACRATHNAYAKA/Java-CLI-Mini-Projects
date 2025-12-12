import java.time.LocalDate;
import java.util.Date;

public class FinTrackCLI {
    private static double balance;
    private static double totalIncome;
    private static double totalExpenses;

    private static String [] MIAN_MENU = {"Add Income", "Add Expenses","Get Report","Exit"};
    public static void main(String[] args) {
        boolean appRunning = true;

        while (appRunning){
            clearScrean();
            drawMainMenu();
            appRunning = false;
        }
    }

    private static void drawMainMenu(){
        int i = 1;
        for (String item: MIAN_MENU){
            System.out.println("["+i+"] "+item);
            i+=1;
        }
    }

    private static void dashBord(String userName, double total) {
        LocalDate date = LocalDate.now();
        System.out.println("user : " + userName + "         " + "Date : " + date);
        System.out.println("__________________________________________________________");
        String balanceStatus = "";
        double balanceScore = balance / total * 100;
        if (balanceScore >= 75)
            balanceStatus = "Healthy";
        else if (balanceScore >= 40)
            balanceStatus = "Normal";
        else
            balanceStatus = "Week";

        System.out.println("Net Balance : "+balance+" ["+balanceStatus+"] ");

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
}
