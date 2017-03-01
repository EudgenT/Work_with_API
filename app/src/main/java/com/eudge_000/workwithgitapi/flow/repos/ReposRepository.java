package com.eudge_000.workwithgitapi.flow.repos;

import android.content.Context;

import com.eudge_000.workwithgitapi.model.Repo;

import java.util.List;

import rx.Single;
import rx.android.schedulers.AndroidSchedulers;

public class ReposRepository implements ReposDataSource {

    private ReposLocaleDataSource mReposLocaleDataSource = new ReposLocaleDataSource();
    private ReposRemoteDataSource mReposRemoteDataSource = new ReposRemoteDataSource();

    @Override
    public Single<List<Repo>> getRepos(String user) {
        return mReposRemoteDataSource.getRepos(user)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(list -> mReposLocaleDataSource.saveRepos(list))
                .onErrorResumeNext(mReposLocaleDataSource.getRepos(user));
    }

    @Override
    public void clearRepos() {
        mReposLocaleDataSource.clearRepos();
    }

    @Override
    public void init(Context context) {
        mReposLocaleDataSource.init(context);
        mReposRemoteDataSource.init(context);
    }
}
