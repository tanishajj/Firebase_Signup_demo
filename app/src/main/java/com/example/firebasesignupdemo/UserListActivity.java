package com.example.firebasesignupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserListActivity extends AppCompatActivity {

    TextView txt_id,txt_name,txt_username,txt_email,
            txt_street,txt_suite,txt_city,txt_zipcode,
            txt_lat,txt_lng,
            txt_phone,txt_website,
            txt_cname,txt_catchphrase,txt_bs;

    String id,name,username,email,
            street,suite,city,zipcode,
            lat,lng,
            phone,website,
            cname,catchPhrase,bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        txt_id = findViewById(R.id.txt_id);
        txt_name = findViewById(R.id.txt_name);
        txt_username = findViewById(R.id.txt_username);
        txt_email = findViewById(R.id.txt_email);

        txt_street = findViewById(R.id.txt_street);
        txt_suite = findViewById(R.id.txt_suite);
        txt_city = findViewById(R.id.txt_city);
        txt_zipcode = findViewById(R.id.txt_zipcode);

        txt_lat = findViewById(R.id.txt_lat);
        txt_lng = findViewById(R.id.txt_lng);

        txt_phone = findViewById(R.id.txt_phone);
        txt_website = findViewById(R.id.txt_website);

        txt_cname = findViewById(R.id.txt_cname);
        txt_catchphrase = findViewById(R.id.txt_catchphrase);
        txt_bs = findViewById(R.id.txt_bs);

        id=getIntent().getStringExtra("id");
        name=getIntent().getStringExtra("name");
        username=getIntent().getStringExtra("username");
        email=getIntent().getStringExtra("email");

        street=getIntent().getStringExtra("street");
        suite=getIntent().getStringExtra("suite");
        city=getIntent().getStringExtra("city");
        zipcode=getIntent().getStringExtra("zipcode");

        lat=getIntent().getStringExtra("lat");
        lng=getIntent().getStringExtra("lng");

        phone=getIntent().getStringExtra("phone");
        website=getIntent().getStringExtra("website");

        cname=getIntent().getStringExtra("cname");
        catchPhrase=getIntent().getStringExtra("catchPhrase");
        bs=getIntent().getStringExtra("bs");

        txt_id.setText(id);
        txt_name.setText(name);
        txt_username.setText(username);
        txt_email.setText(email);

        txt_street.setText(street);
        txt_suite.setText(suite);
        txt_city.setText(city);
        txt_zipcode.setText(zipcode);

        txt_lat.setText(lat);
        txt_lng.setText(lng);

        txt_phone.setText(phone);
        txt_website.setText(website);

        txt_cname.setText(cname);
        txt_catchphrase.setText(catchPhrase);
        txt_bs.setText(bs);

    }
}