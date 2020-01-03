package com.nadiahaplikasi

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toolbar
import com.bumptech.glide.Glide
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class Home : Fragment() {
    val sampleImages = intArrayOf(
        R.drawable.bannersatu,
        R.drawable.bannerdua,
        R.drawable.bannerempat
    )

    //    menyiapkan fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        layoutnya
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setting carouselView
        carouselView.setPageCount(3)
        carouselView.setImageListener(imageListener)

//        button klik
//        ingat kalau di fragment mainactivity diganti activity
        button_Maps.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container_utama, PetaLauwba())?.commit()
        }

    }

    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView?) {
            activity?.let { Glide.with(it).load(sampleImages[position]).into(imageView!!) }
        }
    }
}
