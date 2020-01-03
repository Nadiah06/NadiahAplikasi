package com.nadiahaplikasi

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import android.view.View;
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.os.PersistableBundle
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ///menambah/menghapus fragment
        supportFragmentManager.beginTransaction().replace(R.id.container_utama, Home()).commit()
    }

}
