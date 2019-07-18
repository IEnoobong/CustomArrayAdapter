/*
 * Copyright (c) 2017. Ibanga Enoobong Ime (World class developer and entrepreneur)
 */

package co.enoobong.customarrayadapter.app.adapter

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import co.enoobong.customarrayadapter.app.model.Hotel

//Works but not sustainable if you have to write tons of them
class HotelAdapter(context: Context, @LayoutRes private val layoutResource: Int, private val hotels: List<Hotel>) :
        ArrayAdapter<Hotel>(context, layoutResource, hotels) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return createViewFromResource(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return createViewFromResource(position, convertView, parent)
    }

    private fun createViewFromResource(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: TextView = convertView as TextView?
                ?: LayoutInflater.from(context).inflate(layoutResource, parent, false) as TextView
        view.text = hotels[position].name
        return view
    }
}
