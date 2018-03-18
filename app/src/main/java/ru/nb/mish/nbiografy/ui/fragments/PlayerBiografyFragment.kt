package ru.nb.mish.nbiografy.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_player_biografy.*

import ru.nb.mish.nbiografy.R



class PlayerBiografyFragment : Fragment() {

    private var biografyId: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            biografyId = arguments.getString(ARG_BIOGRAFY_ID)

        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_player_biografy, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvBiografyText.setText(biografyId)
    }

    companion object {
        private val ARG_BIOGRAFY_ID = "biografyId"




        fun newInstance(biografyId: String): PlayerBiografyFragment {
            val fragment = PlayerBiografyFragment()
            val args = Bundle()
            args.putString(ARG_BIOGRAFY_ID, biografyId)
            fragment.arguments = args
            return fragment
        }
    }

}
