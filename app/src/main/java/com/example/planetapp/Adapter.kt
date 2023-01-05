package com.example.planetapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*
import java.util.*

class Adapter(var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.myViewHolder>() {

    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.tv_planetName
        var planetImg = view.img_planet
        var galaxy = view.tv_galaxyName
        var distance = view.tv_distanceValue
        var gravity = view.tv_gravityValue
    }

    //works as the adapter
    //i.e it takes the xml file which is an integer and converts it into a type that the recycler view can consume
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        //layout inflater converts the view
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)

        return myViewHolder(itemView)
    }


    //this works to set the values inside the view
    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage: Int? = null

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,planetDetails::class.java)

            intent.putExtra("planetImage",dummyImage)
            intent.putExtra("planet",planet[position])

            holder.itemView.context.startActivity(intent)
        }

        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.gravity.text = planet[position].gravity + " m/ss"
        holder.distance.text = planet[position].distance + " m km"


        when (planet[position].title!!.lowercase(Locale.getDefault())) {
            "mars" -> {
                dummyImage = R.drawable.ic_mars
            }
            "neptune" -> {
                dummyImage = R.drawable.ic_neptune
            }
            "earth" -> {
                dummyImage = R.drawable.ic_earth
            }
            "moon" -> {
                dummyImage = R.drawable.ic_moon
            }
            "venus" -> {
                dummyImage = R.drawable.ic_venus
            }
            "jupiter" -> {
                dummyImage = R.drawable.ic_jupiter
            }
            "saturn" -> {
                dummyImage = R.drawable.ic_saturn
            }
            "uranus" -> {
                dummyImage = R.drawable.ic_uranus
            }
            "mercury" -> {
                dummyImage = R.drawable.ic_mercury
            }
            "sun" -> {
                dummyImage = R.drawable.ic_sun
            }

        }
        holder.planetImg.setImageResource(dummyImage!!)

    }

    override fun getItemCount(): Int {
        return planet.size
    }

}

