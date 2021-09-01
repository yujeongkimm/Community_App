package org.techtown.mysolelife.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import org.techtown.mysolelife.R

class ContentShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_show)

        val url = intent.getStringExtra("url")
        val webView = findViewById<WebView>(R.id.webView)

        webView.loadUrl(url.toString())
    }
}