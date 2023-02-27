package com.example.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.bottomnav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFrag(Home())

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> replaceFrag(Home())
                R.id.progress -> replaceFrag(Progress())
                R.id.achievements -> replaceFrag(Achievements())
                R.id.to_do -> replaceFrag(ToDo())

                else -> {

                }
            }
            true
        }
    }

    private fun replaceFrag(fragment : Fragment) {
        val fragManager  = supportFragmentManager
        val fragTransaction = fragManager.beginTransaction()
        fragTransaction.replace(R.id.frame_layout,fragment)
        fragTransaction.commit()
    }
}