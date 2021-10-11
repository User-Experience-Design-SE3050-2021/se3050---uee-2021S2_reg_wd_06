package com.example.echannel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class hospitalDetailAdapter extends RecyclerView.Adapter<hospitalDetailAdapter.ViewHolder>
{
    Context context;
    List<HospitalDetailsModel> list;



    public hospitalDetailAdapter(Context context, List<HospitalDetailsModel> list){
        this.context = context;
        this.list = list;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pcr_hospital,parent,false));


    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

            TextView date,time,dateName;
            Button available;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.textView2);
            time = itemView.findViewById(R.id.textView14);
//            dateName = itemView.findViewById(R.id.textView15);

            available = itemView.findViewById(R.id.available);


        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.available.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(holder.itemView).navigate(R.id.nav_Popup);
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
