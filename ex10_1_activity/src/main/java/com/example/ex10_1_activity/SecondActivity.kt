package com.example.ex10_1_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener{
            finish()
        }
    }
}