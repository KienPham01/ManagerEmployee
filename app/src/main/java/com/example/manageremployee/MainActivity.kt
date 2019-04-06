package com.example.manageremployee
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.manageremployee.Adapter.RecycleViewAdapter
import com.example.manageremployee.Interface.OnRequest
import com.example.manageremployee.Model.ModelEmployee
import com.example.manageremployee.Model.RequestEmployee
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  lateinit var requestContent:RequestEmployee
    private  var resultColection = ArrayList<ModelEmployee>()
    private lateinit var adapter:RecycleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = RecycleViewAdapter(this,resultColection)
        recycleView.adapter  =  adapter
        recycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        requestContent = RequestEmployee(onRequest)
        requestContent.request()


    }
    private  val onRequest  = object:OnRequest{

        override fun onDone(listEmployee: ArrayList<ModelEmployee>) {

            resultColection.clear()
            resultColection.addAll(listEmployee)
            adapter.notifyDataSetChanged()

        }

        override fun onFail(t: String) {
            runOnUiThread {
                Toast.makeText(this@MainActivity,t,Toast.LENGTH_LONG).show()
            }
        }

    }
}
