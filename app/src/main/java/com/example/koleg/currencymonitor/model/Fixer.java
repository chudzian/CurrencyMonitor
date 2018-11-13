package com.example.koleg.currencymonitor.model;

        import com.example.koleg.currencymonitor.utils.Converters;

        import java.util.List;
        import java.util.Map;

public class Fixer {
    private String date;

    public String getDate() {
        return date;
    }

    private Map<String, Double> rates;

    public Map<String, Double> getRates() {
        return rates;
    }

    public List<Currency> getCurrencies() {
        return Converters.mapToList(getRates());
    }
}
