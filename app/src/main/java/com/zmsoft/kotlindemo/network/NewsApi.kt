package com.zmsoft.kotlindemo.network

import io.reactivex.Observable
import retrofit2.http.*

interface NewsApi {

    /**
     * 检查版本更新
     */
    @GET("top-headlines")
    fun getTopNews(@Query("country")country:String ,@Query("category")category:String
                   , @Query("apiKey")apiKey:String): Observable<NewsResult>
}