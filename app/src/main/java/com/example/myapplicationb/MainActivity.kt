package com.example.myapplicationb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var que: RequestQueue
    lateinit var req: JsonObjectRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list: List<ExampleItem> = ArrayList<ExampleItem>()

        que = Volley.newRequestQueue(this)
        val url = "http://newsapi.org/v2/top-headlines?country=kr&category=entertainment&apiKey=33a0109fc45646428b0d7096346dd5df"
        req = JsonObjectRequest(Request.Method.GET,url,null,
            Response.Listener {
                    response ->
                val jsonarray = response.getJSONArray("articles")
                for(i in 0 until jsonarray.length()) {
                    val title: String = jsonarray.getJSONObject(i)["title"].toString()
                    val content: String = jsonarray.getJSONObject(i)["description"].toString()
                    val imageurl: String = jsonarray.getJSONObject(i)["urlToImage"].toString()
                    list += ExampleItem(imageurl, title, content)
                }
                recycler_view.adapter = MyAdapter(this,list)
                recycler_view.layoutManager = LinearLayoutManager(this)
                recycler_view.setHasFixedSize(true)
            },Response.ErrorListener {
                Toast.makeText(this,"오류",Toast.LENGTH_LONG).show()
            })
        que.add(req)

    }
}
