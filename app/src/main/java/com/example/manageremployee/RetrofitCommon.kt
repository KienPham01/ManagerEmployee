package com.example.manageremployee

import com.example.manageremployee.Adress.Adress
import retrofit2.Retrofit
import com.example.manageremployee.Model.Api
import retrofit2.converter.gson.GsonConverterFactory


class  RetrofitCommon{

    companion object {

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Adress.domain)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create Api Service
        val apiService = retrofit.create(Api::class.java)



    }

}

