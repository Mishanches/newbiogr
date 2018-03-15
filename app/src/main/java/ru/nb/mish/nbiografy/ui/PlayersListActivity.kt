package ru.nb.mish.nbiografy.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_players_list.*
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.adapters.PlayerAdapter
import ru.nb.mish.nbiografy.components.OnItemClickListener
import ru.nb.mish.nbiografy.models.Coach
import ru.nb.mish.nbiografy.models.Player

class PlayersListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players_list)

        rvPlayers.layoutManager=LinearLayoutManager(this) // подключаем RecView

        // устанавливаем горизонт разделитель между игроками в RyecycleView
        rvPlayers.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        // к адаптеру подкдючаем все икоенки футболистов и их имена
        rvPlayers.adapter = PlayerAdapter(arrayListOf(
                Player(R.drawable.icon_bailly, getString(R.string.TvBailly)),
                Player(R.drawable.icon_blind, getString(R.string.TvBlind)),
                Player(R.drawable.icon_carrick, getString(R.string.TvCarrick)),
                Player(R.drawable.icon_darmian, getString(R.string.TvDarmian)),
                Player(R.drawable.icon_david_de_gea, getString(R.string.TvGea)),
                Player(R.drawable.icon_fell, getString(R.string.TvFellaini)),
                Player(R.drawable.icon_herrera, getString(R.string.TvHerrera)),
                Player(R.drawable.icon_ibra, getString(R.string.TvIbragimovich)),
                Player(R.drawable.icon_carrick, getString(R.string.TvCarrick)),
                Player(R.drawable.icon_lindelof, getString(R.string.TvLindelof)),
                Player(R.drawable.icon_lingard, getString(R.string.TvLingrad)),
                Player(R.drawable.icon_lukaku, getString(R.string.TvLukaku)),
                Player(R.drawable.icon_martial, getString(R.string.TvMartial)),
                Player(R.drawable.icon_mata, getString(R.string.TvMata)),
                Player(R.drawable.icon_matic, getString(R.string.TvMatic)),
                Player(R.drawable.icon_phil_jones, getString(R.string.TvJones)),
                Player(R.drawable.icon_pogba, getString(R.string.TvPogba)),
                Player(R.drawable.icon_rashford, getString(R.string.TvRashford)),
                Player(R.drawable.icon_rojo, getString(R.string.TvRojo)),
                Player(R.drawable.icon_romero, getString(R.string.TvRomero)),
                Player(R.drawable.icon_sanchez, getString(R.string.TvSanchez)),
                Player(R.drawable.icon_smalling, getString(R.string.TvSmalling)),
                Player(R.drawable.icon_valencia, getString(R.string.TvValencia)),
                Player(R.drawable.icon_young, getString(R.string.TvYoung))),
                object : OnItemClickListener<Player>{

            override fun onItemClick(item: Player) {
                Toast.makeText(this@PlayersListActivity, item.name, Toast.LENGTH_SHORT).show()
            }
        })

    }
}