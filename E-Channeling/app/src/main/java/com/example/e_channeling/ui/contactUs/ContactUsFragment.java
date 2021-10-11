package com.example.e_channeling.ui.contactUs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.e_channeling.databinding.FragmentContactUsBinding;

public class ContactUsFragment extends Fragment {

    private FragmentContactUsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContactUsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:9477778888"));
                startActivity(callIntent);
            }
        });
        binding.webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.echannelling.com/Echannelling/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        binding.emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, "");
                intent.putExtra(Intent.EXTRA_SUBJECT, "");

                startActivity(intent);
            }
            });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}