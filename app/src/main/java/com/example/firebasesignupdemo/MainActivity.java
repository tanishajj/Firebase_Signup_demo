package com.example.firebasesignupdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebasesignupdemo.modle.User;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    EditText edt_mail, edt_pass;
    Button btn_sign_in ,btn_google_signin;
    TextView txt_forgot, txt_sign_up;
    ProgressBar progressbar;

    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    String email,password;

    private static final int RC_SIGN_IN = 005;
    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_mail = findViewById(R.id.edt_mail);
        edt_pass = findViewById(R.id.edt_pass);
        btn_sign_in = findViewById(R.id.btn_sign_in);

        btn_google_signin = findViewById(R.id.btn_google_signin);

        txt_forgot = findViewById(R.id.txt_forgot);
        txt_sign_up = findViewById(R.id.txt_sign_up);
        progressbar = findViewById(R.id.progressbar);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        GoogleSignInOptions gsoptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API, gsoptions).build();

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserSigninAuthData();
            }
        });

        btn_google_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(signInIntent, RC_SIGN_IN);

            }
        });

        txt_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(MainActivity.this, ChangePasswordActivity.class);
                startActivity(ii);
            }
        });

        txt_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(i1);
            }
        });
    }

    private void UserSigninAuthData(){

        email=edt_mail.getText().toString();
        password=edt_pass.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(MainActivity.this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(MainActivity.this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(MainActivity.this, "Password must be more than 6 digit", Toast.LENGTH_LONG).show();
            return;
        }
        progressbar.setVisibility(View.VISIBLE);

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                    progressbar.setVisibility(View.GONE);
                    Intent i = new Intent(MainActivity.this, UsersDataActivity.class);
                    startActivity(i);
                    edt_mail.setText("");
                    edt_pass.setText("");

                } else {
                    Toast.makeText(MainActivity.this, "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                    progressbar.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            signInResult(result);
        }

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        OptionalPendingResult<GoogleSignInResult> opresult = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
//        if (opresult.isDone()) {

//            Toast.makeText(MainActivity.this, "Got cached sign-in", Toast.LENGTH_LONG).show();
//            GoogleSignInResult result = opresult.get();
//            signInResult(result);
//        } else {
//            progressbar.setVisibility(View.VISIBLE);
//            opresult.setResultCallback(new ResultCallback<GoogleSignInResult>() {
//                @Override
//                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
//                    progressbar.setVisibility(View.GONE);
//                    signInResult(googleSignInResult);
//                }
//            });
//        }
//    }

    private void signInResult(GoogleSignInResult result){

        if(result.isSuccess()){

            GoogleSignInAccount account = result.getSignInAccount();

            edt_mail.setText(account.getEmail());
            Toast.makeText(MainActivity.this, "SignIn successful!! ", Toast.LENGTH_LONG).show();
            Intent userIntent = new Intent(MainActivity.this, UsersDataActivity.class);
            startActivity(userIntent);
            progressbar.setVisibility(View.GONE);

        } else {
            Toast.makeText(MainActivity.this, "SignIn failed!!! ", Toast.LENGTH_LONG).show();
            progressbar.setVisibility(View.GONE);
        }

    }

}