package com.example.e_channeling.ui.claimRefund;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.e_channeling.CreateRefund;
import com.example.e_channeling.R;
import com.example.e_channeling.databinding.FragmentClaimRefundBinding;


public class ClaimRefundFragment extends Fragment {

    ListView refundList;
    String ref[] = {"0012354823", "0014569823", "0024523458"};
    String reason[] = {"Wrong doctor selection", "Emergency Physician", "Radiologist"};
    String refund[] = { "LKR 5000.00", "LKR 2500.00", "LKR 8000.00"};
    String state[] = {"Approved", "Rejected", "Approved"};


    private FragmentClaimRefundBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentClaimRefundBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        refundList= binding.refunList;


       CustomAdapter adapter = new CustomAdapter(getActivity().getApplicationContext(), ref, reason, refund, state);

        refundList.setAdapter(adapter);

        binding.makeRefundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplication(), CreateRefund.class));
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
class CustomAdapter extends ArrayAdapter<String> {

    Context context;
    String[] ref;
    String[] reason;
    String[] price;
    String[] state;


    CustomAdapter(Context context, String[] ref, String[] reason, String[] price, String [] state) {
        super(context, R.layout.refund_adapter, R.id.ref, ref);
        this.context = context;
        this.ref = ref;
        this.reason = reason;
        this.price = price;
        this.state = state;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.refund_adapter, parent, false);

        TextView refText = v.findViewById(R.id.ref);
        TextView reasonText = v.findViewById(R.id.res);
        TextView priceText = v.findViewById(R.id.pr);
        TextView stat = v.findViewById(R.id.stat);


        refText.setText(ref[position]);
        reasonText.setText(reason[position]);
        priceText.setText(price[position]);
        stat.setText(state[position]);


        return v;
    }
}