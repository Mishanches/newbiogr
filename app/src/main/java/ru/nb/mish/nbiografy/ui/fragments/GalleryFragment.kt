package ru.nb.mish.nbiografy.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.fragment_gallery.*

import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.adapters.GalleryAdapter
import ru.nb.mish.nbiografy.components.IntentHelper
import ru.nb.mish.nbiografy.components.IntentHelper.IMAGE_GALLERY
import ru.nb.mish.nbiografy.components.OnItemClickListener
import ru.nb.mish.nbiografy.ui.FullImageActivity


class GalleryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvImages.layoutManager = GridLayoutManager(activity, 2) // подключаем RecView из activity_players_list.xml
        // GridLayoutManager - отвечает за кол-во столбцов

        val images = arguments?.getStringArrayList(IntentHelper.IMAGE_GALLERY)!!

        rvImages.adapter = GalleryAdapter(images,
                object : OnItemClickListener<String> {


            // клик на кратинку в галереи
            override fun onItemClick(item: String) { // item: String передается адрес картинки, по которой мы кликнули
                startActivity(Intent(activity, FullImageActivity::class.java)
                        .putExtra(IntentHelper.IMAGE_GALLERY, images) // передаем список всех картинок тек пользователя
                        .putExtra(IntentHelper.IMAGE_POS, images.indexOf(item))) // отправляем индекс картинок в списке картинок
                // indexOf - метод, который ищет во всем списке картинку URL

            }
        })

    }

    companion object {

        fun newInstance(imagesArray: ArrayList<String>): GalleryFragment {
            val fragment = GalleryFragment()
            val args = Bundle() // список перменных
            args.putStringArrayList(IntentHelper.IMAGE_GALLERY, imagesArray)
            fragment.arguments = args
            return fragment
        }
    }
}
