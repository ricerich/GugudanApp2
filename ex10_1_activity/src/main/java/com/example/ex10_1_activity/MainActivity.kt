package com.example.ex10_1_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rdoSecond = findViewById<RadioButton>(R.id.rdoSecond)
        var rdoThird = findViewById<RadioButton>(R.id.rdoThird)

        var btn1 = findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            var intent1 : Intent
            if(rdoSecond.isChecked){
                intent1 = Intent(this, SecondActivity::class.java);
                startActivity(intent1)
            }
            else if(rdoThird.isChecked){
                intent1 = Intent(this, ThirdActivity::class.java)
                startActivity(intent1)
            }
            else
                Toast.makeText(this, "선택해주세요", Toast.LENGTH_SHORT).show()

        }
    }
}