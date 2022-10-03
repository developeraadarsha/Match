package com.example.projectone

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectone.model.ExampleJson2KtKotlin
import com.example.projectone.model.Results
import com.example.projectone.roomdb.DatabaseBuilder
import com.example.projectone.roomdb.DatabaseHelperImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    // Data Model Class
    private var myResultData = ArrayList<Results>()
    // Adapter
    private var myadapter: MyListAdapter? = null
    // Recycler View
    private lateinit var rv_first: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Recycler View
        rv_first = findViewById<RecyclerView>(R.id.rv_one_main)
        rv_first.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
        rv_first.setItemAnimator(DefaultItemAnimator())
        getDat1a()
    }

     private fun getDat1a() {
        val call: Call<ExampleJson2KtKotlin> = RetrofitHelper.getClient.getResults()
        call.enqueue(object : Callback<ExampleJson2KtKotlin> {

            override  fun onResponse(
                call: Call<ExampleJson2KtKotlin>?,
                response: Response<ExampleJson2KtKotlin>?
            ) {
                if (response?.body() != null) {
                    myResultData = response!!.body()?.results!!
                    Log.d("Size", "" + myResultData.size)
                    if (myResultData.size > 0) {
                        myadapter = MyListAdapter(myResultData)
                        rv_first.adapter = myadapter
                        // Initializing Room- DB
                        val dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
                        // Inserting all Data in Room DB


                        GlobalScope.launch {
                            dbHelper.insertAll(myResultData)
                        }


                    }
                }
            }

            override fun onFailure(call: Call<ExampleJson2KtKotlin>?, t: Throwable?) {
                Log.d("In get Data", "In funtion")
            }
        })
    }

}