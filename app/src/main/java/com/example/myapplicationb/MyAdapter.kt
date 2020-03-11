package com.example.myapplicationb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

class MyAdapter (val context: Context,val list: List<ExampleItem>)
    : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.example_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        //Glide.with(context).load(list[position].imageResource).into(holder.image)
        holder.image.setImageResource(R.drawable.ic_android)
        holder.text1.text = list[position].text
        holder.image.setOnClickListener {
            //Glide.with(context).load(list[position].imageResource).into(holder.image)
            holder.image.setImageResource(list[position].imageResource)
            android.os.Handler().postDelayed({
                if(Pair.card == 0)
                    Pair.holder = holder
                Pair.card++

                //Toast.makeText(context,holder.image,Toast.LENGTH_SHORT).show()
                if( Pair.card == 2) {
                    Pair.card = 0
                    if(holder.text1.text == Pair.holder.text1.text){
                        holder.image.isClickable=false
                        Pair.holder.image.isClickable=false
                    }
                    else {

                        holder.image.setImageResource(R.drawable.ic_android)
                        Pair.holder.image.setImageResource(R.drawable.ic_android)
                        //Toast.makeText(context, "다른거에요 !!", Toast.LENGTH_SHORT).show()
                    }
                }
            },400)



        }
    }

    override fun getItemCount(): Int = list.size


    class MyHolder(v: View) : RecyclerView.ViewHolder(v){
        val image: ImageView = v.image_view
        val text1: TextView = v.text_view_1
    }
}