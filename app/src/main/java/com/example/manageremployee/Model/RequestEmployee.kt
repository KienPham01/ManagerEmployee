package com.example.manageremployee.Model

import android.util.Log
import com.example.manageremployee.Interface.OnRequest
import com.example.manageremployee.RetrofitCommon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RequestEmployee(private val onRequest: OnRequest) {

    lateinit var request: Call<ModelTest>

    fun request() {
        request = RetrofitCommon.apiService.loadData()

        request.enqueue(object : Callback<ModelTest> {
            override fun onFailure(call:  Call<ModelTest>, t: Throwable) {
                if (!request.isCanceled)
                    onRequest.onFail(t.toString())

                Log.d("State","Test not pass")

            }

            override fun onResponse(call: Call<ModelTest>, response: Response<ModelTest>) {
                val body = response.body()
                body?.let {
                    Log.d("State","Successful")

                    if (!request.isCanceled) {
                       onRequest.onDone(body.result)
                   }
                } ?: kotlin.run {
                    onRequest.onFail("Not Found")
                }

            }

        })
    }

    fun cancel() {
        request.cancel()
    }

}