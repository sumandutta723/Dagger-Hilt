package com.suman.dagger_hilt.Network

import com.suman.dagger_hilt.Model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("users")
   suspend fun getPosts() : List<Post>
}