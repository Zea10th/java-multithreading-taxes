package org.example;

import java.util.List;
import java.util.ArrayList;

public class Market implements Runnable {
    public final static int VALUES = 10;
    public final static int BANK_NOTE_TYPE = 100;
    private List<Integer> transactions;
    private TaxBase taxBase;

    public Market(TaxBase taxBase) {
        this.transactions = new ArrayList();
        this.taxBase = taxBase;
    }

    public void addTransaction() {
        this.transactions.add(BANK_NOTE_TYPE * (int) (Math.random() * VALUES));
    }

    @Override
    public void run() {
        System.out.println("Calculating of market " + Thread.currentThread().getName() + " get started.");
        for (int i = 0; i < VALUES; i++) {
            addTransaction();
        }

        taxBase.addTaxBase(Thread.currentThread().getName(), this.transactions);

        System.out.println("Calculating of market " + Thread.currentThread().getName() + " finished.");
    }
}
