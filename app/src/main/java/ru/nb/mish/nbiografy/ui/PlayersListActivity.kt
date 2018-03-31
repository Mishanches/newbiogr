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
import ru.nb.mish.nbiografy.R.string.TvTitleChoicePlayer
import ru.nb.mish.nbiografy.adapters.PlayerAdapter
import ru.nb.mish.nbiografy.components.ImagesHelper
import ru.nb.mish.nbiografy.components.IntentHelper
import ru.nb.mish.nbiografy.components.OnItemClickListener
import ru.nb.mish.nbiografy.models.Coach
import ru.nb.mish.nbiografy.models.Player


class PlayersListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players_list)

        rvPlayers.layoutManager = GridLayoutManager(this, 1)
        // подключаем RecView(это RecycleView из activity_players_list.xml)
        // к этому RecView "добавляем" layoutManager, в котором есть несколько разновидностей, один из
        // них - GridLayoutManager, который  отвечает за кол-во столбцов

        // вызываем метод смены кол-ва столбцов в завиисимости от ориентации экрана
        // метод указываем при создании активити (ниже, после onCreate - сам этот метод, тут он только вызывается)
        updateSpanCount(resources.configuration.orientation)


        // устанавливаем горизонт разделитель между игроками в RyecycleView
        rvPlayers.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        // к адаптеру подкдючаем иконки футболистов, их имена (и прочие элементы, которые нам понадобятся уже НЕ для этого листа)
        // тут мы просто указали Адаптер, из него можно брать любые данные, не обязательно все сразу,
        // например, для активности с игроками на красном фоне мы берем из адаптера только Иконку и Имя
        rvPlayers.adapter = PlayerAdapter(arrayListOf(
                Player(R.drawable.icon_bailly, getString(R.string.TvBailly), R.drawable.anfas_bailly, getString(R.string.TvBaillyBiografy),
                        ImagesHelper.IMAGES_BAILLY ),
                Player(R.drawable.icon_blind, getString(R.string.TvBlind), R.drawable.anfas_blind,getString(R.string.TvBlindBiografy),
                        ImagesHelper.IMAGES_BLIND),
                Player(R.drawable.icon_carrick, getString(R.string.TvCarrick), R.drawable.anfas_carrick,getString(R.string.TvCarrickBiografy),
                        ImagesHelper.IMAGES_CARRICK),
                Player(R.drawable.icon_darmian, getString(R.string.TvDarmian), R.drawable.anfas_darmian,getString(R.string.TvDarmianBiografy),
                        ImagesHelper.IMAGES_DARMIAN),
                Player(R.drawable.icon_david_de_gea, getString(R.string.TvGea), R.drawable.anfas_de_gea,getString(R.string.TvDeGeaBiografy),
                        ImagesHelper.IMAGES_DEGEA),
                Player(R.drawable.icon_fell, getString(R.string.TvFellaini), R.drawable.anfas_fell,getString(R.string.TvFellainiBiografy),
                        ImagesHelper.IMAGES_FELLAINI),
                Player(R.drawable.icon_herrera, getString(R.string.TvHerrera), R.drawable.anfas_herrera,getString(R.string.TvHerreraBiografy),
                        ImagesHelper.IMAGES_HERRERA),
                Player(R.drawable.icon_ibra, getString(R.string.TvIbragimovich), R.drawable.anfas_ibra,getString(R.string.TvIbraBiografy),
                        ImagesHelper.IMAGES_IBRA),
                Player(R.drawable.icon_shaw, getString(R.string.TvShaw), R.drawable.anfas_show,getString(R.string.TvShawBiografy),
                        ImagesHelper.IMAGES_SHAW),
                Player(R.drawable.icon_lindelof, getString(R.string.TvLindelof), R.drawable.anfas_lindelof,getString(R.string.TvLindelofBiografy),
                        ImagesHelper.IMAGES_LINDELOF),
                Player(R.drawable.icon_lingard, getString(R.string.TvLingrad), R.drawable.anfas_lingrad,getString(R.string.TvLingradBiografy),
                        ImagesHelper.IMAGES_LINGRAND),
                Player(R.drawable.icon_lukaku, getString(R.string.TvLukaku), R.drawable.anfas_lukaku,getString(R.string.TvLukakuBiografy),
                        ImagesHelper.IMAGES_LUKAKU),
                Player(R.drawable.icon_martial, getString(R.string.TvMartial), R.drawable.anfas_martial,getString(R.string.TvMartialBiografy),
                        ImagesHelper.IMAGES_MARTIAL),
                Player(R.drawable.icon_mata, getString(R.string.TvMata), R.drawable.anfas_mata,getString(R.string.TvMataBiografy),
                        ImagesHelper.IMAGES_MATA),
                Player(R.drawable.icon_matic, getString(R.string.TvMatic), R.drawable.anfas_matic,getString(R.string.TvMaticBiografy),
                        ImagesHelper.IMAGES_MATIC),
                Player(R.drawable.icon_phil_jones, getString(R.string.TvJones), R.drawable.anfas_jones,getString(R.string.TvJonesBiografy),
                        ImagesHelper.IMAGES_JONES),
                Player(R.drawable.icon_pogba, getString(R.string.TvPogba), R.drawable.anfas_pogba,getString(R.string.TvPogbaBiografy),
                        ImagesHelper.IMAGES_POGBA),
                Player(R.drawable.icon_rashford, getString(R.string.TvRashford), R.drawable.anfas_rashford,getString(R.string.TvRashfordBiografy),
                        ImagesHelper.IMAGES_RASHFORD),
                Player(R.drawable.icon_rojo, getString(R.string.TvRojo), R.drawable.anfas_rojo,getString(R.string.TvRojoBiografy),
                        ImagesHelper.IMAGES_ROJO),
                Player(R.drawable.icon_romero, getString(R.string.TvRomero), R.drawable.anfas_romero,getString(R.string.TvRomeroBiografy),
                        ImagesHelper.IMAGES_ROMERO),
                Player(R.drawable.icon_sanchez, getString(R.string.TvSanchez), R.drawable.anfas_sanchez,getString(R.string.TvSanchezBiografy),
                        ImagesHelper.IMAGES_SANCHEZ),
                Player(R.drawable.icon_smalling, getString(R.string.TvSmalling), R.drawable.anfas_smolling,getString(R.string.TvSmallingBiografy),
                        ImagesHelper.IMAGES_SMALLING),
                Player(R.drawable.icon_valencia, getString(R.string.TvValencia), R.drawable.anfas_valencia,getString(R.string.TvValenciaBiografy),
                        ImagesHelper.IMAGES_VALENCIA),
                Player(R.drawable.icon_young, getString(R.string.TvYoung), R.drawable.anfas_young,getString(R.string.TvYoungBiografy),
                        ImagesHelper.IMAGES_YOUNG)),

                object : OnItemClickListener<Player>{


            // обработчик нажатий по игрокам (на красном фоне)
            override fun onItemClick(item: Player) { //нажимаем на игрока
                startActivity(Intent(this@PlayersListActivity, PlayerDetailActivity::class.java)
                        // передаем данные в новую активность PlayerDetailActivity и
                        //вставляем информацию по конкретному игроку: Фото_анфас, биографию и галерея
                        .putExtra(IntentHelper.PHOTO_ID, item.anfasPhoto)
                        // IntentHelper.PHOTO_ID - это надпись (или идентификатор), а
                        // item.anfasPhoto - это из конструктора models.Player 3-ий элемент, который отвечает
                        // за подтягиваемую фотографию к фото анфас
                        .putExtra(IntentHelper.BIOGRAFY, item.biografyText)
                        // тут аналогично: IntentHelper.BIOGRAFY - это надпись (или идентификатор)
                        // item.biografyText - 4-ый элемент из конструктора, который отвечает за текст биографии
                        .putExtra(IntentHelper.IMAGE_GALLERY, item.imagesList))
                // item.imagesList - 5-ый элемент из конструктора, отвечающий за список ссылок на фото (ArrayList)
            }
        })

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // кнопка назад наверху
        supportActionBar?.setTitle(getString(TvTitleChoicePlayer)) // устанавливаем новый Title для страницы

    }

    // метод смены кол-ва столбцов в зависимости от ориент. экрана ПРИ ЗАПУСКЕ приложения
    fun updateSpanCount(orientation: Int?) {
        when(orientation) {
            // если горизонт. экран , то кол-во столбцов 2, если верт. - 1
             Configuration.ORIENTATION_LANDSCAPE -> (rvPlayers.layoutManager as GridLayoutManager).spanCount=2
             Configuration.ORIENTATION_PORTRAIT-> (rvPlayers.layoutManager as GridLayoutManager).spanCount=1
        }
    }


     // метод, когда вращается экран уже в запущеном приложении
    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        updateSpanCount(newConfig?.orientation)
    }

    override fun onSupportNavigateUp(): Boolean { // функция кнопки назад
        onBackPressed()
        return true

    }

}