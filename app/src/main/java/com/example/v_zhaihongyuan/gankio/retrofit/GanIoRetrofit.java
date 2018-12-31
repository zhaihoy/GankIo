package com.example.v_zhaihongyuan.gankio.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GanIoRetrofit {
    public static final String BaseURL = "http://gank.io/";
    public static Retrofit mRetrofit;

    public static Retrofit getGanKRetrofit() {

        if (mRetrofit == null) {
            synchronized (GanIoRetrofit.class) {
                mRetrofit = new Retrofit.Builder()
                        .baseUrl(BaseURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
            }
        }

        return mRetrofit;
    }
}
