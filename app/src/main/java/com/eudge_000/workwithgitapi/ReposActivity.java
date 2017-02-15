package com.eudge_000.workwithgitapi;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.eudge_000.workwithgitapi.flow.repos.mvp.ReposPresenter;
import com.eudge_000.workwithgitapi.flow.repos.mvp.ReposView;
import com.eudge_000.workwithgitapi.model.Repo;
import com.jakewharton.rxbinding.support.v7.widget.RxSearchView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.android.schedulers.AndroidSchedulers;

public class ReposActivity extends AppCompatActivity implements ReposView{

    private ReposPresenter mReposPresenter = new ReposPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);

        mReposPresenter.onAttach(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        RxSearchView.queryTextChanges(searchView)
                .debounce(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(query -> mReposPresenter.getRepos(query.toString()));
        return true;
    }

    @Override
    public void showRepos(List<Repo> repos) {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mReposPresenter.onDetach();
    }
}
