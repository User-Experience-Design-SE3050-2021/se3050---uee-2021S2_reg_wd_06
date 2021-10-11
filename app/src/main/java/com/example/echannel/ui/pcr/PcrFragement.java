package com.example.echannel.ui.pcr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.echannel.HospitalModel;
import com.example.echannel.R;
import com.example.echannel.hospitalAdapter;

import java.util.ArrayList;
import java.util.List;

public class PcrFragement extends Fragment {

        RecyclerView hospitalvertical;
//        Button book;

        List<HospitalModel> hospitalModelList;
        hospitalAdapter hospitalAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pcr, container, false);
//        book = root.findViewById(R.id.bookbutton);
//
//        book.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), hospitals.class);
//                startActivity(intent);
//            }
//        });
        hospitalvertical =root.findViewById(R.id.pcr_ver);
        hospitalModelList = new ArrayList<>();
        hospitalModelList.add(new HospitalModel(R.drawable.ic_baseline_local_hospital_24,R.drawable.ic_baseline_local_hospital_24,"DURDANS HOSPITAL","PCR TEST","Durdans Hospital -Colombo 3"));
        hospitalModelList.add(new HospitalModel(R.drawable.ic_baseline_local_hospital_24,R.drawable.ic_baseline_local_hospital_24,"ASIRI HOSPITAL","PCR TEST","Asiri Hospital -Colombo 3"));
        hospitalModelList.add(new HospitalModel(R.drawable.ic_baseline_local_hospital_24,R.drawable.ic_baseline_local_hospital_24,"Navaloka HOSPITAL","PCR TEST","Navaloka Hospital -Colombo 3"));

        hospitalAdapter = new hospitalAdapter(getActivity(),hospitalModelList);
        hospitalvertical.setAdapter(hospitalAdapter);
        hospitalvertical.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        hospitalvertical.setHasFixedSize(true);
        hospitalvertical.setNestedScrollingEnabled(false);
        return root;
    }
}