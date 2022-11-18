package com.example.ex04_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var tv1 = findViewById<TextView>(R.id.Text1)
        var tv2 = findViewById<TextView>(R.id.Text2)

        //var chk1 = findViewById<CheckBox>(R.id.ChkAgree)
        var sw1 = findViewById<Switch>(R.id.swAgree)


        var rg1 = findViewById<RadioGroup>(R.id.Rgroup1)

        var rdo1 = findViewById<RadioButton>(R.id.RdoDog)
        var rdo2 = findViewById<RadioButton>(R.id.RdoCat)
        var rdo3 = findViewById<RadioButton>(R.id.RdoRabbit)

//        var btn1 = findViewById<Button>(R.id.BtnOK)
        var iv1 = findViewById<ImageView>(R.id.ImgPet)

        var btn1 = findViewById<Button>(R.id.btn1);
        var btn2 = findViewById<Button>(R.id.btn2);

        sw1.setOnCheckedChangeListener { compoundButton, b ->
            //1.결과적으로 체크가 되었으면
            //2.결과적으로 체크가 해지 되었으면

            if(sw1.isChecked)
            {
                tv2.visibility =  View.VISIBLE
                rg1.visibility =  View.VISIBLE
                //btn1.visibility =  View.VISIBLE
                iv1.visibility =  View.VISIBLE
                btn1.visibility = View.VISIBLE
                btn2.visibility = View.VISIBLE
            }
            else
            {
                tv2.visibility =  View.INVISIBLE
                rg1.visibility =  View.INVISIBLE
                //btn1.visibility =  View.INVISIBLE
                iv1.visibility =  View.INVISIBLE
                btn1.visibility = View.INVISIBLE
                btn2.visibility = View.INVISIBLE

            }
        }

        rdo1.setOnClickListener {
            iv1.setImageResource(R.drawable.dog)
        }

        rdo2.setOnClickListener {
            iv1.setImageResource(R.drawable.cat)
        }

        rdo3.setOnClickListener {
            iv1.setImageResource(R.drawable.rabbit)
        }

//        btn1.setOnClickListener {
//            when(rg1.checkedRadioButtonId)
//            {
//                R.id.RdoDog -> iv1.setImageResource(R.drawable.dog)
//                R.id.RdoCat -> iv1.setImageResource(R.drawable.cat)
//                R.id.RdoRabbit -> iv1.setImageResource(R.drawable.rabbit)
//                else -> Toast.makeText(applicationContext,"동물을 선택해 주세요!", Toast.LENGTH_SHORT).show()
//            }
//        }

        btn1.setOnClickListener {
            finish()
        }

        btn2.setOnClickListener {
            tv2.visibility =  View.INVISIBLE
            rg1.visibility =  View.INVISIBLE
            //btn1.visibility =  View.INVISIBLE
            iv1.visibility =  View.INVISIBLE
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.INVISIBLE

            sw1.isChecked = false

            rg1.clearCheck()
            iv1.setImageResource(0)
        }

    }
}











