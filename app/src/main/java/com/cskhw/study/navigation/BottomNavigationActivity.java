package com.cskhw.study.navigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cskhw.study.R;
import com.cskhw.study.navigation.fragments.FragmentCart;
import com.cskhw.study.navigation.fragments.FragmentProfile;
import com.cskhw.study.navigation.fragments.FragmentTime;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {
    BottomNavigationView navigation;
    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        navigation = findViewById(R.id.activity_navigation_bottomNavigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                String itemId = String.valueOf(item.getItemId());
                if (item.getItemId() == R.id.navigation_cart) fragment = new FragmentCart();
                else if (item.getItemId() == R.id.navigation_time) fragment = new FragmentTime();
                else if (item.getItemId() == R.id.navigation_profile)
                    fragment = new FragmentProfile();
                else fragment = null;
                fragmentTransaction.replace(R.id.activity_navigation_frameLayout, fragment).addToBackStack(null).commit();
                return true;
            }
        });
        navigation.setSelectedItemId(R.id.navigation_cart);
    }
}
