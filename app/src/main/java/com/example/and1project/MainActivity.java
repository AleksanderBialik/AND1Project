package com.example.and1project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.and1project.Firebase.Firebase;
import com.example.and1project.Fragments.MainFragment;
import com.firebase.ui.auth.AuthUI;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainFragment()).commit();
            navigationView.setCheckedItem(R.id.itemMain);
        }



    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemMain:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainFragment()).commit();
                break;
            case R.id.itemLogOut:
                AuthUI.getInstance().signOut(this).addOnCompleteListener(
                        task -> {
                            Toast.makeText(getApplicationContext(), "You are now signed out",
                                    Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), Firebase.class));
                            finish();
                        }
                );
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

}
