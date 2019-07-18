package co.enoobong.customarrayadapter.lib.adapter

import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import co.enoobong.customarrayadapter.lib.model.ModelDisplayName

class CustomArrayAdapter<T : ModelDisplayName>(context: Context,
                                               @LayoutRes private val layoutResource: Int,
                                               @IdRes private val textViewResourceId: Int = 0,
                                               values: List<T>) : ArrayAdapter<T>(context, layoutResource, values) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = createViewFromResource(convertView, parent, layoutResource)

        return bindData(getItem(position), view)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = createViewFromResource(convertView, parent, android.R.layout.simple_spinner_dropdown_item)

        return bindData(getItem(position), view)
    }

    private fun createViewFromResource(convertView: View?, parent: ViewGroup, layoutResource: Int): TextView {
        val context = parent.context
        val view = convertView
                ?: LayoutInflater.from(context).inflate(layoutResource, parent, false)
        return try {
            if (textViewResourceId == 0) {
                view as TextView
            } else {
                view.findViewById(textViewResourceId)
                        ?: throw RuntimeException("Failed to find view with ID " + "${context.resources.getResourceName(textViewResourceId)} in item layout")
            }
        } catch (ex: ClassCastException) {
            Log.e("CustomArrayAdapter", "You must supply a resource ID for a TextView")
            throw IllegalStateException("ArrayAdapter requires the resource ID to be a TextView", ex)
        }
    }

    private fun bindData(value: T, view: TextView): TextView {
        view.text = value.displayName
        return view
    }
}
