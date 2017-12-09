/*
 * Copyright (c) 2017. Ibanga Enoobong Ime (World class developer and entrepreneur)
 */

package co.enoobong.customarrayadapter.adapter

import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import co.enoobong.customarrayadapter.model.ModelDisplayName

class CustomArrayAdapter(private val mContext: Context,
                         @LayoutRes private val layoutResource: Int,
                         @IdRes private val textViewResourceId: Int = 0,
                         private val values: List<ModelDisplayName>) : ArrayAdapter<ModelDisplayName>(mContext, layoutResource, values){

    override fun getItem(position: Int): ModelDisplayName = values[position]

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = createViewFromResource(convertView, mContext, parent, layoutResource)

        return bindData(getItem(position), view)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = createViewFromResource(convertView, mContext, parent, android.R.layout.simple_spinner_dropdown_item)

        return bindData(getItem(position), view)
    }

    private fun createViewFromResource(convertView: View?, context: Context, parent: ViewGroup, layoutResource: Int): TextView {
        val view = convertView ?: LayoutInflater.from(context).inflate(layoutResource, parent, false)
        return try {
            if (textViewResourceId == 0) view as TextView
            else {
                view.findViewById(textViewResourceId) ?:
                        throw RuntimeException("Failed to find view with ID " +
                                "${mContext.resources.getResourceName(textViewResourceId)} in item layout")
            }
        } catch (ex: ClassCastException){
            Log.e("CustomArrayAdapter", "You must supply a resource ID for a TextView")
            throw IllegalStateException(
                    "ArrayAdapter requires the resource ID to be a TextView", ex)
        }
    }

    private fun bindData(value: ModelDisplayName, view: TextView): TextView {
        view.text = value.displayName
        return view
    }
}