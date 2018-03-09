package ru.nb.mish.nbiografy.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.IntentHelper

class MainActivity : AppCompatActivity() { // наследуемся от AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun onClick (view:View) { // клик на эмблемы

        when (view.id) { // аналог switch


            R.id.IvTwit -> {
                val intent2 = Intent(this@MainActivity, WebViewActivity::class.java)
                        // передаем Title и ссылку
                        .putExtra(IntentHelper.EXTRA_TITLE, getString(R.string.web_twitter))
                        .putExtra(IntentHelper.EXTRA_URL,"https://twitter.com/MANUTD")
                startActivity(intent2)
            }

            R.id.IvGoogle -> {
                val intent2 = Intent(this@MainActivity, WebViewActivity::class.java)
                        .putExtra(IntentHelper.EXTRA_TITLE, getString(R.string.web_google))
                        .putExtra(IntentHelper.EXTRA_URL,"https://plus.google.com/+MANUTD")
                startActivity(intent2)
            }

            R.id.IvSiteMU -> {
                val intent2 = Intent(this@MainActivity, WebViewActivity::class.java)
                        .putExtra(IntentHelper.EXTRA_TITLE, getString(R.string.web_site))
                        .putExtra(IntentHelper.EXTRA_URL,"http://www.manutd.com")
                startActivity(intent2)
            }

            R.id.IvYoutube -> {
                val intent2 = Intent(this@MainActivity, WebViewActivity::class.java)
                        .putExtra(IntentHelper.EXTRA_TITLE, getString(R.string.web_youtube))
                        .putExtra(IntentHelper.EXTRA_URL,"https://www.youtube.com/channel/UCYF2FotHeGO6cNcldrTHN1g")
                startActivity(intent2)
            }
        }

    }

    fun onEmblemClick (view:View) { // отдельный клмк для главной иконки

        //val intent = Intent(this, MUChoicePlayers::class.java)
        // startActivity(intent)

    }

}