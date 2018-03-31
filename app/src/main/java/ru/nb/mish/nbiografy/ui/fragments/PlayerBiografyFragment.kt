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
        if (arguments != null) { // получаем саму строку, которую передали
            biografyId = arguments!!.getString(IntentHelper.BIOGRAFY)

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? { // аналог onCreate в активити

        return inflater!!.inflate(R.layout.fragment_player_biografy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // после создания пустого Вью
        // создаем картинку(фото анфас)
        super.onViewCreated(view, savedInstanceState)
        tvBiografyText.setText(Html.fromHtml(biografyId)) // передаем текст в виде HTML
    }

    companion object {

        fun newInstance(biografyId: String): PlayerBiografyFragment { // передаем сам текст биографии
            val fragment = PlayerBiografyFragment()
            val args = Bundle() // список перменных
            args.putString(IntentHelper.BIOGRAFY, biografyId) // biografyId - сама перменная, которую передаем, IntentHelper.BIOGRAFY - сам текст
            fragment.arguments = args
            return fragment
        }
    }

}
