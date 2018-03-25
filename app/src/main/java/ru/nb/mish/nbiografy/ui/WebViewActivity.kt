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

        val webSettings = webView.settings // поддержка javaScript
        webSettings.javaScriptEnabled = true

        webView.webViewClient = object: WebViewClient() { // object: - создаем анон. класс, унаследованный от WebViewClient()
            // и сразу присваиваем webView

            override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
                // все ссылки, в которых содержится названия сайтов
                // будут открываться внутри приложения
                if (url.contains("twitter.com") or url.contains("plus.google.com")
                        or url.contains("manutd.com") or url.contains("youtube.com")) {
                    return false
                }
                // все остальные ссылки - будет спрашивать: в каком браузере открывать
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
                return true
            }
        }

        title = intent.getStringExtra(IntentHelper.EXTRA_TITLE) // получаем title
        webView.loadUrl(intent.getStringExtra(IntentHelper.EXTRA_URL)) // и ссылку
    }


    // переопределяем кнопку назад
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && this.webView.canGoBack()) {
            this.webView.goBack()
            return true
        }


        return super.onKeyDown(keyCode, event)
    }
}
