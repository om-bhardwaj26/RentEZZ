package com.example.rentezz;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    Button current,history;
    BottomNavigationView bnView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activitity_navigation);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        bnView=findViewById(R.id.bnview);
        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if (id==R.id.current){
                    FragmentManager fm =getSupportFragmentManager();
                    FragmentTransaction ft =fm.beginTransaction();
                    ft.add(R.id.container,new Frag_current());

                    ft.commit();}

                else {
                    FragmentManager fm =getSupportFragmentManager();
                    FragmentTransaction ft =fm.beginTransaction();
                    ft.replace(R.id.container,new Frag_history());
                    ft.addToBackStack(null);
                    ft.commit();
                }
                    

                return true;
            }
        });
        bnView.setSelectedItemId(R.id.current);



        Intent intent = new Intent(this, HistoryActivity.class);// for the opning screen on app

        intent.putExtra("room_number", "room 8");//for featching details from the fire base accoreding too the input
        startActivity(intent);
    }
}

