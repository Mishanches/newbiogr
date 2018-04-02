package ru.nb.mish.nbiografy.ui

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.IntentHelper
import ru.nb.mish.nbiografy.onboarding.CustomIntro

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val t = Thread(object : Runnable {
            override fun run() {
                val getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(baseContext)

                val isFirstStart = getPrefs.getBoolean(this.toString(), true)

                if (isFirstStart) {
                    val i = Intent(this@MainActivity, CustomIntro::class.java)
                    startActivity(i)

                    val e = getPrefs.edit()
                    e.putBoolean(this.toString(), false)
                    e.apply()
                }
            }
        })

        t.start()

    }

    fun onClick (view:View) {

        when (view.id) {


            R.id.IvTwit -> {
                val intent2 = Intent(this@MainActivity, WebViewActivity::class.java)
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

    fun onEmblemClick (view:View) {

        val intent = Intent(this, PlayersListActivity::class.java)
         startActivity(intent)

    }

}