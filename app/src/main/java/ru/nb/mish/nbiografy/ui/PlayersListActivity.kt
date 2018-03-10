package ru.nb.mish.nbiografy.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_players_list.*
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.adapters.PlayerAdapter
import ru.nb.mish.nbiografy.components.IntentHelper
import ru.nb.mish.nbiografy.models.Player

class PlayersListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players_list)

        rvPlayers.layoutManager=LinearLayoutManager(this)

        rvPlayers.adapter = PlayerAdapter(arrayListOf(Player(R.drawable.icon_bailly, getString(R.string.TvBailly)), Player(R.drawable.icon_blind, getString(R.string.TvBlind))))

    }
}