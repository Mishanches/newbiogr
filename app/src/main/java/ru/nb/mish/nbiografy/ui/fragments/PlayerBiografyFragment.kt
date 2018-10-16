package ru.nb.mish.nbiografy.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_player_biografy.*
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.IntentHelper

class PlayerBiografyFragment : Fragment() {

    private var biografyId: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            biografyId = arguments!!.getString(IntentHelper.BIOGRAFY)

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_player_biografy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvBiografyText.setText(Html.fromHtml(biografyId))
    }

    companion object {

        fun newInstance(biografyId: String): PlayerBiografyFragment {
            val fragment = PlayerBiografyFragment()
            val args = Bundle()
            args.putString(IntentHelper.BIOGRAFY, biografyId)
            fragment.arguments = args
            return fragment
        }
    }

}