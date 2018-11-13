package com.example.koleg.currencymonitor.activities;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.koleg.currencymonitor.model.Currency;

public class DetailActivityViewModel extends ViewModel {

    private MutableLiveData<Currency> currencies;

    public DetailActivityViewModel() {
        currencies = new MutableLiveData<>();
    }

    public MutableLiveData<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currency currency) {
        currencies.postValue(currency);
    }
}
