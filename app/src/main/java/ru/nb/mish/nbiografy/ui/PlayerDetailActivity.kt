package ru.nb.mish.nbiografy.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_player_detail.*

import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.IntentHelper
import ru.nb.mish.nbiografy.components.IntentHelper.BIOGRAFY
import ru.nb.mish.nbiografy.components.IntentHelper.PHOTO_ID
import ru.nb.mish.nbiografy.ui.fragments.GalleryFragment
import ru.nb.mish.nbiografy.ui.fragments.PlayerBiografyFragment
import ru.nb.mish.nbiografy.ui.fragments.PlayerMainPhotoFragment


class PlayerDetailActivity : AppCompatActivity() {

    private lateinit var pagerDetail: PagerDetail // для PagerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // кнопка назад наверху

        // инициализируем адаптер для ViewPager.

        pagerDetail = PagerDetail(intent.getIntExtra(PHOTO_ID, -1), // перменной pagerDetail присваиваем
                // класс PagerDetail(он указан ниже ) и в этот класс получаем данные по 3-ем фрагментам, которые будем скролить
                // берем данные по фргаментам из PlayersListActivity на 96 строке
                intent.getStringExtra(BIOGRAFY),
                intent.getStringArrayListExtra(IntentHelper.IMAGE_GALLERY),
                supportFragmentManager)

        viewPager.adapter = pagerDetail // ViewPager-у передали все фрагменты, которые мы будем скролить
                // передали через .adapter (это метод setAdapter)

        // отслеживатель для листаний
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener
        {
            // из 3-ех методов нужен только 1 - самый последний
            // сосотяние скрола
            override fun onPageScrollStateChanged(state: Int) {
            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            // метод для корректного отображения фрагмента и соответсвующей ему иконка снизу (чел, биогр или галерея)
            // чтобы не получилось, что фрагмент - Фото_анфас, а иконка - от биографии
            override fun onPageSelected(position: Int) {
                when(position) {
                     0 ->  navigation.selectedItemId = R.id.itemPhoto
                     1 ->  navigation.selectedItemId = R.id.itemBiografy
                     2 -> navigation.selectedItemId = R.id.itemAllPhoto
                }

            }

        })


        navigation.setOnNavigationItemSelectedListener { // обработчик BottomNavigation
            when (it.itemId) {
                R.id.itemPhoto -> {

                   viewPager.currentItem = 0 // текущее положение берем из PagerDetail(внизу)

                    title = it.getTitle() // указвает Title в ActionBar

                }

                R.id.itemBiografy -> {

                    viewPager.currentItem = 1

                    title = it.getTitle()

                }

                R.id.itemAllPhoto -> {

                   viewPager.currentItem = 2

                    title = it.getTitle()

                }



            }
            true
        }

        navigation.selectedItemId = R.id.itemPhoto // указываем, что изначально будет фрагмент с фото-анфас(а не, напр., биография)

    }

    override fun onSupportNavigateUp(): Boolean { // функция кнопки назад
        onBackPressed()
        return true

    }

    // метод использ. для создания фрагментов
    class PagerDetail(val photoId: Int, val biografy: String, val photos: ArrayList<String>, fm: FragmentManager): FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment? {
            when(position) {
                0 -> return PlayerMainPhotoFragment.newInstance(photoId) // если нажали самый первую иконку( т.е. 0), то
                // фрагмент будет с Фото_анфас
                1 -> return PlayerBiografyFragment.newInstance(biografy) // и т.д.
                2 -> return GalleryFragment.newInstance(photos) // и т.д.
                else -> return null
            }
        }

        override fun getCount(): Int = 3 // вместо "{return 3}" , т.е. сколько фрагментов будут активны (указывем, что все 3)

    }
}

