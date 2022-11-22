package com.example.ex06_reservation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var chrono : Chronometer
//    lateinit var btnStart : Button
//    lateinit var btnEnd : Button
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton
//    lateinit var calView : CalendarView
    lateinit var tPicker : TimePicker
    lateinit var tvYear : TextView
    lateinit var tvMonth : TextView
    lateinit var tvDay : TextView
    lateinit var tvHour : TextView
    lateinit var tvMinute : TextView
//    var selectYear : Int = 0
//    var selectMonth : Int = 0
//    var selectDay : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "시간 예약"

        // 버튼
//        btnStart = findViewById<Button>(R.id.btnStart)
//        btnEnd = findViewById<Button>(R.id.btnEnd)

        // 크로노미터
        chrono = findViewById<Chronometer>(R.id.chronometer1)

        var rg1 = findViewById<RadioGroup>(R.id.rg1)
        // 라디오버튼 2개
        rdoCal = findViewById<RadioButton>(R.id.rdoCal)
        rdoTime = findViewById<RadioButton>(R.id.rdoTime)

        // FrameLayout의 2개 위젯
        tPicker = findViewById<TimePicker>(R.id.timePicker1)
//        calView = findViewById<CalendarView>(R.id.calendarView1)
        var dPicker = findViewById<DatePicker>(R.id.datePicker1)

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        tvYear = findViewById<TextView>(R.id.tvYear)
        tvMonth = findViewById<TextView>(R.id.tvMonth)
        tvDay = findViewById<TextView>(R.id.tvDay)
        tvHour = findViewById<TextView>(R.id.tvHour)
        tvMinute = findViewById<TextView>(R.id.tvMinute)

        // 처음에는 2개를 안보이게 설정
        tPicker.visibility = View.INVISIBLE
//        calView.visibility = View.INVISIBLE
        dPicker.visibility = View.INVISIBLE
        rg1.visibility = View.INVISIBLE



        rdoCal.setOnClickListener {
            tPicker.visibility = View.INVISIBLE
//            calView.visibility = View.VISIBLE
            dPicker.visibility = View.VISIBLE
        }

        rdoTime.setOnClickListener {
            tPicker.visibility = View.VISIBLE
//            calView.visibility = View.INVISIBLE
            dPicker.visibility = View.INVISIBLE
        }

        // 타이머 설정
//        btnStart.setOnClickListener {
//            chrono.base = SystemClock.elapsedRealtime()
//            chrono.start()
//            chrono.setTextColor(Color.RED)
//        }

        chrono.setOnClickListener {
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            chrono.setTextColor(Color.RED)
            rg1.visibility = View.VISIBLE
        }



        // 버튼을 클릭하면 날짜,시간을 가져온다.
//        btnEnd.setOnClickListener {
//            chrono.stop()
//            chrono.setTextColor(Color.BLUE)
//
//            tvYear.text = Integer.toString(selectYear)
//            tvMonth.text = Integer.toString(selectMonth)
//            tvDay.text = Integer.toString(selectDay)

//
//            tvHour.text = Integer.toString(tPicker.currentHour)
//            tvMinute.text = Integer.toString(tPicker.currentMinute)
//        }

        tvYear.setOnLongClickListener {
            chrono.stop()
            chrono.setTextColor(Color.BLUE)

            tvYear.text = Integer.toString(dPicker.year)
            tvMonth.text = Integer.toString(dPicker.month+1)
            tvDay.text = Integer.toString(dPicker.dayOfMonth)

            tvHour.text = Integer.toString(tPicker.currentHour)
            tvMinute.text = Integer.toString(tPicker.currentMinute)

            tPicker.visibility = View.INVISIBLE
//        calView.visibility = View.INVISIBLE
            dPicker.visibility = View.INVISIBLE
            rg1.visibility = View.INVISIBLE

            false
        }

//        calView.setOnDateChangeListener { view, year, month, dayOfMonth ->
//            selectYear = year
//            selectMonth = month + 1
//            selectDay = dayOfMonth
//        }
    }
}
