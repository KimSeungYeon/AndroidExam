package com.example.myapplicationb

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var que: RequestQueue
    lateinit var req: JsonObjectRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val random = Random
        var uselist = ArrayList<Int>(8)
        var list: List<ExampleItem> = ArrayList<ExampleItem>()
        for(i in 0 until 8)
            uselist.add(2)
        for(i in 0 until 16){
            var num: Int = random.nextInt(8)
            while (true) {
                if (uselist[num] == 0) {
                    num++
                    num%=8
                }
                else{
                    uselist[num]-=1
                    break
                }
            }
            when(num) {
                0 -> list += ExampleItem(R.drawable.a1, "1")
                1 -> list += ExampleItem(R.drawable.a2, "2")
                2 -> list += ExampleItem(R.drawable.a3, "3")
                3 -> list += ExampleItem(R.drawable.a4, "4")
                4 -> list += ExampleItem(R.drawable.a5, "5")
                5 -> list += ExampleItem(R.drawable.a6, "6")
                6 -> list += ExampleItem(R.drawable.a7, "7")
                7 -> list += ExampleItem(R.drawable.a8, "8")
            }
            Log.d("dd",num.toString()+"  "+uselist[num].toString())
        }
        recycler_view.adapter = MyAdapter(this,list)
        recycler_view.layoutManager = GridLayoutManager(this,4,GridLayoutManager.HORIZONTAL,false)
    }
}
