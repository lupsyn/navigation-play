package it.enrico.navigation_play

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView {

    private val hostViews = arrayListOf<Int>()  // Member variable of MainActivity
    private val navigation = Navigation(this)

    private val onNavigationSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        navigation.selectBottomNavigationTab(item.itemId)
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpHostViews()
        setupBottomNavigation()

        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = MAIN_TAB_HOST
        }
    }

    private fun setUpHostViews() {
        hostViews.apply {
            add(R.id.homeNavigationFragment)
            add(R.id.dashboardNavigationFragment)
            add(R.id.notificationNavigationFragment)
        }
    }

    override fun showHostView(navHostId: Int) {
        for (i in 0 until hostViews.size) {
            val view = findViewById<View>(hostViews[i])
            view.visibility = if (hostViews[i] == navHostId) View.VISIBLE else View.GONE
        }

        val navController = Navigation.findNavController(this, navHostId)
        setupActionBarWithNavController(this, navController)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(KEY_SELECTED_BOTTOM_NAV_ID, bottomNavigationView.selectedItemId)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        bottomNavigationView.selectedItemId = savedInstanceState?.getInt(KEY_SELECTED_BOTTOM_NAV_ID, -1)
                ?: -1
    }


    private fun setupBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationSelectedListener)
    }

    companion object {
        private const val MAIN_TAB_HOST = R.id.actionHome
        private const val KEY_SELECTED_BOTTOM_NAV_ID = "selected_bottom_nav_tab_id"
    }
}