package com.example.gugudanapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    lateinit var btn5 : Button;

    //internal var numbtnArr = ArrayList<Button>(10);

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main)
//        setContentView(R.layout.activity_main_table_layout)
        setContentView(R.layout.activity_main_grid_linear)
        setContentView(R.layout.activity_main_grid_only)
        var edt1 = findViewById<EditText>(R.id.edt1);
        var edt2 = findViewById<EditText>(R.id.edt2);
        var btn1 = findViewById<Button>(R.id.btn1);
        var btn2 = findViewById<Button>(R.id.btn2);
        var btn3 = findViewById<Button>(R.id.btn3);
        var btn4 = findViewById<Button>(R.id.btn4);

        var tv1  = findViewById<TextView>(R.id.tv1);

        btn5 = findViewById(R.id.btn5);

//        var numbtn0 = findViewById<Button>(R.id.btnNum0)
//        var numbtn1 = findViewById<Button>(R.id.btnNum1)
//        var numbtn2 = findViewById<Button>(R.id.btnNum2)
//        var numbtn3 = findViewById<Button>(R.id.btnNum3)
//        var numbtn4 = findViewById<Button>(R.id.btnNum4)
//        var numbtn5 = findViewById<Button>(R.id.btnNum5)
//        var numbtn6 = findViewById<Button>(R.id.btnNum6)
//        var numbtn7 = findViewById<Button>(R.id.btnNum7)
//        var numbtn8 = findViewById<Button>(R.id.btnNum8)
//        var numbtn9 = findViewById<Button>(R.id.btnNum9)

        //배열로 만들기
        var numbtnArr = ArrayList<Button>(10);

        var numbtnIDArr = arrayOf(R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4,
                                  R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9)



        for(i in 0..numbtnIDArr.size-1 step 1)
        {
//            numbtnArr[i] = findViewById<Button>(numbtnIDArr[i])
            numbtnArr.add(findViewById<Button>(numbtnIDArr[i]))
        }



        for(i in 0..numbtnArr.size-1 step 1) {
            numbtnArr[i].setOnClickListener {
                if (edt1.isFocused == true) {
                    var num = edt1.text.toString() + i
                    edt1.setText(num)
                } else if (edt2.isFocused == true) {
                    var num = edt2.text.toString() + i
                    edt2.setText(num)
                } else {
                    Toast.makeText(this, "에디트를 선택해 주세요!", Toast.LENGTH_SHORT).show()
                }
            }
        }


//        numbtn0.setOnClickListener {
//            if(edt1.isFocused)
//            {
//                var num = edt1.text.toString() + "0"
//                edt1.setText(num)
//            }
//            else if(edt2.isFocused)
//            {
//                var num = edt2.text.toString() + "0"
//                edt2.setText(num)
//            }
//            else
//            {
//                Toast.makeText(this, "에디트를 선택해 주세요!", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        numbtn1.setOnClickListener {
//            if(edt1.isFocused)
//            {
//                var num = edt1.text.toString() + "1"
//                edt1.setText(num)
//            }
//            else if(edt2.isFocused)
//            {
//                var num = edt2.text.toString() + "1"
//                edt2.setText(num)
//            }
//            else
//            {
//                Toast.makeText(this, "에디트를 선택해 주세요!", Toast.LENGTH_SHORT).show()
//            }
//        }

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