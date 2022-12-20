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
        val token: String? = intent.getStringExtra("token")
        bottomNavigationView.background = null
        replaceFragment(HomeFragment(), token)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navhome-> replaceFragment(HomeFragment(), token)
                R.id.navlike-> replaceFragment(FavoriteFragment(), token)
            }
               true
        }
    }

    private fun replaceFragment(fragment : Fragment, token: String?) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putString("token", token)
        fragment.arguments = bundle
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