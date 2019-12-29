package com.ryx.rxjavatest.api;

import com.ryx.rxjavatest.Comment;
import com.ryx.rxjavatest.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("posts")
    Observable<List<Post>> getPosts();

    @GET("posts/{id}/comments")
    Observable<List<Comment>> getComments(
            @Path("id") int id
    );
}
