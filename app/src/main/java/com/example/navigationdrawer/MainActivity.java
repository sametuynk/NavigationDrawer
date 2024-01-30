package com.example.navigationdrawer;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.navigationdrawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        //navigationView ile navHostFragment birleştime işlemi yaptım.
        NavigationUI.setupWithNavController(binding.navigationView,navHostFragment.getNavController());

        binding.toolbar.setTitle("Başlık");

        //drawer ile toolbarı beraber çalışır hale getirildi.
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,binding.drawer,binding.toolbar,0,0);
        binding.drawer.addDrawerListener(toggle);

        toggle.syncState();

    }
}