package com.example.koleg.currencymonitor.utils;


import com.example.koleg.currencymonitor.model.Currency;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Converters {

    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    public static String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }


    public static List<Currency> mapToList(Map<String, Double> map){
        List<Currency> list = new ArrayList<>();
        for(Map.Entry<String,Double> entry: map.entrySet()){
            list.add(new Currency(entry.getKey(),entry.getValue()));
        }
        return list;
    }
}
