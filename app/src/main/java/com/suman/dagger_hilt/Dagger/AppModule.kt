package com.suman.dagger_hilt.Dagger

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.suman.dagger_hilt.Network.ApiService
import com.suman.dagger_hilt.Utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun providesOkhttpClient():OkHttpClient=OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .build()
     @Provides
     @Singleton
    fun providesRetrofit():Retrofit = Retrofit.Builder()
            .baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit) : ApiService =
        retrofit.create(ApiService::class.java)
}