/*
 * Copyright (c) 2017. Ibanga Enoobong Ime (World class developer and entrepreneur)
 */

package co.enoobong.customarrayadapter.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import co.enoobong.customarrayadapter.R
import co.enoobong.customarrayadapter.adapter.CustomArrayAdapter
import co.enoobong.customarrayadapter.model.Chair
import co.enoobong.customarrayadapter.model.Computer
import co.enoobong.customarrayadapter.model.Hotel
import co.enoobong.customarrayadapter.model.HotelAdapter
import kotlinx.android.synthetic.main.demo_activity_layout.*

class DemoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo_activity_layout)
        val listOfComputers = listOf(
                Computer("HP", "HP1059", "1103SWED"),
                Computer("Apple", "Sierra", "XD1103SWED"),
                Computer("Dell", "Beast", "LO1103SWED")
        )
        val listOfChairs = listOf(
                Chair("Ikea", "IK304", "Camp"),
                Chair("Baba Emeka", "NGN0001", "Double Settee"),
                Chair("Nobel", "NB112", "Standing")
        )

        val listOfHotels = listOf(
                Hotel("Protea", "Ikeja", true, true),
                Hotel("George", "Ikoyi", true, true),
                Hotel("Raheem and Sons", "Ilasa", false, false)
        )

        //Uses class toString - implemented wrongly, works but wrong!
        spFirst.adapter = ArrayAdapter(this,  android.R.layout.simple_spinner_item, listOfComputers)

        //Uses class toString - implemented correctly, doesn't work as intended wrong
        spSecond.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOfChairs)

        //Perfecto
        spThird.adapter = CustomArrayAdapter(this, android.R.layout.simple_spinner_item, values = listOfChairs)

        //Works, not sustainable :(
        spFourth.adapter = HotelAdapter(this, android.R.layout.simple_spinner_item, listOfHotels)

    }
}