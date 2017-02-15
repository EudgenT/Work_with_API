package com.eudge_000.workwithgitapi.flow.repos.mvp;

import android.content.Context;

import com.eudge_000.workwithgitapi.model.Repo;

import java.util.List;

public interface ReposView {

    void showRepos(List<Repo> repos);
    Context getContext();
}
