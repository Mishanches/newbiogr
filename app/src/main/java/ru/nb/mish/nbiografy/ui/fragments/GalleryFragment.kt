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


class GalleryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // после создания пустого Вью, а потом
        // создаем картинку(фото анфас)
        super.onViewCreated(view, savedInstanceState)
        rvImages.layoutManager = GridLayoutManager(activity, 2) // подключаем RecView из activity_players_list.xml
        // GridLayoutManager - отвечает за кол-во столбцов

        rvImages.adapter = GalleryAdapter(arguments?.getStringArrayList(IntentHelper.IMAGE_GALLERY)!!, object : OnItemClickListener<String> {


            // обработчик нажатий BottomNavigation
            override fun onItemClick(item: String) {

            }
        })

    }

    companion object {

        fun newInstance(imagesArray: ArrayList<String>): GalleryFragment { // передаем сам текст биографии
            val fragment = GalleryFragment()
            val args = Bundle() // список перменных
            args.putStringArrayList(IntentHelper.IMAGE_GALLERY, imagesArray) // biografyId - сама перменная, которую передаем, IntentHelper.BIOGRAFY - сам текст
            fragment.arguments = args
            return fragment
        }
    }
}
