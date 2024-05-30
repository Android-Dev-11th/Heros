package com.example.heros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.example.heros.databinding.ActivityHeroesDetailBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroesDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeroesDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val context = binding.textViewName.context
        val currHero = intent.getParcelableExtra<Hero>("currHero" )

            binding.textViewName.text = currHero?.name
            binding.textViewDescription.text = currHero?.description
            binding.textViewRanking.text = currHero?.ranking.toString()
            binding.textViewSuperpower.text = currHero?.superpower
            binding.imageViewImage.setImageDrawable(getDrawable(
                resources.getIdentifier(currHero?.image, "drawable", this.packageName)))


    }



}