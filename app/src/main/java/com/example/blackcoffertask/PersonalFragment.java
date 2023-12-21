package com.example.blackcoffertask;

import android.annotation.SuppressLint;
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

import com.example.blackcoffertask.databinding.FragmentPersonalBinding;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentPersonalBinding binding;

    public PersonalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonalFragment newInstance(String param1, String param2) {
        PersonalFragment fragment = new PersonalFragment();
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
        View view = inflater.inflate(R.layout.fragment_personal, container, false);
        binding = FragmentPersonalBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<UserData> users = getDummyUsers();

        RecyclerView recyclerView = view.findViewById(R.id.fragment_personal_rv);
        PersonalRecyclerViewAdapter adapter = new PersonalRecyclerViewAdapter(getContext(), users);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        binding.filterBtn.setOnClickListener(view1 -> {
            Toast.makeText(requireActivity().getApplicationContext(), "Clicked Filter Button", Toast.LENGTH_SHORT).show();
        });
    }

    ArrayList<UserData> getDummyUsers(){
        ArrayList<UserData> users = new ArrayList<>();

        users.add(new UserData(R.drawable.user2,
                "Himanshu Gautam",
                "Indore | Software Tester",
                "Within 1.9 KM",
                "Coffee | Friendship | Business",
                "Hi community! I am open to new connections \"😊\"",
                "PENDING",
                25
        ));

        users.add(new UserData(R.drawable.user5,
                "Rajesh Mamgain",
                "Roorkee | Self-Employed",
                "Within 32.1 KM",
                "Coffee | Friendship | Dating | Business",
                "Hi community! I am open to new connections \"😊\"",
                "+INVITE",
                50
        ));

        users.add(new UserData(R.drawable.user3,
                "Aparna Sharma",
                "Etawah | Student",
                "Within 33.3 KM",
                "Coffee | Friendship | Business",
                "Hi community! I am open to new connections \"😊\"",
                "PENDING",
                20
        ));

        users.add(new UserData(R.drawable.user6,
                "fakra Parvez",
                "Etawah | Housewife",
                "Within 33.3 KM",
                "Coffee | Friendship | Business",
                "Hi community! I am open to new connections \"😊\"",
                "+INVITE",
                15
        ));

        users.add(new UserData(-1,
                "Ankita Yadav",
                "Gwalior | Student",
                "Within 67.6 KM",
                "Friendship | Movies",
                "Hi community! I am open to new connections \"😊\" \nI am learning enthusiast and always ready to grab the opportunity to learn new things.",
                "+INVITE",
                40
        ));

        users.add(new UserData(R.drawable.user4,
                "Shalini Gupta",
                "Gwalior | Manual Tester",
                "Within 44.6 KM",
                "Coffee | Friendship | Movies | Dating | Hobbies | Matrimony | Business",
                "Hi community! I am open to new connections \"😊\"",
                "+INVITE",
                10
        ));

        users.add(new UserData(-1,
                "Ankit Kumar",
                "Kanpur | UI and UX Designer",
                "Within 60.1 KM",
                "Coffee | Friendship | Movies | Business",
                "Hi community! I am open to new connections \"😊\"",
                "+INVITE",
                30
        ));

        users.add(new UserData(R.drawable.user1,
                "Rudram Pathak",
                "Gwalior | Student Member",
                "Within 1.9 KM",
                "Coffee | Friendship | Movies | Dating | Hobbies | Matrimony | Business",
                "Hi community! I am open to new connections \"😊\"",
                "PENDING",
                90
        ));

        return users;
    }
}