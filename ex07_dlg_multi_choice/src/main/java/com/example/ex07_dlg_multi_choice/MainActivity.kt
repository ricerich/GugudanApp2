package com.example.ex07_dlg_multi_choice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 = findViewById<View>(R.id.button1) as Button

        var checkArray = booleanArrayOf(false,false,false)
        btn1.setOnClickListener {

            var versionArray = arrayOf("오레오","파이","큐")
//            var checkArray = booleanArrayOf(true,false,false)

            var dlg = AlertDialog.Builder(this)
            dlg.setTitle("좋아하는 버전은?")
            dlg.setIcon(R.mipmap.ic_launcher)
            //내용

            dlg.setMultiChoiceItems(versionArray,checkArray){dialog, position, isChecked ->
//                btn1.text = versionArray[position]
                var str1 : String = ""
                var cnt = 0;
                for(i in 0..versionArray.size-1)
                {
                    if(checkArray[i])
                    {
                        cnt++;
                        if(cnt == 1)
                            str1 = versionArray[i]
                        else
                            str1 = str1 + "," + versionArray[i]
                    }
                }
                btn1.text = str1
            }

            dlg.setPositiveButton("닫기",null)
            dlg.show()
        }
    }
}






