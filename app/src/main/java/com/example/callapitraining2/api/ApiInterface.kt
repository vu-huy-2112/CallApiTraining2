package com.example.callapitraining2.api

import com.example.callapitraining2.model.UsersItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("public/v2/users")
    fun getUser() : Call<List<UsersItem>>
}