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

        // поддержка javaScript
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        webView.webViewClient = object: WebViewClient() { // object: - создаем анонимный класс, унаследованный от WebViewClient()
            // и сразу присваиваем webView (который в activity_web_view.xml)

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


        // в onCreate "принимаем"
        // title сразу присваиваем строку, полученную от MainActivity (например, web_twitter)
        title = intent.getStringExtra(IntentHelper.EXTRA_TITLE)
        // в webView (который в activity_web_view.xml) загружаем интент, в котором получаем ссдку
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
