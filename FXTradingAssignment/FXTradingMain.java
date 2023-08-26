package FXTradingAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FXTradingMain {
	private static List<TradeInfo> trades = new ArrayList<>();
    private static double usdToInrRate = 66.00; // Initial hard coded rate for USD to INR

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        while(true) {
            displayOptions();
            choice = input.nextInt();
            input.nextLine(); //newline

            switch (choice) {
                case 1:
                    bookTrade(input);
                    break;
                case 2:
                    printTrades();
                    break;
                case 3:
                    exitProgram(input);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void displayOptions() {
        System.out.println("Options:");
        System.out.println("1. Book Trade");
        System.out.println("2. Print Trades");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void bookTrade(Scanner scanner) {
        System.out.print("Enter customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Currency Pair: ");
        String currencyPair = scanner.nextLine();

        if (!currencyPair.equals("USDINR")) {
            System.out.println("Invalid currency pair. Please Enter USDINR to proceed transaction!");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // newline
        if(amount<=0) {
        	System.out.println("Enter valid amount!");
        	System.out.println();
        	return;
        }

        System.out.print("Do you want to get Rate (Yes/No): ");
        String rateChoice = scanner.nextLine();

        double rate = usdToInrRate; // Default rate
        double inrAmount = amount * rate; //inr amount
        if (rateChoice.equalsIgnoreCase("Yes")) {
            System.out.printf("You are transferring INR %.2f to %s. %n", inrAmount, customerName);
        }

        System.out.print("Book/Cancel this trade? (Book/Cancel): ");
        String action = scanner.nextLine();

        if (action.equalsIgnoreCase("Book")) {
            trades.add(new TradeInfo(currencyPair, customerName, inrAmount, rate));
            System.out.printf("Trade for %s has been booked with rate %.2f. %n", currencyPair, rate);
            System.out.printf("The amount of Rs %.2f will be transferred in 2 working days to %s. %n",
                              inrAmount, customerName);
            System.out.println();
        } else if (action.equalsIgnoreCase("Cancel")) {
            System.out.println("Trade is Canceled.");
        }
        else {
        	System.out.println("Trade is Canceled. Please enter Book to book yor transaction!");
        }
    }

    private static void printTrades() {
        if (trades.isEmpty()) {
            System.out.println("No trades booked yet.");
            return;
        }

        System.out.println("TradeNo CurrencyPair CustomerName  Amount         Rate");
        for (TradeInfo trade : trades) {
            trade.displayTradeInfo();
        }
    }

    private static void exitProgram(Scanner scanner) {
        System.out.print("Do you really want to exit (y/n): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("y")) {
            System.out.println("Bye - have a good day!");
            scanner.close();
            System.exit(0);
        }
        else if(confirmation.equalsIgnoreCase("n")){
            return;
        }
        else{
            System.out.println("Please enter Y or y to exit !!!");
        }
        
    }

}
