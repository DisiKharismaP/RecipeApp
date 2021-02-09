package disiiy.khaper.recipeapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import disiiy.khaper.recipeapp.MainActivity.Companion.getLaunchService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.navigation_home ->{
                val fragment = HomeFragment.newInstance()
                implementFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_add ->{
                val fragment = AddFragment()
                implementFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_saved ->{
                val fragment = SavedFragment()
                implementFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    companion object{
        fun getLaunchService(from: Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        navigation_menu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = HomeFragment.newInstance()
        implementFragment(fragment)
    }

    private fun implementFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.content_main, fragment, fragment.javaClass.simpleName)
            .commit()
    }

}