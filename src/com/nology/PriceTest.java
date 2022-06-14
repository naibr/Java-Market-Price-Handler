package com.nology;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    private PriceRepository prices = new PriceRepository();
    private Price price1;
    private Price price2;
    private Price price3;



    @Test
    public void checkPricesAreInSequence_CheckPricesAreAllPresent() {
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
    public void AddAllPrice_RemoveDuplicates_ReturnsOnlyLatestPrices() throws ParseException {
//    Arrange
        Price price1 = new Price(1,"EUR/USD", 1.1000, 1.2000, "01/06/2020 12:01:01:001");
        Price price2 = new Price(2,"EUR/JPY", 119.60, 119.90, "01/06/2020 12:01:02:002");
        Price price3 = new Price(3,"GBP/USD", 1.2500, 1.2560, "01/06/2020 12:01:02:002");
        Price price4 = new Price(4,"GBP/USD", 1.2500, 1.2560, "01/06/2020 12:01:03:002");

        PriceRepository priceList = new PriceRepository();
        priceList.addPrice(price1);
        priceList.addPrice(price2);
        priceList.addPrice(price3);
        priceList.addPrice(price4);

//    Act
        priceList.addPricesToClientList();

//    Assert
        assertEquals(4, priceList.getClientPriceList().size());

//        Act
        priceList.removeDuplicatesFromPriceList();

//        Assert
        assertEquals(3, priceList.getClientPriceList().size());

    }


    @Test
    public void OnlyShowsLatestDate() throws ParseException {
//    Arrange
        Price price3 = new Price(3,"GBP/USD", 1.2500, 1.2560, "01/06/2020 12:01:02:002");
        Price price4 = new Price(4,"GBP/USD", 1.2500, 1.2560, "01/06/2020 12:01:03:002");

        PriceRepository priceList = new PriceRepository();
        priceList.addPrice(price3);
        priceList.addPrice(price4);
        // Act

        priceList.addPricesToClientList();
        priceList.removeDuplicatesFromPriceList();

        // Assert
        assertEquals("01/06/2020 12:01:03:002", priceList.getClientPriceList().get(0).getTimestamp());
    }

    @Test
    public void checkMarginIsAppliedToPriceWhenAddingToPriceList_CheckAskIsMoreThanBid() {
//        Arrange
        Price price1 = new Price(1,"EUR/USD", 1.1000, 1.2000, "01/06/2020 12:01:01:001");

        PriceRepository priceList = new PriceRepository();

//        Act
        priceList.addPrice(price1);

//    Assert
        assertEquals(1.0989, priceList.getPriceList().get(0).getBid());
        assertEquals(1.2012, priceList.getPriceList().get(0).getAsk());
        assertTrue(priceList.getPriceList().get(0).getAsk() > priceList.getPriceList().get(0).getBid());
    }




    @Test
    public void checkMarginIsAppliedToAllPricesInPriceList() {
//        Arrange
        Price price1 = new Price(1,"EUR/USD", 1.1000, 1.2000, "01/06/2020 12:01:01:001");
        Price price2 = new Price(2,"EUR/JPY", 119.60, 119.90, "01/06/2020 12:01:02:002");
        Price price3 = new Price(3,"GBP/USD", 1.2500, 1.2560, "01/06/2020 12:01:02:002");
        Price price4 = new Price(4,"GBP/USD", 1.2500, 1.2560, "01/06/2020 12:01:03:002");

        PriceRepository priceList = new PriceRepository();
        priceList.addPrice(price1);
        priceList.addPrice(price2);
        priceList.addPrice(price3);
        priceList.addPrice(price4);

//    Act
        priceList.isValidPrice(priceList.getPriceList());

//    Assert
        assertTrue(priceList.isValidPrice(priceList.getPriceList()));
    }

}