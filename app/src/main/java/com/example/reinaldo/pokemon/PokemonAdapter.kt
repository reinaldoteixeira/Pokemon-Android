package com.example.reinaldo.pokemon

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.io.IOException
import java.io.InputStream

class PokemonAdapter(context: Context, lista: ArrayList<Pokemon> ,
                     assetManager: AssetManager
) : BaseAdapter() {

    private var listaPokemon: ArrayList<Pokemon>
    private var inflator: LayoutInflater
    private var assetManager: AssetManager


    init {
        this.listaPokemon = lista
        this.inflator = LayoutInflater.from(context)
        this.assetManager = assetManager
    }

    override fun getCount(): Int {
        return this.listaPokemon.size
    }

    override fun getItem(position: Int): Any? {
        return this.listaPokemon.get(position)
    }

    override fun getItemId(position: Int): Long {
        return this.listaPokemon.get(position).id;
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val pokemon = this.listaPokemon.get(position)
        val view = this.inflator.inflate(R.layout.activity_linha, parent, false)
        val bitmapImage = this.getBitmapFromAsset(pokemon.id)

        (view.findViewById<TextView>(R.id.nome)).text = pokemon.nome
        var imageView = view.findViewById<ImageView>(R.id.foto)
        imageView.setImageBitmap(bitmapImage)

        return view
    }

    private fun getBitmapFromAsset(id: Long): Bitmap {
        val assetManager = this.assetManager
        var istr: InputStream? = null
        try {
            istr = assetManager.open("c$id.png")
        } catch (e: IOException) {
            istr = assetManager.open("c$id.png")
        }
        return BitmapFactory.decodeStream(istr)
    }


}
