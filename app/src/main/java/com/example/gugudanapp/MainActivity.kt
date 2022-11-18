package com.example.gugudanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var btn5 : Button;

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var edt1 = findViewById<EditText>(R.id.edt1);
        var edt2 = findViewById<EditText>(R.id.edt2);
        var btn1 = findViewById<Button>(R.id.btn1);
        var btn2 = findViewById<Button>(R.id.btn2);
        var btn3 = findViewById<Button>(R.id.btn3);
        var btn4 = findViewById<Button>(R.id.btn4);

        var tv1  = findViewById<TextView>(R.id.tv1);

        btn5 = findViewById(R.id.btn5);

        btn1.setOnClickListener { 
            var num1 = edt1.text.toString();
            var num2 = edt2.text.toString();

            //var num2 = edt2.getText().toString();
            //var res = Integer.parseInt(num1) + Integer.parseInt(num2);
            var res = num1.toInt() + num2.toInt();

            //tv1.setText(res);
            //tv1.text = res.toString();
            tv1.text = "계산결과:" + res;

        }

        btn2.setOnClickListener {
            var num1 = edt1.text.toString();
            var num2 = edt2.text.toString();

            var res = num1.toInt() - num2.toInt();
            tv1.text = "계산결과:" + res;
        }

        btn3.setOnClickListener {
            var num1 = edt1.text.toString();
            var num2 = edt2.text.toString();

            var res = num1.toInt() * num2.toInt();
            tv1.text = "계산결과:" + res;
        }

//        btn4.setOnClickListener {
//
//            Toast.makeText(this,"나누기 입니다",Toast.LENGTH_SHORT).show();
//
//            var num1 = edt1.text.toString();
//            var num2 = edt2.text.toString();
//
//            var res = num1.toInt() / num2.toInt();
//            tv1.text = "계산결과:" + res;
//        }

        btn4.setOnTouchListener { view, motionEvent ->
            var num1 = edt1.text.toString();
            var num2 = edt2.text.toString();

            if(num1.trim() == "" || num2.trim() == "")
            {
                Toast.makeText(this,"빈값있음!",Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(num2.trim() == "0")
                {
                    Toast.makeText(this,"0으로 나눌수 없습니다",Toast.LENGTH_SHORT).show();
                    return@setOnTouchListener false;
                }

                var res = num1.toDouble() / num2.toDouble();
                res = (res*100).toInt()/100.0;

                tv1.text = "계산결과:" + res;
            }

            false;
        }

        btn5.setOnTouchListener { view, motionEvent ->
            //Toast.makeText(this,"나누기 입니다",Toast.LENGTH_SHORT).show();

            var num1 = edt1.text.toString();
            var num2 = edt2.text.toString();

            if(num1.trim() == "" || num2.trim() == "")
            {
                Toast.makeText(this,"빈값있음!",Toast.LENGTH_SHORT).show();
            }
            else
            {
                var res = num1.toInt() % num2.toInt();
                tv1.text = "계산결과:" + res;
            }

            false;
        }


    }
}