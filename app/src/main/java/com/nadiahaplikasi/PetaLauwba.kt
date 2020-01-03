package com.nadiahaplikasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class PetaLauwba() : Fragment(), OnMapReadyCallback, View.OnClickListener {

    lateinit var petalauwba: LatLng

    lateinit var map: GoogleMap
    lateinit var mp: SupportMapFragment

    lateinit var normal: Button
    lateinit var satelit: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_peta_lauwba, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mp = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mp.getMapAsync(this)

        normal = view.findViewById(R.id.button_normal)
        satelit = view.findViewById(R.id.button_satelit)

        normal.setOnClickListener(this)
        satelit.setOnClickListener(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peta_lauwba)
    }

    private fun setContentView(activityPetaLauwba: Int) {
    }

    //LETAK TITIK KOORDINATOR
    override fun onMapReady(p0: GoogleMap?) {
        map = p0!!

        petalauwba = LatLng(-7.7832158, 110.4112737)
        map.addMarker((MarkerOptions().position(petalauwba).title("PT.LAUWBA TECHNO INDONESIA")))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(petalauwba, 17F))

        val builder = LatLngBounds.Builder()
        builder.include(petalauwba)
    }

    override fun onClick(p0: View) {
        when (p0!!.id) {
            R.id.button_normal -> {
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.button_satelit -> {
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }
        }
    }
}

private fun Button.setOnClickListener(petaLauwba: PetaLauwba) {

}
