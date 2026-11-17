package com.example.pulpargame

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.JavascriptInterface
import android.speech.tts.TextToSpeech
import java.util.Locale

class MainActivity : Activity(), TextToSpeech.OnInitListener {
    private lateinit var web: WebView
    private var tts: TextToSpeech? = null
    private var ready = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tts = TextToSpeech(this, this)
        web = WebView(this)
        web.settings.javaScriptEnabled = true
        web.webViewClient = WebViewClient()
        web.addJavascriptInterface(Voice(), "AndroidVoice")
        setContentView(web)
        web.loadUrl("file:///android_asset/index.html")
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale("gu", "IN"))
            ready = result != TextToSpeech.LANG_MISSING_DATA &&
                    result != TextToSpeech.LANG_NOT_SUPPORTED
        }
    }

    inner class Voice {
        @JavascriptInterface
        fun speak(message: String) {
            runOnUiThread {
                if (ready) {
                    tts?.speak(message, TextToSpeech.QUEUE_FLUSH, null, "voice")
                }
            }
        }
    }

    override fun onDestroy() {
        tts?.stop()
        tts?.shutdown()
        web.destroy()
        super.onDestroy()
    }
}
