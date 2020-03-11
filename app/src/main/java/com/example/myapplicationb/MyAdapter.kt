package com.example.myapplicationb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.example_item.view.*

class MyAdapter (val context: Context,val list: List<ExampleItem>)
    : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.example_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item: ExampleItem = list[position]
        Glide.with(context).load(list[position].imageResource).into(holder.image)
        holder.text1.text = list[position].text1
        holder.text2.text = list[position].text2
    }

    override fun getItemCount(): Int = list.size


    class MyHolder(v: View) : RecyclerView.ViewHolder(v){
        val image: ImageView = v.image_view
        val text1: TextView = v.text_view_1
        val text2: TextView = v.text_view_2
    }
}