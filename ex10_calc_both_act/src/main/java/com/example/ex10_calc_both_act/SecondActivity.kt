package com.example.ex10_calc_both_act

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        title = "Second 액티비티"

        Log.i("aaa", "3333333333")

        val inIntent = intent

        val calc = inIntent.getStringExtra("Calc")

        var calValue = 0
        if (calc == "+") {
            calValue = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0)
        } else if (calc == "-") {
            calValue = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0)
        } else if (calc == "*") {
            calValue = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0)
        } else {
            calValue = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0)
        }

        //val retValue = calValue

        val btn1 = findViewById<View>(R.id.btn1) as Button
        btn1.setOnClickListener {
            Log.i("aaa", "4444444")
            val outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", calValue)
            Log.i("aaa", "값--->"+calValue)
            setResult(AppCompatActivity.RESULT_OK, outIntent)
            finish()
        }
    }
}