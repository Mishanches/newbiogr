package ru.nb.mish.nbiografy.ui

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_players_list.*
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.adapters.PlayerAdapter
import ru.nb.mish.nbiografy.components.IntentHelper
import ru.nb.mish.nbiografy.components.OnItemClickListener
import ru.nb.mish.nbiografy.models.Coach
import ru.nb.mish.nbiografy.models.Player

class PlayersListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players_list)

        rvPlayers.layoutManager= GridLayoutManager(this, 1) // подключаем RecView из activity_players_list.xml
                // GridLayoutManager - отвечает за кол-во столбцов

        // вызываем метод при создании активити (ниже- сам этот метод, тут он только вызывается)
        updateSpanCount(resources.configuration.orientation)


        // устанавливаем горизонт разделитель между игроками в RyecycleView
        rvPlayers.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        // к адаптеру подкдючаем все иконки футболистов, их имена (и прочие элементы, которые нам понадобятся уже НЕ для этого листа)
        rvPlayers.adapter = PlayerAdapter(arrayListOf(
                Player(R.drawable.icon_bailly, getString(R.string.TvBailly), R.drawable.anfas_bailly,getString(R.string.TvBaillyBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_blind, getString(R.string.TvBlind), R.drawable.anfas_blind,getString(R.string.TvBlindBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_carrick, getString(R.string.TvCarrick), R.drawable.anfas_carrick,getString(R.string.TvCarrickBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_darmian, getString(R.string.TvDarmian), R.drawable.anfas_darmian,getString(R.string.TvDarmianBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_david_de_gea, getString(R.string.TvGea), R.drawable.anfas_de_gea,getString(R.string.TvDeGeaBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_fell, getString(R.string.TvFellaini), R.drawable.anfas_fell,getString(R.string.TvFellainiBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_herrera, getString(R.string.TvHerrera), R.drawable.anfas_herrera,getString(R.string.TvHerreraBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_ibra, getString(R.string.TvIbragimovich), R.drawable.anfas_ibra,getString(R.string.TvIbraBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_shaw, getString(R.string.TvShaw), R.drawable.anfas_show,getString(R.string.TvShawBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_lindelof, getString(R.string.TvLindelof), R.drawable.anfas_lindelof,getString(R.string.TvLindelofBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_lingard, getString(R.string.TvLingrad), R.drawable.anfas_lingrad,getString(R.string.TvLingradBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_lukaku, getString(R.string.TvLukaku), R.drawable.anfas_lukaku,getString(R.string.TvLukakuBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_martial, getString(R.string.TvMartial), R.drawable.anfas_martial,getString(R.string.TvMartialBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_mata, getString(R.string.TvMata), R.drawable.anfas_mata,getString(R.string.TvMataBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_matic, getString(R.string.TvMatic), R.drawable.anfas_matic,getString(R.string.TvMaticBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_phil_jones, getString(R.string.TvJones), R.drawable.anfas_jones,getString(R.string.TvJonesBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_pogba, getString(R.string.TvPogba), R.drawable.anfas_pogba,getString(R.string.TvPogbaBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_rashford, getString(R.string.TvRashford), R.drawable.anfas_rashford,getString(R.string.TvRashfordBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_rojo, getString(R.string.TvRojo), R.drawable.anfas_rojo,getString(R.string.TvRojoBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_romero, getString(R.string.TvRomero), R.drawable.anfas_romero,getString(R.string.TvRomeroBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_sanchez, getString(R.string.TvSanchez), R.drawable.anfas_sanchez,getString(R.string.TvSanchezBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_smalling, getString(R.string.TvSmalling), R.drawable.anfas_smolling,getString(R.string.TvSmallingBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_valencia, getString(R.string.TvValencia), R.drawable.anfas_valencia,getString(R.string.TvValenciaBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png")),
                Player(R.drawable.icon_young, getString(R.string.TvYoung), R.drawable.anfas_young,getString(R.string.TvYoungBiografy),
                        arrayListOf("http://mish-app.ru/images/Bailly1.png",
                                "http://mish-app.ru/images/Bailly2.png",
                                "http://mish-app.ru/images/Bailly3.png"))),

                object : OnItemClickListener<Player>{


            // обработчик нажатий BottomNavigation
            override fun onItemClick(item: Player) {
                startActivity(Intent(this@PlayersListActivity, PlayerDetailActivity::class.java)
                        //вставляем Фото_анфас и биографию b
                        .putExtra(IntentHelper.PHOTO_ID, item.anfasPhoto)
                        .putExtra(IntentHelper.BIOGRAFY, item.biografyText)
                        .putExtra(IntentHelper.IMAGE_GALLERY, item.imagesList))
            }
        })

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // кнопка назад наверху
        supportActionBar?.setTitle("Выбор игрока") // устанавливаем новый Title для страницы

    }

    // метод смены кол-ва столбцов в зависимости от ориент. экрана
    fun updateSpanCount(orientation: Int?) {
        when(orientation) {
            // если горизонт. экран , то кол-во столбцов 1, если верт. - 1
            Configuration.ORIENTATION_LANDSCAPE -> (rvPlayers.layoutManager as GridLayoutManager).spanCount=2
            Configuration.ORIENTATION_PORTRAIT-> (rvPlayers.layoutManager as GridLayoutManager).spanCount=1
        }
    }

     // метод, когда вращается текущий экран
    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        updateSpanCount(newConfig?.orientation)
    }

    override fun onSupportNavigateUp(): Boolean { // функция кнопки назад
        onBackPressed()
        return true

    }

}