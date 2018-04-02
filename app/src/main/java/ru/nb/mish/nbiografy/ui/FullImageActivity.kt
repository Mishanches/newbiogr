package ru.nb.mish.nbiografy.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_full_image.*
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.IntentHelper
import ru.nb.mish.nbiografy.ui.fragments.FullImageFragment


class FullImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(getString(R.string.TvTitleFullImage))

        viewPager.adapter = ImageAdapter(
                intent.getStringArrayListExtra(IntentHelper.IMAGE_GALLERY),
                supportFragmentManager)

        viewPager.currentItem = intent.getIntExtra(IntentHelper.IMAGE_POS, -1)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

    class ImageAdapter(val imagesArray: ArrayList<String>, fm: FragmentManager): FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment? {
            return FullImageFragment.newInstance(imagesArray[position])
        }

        override fun getCount(): Int = imagesArray.size

    }


}