package com.eudge_000.workwithgitapi.flow.repos;

import com.eudge_000.workwithgitapi.base.BaseDataSource;

import rx.Single;

public interface ReposDataSource extends BaseDataSource {

    Single getRepos(String user);

    void clearRepos();

}
