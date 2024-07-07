package com.example.spotify_encore;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import com.google.firebase.database.DatabaseReference;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class signUp extends AppCompatActivity {

    FirebaseAuth mAuth;

    // Sign Up Information
    private TextView signUpEmail;
    private TextView signUpUsername;
    private TextView signUpPassword;

    private EditText editTextEmailSignUp;
    private EditText editTextUserNameSignUp;
    private EditText editTextPasswordSignUp;

    private AppCompatButton createAccountButton;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), firebaseUserManager.class);
            intent.putExtra("userAction", "homepage");
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup);

        mAuth = FirebaseAuth.getInstance();

        editTextEmailSignUp = findViewById(R.id.editTextEmailSignUp);
        editTextPasswordSignUp = findViewById(R.id.editTextPasswordSignUp);
        createAccountButton = findViewById(R.id.createAccountButtonSignUp);

        // User creates their new account

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = editTextEmailSignUp.getText().toString();
                password = editTextPasswordSignUp.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    editTextEmailSignUp.setError("Invalid Email");
                    editTextEmailSignUp.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    editTextPasswordSignUp.setError("Invalid Password");
                    editTextPasswordSignUp.requestFocus();
                    return;
                }

                registerUser(email, password);

                /*

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(signUp.this, "Enter Email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(signUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
                } else {

                }
                */

            }
        });
    }

    private void registerUser(String email, String password) {
        // Create a New User if they don't already have an account
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signUp.this, "Account Created.",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplicationContext(), login.class);
                            startActivity(intent);
                        } else {
                            Log.w("Authentication", "createUserWithEmail:failure", task.getException());
                            // If sign in fails, display a message to the user.
                            Toast.makeText(signUp.this, "Account Creation Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}
