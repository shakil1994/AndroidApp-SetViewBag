package com.example.shakil.kotlinbotnavview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val item1 = AHBottomNavigationItem("Tab 1", R.drawable.ic_add_alert_black_24dp, android.R.color.white)
        val item2 = AHBottomNavigationItem("Tab 2", R.drawable.ic_add_location_black_24dp, android.R.color.white)
        val item3 = AHBottomNavigationItem("Tab 3", R.drawable.ic_add_shopping_cart_black_24dp, android.R.color.white)

        bottom_nav.addItem(item1)
        bottom_nav.addItem(item2)
        bottom_nav.addItem(item3)

        // Set background color
        bottom_nav.setDefaultBackgroundColor(Color.parseColor("#190019"))

        btn_count.setOnClickListener {
            count++
            bottom_nav.setNotification(count.toString(), 0)
        }

        bottom_nav.setOnTabSelectedListener { position, wasSelected ->
            Toast.makeText(this@MainActivity, "Start Activity: " + position, Toast.LENGTH_SHORT).show()
            true
        }
    }
}
