package com.example.manageremployee.Model

import retrofit2.http.GET
import retrofit2.http.Query

interface  Api{

    @GET("roomrent/employee")
    fun loadData():retrofit2.Call<ModelTest>

}