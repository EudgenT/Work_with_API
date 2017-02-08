package com.eudge_000.workwithgitapi.flow.repos;

import com.eudge_000.workwithgitapi.base.BaseRemoteDataSource;
import com.eudge_000.workwithgitapi.model.Repo;

import java.util.List;

import rx.Single;

public class ReposRemoteDataSource extends BaseRemoteDataSource implements ReposDataSource {

    @Override
    public Single<List<Repo>> getRepos(String user) {
        return reposService.getRepos(user);
    }

    @Override
    public void clearRepos() {

    }
}
