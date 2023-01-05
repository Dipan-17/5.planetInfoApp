package com.example.planetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_planet_details.*

class planetDetails : AppCompatActivity() {

    private lateinit var obj:PlanetData
    private var planetImage:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_details)


        window.decorView.apply { systemUiVisibility= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION  or View.SYSTEM_UI_FLAG_FULLSCREEN}

        obj= intent.getParcelableExtra("planet")!!
        planetImage=intent.getIntExtra("planetImage",-1)

        setData(obj,planetImage!!)


        button_info.setOnClickListener{
            val intent=Intent(this, FinalActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setData(obj:PlanetData, planetImage:Int){
        tv_planetName_info.text=obj.title;
        tv_distanceValue_info.text=obj.distance + " m km";
        tv_gravityValue_info.text=obj.gravity + " m/ss";

        tv_overView_info.text=obj.overView;

        img_planet_Info.setImageResource(planetImage)

        tv_galaxyName_info.text=obj.galaxy

    }

}