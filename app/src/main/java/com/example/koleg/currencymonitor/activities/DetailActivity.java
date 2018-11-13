package com.example.koleg.currencymonitor.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.koleg.currencymonitor.R;
import com.example.koleg.currencymonitor.utils.InjectorUtils;

import java.util.Currency;

public class DetailActivity extends AppCompatActivity {



    private TextView currency,value;
    private Currency cur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        cur = Currency.getInstance(intent.getStringExtra("CURRENCY"));

        currency = (TextView) findViewById(R.id.detail_textview_currency);
        value = (TextView) findViewById(R.id.detail_textview_value);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            currency.setText(cur.getDisplayName());
        } else{
            currency.setText(intent.getStringExtra("CURRENCY"));
        }
        value.setText(intent.getStringExtra("VALUE"));

    }

    private void bindCurrencyEntryToUi(com.example.koleg.currencymonitor.model.Currency currencyEntry) {

    }

}
