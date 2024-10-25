package com.example.joaovitor_navigationdrawer;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                if (item.getItemId() == R.id.nav_primeiro_periodo){
                    fragment = new PrimeiroPeriodoFragment();
                }

                if (item.getItemId() == R.id.nav_segundo_periodo){
                    fragment = new SegundoPeriodoFragment();
                }

                if (item.getItemId() == R.id.nav_terceiro_periodo){
                    fragment = new TerceiroPeriodoFragment();
                }

                if(item.getItemId() == R.id.nav_quarto_periodo){
                    fragment = new QuartoPeriodoFragment();
                }

                if (item.getItemId() == R.id.nav_quinto_periodo){
                    fragment = new QuartoPeriodoFragment();
                }

                if (item.getItemId() == R.id.nav_sexto_periodo){
                    fragment = new SegundoPeriodoFragment();
                }

               if (fragment != null){
                   getSupportFragmentManager()
                           .beginTransaction()
                           .replace(R.id.fragment_container, fragment)
                           .commit();
               }
               drawerLayout.closeDrawer(GravityCompat.START);
               return true;
            }
        });

        if (savedInstanceState == null){
          getSupportFragmentManager()
                  .beginTransaction()
                  .replace(R.id.fragment_container, new PrimeiroPeriodoFragment())
                  .commit();
        }
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    private void setup(){
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
    }
}