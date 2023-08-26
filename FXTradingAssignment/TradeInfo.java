package FXTradingAssignment;

public class TradeInfo {
	private static int tradeCount = 0;

    private int tradeNumber;
    private String currencyPair;
    private String customerName;
    private double amount;
    private double rate;

    public TradeInfo(String currencyPair, String customerName, double amount, double rate) {
        this.tradeNumber = ++tradeCount;
        this.currencyPair = currencyPair;
        this.customerName = customerName;
        this.amount = amount;
        this.rate = rate;
    }

    public void displayTradeInfo() {
        System.out.printf("%d       %-8s      %-8s     INR%-10.2f  %.2f %n",
                          tradeNumber, currencyPair, customerName, amount, rate);
    }

}
