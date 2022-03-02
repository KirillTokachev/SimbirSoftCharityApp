package com.example.simbirsoftsummerworkshop.network

import com.example.simbirsoftsummerworkshop.model.Datas
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface ServerApi {

    @GET("./categories")
    @Headers("Content-Type: application/json")
    fun getHelpCategoryList(): Single<List<Datas.HelpCategory>>

    @GET("./news")
    @Headers("Content-Type: application/json")
    fun getNewsList(): Single<List<Datas.News>>
}