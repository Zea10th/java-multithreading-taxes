package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class TaxBase {
    private final Map<String, LongAdder> marketsTaxBase;

    public TaxBase() {
        this.marketsTaxBase = new HashMap<>();
    }

    public void addTaxBase(String name, Long transaction) {
        if(marketsTaxBase.containsKey(name)) {
            marketsTaxBase.get(name).add(transaction);
        } else {
            LongAdder adder = new LongAdder();
            adder.add(transaction);
            marketsTaxBase.put(name, adder);
        }
    }

    public void printMarketsTaxBase() {
        for (Map.Entry<String, LongAdder> entry : marketsTaxBase.entrySet()) {
            System.out.println("Market " + entry.getKey() + " provided this tax base: " + entry.getValue().sum());
        }
    }
}
