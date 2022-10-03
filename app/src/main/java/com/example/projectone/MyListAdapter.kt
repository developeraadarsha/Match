package com.example.projectone


import com.example.projectone.model.Results
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import java.util.ArrayList

class MyListAdapter(private val resultdata: ArrayList<Results>) :
    RecyclerView.Adapter<MyListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem =
            layoutInflater.inflate(R.layout.recycler_row_one, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = resultdata[position].name!!.first
        holder.gender.text = resultdata[position].gender
        holder.location.text = resultdata[position].location!!.country
    }

    override fun getItemCount(): Int {
        return resultdata.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var relativeLayout: RelativeLayout
        var name: TextView
        var gender: TextView
        var location: TextView

        init {
            relativeLayout = itemView.findViewById(R.id.rl_recycler_view_row)
            name = itemView.findViewById(R.id.tv_first_name)
            gender = itemView.findViewById(R.id.tv_second_gender)
            location = itemView.findViewById(R.id.tv_third_location)
        }
    }
}