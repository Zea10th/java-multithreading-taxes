package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class Market implements Callable<String> {
    public static final int VALUES = 10;
    public static final int BANK_NOTE_TYPE = 100;
    private final TaxBase taxBase;
    private List<Long> transactions;

    public Market(TaxBase taxBase) {
        this.transactions = new ArrayList<>();
        this.taxBase = taxBase;
    }

    public void addTransaction() {
        this.transactions.add((long) BANK_NOTE_TYPE * (new Random().nextInt(VALUES) + VALUES));
    }

    @Override
    public String call() throws Exception {
        System.out.println("Calculating of market " + Thread.currentThread().getName() + " get started.");
        for (int i = 0; i < VALUES; i++) {
            addTransaction();
        }

        System.out.println("Calculating of market " + Thread.currentThread().getName() + " finished.");

        for (Long transaction : transactions) {
            taxBase.addTaxBase(Thread.currentThread().getName(), transaction);
        }

        return Thread.currentThread().getName();
    }
}
