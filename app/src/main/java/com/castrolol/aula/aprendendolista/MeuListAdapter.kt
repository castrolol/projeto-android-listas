package com.castrolol.aula.aprendendolista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MeuListAdapter(context: Context, val list: List<String>) : ArrayAdapter<String>(context, 0, list) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val listItem = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val title = listItem.findViewById<TextView>(R.id.title)

        title.text = list[position]

        return listItem
    }

}