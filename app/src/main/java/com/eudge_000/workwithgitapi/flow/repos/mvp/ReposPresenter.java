package com.eudge_000.workwithgitapi.flow.repos.mvp;

import android.content.Context;

import com.eudge_000.workwithgitapi.flow.repos.ReposDataSource;
import com.eudge_000.workwithgitapi.flow.repos.ReposRepository;
import com.eudge_000.workwithgitapi.model.Repo;

import java.util.List;

import rx.Single;
import rx.internal.util.SubscriptionList;

public class ReposPresenter implements ReposDataSource {

    private ReposRepository mReposRepository = new ReposRepository();
    private ReposView mReposView;
    private SubscriptionList subscriptionList = new SubscriptionList();

    public void onAttach(ReposView view){
        mReposView = view;
        mReposRepository.init(view.getContext());
    }

    public void onDetach(){
        subscriptionList.unsubscribe();
    }

    @Override
    public Single<List<Repo>> getRepos(String user) {
         mReposRepository.getRepos(user)
                .subscribe(list -> {
                    mReposView.showRepos(list);
                }, Throwable::printStackTrace);
        return null;
    }

    @Override
    public void clearRepos() {
        mReposRepository.clearRepos();
    }

    @Override
    public void init(Context context) {

    }
}
