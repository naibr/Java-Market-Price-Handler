package com.nology;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class PriceRepository {

    private List<Price> priceList = new ArrayList<>();
    private List<Price>clientPriceList = new ArrayList<>();

    public PriceRepository() {
    }

    public List<Price> getPriceList() {
        return priceList;
    }

    public List<Price> getClientPriceList() {
        return clientPriceList;
    }

    public void addPrice(Price price) {
        price.bidMargin(price.getBid());
        price.askMargin(price.getAsk());
        priceList.add(price);
    }


    public long convertDate(String Date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
        Date date = sdf.parse(Date);
        long millis = date.getTime();
        return millis;
    }

    public List<Price> addPricesToClientList () {
        clientPriceList.addAll(priceList);
        return clientPriceList;
    }


    public List<Price> removeDuplicatesFromPriceList() throws ParseException {
        for (int i = 0; i < priceList.size(); i++) {
            String name = priceList.get(i).getInstrumentName();
            String nameDate = priceList.get(i).getTimestamp();
            long date1Millis = convertDate(nameDate);
            for (Price price : priceList) {
                if (name.equals(price.getInstrumentName())) {
                    String nameDate2 = price.getTimestamp();
                    long date2Millis = convertDate(nameDate2);
                    if (date1Millis > date2Millis) {
                        clientPriceList.remove(price);
                    }
                }
            }
        }
        return clientPriceList;
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

    public boolean isValidPrice(List<Price> list) {
        for (int i = 0; i <list.size(); i++) {
            if (list.get(i).getAsk() > list.get(i).getBid()) {
                return true;
            }

        }
        return false;
    }



}
