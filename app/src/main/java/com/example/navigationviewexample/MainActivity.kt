package com.example.navigationviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    lateinit var toolBar:Toolbar
    lateinit var drawerLayout:DrawerLayout
    lateinit var navView:NavigationView

    lateinit var messageFragment:MessageFragment
    lateinit var chatFragment: ChatFragment
    lateinit var profileFragment:ProfileFragment
    lateinit var sendFragment: SendFragment
    lateinit var shareFragment: ShareFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolBar=findViewById(R.id.toolBar)
        drawerLayout=findViewById(R.id.drawerLayout)
        navView=findViewById(R.id.nav_view)
        setSupportActionBar(toolBar)
        val actionBar=supportActionBar
        actionBar?.title="Navigation Drawer"

        val drawerToggle:ActionBarDrawerToggle=object :ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolBar,
            (R.string.open),
            (R.string.close)
        ){
        }

        drawerToggle.isDrawerIndicatorEnabled=true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        messageFragment=MessageFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,messageFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.message->{ messageFragment=MessageFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,messageFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()}
            R.id.chat->{ chatFragment= ChatFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,chatFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()}
            R.id.profile->{ profileFragment=ProfileFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,profileFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()}
            R.id.share->{ shareFragment= ShareFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,shareFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()}
            R.id.send->{ sendFragment= SendFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,sendFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()}

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }


    }
}