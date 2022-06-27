package com.firstapp.applicationdev1.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.firstapp.applicationdev1.R;
import com.firstapp.applicationdev1.databinding.FragmentHomeBinding;
import com.firstapp.applicationdev1.menuActivity_notes;
import com.firstapp.applicationdev1.quiz_main;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ImageButton mnotes;
    private ImageButton mquiz;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mnotes = root.findViewById(R.id.notes);
        mnotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), menuActivity_notes.class);
                startActivity(intent);
            }
        });

        mquiz = root.findViewById(R.id.quiz);
        mquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), quiz_main.class);
                startActivity(intent);
            }
        });

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}