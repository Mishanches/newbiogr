package ru.nb.mish.nbiografy.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_full_image.*
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.IntentHelper

class FullImageFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this)
                .load(arguments?.getString(IntentHelper.PHOTO_URL))
                .into(imageView)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_full_image, container, false)
    }

    companion object {

        fun newInstance(imageUrl: String): FullImageFragment {
            val fragment = FullImageFragment()
            val args = Bundle()
            args.putString(IntentHelper.PHOTO_URL, imageUrl)
            fragment.arguments = args
            return fragment
        }
    }
}