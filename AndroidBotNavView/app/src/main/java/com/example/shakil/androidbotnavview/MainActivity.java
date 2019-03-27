package com.example.shakil.androidbotnavview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    AHBottomNavigation bottomNavigation;
    Button btn_count;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_nav);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Tab 1", R.drawable.ic_add_alert_black_24dp, android.R.color.white);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Tab 2", R.drawable.ic_add_location_black_24dp, android.R.color.white);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Tab 3", R.drawable.ic_add_shopping_cart_black_24dp, android.R.color.white);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#190019"));

        btn_count = findViewById(R.id.btn_count);
        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                bottomNavigation.setNotification("" + count, 0);
            }
        });

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                Toast.makeText(MainActivity.this, "Start Activity " + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
