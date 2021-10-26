package com.example.chakchak

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chakchak.UI.Fragments.ApiFragment
import com.example.chakchak.UI.Fragments.JokeFragment
import com.example.chakchak.databinding.ActivityMainBinding
import com.example.chakchak.utilits.APP_ACTIVITY
import com.example.chakchak.utilits.replaceFragment
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val homeFragment = JokeFragment()
        val apiFragment = ApiFragment()

        replaceFragment(homeFragment)

        binding.bottomBar
            .setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when(newIndex){
                    0 -> replaceFragment(homeFragment)
                    1 -> replaceFragment(apiFragment)
                }
            }
        });
    }
}