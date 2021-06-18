package com.example.firebasesignupdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebasesignupdemo.modle.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignupActivity extends AppCompatActivity {

    EditText edt_full_name, edt_email_id, edt_password;
    Button btn_sign_up;
    TextView txt_sign_in;
    ProgressBar progressbar;

    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    String name,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edt_full_name = findViewById(R.id.edt_full_name);
        edt_email_id = findViewById(R.id.edt_email_id);
        edt_password = findViewById(R.id.edt_password);
        btn_sign_up = findViewById(R.id.btn_sign_up);
        txt_sign_in = findViewById(R.id.txt_sign_in);
        progressbar = findViewById(R.id.progressbar);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserSignupAuthData();
//                AddUserData();

            }
        });
        txt_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(i1);
            }
        });

    }

    private void UserSignupAuthData(){

        name=edt_full_name.getText().toString();
        email=edt_email_id.getText().toString();
        password=edt_password.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(SignupActivity.this, "Please enter Full Name", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(SignupActivity.this, "Please enter Email", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(SignupActivity.this, "Please enter Password", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(SignupActivity.this, "Password must be more than 6 digit", Toast.LENGTH_LONG).show();
            return;
        }
        progressbar.setVisibility(View.VISIBLE);

            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        AddUserData();
                        Toast.makeText(SignupActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                        progressbar.setVisibility(View.GONE);
                        Intent i = new Intent(SignupActivity.this, MainActivity.class);
                        startActivity(i);
                        edt_full_name.setText("");
                        edt_email_id.setText("");
                        edt_password.setText("");
                    } else {
                        Toast.makeText(SignupActivity.this, "Registration failed! Please try again later", Toast.LENGTH_LONG).show();
                        progressbar.setVisibility(View.GONE);
                    }
                }
            });
    }
    private void AddUserData(){

        CollectionReference collectionReference = firebaseFirestore.collection("Users");

        User users = new User(name,email,password);
        collectionReference.add(users).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {

                Toast.makeText(SignupActivity.this, "Your User has been added to Firebase Firestore.... " + users.getFull_name()   + users.getMail(), Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(SignupActivity.this, "Fail to add user \n" + e, Toast.LENGTH_SHORT).show();

            }
        });
    }
}