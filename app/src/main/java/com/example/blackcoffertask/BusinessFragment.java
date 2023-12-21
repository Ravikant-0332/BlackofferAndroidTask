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

import com.example.blackcoffertask.databinding.FragmentBusinessBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BusinessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BusinessFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentBusinessBinding binding;

    public BusinessFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BusinessFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BusinessFragment newInstance(String param1, String param2) {
        BusinessFragment fragment = new BusinessFragment();
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
        View view = inflater.inflate(R.layout.fragment_business, container, false);
        binding = FragmentBusinessBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<BusinessData> users = getDummyUsers();

        RecyclerView recyclerView = view.findViewById(R.id.fragment_business_rv);
        BusinessRecyclerViewAdapter adapter = new BusinessRecyclerViewAdapter(getContext(), users);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        binding.filterBtn.setOnClickListener(view1 -> {
            Toast.makeText(requireActivity().getApplicationContext(), "Clicked Filter Button", Toast.LENGTH_SHORT).show();
        });
    }

    ArrayList<BusinessData> getDummyUsers(){
        ArrayList<BusinessData> users = new ArrayList<>();

        users.add(new BusinessData(R.drawable.user2,
                "Rakesh Yadav",
                "Gwalior, within 69.6 KM",
                "Ahjaa | 1 years of experience",
                "Hi community! I am available at your service!",
                "+INVITE",
                30
        ));

        users.add(new BusinessData(R.drawable.user5,
                "Kapil Dev Sharma",
                "Noida, within 76.5 KM",
                "Student | 0 years of experience",
                "Hi community! I am available at your service! \nI am a student who has keen interest in python programming and development. I have made some Projects like games (Gun, Snake and water) by using Python. I have good knowledge of python programming language.",
                "+INVITE",
                10
        ));

        users.add(new BusinessData(-1,
                "Himanshu Gupta",
                "Morena, within 81.7 KM",
                "Software Developer | 1 years of experience",
                "Hi community! I am available at your service!",
                "PENDING",
                20
        ));

        users.add(new BusinessData(R.drawable.user6,
                "fakra Parvez",
                "Etawah | within 34.3 KM",
                "Student | 0 years of experience",
                "Hi community! I am available at your service!",
                "+INVITE",
                15
        ));

        users.add(new BusinessData(R.drawable.user4,
                "Shalini Gupta",
                "Gwalior | Manual Tester",
                "Content Writer | 5 years of experience",
                "Hi community! I am available at your service!",
                "+INVITE",
                70
        ));

        return users;
    }
}