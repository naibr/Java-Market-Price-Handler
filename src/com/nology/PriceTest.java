package com.nology;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    private PriceRepository prices = new PriceRepository();
    private Price price1;
    private Price price2;
    private Price price3;



    @Test
    public void checkPrices() {
        price1 = new Price(1, "EUR/USD", 1.1000, 1.2000, "01/06/2020 12:01:01:001");
        price2 = new Price(2, "EUR/JPY", 119.60, 119.90, "01/06/2020 12:01:02:002");
        price3 = new Price(3, "GBP/USD", 1.2500, 1.2560, "01/06/2020 12:01:02:002");
        prices.addPrice(price1);
        prices.addPrice(price2);
        prices.addPrice(price3);
//    Act
        prices.checkIfValidList();

//    Assert
        assertEquals(1, prices.checkIfValidList());
    }


    @Test
    public void hasLatestPrice() {
//    Arrange
        Price price1 = new Price(106,"EUR/JPY", 119.61, 119.91, "01/06/2020 12:01:012:110");

//    Act
        price1.showLatestPrice();

//    Assert
        assertEquals(119.91, price1.getAsk());
    }

    @Test
    public void validPrice() {
//        Arrange
        Price price1 = new Price(106,"EUR/JPY", 119.61, 119.91, "01/06/2020 12:01:012:110");

//    Act
        price1.isValidPrice();

//    Assert
        assertEquals(true, price1.isValidPrice());
    }


//    margin tests
    price1.bidMargin;
    price1.askMargin;



}