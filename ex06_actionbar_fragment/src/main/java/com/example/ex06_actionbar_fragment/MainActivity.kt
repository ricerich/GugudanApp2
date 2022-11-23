package com.example.ex06_actionbar_fragment

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBar.Tab
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

@Suppress("deprecation")
class MainActivity : AppCompatActivity(), ActionBar.TabListener {
    lateinit var tab1 : Tab
    lateinit var tab2 : Tab
    lateinit var tab3 : Tab

    var myFrags = arrayOfNulls<MyTabFragment>(3);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        var bar = this.supportActionBar

        bar!!.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        tab1 = bar.newTab()
        tab1.text = "음악별"
        tab1.setTabListener(this)
        bar.addTab(tab1)

        tab2 = bar.newTab()
        tab2.text = "가수별"
        tab2.setTabListener(this)
        bar.addTab(tab2)

        tab3 = bar.newTab()
        tab3.text = "음악별"
        tab3.setTabListener(this)
        bar.addTab(tab3)
    }

    //내부 클래스
    class MyTabFragment : Fragment()
    {
        var tabName : String? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            var data = arguments
            tabName = data!!.getString("tabName")
        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
        {
            var param = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT)

            var baseLayout = LinearLayout(super.getActivity())
            baseLayout.orientation = LinearLayout.VERTICAL
            baseLayout.layoutParams = param

            if(tabName === "음악별")
                baseLayout.setBackgroundColor(Color.RED)
            if(tabName === "가수별")
                baseLayout.setBackgroundColor(Color.GREEN)
            if(tabName === "앨범별")
                baseLayout.setBackgroundColor(Color.BLUE)


            return baseLayout
        }
    }

    override fun onTabSelected(tab: Tab, ft: FragmentTransaction) {
        var myTabFrag : MyTabFragment? = null

        if(myFrags[tab.position] == null)
        {
            //프래그먼트 객체를 new 새로 만들어서, 사용하시고, 배열에 보관도 하자
            myTabFrag = MyTabFragment()
            var data = Bundle()
            data.putString("tabName", tab.text.toString())
            myTabFrag.arguments = data
            myFrags[tab.position] = myTabFrag
        }
        else //배열에서 꺼내라
        {
            myTabFrag= myFrags[tab.position]
        }

        ft.replace(android.R.id.content, myTabFrag!!)

    }

    override fun onTabUnselected(tab: Tab?, ft: FragmentTransaction?) {
    }

    override fun onTabReselected(tab: Tab?, ft: FragmentTransaction?) {
    }
}












