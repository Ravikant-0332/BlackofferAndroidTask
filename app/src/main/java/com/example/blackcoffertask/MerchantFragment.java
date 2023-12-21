package com.example.blackcoffertask;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.blackcoffertask.databinding.FragmentMerchantBinding;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MerchantFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MerchantFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentMerchantBinding binding;

    public MerchantFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MerchantFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MerchantFragment newInstance(String param1, String param2) {
        MerchantFragment fragment = new MerchantFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_merchant, container, false);
        binding = FragmentMerchantBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<MerchantData> users = getDummyUsers();

        RecyclerView recyclerView = view.findViewById(R.id.fragment_merchant_rv);
        MerchantRecyclerViewAdapter adapter = new MerchantRecyclerViewAdapter(getContext(), users);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        binding.filterBtn.setOnClickListener(view1 -> {
            Toast.makeText(requireActivity().getApplicationContext(), "Clicked Filter Button", Toast.LENGTH_SHORT).show();
        });
    }

    ArrayList<MerchantData> getDummyUsers(){
        ArrayList<MerchantData> users = new ArrayList<>();

        users.add(new MerchantData(R.drawable.user4,
                "Anvi Goodluck Holidays",
                "Firozabad, within 77.7 KM",
                "Hi community! We have great deals for you. Check us out!!",
                67
        ));

        users.add(new MerchantData(R.drawable.user2,
                "Ayush tour and travels",
                "Delhi, within 105 KM",
                "Hi community! We have great deals for you. Check us out!! \nCar rental agency",
                80
        ));

        users.add(new MerchantData(R.drawable.user1,
                "Devendra Carpenter",
                "Agra, within 91.5 KM",
                "Hi community! We have great deals for you. Check us out!!",
                50
        ));

        users.add(new MerchantData(-1,
                "A to Z Cosmetic Shop",
                "Agra, within 96.5 KM",
                "Hi community! We have great deals for you. Check us out!!",
                70
        ));

        users.add(new MerchantData(-1,
                "The Platinum Planners By Kunjamal",
                "Agra, within 97.1 KM",
                "Hi community! We have great deals for you. Check us out!! \nWedding Planner",
                60
        ));

        return users;
    }
}