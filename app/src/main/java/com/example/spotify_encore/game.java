package com.example.spotify_encore;


import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;
import androidx.recyclerview.widget.LinearLayoutManager;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;

import org.checkerframework.checker.units.qual.A;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import org.json.JSONArray;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import android.widget.Toast;

public class game extends AppCompatActivity {
    AppCompatButton submitAnswer;
    AppCompatButton playAgain;
    FirebaseAuth auth;
    FirebaseUser user;
    FirebaseDatabase FdataBase;
    String userID;
    List<JSONObject> wrapsJsonList2;
    List<String> trackQuestions;
    List<String> artistAnswers;
    TextView playerScore;
    EditText guessSongEdit;
    TextView songText;

    AppCompatButton submitButotn;

    boolean currentGame = false;

    int playerScoreValue;

    int currentQuestionIndex;

    AppCompatButton playAgainButton;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.game);

        FdataBase = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        userID = getIntent().getStringExtra("userId");
        playerScore = findViewById(R.id.scoreTracker);
        songText = findViewById(R.id.songText);
        guessSongEdit = findViewById(R.id.guessSongEdit);
        submitAnswer = findViewById(R.id.checkIfYouWinButton);
        wrapsJsonList2 = new ArrayList<>();
        trackQuestions = new ArrayList<>();
        artistAnswers = new ArrayList<>();

        if (user != null) {

            setWrapsList();
            currentGame = true;
            populateInfo();
            playGame();


        }
    }

    public void setWrapsList() {
        String userId = user.getUid();
        DatabaseReference userWrapsRef = FirebaseDatabase.getInstance().getReference()
                .child("users").child(userId).child("Wraps");
        userWrapsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String wrapJsonString = snapshot.getValue(String.class);
                    try {
                        JSONObject wrapJson = new JSONObject(wrapJsonString);
                        // wrapsJsonList.add(wrapJson);
                        wrapsJsonList2.add(wrapJson);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        // Handle JSON parsing error
                    }
                }

                populateInfo();

                playGame();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle database error
                Log.e("Firebase", "Database error: " + databaseError.getMessage());
            }
        });
    }

    private void populateInfo() {
        try {
            for (int k = 0; k < wrapsJsonList2.size(); ++k) {
                StringBuilder topTrack = new StringBuilder();
                StringBuilder topArtist = new StringBuilder();
                JSONObject wrapJson = wrapsJsonList2.get(k);

                JSONArray topTracksArray = wrapJson.getJSONArray("topTracks");
                JSONArray topArtistsArray = wrapJson.getJSONArray("topArtists");
                String topAlbum = wrapJson.getString("topAlbum");

                for (int i = 0; i < topTracksArray.length(); i++) {
                    JSONObject trackJson = topTracksArray.getJSONObject(i);
                    String trackName = trackJson.getString("trackName");
                    String artistName = trackJson.getString("artistName");
                    Log.d("Track", trackName);
                    Log.d("Artist", artistName);
                    trackQuestions.add(trackName);
                    artistAnswers.add(artistName);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void playGame() {
        if (!currentGame) {
            currentGame = true;
            playerScoreValue = 0;
            currentQuestionIndex = 0;
            askNextQuestion();
        } else {
            Toast.makeText(this, "Game in progress", Toast.LENGTH_SHORT).show();
        }
    }

    private void askNextQuestion() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (currentQuestionIndex < trackQuestions.size()) {
                    String currentQuestion = trackQuestions.get(currentQuestionIndex);
                    StringBuilder builder = new StringBuilder();
                    // Display current question
                    builder.append("Who is the artist of the song").append(" : ").append(currentQuestion);
                    songText.setText(builder.toString());

                } else {
                    // All questions asked, game over
                    endGame();
                }
            }
        });

    }

    public void checkAnswer(View view) {
        if (currentGame) {
            String userAnswer = guessSongEdit.getText().toString().trim();
            String correctAnswer = artistAnswers.get(currentQuestionIndex);
            if (userAnswer.isEmpty()) {
                Toast.makeText(this, "Submit an Answer", Toast.LENGTH_SHORT).show();
            } else if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                // Correct answer, update score
                playerScoreValue += 10;
                // Move to the next question
                currentQuestionIndex++;

                askNextQuestion();
            } else {
                StringBuilder builder = new StringBuilder();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Display current question
                        builder.append("Game Over! Correct answer").append(" : ").append(correctAnswer);
                        // Incorrect answer, game over
                        songText.setText(builder.toString());
                        endGame();
                    }
                });
                // Incorrect answer, game over
                songText.setText("Game Over! Correct answer: " + correctAnswer);
                endGame();
            }
            // Clear user input field
            guessSongEdit.getText().clear();
        }

    }

    // Method to end the game
    private void endGame() {
        currentGame = false;
        if (currentQuestionIndex == trackQuestions.size()) {
            // All questions answered, display final message
            songText.setText("You Win! Final Score: " + playerScore);
        }
    }

    public void playAgain() {
        if (currentGame) {
            Toast.makeText(this, "Game in progress", Toast.LENGTH_SHORT).show();
        } else {
            playGame();
        }
    }

    public void backToHomePage(View view) {
        endGame();
        Intent sign = new Intent(this, firebaseUserManager.class);
        String authentication = "homepage";
        sign.putExtra("userAction", authentication);
        startActivity(sign);
        finish();
    }



}
