package com.example.resepdapur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bottomNavigationView : BottomNavigationView
    private lateinit var fabAdd: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        bottomNavigationView.background = null
        replaceFragment(HomeFragment())
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navhome-> replaceFragment(HomeFragment())
                R.id.navlike-> replaceFragment(FavoriteFragment())
            }
               true
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    private fun init(){
        bottomNavigationView = findViewById(R.id.bottomNavView)
        fabAdd = findViewById(R.id.fabAdd)
        fabAdd.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.fabAdd-> startActivity(Intent(this, AddRecipesActivity::class.java))
        }
    }

}