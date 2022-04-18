package com.example.callapitraining2.model

import com.google.gson.annotations.SerializedName

data class UsersItem(
    @SerializedName("email")
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String
)