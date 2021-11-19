package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static final int MARKET_AMOUNT = 3;

    public static void main(String[] args) throws InterruptedException {
        TaxBase taxBase = new TaxBase();
        List<Market> markets = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(MARKET_AMOUNT);

        for (int i = 0; i < MARKET_AMOUNT; i++) {
            markets.add(new Market(taxBase));
        }

        executor.invokeAll(markets);

        taxBase.printMarketsTaxBase();

        executor.shutdownNow();
    }
}
