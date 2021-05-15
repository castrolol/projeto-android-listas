package com.castrolol.aula.aprendendolista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MeuListAdapter(context: Context, val list: List<Repository>) : ArrayAdapter<Repository>(context, 0, list) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val listItem = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val image = listItem.findViewById<ImageView>(R.id.imageView)
        val title = listItem.findViewById<TextView>(R.id.title)
        val subtitle = listItem.findViewById<TextView>(R.id.subtitle)

        image.setImageResource(if(list[position].fork) R.drawable.fork else R.drawable.repository)
        title.text = list[position].name
        subtitle.text = "${list[position].language}・ ★ ${list[position].stargazers_count}"

        return listItem
    }

}