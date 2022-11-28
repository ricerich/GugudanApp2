package com.example.ex07_jeju

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity()
{
    lateinit var edt1 : EditText
    lateinit var iv1 : ImageView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "제주도"

        edt1 = findViewById(R.id.edt1)
        iv1 = findViewById(R.id.iv1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        var mInflate = menuInflater
        mInflate.inflate(R.menu.menu1,menu)

        return super.onCreateOptionsMenu(menu)
    }



    companion object {
        var fAng: Float = 0.0f
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.itemRotate -> {
                fAng += edt1.text.toString().toFloat()
                iv1.rotation = fAng
                return true
            }

            R.id.item1 ->{
                iv1.setImageResource(R.drawable.jeju12)
                return true
            }
            R.id.item2 ->{
                iv1.setImageResource(R.drawable.jeju15)
                return true
            }
            R.id.item3 -> {
                iv1.setImageResource(R.drawable.jeju4)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}



