package ru.nb.mish.nbiografy.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_player_main_photo.*

import ru.nb.mish.nbiografy.R


class PlayerMainPhotoFragment : Fragment() {


    private var photoId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            photoId = arguments.getInt(ARG_PHOTO_ID)

        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_player_main_photo, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivPlayer.setImageResource(photoId)

    }

    companion object {

        private val ARG_PHOTO_ID = "photoId"


        fun newInstance(photoId: Int): PlayerMainPhotoFragment {
            val fragment = PlayerMainPhotoFragment()
            val args = Bundle()
            args.putInt(ARG_PHOTO_ID, photoId)
            fragment.arguments = args
            return fragment

        }
    }
}