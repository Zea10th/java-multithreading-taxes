package org.example;

import java.util.List;
import java.util.Map;

public class TaxBase {
    private Map<String, List<Integer>> marketsTaxBase;

    public synchronized void addTaxBase(String name, List transactions) {
        this.marketsTaxBase.put(name, transactions);
    }

    public void printMarketsTaxBase() {
        for(Map.Entry<String, List<Integer>> entry : marketsTaxBase.entrySet()) {
            System.out.println("Market " + entry.getKey() + " provided these transactions:");

            for (Integer transaction : entry.getValue()) {
                System.out.println("\t" + transaction);
            }
        }
    }
}
