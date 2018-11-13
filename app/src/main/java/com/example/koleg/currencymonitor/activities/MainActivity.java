package com.example.koleg.currencymonitor.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.koleg.currencymonitor.model.Currency;
import com.example.koleg.currencymonitor.recyclerview.EndlessRecyclerViewScrollListener;
import com.example.koleg.currencymonitor.R;
import com.example.koleg.currencymonitor.recyclerview.CustomAdapter;
import com.example.koleg.currencymonitor.model.Fixer;
import com.example.koleg.currencymonitor.model.FixerService;
import com.example.koleg.currencymonitor.model.ServiceGenerator;
import com.example.koleg.currencymonitor.utils.InjectorUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EndlessRecyclerViewScrollListener scollListener;
    private List<Currency> currencies;
    private CustomAdapter adapter;
    private Calendar cal;
    private SimpleDateFormat sdf;
    private String date;
    private FixerService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currencies = new ArrayList<>();
        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.format(cal.getTime());

        service = ServiceGenerator.createService(FixerService.class);

        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        loadNextDataFromApi(0);

        scollListener = new EndlessRecyclerViewScrollListener((LinearLayoutManager) layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadNextDataFromApi(page);
            }
        };

        recyclerView.addOnScrollListener(scollListener);

    }

    public void loadNextDataFromApi(int days){
        cal.add(Calendar.DATE,days*(-1));
        date = sdf.format(cal.getTime());
        cal = Calendar.getInstance();
        Call<Fixer> call = service.listFixers(date);

        call.enqueue(new Callback<Fixer>() {
            @Override
            public void onResponse(Call<Fixer> call, Response<Fixer> response) {
                if(currencies.isEmpty()) {
                    currencies.addAll(response.body().getCurrencies());
                    adapter = new CustomAdapter(currencies);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else{
                    currencies.addAll(response.body().getCurrencies());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Fixer> call, Throwable t) {
                Log.d("failure", String.valueOf(t.getMessage()));
            }
        });
    }


}
