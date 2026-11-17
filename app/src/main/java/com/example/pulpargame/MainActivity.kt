
package com.example.pulpargame

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class MainActivity : Activity() {
    private lateinit var web: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            web = WebView(this)
            setContentView(web)

            web.settings.javaScriptEnabled = true
            web.settings.domStorageEnabled = true
            web.webViewClient = WebViewClient()

            web.loadUrl("file:///android_asset/index.html")
        } catch (e: Exception) {
            Toast.makeText(
                this,
                e.message ?: "App error",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onDestroy() {
        if (::web.isInitialized) {
            web.destroy()
        }
        super.onDestroy()
    }
}
