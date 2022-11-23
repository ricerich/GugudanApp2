package com.example.ex06_webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit internal var edtUrl : EditText
    lateinit internal var btnGo : Button
    lateinit internal var btnBack : Button
    lateinit internal var web : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
        getSupportActionBar()!!.setIcon(R.drawable.web)

        edtUrl = findViewById<EditText>(R.id.edtUrl)
        btnGo = findViewById<Button>(R.id.btnGo)
        btnBack = findViewById<Button>(R.id.btnBack)

        web = findViewById<WebView>(R.id.webView1)

        web.webViewClient = CookWebViewClient()

        var webSet = web.settings
        webSet.builtInZoomControls = true

        btnGo.setOnClickListener {
            web.loadUrl(edtUrl.text.toString())
        }

        btnBack.setOnClickListener {
            web.goBack()
        }
    }

    class CookWebViewClient : WebViewClient()
    {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return super.shouldOverrideUrlLoading(view, url)
        }
    }

//    class CookWebViewClient : WebViewClient() {
//        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//            return super.shouldOverrideUrlLoading(view, url)
//        }
//    }
}
