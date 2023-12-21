package com.example.blackcoffertask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.blackcoffertask.databinding.ActivityExploreBinding;
import com.google.android.material.navigation.NavigationBarView;


public class ExploreActivity extends AppCompatActivity {

    ActivityExploreBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExploreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.refineMenuBtn.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), RefineActivity.class)));
        setFragment(new ExploreBottomNavFragment());
        binding.bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.explore_tab:{
                    setFragment(new ExploreBottomNavFragment());
                    break;
                }
                case R.id.network_tab:{
                    setFragment(new NetworkBottomNavFragment());
                    break;
                }
                case R.id.chat_tab:{
                    setFragment(new ChatBottomNavFragment());
                    break;
                }
                case R.id.contacts_tab:{
                    setFragment(new ContactsBottomNavFragment());
                    break;
                }
                case R.id.groups_tab:{
                    setFragment(new GroupsBottomNavFragment());
                    break;
                }
                default:
            }
            return true;
        });

    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}