package com.example.ex07_login


import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//    lateinit var tvName : TextView
//    lateinit var tvEmail : TextView
    lateinit var edtName : EditText
    lateinit var edtEmail : EditText
    lateinit var button1 : Button
    lateinit var dlgEdtName : EditText
    lateinit var dlgEdtEmail : EditText
    lateinit var toastText : TextView
    lateinit var dialogView : View
    lateinit var toastView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "사용자 정보 입력"
        edtName = findViewById<EditText>(R.id.edtName)
        edtEmail = findViewById<EditText>(R.id.edtEmail)
        button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {

            dialogView = View.inflate(this@MainActivity, R.layout.dialog1, null)

            dlgEdtName = dialogView.findViewById<EditText>(R.id.dlgEdt1)
            dlgEdtEmail = dialogView.findViewById<EditText>(R.id.dlgEdt2)

            dlgEdtName.setText(edtName.text.toString())
            dlgEdtEmail.setText(edtEmail.text.toString())


            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(R.drawable.ic_menu_allfriends)
            dlg.setView(dialogView)
            dlg.setPositiveButton("확인") { dialog, which ->
//                dlgEdtName = dialogView.findViewById<EditText>(R.id.dlgEdt1)
//                dlgEdtEmail = dialogView.findViewById<EditText>(R.id.dlgEdt2)

//                edtName.text = dlgEdtName.text.toString()
//                edtEmail.text = dlgEdtEmail.text.toString()

                edtName.setText(dlgEdtName.text.toString())
                edtEmail.setText(dlgEdtEmail.text.toString())

            }
            dlg.setNegativeButton("취소") { dialog, which ->
//                var toast = Toast(this@MainActivity)
//                toastView = View.inflate(this@MainActivity, R.layout.toast1,null)
//                toastText = toastView .findViewById<TextView>(R.id.toastText1)
//                toastText.text = "취소했습니다"
//                toast.view = toastView
//                toast.show()

                val toast = Toast(this@MainActivity)

                val display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
                val xOffset = (Math.random() * display.width).toInt()
                val yOffset = (Math.random() * display.height).toInt()

                toast.setGravity(Gravity.TOP or Gravity.LEFT, xOffset, yOffset)

                toastView = View.inflate(this@MainActivity, R.layout.toast1, null) as View
                toastText = toastView.findViewById<View>(R.id.toastText1) as TextView
                toastText.text = "취소했습니다"
                toast.view = toastView
                toast.show()
            }
            dlg.show()
        }
    }
}
