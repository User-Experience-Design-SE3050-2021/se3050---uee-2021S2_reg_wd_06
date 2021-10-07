package com.example.e_channeling.ui.channelHistory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.e_channeling.databinding.FragmentChannelHistoryBinding;

public class ChannelHistoryFragment extends Fragment {

    private FragmentChannelHistoryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentChannelHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();






        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}