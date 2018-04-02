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

    private lateinit var pagerDetail: PagerDetail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

               pagerDetail = PagerDetail(intent.getIntExtra(PHOTO_ID, -1),
                intent.getStringExtra(BIOGRAFY),
                intent.getStringArrayListExtra(IntentHelper.IMAGE_GALLERY),
                supportFragmentManager)

        viewPager.adapter = pagerDetail

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener
        {

            override fun onPageScrollStateChanged(state: Int) {
            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when(position) {
                     0 ->  navigation.selectedItemId = R.id.itemPhoto
                     1 ->  navigation.selectedItemId = R.id.itemBiografy
                     2 -> navigation.selectedItemId = R.id.itemAllPhoto
                }

            }

        })


        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemPhoto -> {

                   viewPager.currentItem = 0

                    title = it.getTitle()

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

        navigation.selectedItemId = R.id.itemPhoto

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

    class PagerDetail(val photoId: Int, val biografy: String, val photos: ArrayList<String>, fm: FragmentManager): FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment? {
            when(position) {
                0 -> return PlayerMainPhotoFragment.newInstance(photoId)
                1 -> return PlayerBiografyFragment.newInstance(biografy)
                2 -> return GalleryFragment.newInstance(photos)
                else -> return null
            }
        }

        override fun getCount(): Int = 3

    }
}

