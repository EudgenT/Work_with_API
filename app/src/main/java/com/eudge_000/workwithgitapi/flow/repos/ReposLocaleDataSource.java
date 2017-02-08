package com.eudge_000.workwithgitapi.flow.repos;

import com.eudge_000.workwithgitapi.base.BaseLocaleDataSource;
import com.eudge_000.workwithgitapi.model.Repo;

import java.util.List;

import io.realm.RealmResults;
import rx.Single;

public class ReposLocaleDataSource extends BaseLocaleDataSource implements ReposDataSource {

    public Single saveRepos(List<Repo> list){
        realm.executeTransaction(realm -> {
            realm.copyToRealmOrUpdate(list);
        });
        return Single.just(list);
    }

    @Override
    public Single<List<Repo>> getRepos(String user) {
        return Single.create(subscriber -> {
            realm.executeTransaction(innerRealm -> {
                RealmResults<Repo> results = innerRealm.where(Repo.class).findAll();
                if (results == null) {
                    subscriber.onError(new Exception("vse ploho"));
                } else {
                    List<Repo> repos = innerRealm.copyFromRealm(results);
                    if (repos != null) {
                        subscriber.onSuccess(repos);
                    } else {
                        subscriber.onError(new Exception("vse ploho2"));
                    }
                }
            });
        });
    }

    @Override
    public void clearRepos() {

    }
}
