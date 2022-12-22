package com.android_python_integaration

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var btnExcute: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this));
        }

        textView = findViewById(R.id.txtView)
        btnExcute = findViewById(R.id.btnExecute)

        btnExcute.setOnClickListener {
            val pyObject = Python.getInstance().getModule("sample")
            val result = pyObject.callAttr("main").toString()
            textView.text = result

        }
    }
}