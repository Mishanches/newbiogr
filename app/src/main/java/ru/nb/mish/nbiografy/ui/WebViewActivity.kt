package ru.nb.mish.nbiografy.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.IntentHelper

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
                if (url.contains("twitter.com") or url.contains("plus.google.com")
                        or url.contains("manutd.com") or url.contains("youtube.com")) {
                    return false
                }

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
                return true
            }
        }

        title = intent.getStringExtra(IntentHelper.EXTRA_TITLE)
        webView.loadUrl(intent.getStringExtra(IntentHelper.EXTRA_URL))
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && this.webView.canGoBack()) {
            this.webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}