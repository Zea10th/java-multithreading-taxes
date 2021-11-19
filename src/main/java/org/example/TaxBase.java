package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxBase {
    private volatile Map<String, List<Integer>> marketsTaxBase;

    public TaxBase() {
        this.marketsTaxBase = new HashMap<>();
    }

    public void addTaxBase(String name, List<Integer> transactions) {
        this.marketsTaxBase.put(name, transactions);
        System.out.println("Market " + name + " had sent tax reporting.");
    }

    public void printMarketsTaxBase() {
        for (Map.Entry<String, List<Integer>> entry : marketsTaxBase.entrySet()) {
            System.out.println("Market " + entry.getKey() + " provided this tax base: " +
                    entry.getValue().stream().reduce(0, Integer::sum));
        }
    }
}
