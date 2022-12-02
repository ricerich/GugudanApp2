package com.example.ex10_calc_both_act

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "메인 액티비티"

        Log.i("aaa", "1111111")

        val edtNum1 = findViewById<View>(R.id.edt1) as EditText
        val edtNum2 = findViewById<View>(R.id.edt2) as EditText
        val rdoGroup = findViewById<View>(R.id.rg1) as RadioGroup

        val btn1 = findViewById<View>(R.id.btn1) as Button
        btn1.setOnClickListener {
            val intent = Intent(applicationContext,  SecondActivity::class.java)

            Log.i("aaa", "222222222")

            when (rdoGroup.checkedRadioButtonId) {
                R.id.rdo1 -> intent.putExtra("Calc", "+")
                R.id.rdo2 -> intent.putExtra("Calc", "-")
                R.id.rdo3 -> intent.putExtra("Calc", "*")
                R.id.rdo4 -> intent.putExtra("Calc", "/")
                else -> {
                }
            }

            intent.putExtra("Num1", edtNum1.text.toString().toInt())
            intent.putExtra("Num2", edtNum2.text.toString().toInt())

            startActivityForResult(intent, 0)
        }
    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            Log.i("aaa", "555555555")
            val hap = data!!.getIntExtra("Hap", 0)
            Toast.makeText(applicationContext, "결과 :$hap",
                Toast.LENGTH_SHORT).show()
        }
    }

}
