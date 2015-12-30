package com.jianda.lesson3;

import com.jianda.lesson3.utils.Item;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Administrator on 15-12-29.
 */
public interface QsbkService {
    @GET("article/list/{type}")
    Call<List<Item>> getList(@Path("type") String type, @Query("page") int page);
//    Call<Response> getList(@Path("type") String type, @Query("page") int page);
}
