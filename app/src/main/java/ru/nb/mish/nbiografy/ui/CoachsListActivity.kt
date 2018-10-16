package ru.nb.mish.nbiografy.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_coachs_list.*
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.adapters.CoachAdapter
import ru.nb.mish.nbiografy.models.Coach

class CoachsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coachs_list)

        rvCoachs.layoutManager = LinearLayoutManager(this)

        rvCoachs.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        rvCoachs.adapter = CoachAdapter(arrayListOf(
                Coach(R.drawable.anfas_bailly, getString(R.string.TvCoachFrance), getString(R.string.TvCoachDiscrFrance)),
                Coach(R.drawable.anfas_bailly, getString(R.string.TvCoachRussia), getString(R.string.TvCoachDiscrRussia)),
                Coach(R.drawable.anfas_bailly, getString(R.string.TvCoachPortugal), getString(R.string.TvCoachDiscrPortugal))
        ))
    }
}