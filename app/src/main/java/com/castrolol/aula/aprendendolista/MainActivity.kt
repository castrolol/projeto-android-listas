package com.castrolol.aula.aprendendolista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf(
            "Caio Lopes",
            "João Henrique",
            "Kelvin Kleain",
            "Rogerio Rondon",
            "Gilson Ribeiro"
        )

        val list = findViewById<ListView>(R.id.list)
        val adapter = MeuListAdapter(this, items)

        list.adapter = adapter

        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val text = editText.text.toString()
            items.add(text)
            adapter.notifyDataSetChanged()
        }

    }
}