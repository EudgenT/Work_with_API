package com.eudge_000.workwithgitapi.base;

import android.content.Context;

import io.realm.Realm;

public abstract class BaseLocaleDataSource implements BaseDataSource{

    protected Realm realm = null;

    @Override
    public void init(Context context) {
        realm = Realm.getDefaultInstance();
    }
}
