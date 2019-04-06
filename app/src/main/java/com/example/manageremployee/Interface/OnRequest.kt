package com.example.manageremployee.Interface

import com.example.manageremployee.Model.ModelEmployee

interface  OnRequest{

    fun  onDone(listEmployee: ArrayList<ModelEmployee>)
    fun onFail(t:String)

}