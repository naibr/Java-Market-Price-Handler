package com.nology;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriceRepository {

    private List<Price> priceList = new ArrayList<>();

    public PriceRepository() {
    }

    public List<Price> getPrices() {
        return priceList;
    }

    public void addPrice(Price price) {
        priceList.add(price);
    }


    public boolean isListInSequence() {
        for (int i = 1; i < priceList.size(); i++) {
            int temp = priceList.get(i).getId();
            System.out.println(temp);
            if (temp > priceList.get(i + 1).getId()) {
                System.out.println("Not in sequence");
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean hasAllPrices() {
        int temp2 = priceList.get(priceList.size()-1).getId();
        System.out.println(temp2);
        if (priceList.size() != temp2) {
            System.out.println("Prices missing");
        } else {
            return true;
        }
        return false;
    }

    public int checkIfValidList() {
        if (isListInSequence() && hasAllPrices()) {
            return 1;
        }
        return 0;
    }



}
