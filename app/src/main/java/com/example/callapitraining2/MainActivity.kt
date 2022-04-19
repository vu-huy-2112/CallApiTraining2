package com.example.callapitraining2

import android.os.Bundle
import android.widget.Adapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.callapitraining2.adapter.MyAdapter
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

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayout : LinearLayoutManager
    lateinit var recyclerView : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setHasFixedSize(true)
        linearLayout = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayout


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
                var responseBody = response.body()!!

                myAdapter = MyAdapter(baseContext, responseBody)

                recyclerView.adapter = myAdapter

            }

            override fun onFailure(call: Call<List<UsersItem>?>, t: Throwable) {

            }
        })


    }
}