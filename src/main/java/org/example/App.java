package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static final int MARKET_AMOUNT = 3;

    public static void main(String[] args) {
        TaxBase taxBase = new TaxBase();
        ExecutorService executor = Executors.newFixedThreadPool(MARKET_AMOUNT);

        for (int i = 0; i < MARKET_AMOUNT; i++) {
            executor.submit(new Market(taxBase));
        }

    }
}
