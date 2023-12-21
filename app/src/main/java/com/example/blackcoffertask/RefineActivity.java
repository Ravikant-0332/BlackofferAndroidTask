package com.example.blackcoffertask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blackcoffertask.databinding.ActivityRefineBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class RefineActivity extends AppCompatActivity {

    ActivityRefineBinding binding;
    private int countSelectedPurpose=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRefineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayout coffee_ll = binding.coffeeLl;
        LinearLayout business_ll = binding.businessLl;
        LinearLayout hobbies_ll = binding.hobbiesLl;
        LinearLayout friendship_ll = binding.friendshipLl;
        LinearLayout movies_ll = binding.moviesLl;
        LinearLayout dinning_ll = binding.dinningLl;
        LinearLayout dating_ll = binding.datingLl;
        LinearLayout matrimony_ll = binding.matrimonyLl;

        TextView coffee_tgl = binding.coffeeTgl;
        TextView business_tgl = binding.businessTgl;
        TextView hobbies_tgl = binding.hobbiesTgl;
        TextView friendship_tgl = binding.friendshipTgl;
        TextView movies_tgl = binding.moviesTgl;
        TextView dinning_tgl = binding.dinningTgl;
        TextView dating_tgl = binding.datingTgl;
        TextView matrimony_tgl = binding.matrimonyTgl;

        coffee_ll.setOnClickListener(view -> toggle(coffee_ll, coffee_tgl));
        business_ll.setOnClickListener(view -> toggle(business_ll, business_tgl));
        hobbies_ll.setOnClickListener(view -> toggle(hobbies_ll, hobbies_tgl));
        friendship_ll.setOnClickListener(view -> toggle(friendship_ll, friendship_tgl));
        movies_ll.setOnClickListener(view -> toggle(movies_ll, movies_tgl));
        dinning_ll.setOnClickListener(view -> toggle(dinning_ll, dinning_tgl));
        dating_ll.setOnClickListener(view -> toggle(dating_ll, dating_tgl));
        matrimony_ll.setOnClickListener(view -> toggle(matrimony_ll, matrimony_tgl));

        ArrayList<String> choices;
        choices = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.availability_choices)));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplication(), R.layout.spinner_item_card, choices);
        binding.filledExposedDropdown.setAdapter(adapter);

        binding.backButton.setOnClickListener(view -> finish());
        binding.saveButton.setOnClickListener(view -> Toast.makeText(this, "Changes Saved", Toast.LENGTH_SHORT).show());

        binding.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.seekbarIndicator.setText(String.valueOf((int)(0.99*i+1)));
                binding.dummyPi.setLayoutParams(new LinearLayout.LayoutParams((int)((binding.seekbar.getWidth()-3.5*binding.seekbar.getThumbOffset())*i/100.0), ViewGroup.LayoutParams.WRAP_CONTENT));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void toggle(LinearLayout ll, TextView tgl){
        if(tgl.getCurrentTextColor() == getColor(R.color.base)){
            //Outlined to solid
            ll.setBackground(getDrawable(R.drawable.button_round_bg));
            tgl.setTextColor(getColor(R.color.white));
            countSelectedPurpose++;
        }else{
            // Solid To Outlined
            if(countSelectedPurpose>1){
                ll.setBackground(getDrawable(R.drawable.button_round_outline_bg));
                tgl.setTextColor(getColor(R.color.base));
                countSelectedPurpose--;
            }
        }
    }
}