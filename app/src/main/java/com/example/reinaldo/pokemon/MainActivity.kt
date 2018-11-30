package com.example.reinaldo.pokemon

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaPokemon = ArrayList<Pokemon>()
        val c1 = Pokemon(1L, "Cyndaquil","","rapido")
        val c2 = Pokemon(2L, "Pikachu", "","forte")
        val c3 = Pokemon(3L, "Caterpie", "", "porte menor")
        val c4 = Pokemon(4L, "Totodile","","porte maior" )
        val c5 = Pokemon(5L, "Togepi", "", "agil")
        val c6 = Pokemon(6L, "Charmander","", "voa")
        val c7 = Pokemon(7L, "Mew","","rosa")
        val c8 = Pokemon(8L, "Quilava", "","fogo")

        listaPokemon.add(c1)
        listaPokemon.add(c2)
        listaPokemon.add(c3)
        listaPokemon.add(c4)
        listaPokemon.add(c5)
        listaPokemon.add(c6)
        listaPokemon.add(c7)
        listaPokemon.add(c8)


        val adapter = PokemonAdapter(applicationContext, listaPokemon, assets)

        val lista = findViewById<ListView>(R.id.lista)
        lista.setAdapter(adapter)

        lista.setOnItemClickListener {parent, view, position, id ->
            val pokemon = listaPokemon.get(position)
            val intent = Intent(this, DetalhePokemon::class.java)
            intent.putExtra("pokemon", pokemon)
            startActivity(intent)
        }


    }
}
