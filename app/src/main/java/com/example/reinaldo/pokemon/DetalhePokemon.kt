package com.example.reinaldo.pokemon

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_detalhe_pokemon.*
import java.io.IOException
import java.io.InputStream

class DetalhePokemon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_pokemon)

        val intent = intent
        if (intent != null) {
            val pokemon = intent.getSerializableExtra("pokemon") as Pokemon
            val nomepokemon = findViewById<TextView>(R.id.nomepokemon)
            val fotopokemon = findViewById<ImageView>(R.id.fotopokemon)
            val descricaopokemon = findViewById<TextView>(R.id.descricaopokemon)
            val bitmap = getBitmapFromAsset(pokemon.id)
            nomepokemon.text = pokemon.nome
            fotopokemon.setImageBitmap(bitmap)
            descricaopokemon.text = pokemon.descricao
        }

    }

    private fun getBitmapFromAsset(id: Long): Bitmap {
        val assetManager = this.assets
        var istr: InputStream? = null
        try {
            istr = assetManager.open("c$id.png")
        } catch (e: IOException) {
            istr = assetManager.open("c$id.png")
        }
        return BitmapFactory.decodeStream(istr)
    }
}
