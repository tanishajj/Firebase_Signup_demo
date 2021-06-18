package com.example.firebasesignupdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasesignupdemo.R;
import com.example.firebasesignupdemo.UserListActivity;
import com.example.firebasesignupdemo.UsersApiInterface;
import com.example.firebasesignupdemo.UsersDataActivity;
import com.example.firebasesignupdemo.modle.Users;

import java.util.List;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.RecyclerViewHolder> {

    List<Users> model;
    Context context;

    public UsersRecyclerAdapter( List<Users> model , Context context) {
        this.model = model;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row_userdata,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        final Users temp = model.get(position);

        holder.txt_id.setText(model.get(position).getString_id());
        holder.txt_name.setText(model.get(position).getString_name());
        holder.txt_username.setText(model.get(position).getString_username());
        holder.txt_email.setText(model.get(position).getString_email());

        holder.txt_street.setText(model.get(position).getAddress().getString_street());
        holder.txt_suite.setText(model.get(position).getAddress().getString_suite());
        holder.txt_city.setText(model.get(position).getAddress().getString_city());
        holder.txt_zipcode.setText(model.get(position).getAddress().getString_zipcode());

        holder.txt_lat.setText(model.get(position).getAddress().getGeolocation().getString_lat());
        holder.txt_lng.setText(model.get(position).getAddress().getGeolocation().getString_lng());

        holder.txt_phone.setText(model.get(position).getString_phone());
        holder.txt_website.setText(model.get(position).getString_website());

        holder.txt_cname.setText(model.get(position).getCompany().getString_cname());
        holder.txt_catchphrase.setText(model.get(position).getCompany().getString_catchPhrase());
        holder.txt_bs.setText(model.get(position).getCompany().getString_bs());

        holder.linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UserListActivity.class);

                intent.putExtra("id",temp.getString_id());
                intent.putExtra("name",temp.getString_name());
                intent.putExtra("username",temp.getString_username());
                intent.putExtra("email",temp.getString_email());

                intent.putExtra("street",temp.getAddress().getString_street());
                intent.putExtra("suite",temp.getAddress().getString_suite());
                intent.putExtra("city",temp.getAddress().getString_city());
                intent.putExtra("zipcode",temp.getAddress().getString_zipcode());

                intent.putExtra("lat",temp.getAddress().getGeolocation().getString_lat());
                intent.putExtra("lng",temp.getAddress().getGeolocation().getString_lng());

                intent.putExtra("phone",temp.getString_phone());
                intent.putExtra("website",temp.getString_website());

                intent.putExtra("cname",temp.getCompany().getString_cname());
                intent.putExtra("catchPhrase",temp.getCompany().getString_catchPhrase());
                intent.putExtra("bs",temp.getCompany().getString_bs());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView txt_id,txt_name,txt_username,txt_email,
                txt_street,txt_suite,txt_city,txt_zipcode,
                txt_lat,txt_lng,
                txt_phone,txt_website,
                txt_cname,txt_catchphrase,txt_bs;

        LinearLayout linearlayout;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.txt_id);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_username = itemView.findViewById(R.id.txt_username);
            txt_email = itemView.findViewById(R.id.txt_email);

            txt_street = itemView.findViewById(R.id.txt_street);
            txt_suite = itemView.findViewById(R.id.txt_suite);
            txt_city = itemView.findViewById(R.id.txt_city);
            txt_zipcode = itemView.findViewById(R.id.txt_zipcode);

            txt_lat = itemView.findViewById(R.id.txt_lat);
            txt_lng = itemView.findViewById(R.id.txt_lng);

            txt_phone = itemView.findViewById(R.id.txt_phone);
            txt_website = itemView.findViewById(R.id.txt_website);

            txt_cname = itemView.findViewById(R.id.txt_cname);
            txt_catchphrase = itemView.findViewById(R.id.txt_catchphrase);
            txt_bs = itemView.findViewById(R.id.txt_bs);

            linearlayout =itemView.findViewById(R.id.linearlayout);

        }
    }
}
