package com.example.manageremployee.Adapter

import android.content.Context
import com.example.manageremployee.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.manageremployee.Model.ModelEmployee
import kotlinx.android.synthetic.main.row_item.view.*

class  RecycleViewAdapter(private val context: Context, private val listEmployee: ArrayList<ModelEmployee>):
    RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(context)
        var view: View? = null

        view =  layoutInflater.inflate(R.layout.row_item,p0,false)


        return  MyViewHolder(view)



    }

    override fun getItemCount(): Int {

        return  listEmployee.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val data = listEmployee[p1]
        val  view = p0.itemView

        if (data!= null)
        {

        createContent(data,view)

        }


    }
    private  fun  createContent(data:ModelEmployee,view: View){
        view.textName.text =  data.name
        view.textDate.text = data.date
        view.textGender.text = data.gender
        view.textRole.text = data.role

        if (data.gender =="Male")
        {
            view.imageName.setImageResource(R.drawable.ic_person_black_24dp)
        }else{
            view.imageName.setImageResource(R.drawable.tooltip_frame_dark)

        }
    }


    inner  class MyViewHolder(item: View):RecyclerView.ViewHolder(item)



}