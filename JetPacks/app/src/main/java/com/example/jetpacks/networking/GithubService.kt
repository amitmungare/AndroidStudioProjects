package com.example.jetpacks.networking

import com.example.jetpacks.modals.User
import retrofit2.Response
import retrofit2.http.GET

class GithubService {
    interface GithubService {
        @GET("users")
        suspend fun getUsers(): Response<List<User>>
    }
}