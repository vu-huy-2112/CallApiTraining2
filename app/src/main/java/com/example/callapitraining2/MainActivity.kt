package com.example.callapitraining2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.callapitraining2.api.ApiInterface
import com.example.callapitraining2.model.UsersItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

const val BASE_URL = "https://gorest.co.in/"
class MainActivity : AppCompatActivity() {

    private lateinit var tvID : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvID = findViewById(R.id.tvID)
        getData()
    }

    private fun getData() {

        // khoi tao retrofit
        val retrofitBuiler = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuiler.getUser()

        retrofitData.enqueue(object : Callback<List<UsersItem>?>{
            override fun onResponse(call: Call<List<UsersItem>?>, response: Response<List<UsersItem>?>) {

                val responseBody = response.body()!!

                val stringBundle = StringBuilder()
                for (myData in responseBody){
                    stringBundle.append(myData.email)
                    stringBundle.append("\n")
                }
                tvID.text = stringBundle
            }

            override fun onFailure(call: Call<List<UsersItem>?>, t: Throwable) {

            }
        })


    }
}