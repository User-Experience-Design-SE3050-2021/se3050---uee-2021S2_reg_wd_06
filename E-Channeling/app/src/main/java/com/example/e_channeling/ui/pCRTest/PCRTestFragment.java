package com.example.e_channeling.ui.pCRTest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.e_channeling.databinding.FragmentPcrTestBinding;

public class PCRTestFragment extends Fragment {

    private FragmentPcrTestBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPcrTestBinding.inflate(inflater, container, false);
        View root = binding.getRoot();






        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}