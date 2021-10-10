package com.example.echannel.ui.pcr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.echannel.HospitalDetailsModel;
import com.example.echannel.HospitalModel;
import com.example.echannel.R;
import com.example.echannel.hospitalAdapter;
import com.example.echannel.hospitalDetailAdapter;

import java.util.ArrayList;
import java.util.List;

public class PcrHospital extends Fragment {

    RecyclerView hospital;
//        Button book;

    List<HospitalDetailsModel> HospitalDetailsModel;
    hospitalDetailAdapter hospitalDetailAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pcr_hospital, container, false);
//        book = root.findViewById(R.id.bookbutton);
//
//        book.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), hospitals.class);
//                startActivity(intent);
//            }
//        });
        hospital =root.findViewById(R.id.hospitalpcr);
        HospitalDetailsModel = new ArrayList<>();
        HospitalDetailsModel.add(new HospitalDetailsModel(2021-01-02,"8.00 AM","Monday"));
        HospitalDetailsModel.add(new HospitalDetailsModel(2021-01-02,"8.00 AM","Monday"));
        HospitalDetailsModel.add(new HospitalDetailsModel(2021-01-02,"8.00 AM","Monday"));

        hospitalDetailAdapter = new hospitalDetailAdapter(getActivity(),HospitalDetailsModel);
        hospital.setAdapter(hospitalDetailAdapter);
        hospital.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        hospital.setHasFixedSize(true);
        hospital.setNestedScrollingEnabled(false);
        return root;
    }
}