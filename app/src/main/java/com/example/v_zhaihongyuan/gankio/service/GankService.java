package com.example.v_zhaihongyuan.gankio.service;

import com.example.v_zhaihongyuan.gankio.bean.GanHuo;

import java.util.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GankService {
    //get 请求
    @GET("api/data/{type}/{count}/{page}")
    rx.Observable<GanHuo> getGanHuo(
            @Path("type") String type,
            @Path("count") int count,
            @Path("page") int page
    );

}
