package com.example.e_channeling.ui.channelHistory;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.e_channeling.R;
import com.example.e_channeling.databinding.FragmentChannelHistoryBinding;

public class ChannelHistoryFragment extends Fragment {

    ListView historyList;
    String dName[] = {"Dr_Jane_Doe", "Dr_Jean_Louis", "Dr_Ryan_Lehr"};
    String dType[] = {"Family Physician", "Emergency Physician", "Radiologist"};
    String date[] = {"2021/10/1", "2021/5/1", "2021/9/5"};
    String time[] = {"10.00AM", "12.30PM", "8.20AM", };
    String price[] = { "LKR 5000.00", "LKR 2500.00", "LKR 8000.00"};

    int images[] = {R.drawable.dr_jane_doe, R.drawable.dr_jean_louis, R.drawable.dr_ryan_lehr};
    private FragmentChannelHistoryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentChannelHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        historyList= binding.historyList;

        CustomAdapter adapter = new CustomAdapter(getActivity().getApplication(), dName, dType, date, time,price, images);
//startActivity(new Intent(getActivity().getApplication(), MainActivity.class));
        historyList.setAdapter(adapter);




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    class CustomAdapter extends ArrayAdapter<String> {

        Context context;
        String[] dName;
        String[] dType;
        String[] date;
        String[] time;
        String[] price;

        int[] image;

        CustomAdapter(Context context, String[] dName, String[] dType, String[] date, String[] time, String[] price, int[] image) {
            super(context, R.layout.history_adapter, R.id.dName, dName);
            this.context = context;
            this.dName = dName;
            this.dType = dType;
            this.date = date;
            this.time = time;
            this.price = price;
            this.image = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.history_adapter, parent, false);

            TextView nameText = v.findViewById(R.id.dName);
            TextView typeText = v.findViewById(R.id.dType);
            TextView dateText = v.findViewById(R.id.dDate);
            TextView timeText = v.findViewById(R.id.dTime);
            TextView priceText = v.findViewById(R.id.dPrice);
            ImageView img = v.findViewById(R.id.img);

            nameText.setText(dName[position]);
            typeText.setText(dType[position]);
            dateText.setText(date[position]);
            timeText.setText(time[position]);
            priceText.setText(price[position]);
            img.setImageResource(image[position]);


            return v;
        }
    }
}