package com.example.echannel.ui.pcr;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.echannel.AvailableDoctors;
import com.example.echannel.R;
import com.example.echannel.Registration;


public class Popup extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_popup, container, false);
        Button proceed  = v.findViewById(R.id.proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Navigation.findNavController(requireActivity(),R.id.nav_host_fragment_content_main).navigate(R.id.nav_Registration);
//                FragmentManager fragmentManager = getParentFragmentManager();
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                transaction.setReorderingAllowed(true);
//
//// Replace whatever is in the fragment_container view with this fragment
//                transaction.replace(R.id.nav_host_fragment_container, RegistrationFragement.class, null);
//
//// Commit the transaction
//                transaction.commit();
                startActivity(new Intent(getActivity(), Registration.class));
            }
        });
        return v;
    }
}