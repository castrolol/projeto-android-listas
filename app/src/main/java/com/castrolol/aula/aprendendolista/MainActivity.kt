package com.castrolol.aula.aprendendolista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.failure
import com.github.kittinunf.result.success


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<Repository>()

        val list = findViewById<ListView>(R.id.list)
        val adapter = MeuListAdapter(this, items)

        list.adapter = adapter

        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {

            // navegar pra outra tela
//            val intent = Intent(this@MainActivity, NovaTela::class.java)
//            startActivity(intent)

            val text = editText.text.toString()
//            button.setBackgroundColor(getColor(R.color.cor_nossa_so_nossa))

            getRepositories(text) {
                items.clear()
                items.addAll(it)
                adapter.notifyDataSetChanged()
            }
        }

    }

    private fun getRepositories(user: String, callback: (List<Repository>) -> Unit ){

        "https://api.github.com/users/$user/repos"
                .httpGet()
                .responseObject<List<Repository>> { _, _, result ->

                    result.success {
                        callback(it)
                    }

                    result.failure {
                        it.printStackTrace()
                    }
                }

    }



}