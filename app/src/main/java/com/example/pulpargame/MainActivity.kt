
package com.example.pulpargame

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : Activity() {

    private lateinit var web: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        web = WebView(this)
        setContentView(web)

        web.settings.javaScriptEnabled = true
        web.webViewClient = WebViewClient()

        web.loadUrl("file:///android_asset/index.html")
    }

    override fun onDestroy() {
        web.destroy()
        super.onDestroy(
            
        )
    }
}
