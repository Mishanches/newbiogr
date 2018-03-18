package ru.nb.mish.nbiografy.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_player_detail.*

import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.IntentHelper.BIOGRAFY
import ru.nb.mish.nbiografy.components.IntentHelper.PHOTO_ID
import ru.nb.mish.nbiografy.ui.fragments.PlayerBiografyFragment
import ru.nb.mish.nbiografy.ui.fragments.PlayerMainPhotoFragment

class PlayerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemPhoto -> {

                    supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content, PlayerMainPhotoFragment.newInstance(intent.getIntExtra(PHOTO_ID, -1)))
                    .commit()

                }

                R.id.itemBiografy -> {

                    supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.content, PlayerBiografyFragment.newInstance(intent.getStringExtra(BIOGRAFY)))
                            .commit()

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
}