package com.felipespirit.awesometourney;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private  DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.main_layout);
        ActionBarDrawerToggle abdt= new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,
                R.string.open_side_menu,R.string.close_side_menu);
        abdt.syncState();

        NavController nc = Navigation.findNavController(this, R.id.nav_fragment);

        BottomNavigationView bnv = findViewById(R.id.nav_view);
        bnv.setVisibility(View.INVISIBLE);
        NavigationView nv = findViewById(R.id.side_nav_view);

        NavigationUI.setupWithNavController(bnv,nc);
        NavigationUI.setupWithNavController(nv,nc);
    }

    @Override
    public void onBackPressed() {
        if(this.drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}