package com.example.vollay_libraries

import androidx.appcompat.app.AppCompatActivity

import android.nfc.Tag
import android.os.Bundle
import android.util.Log

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    //APIs
    // implementation 'com.android.volley:volley:1.1.1'
    // dependency add kro.

    // Aplication programing interface
    // its an middle man between the App and our server.
    // it get queries from client and after that he decide that
    // he should send response back or not.
    // and he get responce from server and send to our clients.
    // jo start me hum select krty hn k ktny device me run kry gi.
    // wo api level hota hain.
    // vollay get krti hai data and show krtin ha on server post method.
    // to is k lye server required hota h.
    // to fake api server net pr available hai usko use kr skty hn freely.
    // for practice k lye.
    // website jsonplaceholder.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val requestQueue: RequestQueue

        // make queue

        requestQueue = Volley.newRequestQueue(this)

        // now we make json array for get method
        // because we get from fake api so thats why used.
        // it will fetch data from server of jsonplaceholder.
        // below code will be get data from server.
        // ye general code hai ap isko use krky kisi bhi json ko use kr skty ho.

        /*
        * Run this code in a console or from any site:

fetch('https://jsonplaceholder.typicode.com/todos/1')
  .then(response => response.json())
  .then(json => console.log(json))
Try it

{
  "userId": 1,
  "id": 1,
  "title": "delectus aut autem",
  "completed": false
}
        *
        * */
        // uper wali example jo hai ye jsonplaceholder(server) ki hai.
        //       mny iska link paste kia hai.
        // or response waly function me object likha h e.g id.
        // tu after run krny k bad 4:Run me jana wahan iska data fetch ml jy ga.
        // lkn internet required hai.
        // server se data fetch kr k app isko display krwa skty hn.
        // or jtny bhi method hn get,post,pull sb isi code k zarye use kiye ja skty hn.
        // bs method change krna jasy
        // LINE 89 me Request.Method.GET,POST,DELETE,TRACE,HEAD,OPTION.


        // jsonplaceholder server link https://jsonplaceholder.typicode.com/todos/1:
        // random user api link search krna jo phly wali web ho usko open kr lena.
        //


        val jsonobjectRequest = JsonObjectRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos/1", null,
                Response.Listener { response ->
                    try {
          //             Log.d(" MYapp", "The response is:  " + response.getString("title"))
// GET DATA FROM SERVER VAR

                        val usrid = response.getInt("userId")
                     //   val d= response.getInt("id")
                        val tl = response.getString("title")
                        // val cmp = response.getBoolean("complected")

                        // DISPLAY DATA

                        uid.text = usrid.toString()
                       //outid.text = d.toString()
                        tit.text = tl.toString()
                        //compl.text = cmp.toString()

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }, Response.ErrorListener { })
        requestQueue.add(jsonobjectRequest)

    }
}


