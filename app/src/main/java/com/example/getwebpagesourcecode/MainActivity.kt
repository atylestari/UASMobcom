package com.example.getwebpagesourcecode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    var https = "HTTP://"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getActionBar()?.setTitle("GET WEB page Source code");
        getSupportActionBar()?.setTitle("GET WEB page Source code");

        val spinner: Spinner = findViewById(R.id.sp_http)
        val reqbtn: Button = findViewById(R.id.btn)
        val text_url: EditText = findViewById(R.id.text_url)
        val textView: TextView = findViewById(R.id.tv)

        ArrayAdapter.createFromResource(
            this,
            R.array.array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        reqbtn.setOnClickListener {
            val queue = Volley.newRequestQueue(this)
            val url = spinner.selectedItem.toString()+ text_url.toString()

            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    textView.text = response.toString()
                },
                Response.ErrorListener { textView.text = "That didn't work!" })

            queue.add(stringRequest)
        }

    }
}