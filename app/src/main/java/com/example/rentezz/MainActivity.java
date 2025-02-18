package com.example.rentezz;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activitity_navigation);
//        Intent intent = new Intent(this, HistoryActivity.class);// for the opning screen on app
//
//        intent.putExtra("room_number", "room 8");//for featching details from the fire base accoreding too the input
//        startActivity(intent);

        bnView = findViewById(R.id.bnview);

        // Set default fragment
        if (savedInstanceState == null) {
            loadFragment(new Frag_current());
        }

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.current) {
                    selectedFragment = new Frag_current();
                } else if (item.getItemId() == R.id.history) {
                    selectedFragment = new Frag_history();
                }

                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                    return true;
                }
                return false;
            }
        });
    }

    // Method to load fragments
    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack(null);
        ft.commit();

    }

}

