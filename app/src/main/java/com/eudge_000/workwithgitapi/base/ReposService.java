package com.eudge_000.workwithgitapi.base;

import com.eudge_000.workwithgitapi.model.Repo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Single;

public interface ReposService {
    @GET("/users/{user}/repos")
    Single<List<Repo>> getRepos(@Path("user") String user);
}
