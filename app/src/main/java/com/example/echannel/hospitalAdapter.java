package com.example.echannel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.echannel.ui.pcr.PcrHospital;

import java.util.List;

public class hospitalAdapter extends RecyclerView.Adapter<hospitalAdapter.ViewHolder>
{
    Context context;
    List<HospitalModel> list;



    public hospitalAdapter(Context context,List<HospitalModel> list){
        this.context = context;
        this.list = list;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pcr_vertical_hospitals,parent,false));


    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView image1,image2;
            TextView hospital,test,address;
            Button book;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.image1);
            image2 = itemView.findViewById(R.id.image2);
            hospital = itemView.findViewById(R.id.textView2);
            test = itemView.findViewById(R.id.textView5);
            address = itemView.findViewById(R.id.textView6);
            book = itemView.findViewById(R.id.available);


        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image1.setImageResource(list.get(position).getImage1());
        holder.image2.setImageResource(list.get(position).getImage2());

        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(holder.itemView).navigate(R.id.nav_hospital);
            }
        });

//        holder.book.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, PcrHospital.class);
//                context.startActivity(intent);
//            }
//        });


    }
}
