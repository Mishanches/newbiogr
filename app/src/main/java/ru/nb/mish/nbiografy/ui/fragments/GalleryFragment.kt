package ru.nb.mish.nbiografy.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_gallery.*
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.adapters.GalleryAdapter
import ru.nb.mish.nbiografy.components.IntentHelper
import ru.nb.mish.nbiografy.components.OnItemClickListener
import ru.nb.mish.nbiografy.ui.FullImageActivity

class GalleryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvImages.layoutManager = GridLayoutManager(activity, 2)

        val images = arguments?.getStringArrayList(IntentHelper.IMAGE_GALLERY)!!

        rvImages.adapter = GalleryAdapter(images,
                object : OnItemClickListener<String> {

                    override fun onItemClick(item: String) {
                        startActivity(Intent(activity, FullImageActivity::class.java)
                                .putExtra(IntentHelper.IMAGE_GALLERY, images)
                                .putExtra(IntentHelper.IMAGE_POS, images.indexOf(item)))
                    }
                })

    }

    companion object {

        fun newInstance(imagesArray: ArrayList<String>): GalleryFragment {
            val fragment = GalleryFragment()
            val args = Bundle()
            args.putStringArrayList(IntentHelper.IMAGE_GALLERY, imagesArray)
            fragment.arguments = args
            return fragment
        }
    }
}