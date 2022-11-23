package com.example.ex06_3_tab_host

import android.app.TabActivity
import android.os.Bundle
import android.widget.TabHost
import android.widget.TabHost.TabSpec

@Suppress("deprecation")
class MainActivity : TabActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabHost = this.tabHost

        var tabSpec1 = tabHost.newTabSpec("TAB1").setIndicator("강아지")
        tabSpec1.setContent(R.id.iv1)
        tabHost.addTab(tabSpec1)

        var tabSpec2 = tabHost.newTabSpec("TAB2").setIndicator("고양이")
        tabSpec2.setContent(R.id.iv2)
        tabHost.addTab(tabSpec2)

        var tabSpec3 = tabHost.newTabSpec("TAB3").setIndicator("토끼")
        tabSpec3.setContent(R.id.iv3)
        tabHost.addTab(tabSpec3)

        var tabSpec4 = tabHost.newTabSpec("TAB4").setIndicator("말")
        tabSpec4.setContent(R.id.iv4)
        tabHost.addTab(tabSpec4)

        tabHost.currentTab = 1

//        var tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별")
//        tabSpecSong.setContent(R.id.tabSong)
//        tabHost.addTab(tabSpecSong)
//
//        var tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별")
//        tabSpecArtist.setContent(R.id.tabArtist)
//        tabHost.addTab(tabSpecArtist)
//
//        var tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별")
//        tabSpecAlbum.setContent(R.id.tabAlbum)
//        tabHost.addTab(tabSpecAlbum)
//
//        tabHost.currentTab = 0
    }
}
