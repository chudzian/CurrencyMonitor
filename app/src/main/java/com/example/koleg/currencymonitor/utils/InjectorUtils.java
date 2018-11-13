package com.example.koleg.currencymonitor.utils;

import android.content.Context;

public class InjectorUtils {
    public static FixerNetworkDataSource provideNetworkDataSource(Context context) {
        AppExecutors executors = AppExecutors.getInstance();
        return FixerNetworkDataSource.getInstance(context.getApplicationContext(), executors);
    }

    public static FixerRepository provideRepository(Context context) {
        FixerDatabase database = FixerDatabase.getInstance(context.getApplicationContext());
        AppExecutors executors = AppExecutors.getInstance();
        FixerNetworkDataSource networkDataSource =
                FixerNetworkDataSource.getInstance(context.getApplicationContext(), executors);
        return FixerRepository.getInstance(database.currencyDao(), networkDataSource, executors);
    }
}
