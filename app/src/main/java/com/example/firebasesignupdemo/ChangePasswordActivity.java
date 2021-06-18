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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText edt_new_password;
    Button btn_pass;
    ProgressBar progressbar;

    FirebaseUser user;
    FirebaseAuth.AuthStateListener authListener;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        edt_new_password = findViewById(R.id.edt_new_password);
        btn_pass = findViewById(R.id.btn_pass);
        progressbar = findViewById(R.id.progressbar);

        user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    Intent i1 = new Intent(ChangePasswordActivity.this, MainActivity.class);
                    startActivity(i1);
                    finish();
                }
            }
        };

        btn_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UpdatePassword();
                Intent in = new Intent(ChangePasswordActivity.this, MainActivity.class);
                startActivity(in);

            }
        });

    }
    private void UpdatePassword(){

        password=edt_new_password.getText().toString();

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(ChangePasswordActivity.this, "Please enter Password", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(ChangePasswordActivity.this, "Password must be more than 6 digit", Toast.LENGTH_LONG).show();
            return;
        }
        progressbar.setVisibility(View.VISIBLE);

        user.updatePassword(password).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(ChangePasswordActivity.this, "Password is updated, sign in with new password!", Toast.LENGTH_SHORT).show();
                    progressbar.setVisibility(View.GONE);
                } else {
                    Toast.makeText(ChangePasswordActivity.this, "Failed to update password!", Toast.LENGTH_SHORT).show();
                    progressbar.setVisibility(View.GONE);
                }
            }
        });

    }
}