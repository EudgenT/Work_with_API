package com.eudge_000.workwithgitapi.flow.repos;

import com.eudge_000.workwithgitapi.base.BaseDataSource;
import com.eudge_000.workwithgitapi.model.Repo;

import java.util.List;

import rx.Single;

public interface ReposDataSource extends BaseDataSource {

    Single<List<Repo>> getRepos(String user);

    void clearRepos();

}
