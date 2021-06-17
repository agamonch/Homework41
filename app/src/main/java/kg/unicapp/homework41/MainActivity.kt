package kg.unicapp.homework41

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.myDrawer)
        navigationView = findViewById(R.id.navView)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView.setNavigationItemSelectedListener {
            val transaction = supportFragmentManager.beginTransaction()
            when(it.itemId){
                R.id.fragment1ID -> transaction.run {
                replace(R.id.container, FragmentA(), FragmentA.TAG)
                addToBackStack(null)
                commit()

            }
                R.id.fragment2ID -> transaction.run {
                    replace(R.id.container2, FragmentB(), FragmentB.TAG)
                    addToBackStack(null)
                    commit()
                }
                R.id.fragment3ID -> transaction.run {
                    replace(R.id.container3, FragmentC(), FragmentC.TAG)
                    addToBackStack(null)
                    commit()
                }
                R.id.close_app -> finish()
             }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            true
        }

        return super.onOptionsItemSelected(item)
    }





}