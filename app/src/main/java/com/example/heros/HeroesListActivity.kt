package com.example.heros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heros.databinding.ActivityHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroesListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeroesListBinding

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.ranking -> {
                val inputStream = resources.openRawResource(R.raw.heroes)
                val jsonString = inputStream.bufferedReader().use{
                    it.readText() }
                val gson = Gson()
                val qType = object : TypeToken<List<Hero>>() { }.type
                val heroes = gson.fromJson<List<Hero>>(jsonString, qType).sortedBy{it.ranking}

                val adapter = HeroAdapter(heroes)
                binding.recyclerViewHeroesList.adapter = adapter
                binding.recyclerViewHeroesList.layoutManager = LinearLayoutManager(this)
                true
            }
            R.id.name -> {
                val inputStream = resources.openRawResource(R.raw.heroes)
                val jsonString = inputStream.bufferedReader().use{
                    it.readText() }
                val gson = Gson()
                val qType = object : TypeToken<List<Hero>>() { }.type
                val heroes = gson.fromJson<List<Hero>>(jsonString, qType).sortedBy{it.name}

                val adapter = HeroAdapter(heroes)
                binding.recyclerViewHeroesList.adapter = adapter
                binding.recyclerViewHeroesList.layoutManager = LinearLayoutManager(this)
                true
            }
            R.id.description -> {
                val inputStream = resources.openRawResource(R.raw.heroes)
                val jsonString = inputStream.bufferedReader().use{
                    it.readText() }
                val gson = Gson()
                val qType = object : TypeToken<List<Hero>>() { }.type
                val heroes = gson.fromJson<List<Hero>>(jsonString, qType).sortedBy{it.description.length}

                val adapter = HeroAdapter(heroes)
                binding.recyclerViewHeroesList.adapter = adapter
                binding.recyclerViewHeroesList.layoutManager = LinearLayoutManager(this)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputStream = resources.openRawResource(R.raw.heroes)
        val jsonString = inputStream.bufferedReader().use{
            it.readText() }
        val gson = Gson()
        val qType = object : TypeToken<List<Hero>>() { }.type
        val heroes = gson.fromJson<List<Hero>>(jsonString, qType).sorted()

        Log.d("yay",  "onCreate: $heroes")

        //link adapter to recycler view and give list
        val adapter = HeroAdapter(heroes)
        binding.recyclerViewHeroesList.adapter = adapter
        binding.recyclerViewHeroesList.layoutManager = LinearLayoutManager(this)


    }



}