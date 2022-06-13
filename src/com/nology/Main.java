package com.nology;

public class Main {

    public static void main(String[] args) {

        Price price1 = new Price(1,"EUR/USD", 1.1000, 1.2000, "01/06/2020 12:01:01:001");
        Price price2 = new Price(2,"EUR/JPY", 119.60, 119.90, "01/06/2020 12:01:02:002");
        Price price3 = new Price(3,"GBP/USD", 1.2500, 1.2560, "01/06/2020 12:01:02:002");

        PriceRepository priceList = new PriceRepository();
        priceList.addPrice(price1);
        priceList.addPrice(price2);
        priceList.addPrice(price3);

        System.out.println(priceList.isListInSequence());
        System.out.println(priceList.hasAllPrices());
        System.out.println(priceList.checkIfValidList());
    }
}
