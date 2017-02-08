package com.eudge_000.workwithgitapi.base;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public abstract class BaseRemoteDataSource implements BaseDataSource {

    protected ReposService reposService = null;
    static final protected String BASE_URL = "https://api.github.com/";

    @Override
    public void init(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
        reposService = retrofit.create(ReposService.class);
    }


}