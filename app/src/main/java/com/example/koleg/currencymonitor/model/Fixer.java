package com.example.koleg.currencymonitor.model;

        import com.google.gson.annotations.SerializedName;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Map;

public class Fixer {
    private String date;

    public String getDate() {
        return date;
    }

    private Map<String,Double> rates;

    public Map<String, Double> getRates() {
        return rates;
    }

    public List<Currency> getCurrencies(){
        List<Currency> list = new ArrayList<>();
        for(Map.Entry<String,Double> entry: rates.entrySet()){
            Currency c = new Currency(entry.getKey(),entry.getValue(), getDate());
            list.add(c);
        }
        return list;
    }



    public class Currency{
        private String name;
        private Double value;
        private String date;

        public Currency(String name, Double value, String date) {
            this.name = name;
            this.value = value;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public Double getValue() {
            return value;
        }

        public String getDate() {
            return date;
        }
    }


}
