package com.example.koleg.currencymonitor.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.koleg.currencymonitor.activities.DetailActivity;
import com.example.koleg.currencymonitor.R;
import com.example.koleg.currencymonitor.model.Currency;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<Currency> currencies;


    public CustomAdapter(List<Currency> currencies) {
        this.currencies = currencies;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.value.setText(String.valueOf(currencies.get(i).getValue()));
        viewHolder.currency.setText(currencies.get(i).getName());
    }






    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView  value, currency;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            currency = (TextView) itemView.findViewById(R.id.rvitem_textview_currency);
            value = (TextView) itemView.findViewById(R.id.rvitem_textview_value);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("CURRENCY",currency.getText());
                    intent.putExtra("VALUE",value.getText());
                    context.startActivity(intent);
                }
            });
        }
    }

}

