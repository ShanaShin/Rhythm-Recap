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


// This class interacts with Firebase Authentication to perform login, signup, logout, etc.
public class authentication extends AppCompatActivity {

    // Firebase Information
    FirebaseAuth mAuth;

    // Sign Up Information
    private TextView signUpEmail;
    private TextView signUpUsername;
    private TextView signUpPassword;

    private EditText editTextEmailSignUp;
    private EditText editTextUserNameSignUp;
    private EditText editTextPasswordSignUp;

    private AppCompatButton createAccountButton;

    private AppCompatButton connectSpotifyAccountButton;

    int index = 0;

    // Login Information
    private TextView textEmailLogin;
    private TextView textPasswordLogin;
    private EditText editTextEmailLogin;
    private EditText editTextPasswordLogin;

    private AppCompatButton loginAccountButton;

    // Access Spotify Information
    public static final String CLIENT_ID = "edd6322503f640c1a8514e901e175453";
    public static final String REDIRECT_URI = "com.example.spotifyencore://auth";

    public static final int AUTH_TOKEN_REQUEST_CODE = 0;
    public static final int AUTH_CODE_REQUEST_CODE = 1;

    private final OkHttpClient mOkHttpClient = new OkHttpClient();
    private String mAccessToken, mAccessCode;
    private Call mCall;

    // When initializing your Activity, check to see if the user is currently signed in
    @Override
    public void onStart() {

        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null) {
            Intent intent = new Intent(getApplicationContext(), firebaseUserManager.class);
            intent.putExtra("userAction", "homepage");
            intent.putExtra("userId", currentUser.getUid());
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String action = getIntent().getStringExtra("userAction");

        mAuth = FirebaseAuth.getInstance();

        editTextEmailSignUp = findViewById(R.id.editTextEmailSignUp);
        editTextPasswordSignUp = findViewById(R.id.editTextPasswordSignUp);
        editTextEmailLogin = findViewById(R.id.editTextEmailLogin);
        editTextPasswordLogin = findViewById(R.id.editTextPasswordLogin);

        // User Logs into their account
        if (action.equals("LogIn")) {

            setContentView(R.layout.login);

            loginAccountButton = findViewById(R.id.login_button);
            loginAccountButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email, password;
                    email = String.valueOf(editTextEmailLogin);
                    password = String.valueOf(editTextPasswordLogin);

                    if (TextUtils.isEmpty(email)) {
                        Toast.makeText(authentication.this, "Enter Email", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(password)) {
                        Toast.makeText(authentication.this, "Enter Password", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success - Show the Home Page For the User
                                        Toast.makeText(authentication.this, "Login Successful.",
                                                Toast.LENGTH_SHORT).show();
                                        /*
                                        Intent intent = new Intent(getApplicationContext(), firebaseUserManager.class);
                                        intent.putExtra("userAction", "homepage");
                                        startActivity(intent);
                                        finish();
                                        */

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(authentication.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            });

        } else if (action.equals("SignUp")) {

            setContentView(R.layout.signup);

            createAccountButton = findViewById(R.id.createAccountButtonSignUp);

            // User creates their new account
            createAccountButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email, password;
                    email = String.valueOf(editTextEmailSignUp);
                    password = String.valueOf(editTextPasswordSignUp);

                    if (TextUtils.isEmpty(email)) {
                        Toast.makeText(authentication.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    }

                    if (TextUtils.isEmpty(password)) {
                        Toast.makeText(authentication.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    }

                    // Create a New User if they don't already have an account
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(authentication.this, "Account Created.",
                                                Toast.LENGTH_SHORT).show();

                                    } else {
                                        Log.w("Authentication", "createUserWithEmail:failure", task.getException());
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(authentication.this, "Account Creation Failed",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            });

        }





    }

    private void retrieveSpotifyInformation() {




    }




    /**
     * Get token from Spotify
     * This method will open the Spotify login activity and get the token
     * What is token?
     * https://developer.spotify.com/documentation/general/guides/authorization-guide/
     */
    public void getToken() {
        final AuthorizationRequest request = getAuthenticationRequest(AuthorizationResponse.Type.TOKEN);
        AuthorizationClient.openLoginActivity(authentication.this, AUTH_TOKEN_REQUEST_CODE, request);
    }

    /**
     * Get code from Spotify
     * This method will open the Spotify login activity and get the code
     * What is code?
     * https://developer.spotify.com/documentation/general/guides/authorization-guide/
     */
    public void getCode() {
        final AuthorizationRequest request = getAuthenticationRequest(AuthorizationResponse.Type.CODE);
        AuthorizationClient.openLoginActivity(authentication.this, AUTH_CODE_REQUEST_CODE, request);
    }

    private void saveTokenToFirebase(String token) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(userId);
            userRef.child("spotifyAccessToken").setValue(token)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                // Token saved successfully
                                Toast.makeText(authentication.this, "Spotify token saved successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                // Failed to save token
                                Toast.makeText(authentication.this, "Failed to save Spotify token", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    /**
     * When the app leaves this activity to momentarily get a token/code, this function
     * fetches the result of that external activity to get the response from Spotify
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final AuthorizationResponse response = AuthorizationClient.getResponse(resultCode, data);

        // Check which request code is present (if any)
        if (AUTH_TOKEN_REQUEST_CODE == requestCode) {
            mAccessToken = response.getAccessToken();
            //setTextAsync(mAccessToken, tokenTextView);
            saveTokenToFirebase(mAccessToken);

        } else if (AUTH_CODE_REQUEST_CODE == requestCode) {
            mAccessCode = response.getCode();
            //setTextAsync(mAccessCode, codeTextView);
        }
    }



    /**
     * Creates a UI thread to update a TextView in the background
     * Reduces UI latency and makes the system perform more consistently
     *
     * @param text the text to set
     * @param textView TextView object to update
     */
    private void setTextAsync(final String text, TextView textView) {
        runOnUiThread(() -> textView.setText(text));
    }

    /**
     * Get authentication request
     *
     * @param type the type of the request
     * @return the authentication request
     */
    private AuthorizationRequest getAuthenticationRequest(AuthorizationResponse.Type type) {
        return new AuthorizationRequest.Builder(CLIENT_ID, type, getRedirectUri().toString())
                .setShowDialog(false)
                .setScopes(new String[] { "user-read-email" }) // <--- Change the scope of your requested token here
                .setCampaign("your-campaign-token")
                .build();
    }

    /**
     * Gets the redirect Uri for Spotify
     *
     * @return redirect Uri object
     */
    private Uri getRedirectUri() {
        return Uri.parse(REDIRECT_URI);
    }

    private void cancelCall() {
        if (mCall != null) {
            mCall.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        cancelCall();
        super.onDestroy();
    }






}
