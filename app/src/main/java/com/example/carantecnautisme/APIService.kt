package com.example.carantecnautisme

import com.example.carantecnautisme.models.PlongeeModel
import retrofit2.http.Body
import retrofit2.http.*
import retrofit2.Response
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    @GET("plongees")
    suspend fun getAllPlongees(): Response<MutableList<PlongeeModel>>

//    @GET("users")
//    suspend fun getUsers(): Response<MutableList<User>>
//
//    @GET("posts/{num}")
//    suspend fun getPostById(@Path("num") num : Int): Response<Post>
//
//    @GET("comments")
//    suspend fun getCommentsByPost(@Query("postId") postId : Int): Response<MutableList<Comment>>
//
//    @POST("posts")
//    suspend fun createPost(@Body post: Post): Response<Post>
}
