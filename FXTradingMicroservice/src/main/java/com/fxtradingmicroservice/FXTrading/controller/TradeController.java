package com.fxtradingmicroservice.FXTrading.controller;

import com.fxtradingmicroservice.FXTrading.model.TradeInfo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trades")
public class TradeController {

    private final List<TradeInfo> trades = new ArrayList<>();
    private final double usdToInrRate = 66.00;
    private int tradeCount = 0;

    @PostMapping("/book")
    public String bookTrade(@RequestBody TradeInfo tradeDetails) {
        String currencyPair = tradeDetails.getCurrencyPair();
        String customerName = tradeDetails.getCustomerName();
        double usdAmount = tradeDetails.getUsdAmount();

        if (!currencyPair.equalsIgnoreCase("USDINR")) {
            return "Invalid currency pair. Please enter USDINR to proceed with the transaction.";
        }

        if (usdAmount <= 0) {
            return "Please enter a valid amount.";
        }

        double rate = usdToInrRate;
        double inrAmount = usdAmount * rate;

        String rateInfoMsg = (tradeDetails.getRateChoice().equalsIgnoreCase("Yes")) ? "You are transferring INR " + inrAmount + " to " + customerName : "";

        if (tradeDetails.getConfirmation().equalsIgnoreCase("Book")) {
            TradeInfo tradeInfo = new TradeInfo(++tradeCount, currencyPair, customerName,usdAmount, inrAmount, rate, tradeDetails.getConfirmation());
            trades.add(tradeInfo);
            return tradeInfo.toString() + "\n" + rateInfoMsg + "\n" +
                    "Trade for " + currencyPair + " has been booked with rate " + rate + "\n" +
                    "The amount of Rs " + inrAmount + " will be transferred in 2 working days to " + customerName;
        } else if (tradeDetails.getConfirmation().equalsIgnoreCase("Cancel")) {
            return "Trade is Canceled.";
        }

        return "Invalid confirmation choice.";
    }

    @GetMapping("/list")
    public List<TradeInfo> listTrades() {
        return trades;
    }
}
