package com.example.spotify_encore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;

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

public class commentedCode {

/*
ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sort_options, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spotifySum.setAdapter(adapter);

                    sumGoHome = findViewById(R.id.sumHomeButt);
                    spotifySum = findViewById(R.id.generateSummary);

                    spotifySum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String selectedOption = parent.getItemAtPosition(position).toString();

                            switch (selectedOption) {
                                case "1 Week":
                                    retrieveSpotifyAccessTokenAndGetTopTrack("short_term");
                                    retrieveSpotifyAccessTokenAndGetTopArtist("short_term");

                                    break;
                                case "1 Month":
                                    retrieveSpotifyAccessTokenAndGetTopTrack("medium_term");
                                    retrieveSpotifyAccessTokenAndGetTopArtist("medium_term");

                                    break;
                                case "1 Year":
                                    retrieveSpotifyAccessTokenAndGetTopTrack("long_term");
                                    retrieveSpotifyAccessTokenAndGetTopArtist("long_term");
                                    break;
                                case "All Time":
                                    retrieveSpotifyAccessTokenAndGetTopTrack("all_time");
                                    retrieveSpotifyAccessTokenAndGetTopArtist("all_time");
                                    break;
                                default:
                                    // Handle default case or do nothing
                                    break;
                            }

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            // Do nothing
                        }
                    });

                    sumGoHome.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), firebaseUserManager.class);
                            intent.putExtra("userAction", "homepage");
                            startActivity(intent);
                            finish();
                        }
                    });
 */





    ///////////////////////////     getTopTracks()   and getTopArtists()    getRecomendations()      ////////////////////////////


    /**
     * This code is for
     */
//    private void getTopTrack(String spotifyAccessToken, String timeline) {
//        OkHttpClient client = new OkHttpClient();
//
//        // Construct the URL for the top tracks endpoint
//        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.spotify.com/v1/me/top/tracks").newBuilder();
//        urlBuilder.addQueryParameter("time_range", "medium_term");
//        urlBuilder.addQueryParameter("limit", "1");
//        urlBuilder.addQueryParameter("offset", "0");
//
//
//        Request request = new Request.Builder()
//                .url(urlBuilder.build())
//                .addHeader("Authorization", "Bearer " + spotifyAccessToken)
//                .get() // Specify that this is a GET request
//                .build();
//
//        // Send the request asynchronously
//        client.newCall(request).enqueue(new okhttp3.Callback() {
//            @Override
//            public void onFailure(okhttp3.Call call, IOException e) {
//                e.printStackTrace();
//                // Handle request failure
//            }
//
//            @Override
//            public void onResponse(okhttp3.Call call, Response response) throws IOException {
//                if (!response.isSuccessful()) {
//                    throw new IOException("Unexpected code " + response);
//                }
//
//                try {
//                    // Parse response JSON
//                    String responseData = response.body().string();
//
//                    JSONObject jsonResponse = new JSONObject(responseData);
//
//                    JSONArray tracks = jsonResponse.getJSONArray("items");
//
//                    if (tracks.length() > 0) {
//                        // Get the first track from the list
//                        JSONObject firstTrack = tracks.getJSONObject(0);
//                        String trackName = firstTrack.getString("name");
//                        JSONArray artists = firstTrack.getJSONArray("artists");
//                        String artistName = artists.getJSONObject(0).getString("name");
//
//                        // Update UI with the top track information
//                        String topTrackInfo = "Top Track: " + trackName + " - " + artistName;
////                        runOnUiThread(new Runnable() {
////                            @Override
////                            public void run() {
////                                topTrackText.setText(topTrackInfo);
////                            }
////                        });
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    // Handle JSON parsing error
//                }
//            }
//        });
//    }







     /*
    private void getTopArtist(String spotifyAccessToken, String timeline) {
        OkHttpClient client = new OkHttpClient();
        // Construct the URL for the top artists endpoint
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.spotify.com/v1/me/top/artists").newBuilder();
        urlBuilder.addQueryParameter("time_range", "short_term");
        urlBuilder.addQueryParameter("limit", "1");
        urlBuilder.addQueryParameter("offset", "0");

        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .addHeader("Authorization", "Bearer " + spotifyAccessToken)
                .get() // Specify that this is a GET request
                .build();

        // Send the request asynchronously
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                e.printStackTrace();
                // Handle request failure
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                try {
                    // Parse response JSON
                    String responseData = response.body().string();
                    JSONObject jsonResponse = new JSONObject(responseData);
                    JSONArray artists = jsonResponse.getJSONArray("items");

                    if (artists.length() > 0) {
                        // Get the first artist from the list
                        JSONObject firstArtist = artists.getJSONObject(0);
                        String artistName = firstArtist.getString("name");

                        // Update UI with the top artist information
                        String topArtistInfo = "Top Artist: " + artistName;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                topArtistText.setText(topArtistInfo);
                            }
                        });
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    // Handle JSON parsing error
                }
            }
        });
    }
     */

  /*
                    wrapListView = findViewById(R.id.wrapListView);
                    generateWrap = findViewById(R.id.generateButton);
                    gettoken = findViewById(R.id.gettoken);
                    listView = findViewById(R.id.wrapListView);



                    // Create an ArrayList and add the hard-coded Wrap object
                    ArrayList<Wrap> wraps = new ArrayList<>();
                    wraps.add(wrap4song);

                    // Create and set the adapter for the ListView

                    WrapAdapter adapter = new WrapAdapter(firebaseUserManager.this, wraps);
                    wrapListView.setAdapter(adapter);

                    // Set click listener for ListView item
                    wrapListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        private MediaPlayer mediaPlayer; // Reference to the currently playing MediaPlayer
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            // Stop the currently playing music (if any)
                            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                mediaPlayer.stop();
                                mediaPlayer.release();
                            }

                            // Assuming position starts from 0
                            if (position < 5) {
                                // Check if the data is not null and the number of rows is at least 3
                                if (wrap[2][position] != null) {
                                    // Get the song URL from the 3rd row and 0th column (assuming the URL is in the first column)
                                    String songUrl = wrap[2][position];

                                    // Remove slashes from the song URL if needed
                                    String musicUrl = songUrl.replace("\\", "");

                                    // Create a new MediaPlayer instance and start playback
                                    mediaPlayer = new MediaPlayer();
                                    try {
                                        mediaPlayer.setDataSource(musicUrl);
                                        mediaPlayer.prepare();
                                        mediaPlayer.start();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        // Handle error
                                    }
                                } else {
                                    // Handle case where the data is not available or doesn't have enough rows
                                    Toast.makeText(firebaseUserManager.this, "No song URL available", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });

                    // Method that makes an Onclick
                    generateWrap.setOnClickListener(this::onClick);

                    gettoken.setOnClickListener((v) -> {
                        getAccessToken();
                    });
                     */



     /*
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sort_options, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spotifySum.setAdapter(adapter);

                    generateSummary.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Get the selected option from the spinner
                            String selectedOption = spotifySum.getSelectedItem().toString();

                            // Call the method to generate summary based on the selected option
                            switch (selectedOption) {
                                case "1 Week":
                                    retrieveSpotifyAccessTokenAndGetTopTrack();

                                    //retrieveSpotifyAccessTokenAndGetTopArtist("short_term");
                                    break;
                                case "1 Month":
                                    retrieveSpotifyAccessTokenAndGetTopTrack();
                                    //retrieveSpotifyAccessTokenAndGetTopArtist("medium_term");
                                    break;
                                case "1 Year":
                                    retrieveSpotifyAccessTokenAndGetTopTrack();
                                    //retrieveSpotifyAccessTokenAndGetTopArtist("long_term");
                                    break;
                                case "All Time":
                                    retrieveSpotifyAccessTokenAndGetTopTrack();
                                    //retrieveSpotifyAccessTokenAndGetTopArtist("all_time");
                                    break;
                                default:
                                    // Handle default case or do nothing
                                    break;
                            }
                        }
                    });
                    */

                    /*
                    spotifySum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String selectedOption = parent.getItemAtPosition(position).toString();



                            switch (selectedOption) {
                                case "1 Week":
                                    retrieveSpotifyAccessTokenAndGetTopTrackArtist("short_term");
                                    retrieveSpotifyAccessTokenAndGetTopArtist("short_term");

                                    break;
                                case "1 Month":
                                    retrieveSpotifyAccessTokenAndGetTopTrackArtist("medium_term");
                                    retrieveSpotifyAccessTokenAndGetTopArtist("medium_term");

                                    break;
                                case "1 Year":
                                    retrieveSpotifyAccessTokenAndGetTopTrackArtist("long_term");
                                    retrieveSpotifyAccessTokenAndGetTopArtist("long_term");
                                    break;
                                case "All Time":
                                    retrieveSpotifyAccessTokenAndGetTopTrackArtist("all_time");
                                    retrieveSpotifyAccessTokenAndGetTopArtist("all_time");
                                    break;
                                default:
                                    // Handle default case or do nothing
                                    break;
                            }

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            // Do nothing
                        }
                    });
                     */



     /*
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sort_options, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spotifySum.setAdapter(adapter);

                    generateSummary.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Get the selected option from the spinner
                            String selectedOption = spotifySum.getSelectedItem().toString();

                            // Call the method to generate summary based on the selected option
                            switch (selectedOption) {
                                case "1 Week":
                                    retrieveSpotifyAccessTokenAndGetTopTrack();

                                    //retrieveSpotifyAccessTokenAndGetTopArtist("short_term");
                                    break;
                                case "1 Month":
                                    retrieveSpotifyAccessTokenAndGetTopTrack();
                                    //retrieveSpotifyAccessTokenAndGetTopArtist("medium_term");
                                    break;
                                case "1 Year":
                                    retrieveSpotifyAccessTokenAndGetTopTrack();
                                    //retrieveSpotifyAccessTokenAndGetTopArtist("long_term");
                                    break;
                                case "All Time":
                                    retrieveSpotifyAccessTokenAndGetTopTrack();
                                    //retrieveSpotifyAccessTokenAndGetTopArtist("all_time");
                                    break;
                                default:
                                    // Handle default case or do nothing
                                    break;
                            }
                        }
                    });
                    */

                    /*
                    spotifySum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String selectedOption = parent.getItemAtPosition(position).toString();



                            switch (selectedOption) {
                                case "1 Week":
                                    retrieveSpotifyAccessTokenAndGetTopTrackArtist("short_term");
                                    retrieveSpotifyAccessTokenAndGetTopArtist("short_term");

                                    break;
                                case "1 Month":
                                    retrieveSpotifyAccessTokenAndGetTopTrackArtist("medium_term");
                                    retrieveSpotifyAccessTokenAndGetTopArtist("medium_term");

                                    break;
                                case "1 Year":
                                    retrieveSpotifyAccessTokenAndGetTopTrackArtist("long_term");
                                    retrieveSpotifyAccessTokenAndGetTopArtist("long_term");
                                    break;
                                case "All Time":
                                    retrieveSpotifyAccessTokenAndGetTopTrackArtist("all_time");
                                    retrieveSpotifyAccessTokenAndGetTopArtist("all_time");
                                    break;
                                default:
                                    // Handle default case or do nothing
                                    break;
                            }

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            // Do nothing
                        }
                    });
                     */







     /*
    private void getTopArtist(String spotifyAccessToken, String timeline) {
        OkHttpClient client = new OkHttpClient();
        // Construct the URL for the top artists endpoint
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.spotify.com/v1/me/top/artists").newBuilder();
        urlBuilder.addQueryParameter("time_range", "short_term");
        urlBuilder.addQueryParameter("limit", "1");
        urlBuilder.addQueryParameter("offset", "0");

        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .addHeader("Authorization", "Bearer " + spotifyAccessToken)
                .get() // Specify that this is a GET request
                .build();

        // Send the request asynchronously
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                e.printStackTrace();
                // Handle request failure
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                try {
                    // Parse response JSON
                    String responseData = response.body().string();
                    JSONObject jsonResponse = new JSONObject(responseData);
                    JSONArray artists = jsonResponse.getJSONArray("items");

                    if (artists.length() > 0) {
                        // Get the first artist from the list
                        JSONObject firstArtist = artists.getJSONObject(0);
                        String artistName = firstArtist.getString("name");

                        // Update UI with the top artist information
                        String topArtistInfo = "Top Artist: " + artistName;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                topArtistText.setText(topArtistInfo);
                            }
                        });
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    // Handle JSON parsing error
                }
            }
        });
    }
     */





     /*
    private void makeRecommendationRequest(String spotifyAccessToken) {

        OkHttpClient client = new OkHttpClient();

        // Define the request to the Spotify API
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/recommendations?limit=10&market=ES") // Include limit and market parameters
                .addHeader("Authorization", "Bearer " + spotifyAccessToken)
                .get() // Specify that this is a GET request
                .build();
        // Send the request asynchronously
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                e.printStackTrace();
                // Handle request failure
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }


                Toast.makeText(firebaseUserManager.this, "Received Reccomendation", Toast.LENGTH_SHORT).show();

                try {
                    // Parse response JSON
                    String responseData = response.body().string();
                    List<String> recommendedTracks = parseRecommendations(responseData);

                    // Update UI with recommended tracks
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (adapter != null) {
                                adapter.setRecommendedTracks(recommendedTracks); // Update the dataset with recommended tracks
                                adapter.notifyDataSetChanged(); // Notify the adapter that the dataset has changed
                            } else {
                                // If adapter is null, initialize it with the recommended tracks
                                adapter = new reccomendationAdapter(recommendedTracks, getApplicationContext()); // Pass recommended tracks to the constructor of your adapter
                                userReccomendation.setAdapter(adapter); // Set the adapter to your ListView
                            }
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                    // Handle JSON parsing error
                }
            }
        });
    }
     */


    ///////////////////////////     getTopTracks()   and getTopArtists()   and getRecomendations()       ////////////////////////////







    ////////////////////            JCode               /////////////////////////////




    /*

    private String[][] getWrapData(String Token) throws IOException, InterruptedException {
        String[][] stuff = new String[3][5];
        int count = 0;

        if (Token == null) {
            Toast.makeText(this, "You need to get an access token first!", Toast.LENGTH_SHORT).show();
            return null;
        }
        // Create a request to get the user profile
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/me/player/recently-played")
                .addHeader("Authorization", "Bearer " + Token)
                .build();
        cancelCall();
        mCall = mOkHttpClient.newCall(request);

        Run(mCall);

        while(waiting()) {
            continue;
        }

        data = Arrays.toString(data).split("\"id\": \"");
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].split("\"", 2)[0];
        }

        HashSet<String> IDs = new HashSet<String>(Arrays.asList(data));

        data = null;

        for (String ID : IDs) {
            request = new Request.Builder()
                    .url("https://api.spotify.com/v1/tracks/" + ID)
                    .addHeader("Authorization", "Bearer " + Token)
                    .build();
            cancelCall();
            mCall = mOkHttpClient.newCall(request);

            data = null;
            Run(mCall);

            while(waiting()) {
                continue;
            }
            if (Arrays.toString(data).contains("error")) {
                continue;
            }

            if (count < 5 && stuff[0][count] == null) {
                String[] songData = Arrays.toString(data).split("\"name\": \"");

                stuff[0][count] = songData[songData.length - 1].split("\"",2)[0];
                stuff[1][count] = songData[songData.length - 2].split("\"",2)[0];
                stuff[2][count] = Arrays.toString(data).split("\"preview_url\": \"")[1].split("\"",2)[0];
                count++;

                if (count == 5) {
                    return stuff;
                }
            }
        }

        return stuff;
    }

    private void Run(Call mCall) throws IOException {
        mCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("HTTP", "Failed to fetch data: " + e);

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    final JSONObject jsonObject = new JSONObject(response.body().string());

                    data = new String[]{jsonObject.toString(0)};

                } catch (JSONException e) {
                    Log.d("JSON", "Failed to parse data: " + e);
                }
            }
        });

        return;
    }
    */
    /*
    private void playMusic(String musicUrl) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(musicUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle any errors that occur during playback
        }
    }


    private boolean waiting() {
        return data == null;
    }

    private void onClick(View v) {
        ongeneratewrap();
        cadapter = new CustomAdapter(this, wrap);
        listView.setAdapter(adapter);
    }

    private void ongeneratewrap(){
        try {
            Log.d("ggez","in try");
            wrap = getWrapData(mAccessToken);
            Log.d("testing1", wrap[0][0]);
            Log.d("testing2", wrap[0][1]);
            Log.d("testing3",wrap[0][2]);
            Log.d("testing4",wrap[0][3]);
            Log.d("testing5",wrap[0][4]);
            Log.d("testing7",wrap[1][0]);
            Log.d("testing8",wrap[2][0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
     */

    /////////////////////////       End of Jcode   //////////////////////////////








    /////////////////////////       User  //////////////////////////////

    /**
     * Get user profile
     * This method will get the user profile using the token
     */
    /*
    public void getUserProfile() {
        if (mAccessToken == null) {
            Toast.makeText(this, "You need to get an access token first!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a request to get the user profile
        final Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/me")
                .addHeader("Authorization", "Bearer " + mAccessToken)
                .build();

        cancelCall();
        mCall = mOkHttpClient.newCall(request);

        mCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("HTTP", "Failed to fetch data: " + e);
                Toast.makeText(authentication.this, "Failed to fetch data, watch Logcat for more details",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    final JSONObject jsonObject = new JSONObject(response.body().string());
                    //setTextAsync(jsonObject.toString(3), profileTextView);
                } catch (JSONException e) {
                    Log.d("JSON", "Failed to parse data: " + e);
                    Toast.makeText(authentication.this, "Failed to parse data, watch Logcat for more details",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    */









     /*
    public void onGetUserProfileClicked() {
        if (mAccessToken == null) {
            Toast.makeText(this, "You need to get an access token first!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a request to get the user profile
        final Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/me")
                .addHeader("Authorization", "Bearer " + mAccessToken)
                .build();

        cancelCall();
        mCall = mOkHttpClient.newCall(request);

        mCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("HTTP", "Failed to fetch data: " + e);
                Toast.makeText(firebaseUserManager.this, "Failed to fetch data, watch Logcat for more details",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    final JSONObject jsonObject = new JSONObject(response.body().string());
                    setTextAsync(jsonObject.toString(3), profileTextView);
                } catch (JSONException e) {
                    Log.d("JSON", "Failed to parse data: " + e);
                    Toast.makeText(MainActivity.this, "Failed to parse data, watch Logcat for more details",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
     */







    // This code comment does not work
    /*
    public void onGetUserProfileClicked() {
        // Retrieve the Spotify access token from Firebase
        retrieveSpotifyAccessTokenFromUserProfile(new OnTokenRetrievedListener() {
            @Override
            public void onTokenRetrieved(String spotifyAccessToken) {
                if (spotifyAccessToken != null) {
                    // Use the Spotify access token retrieved from Firebase

                    // Update the URL to fetch other personal user information
                    final Request request = new Request.Builder()
                            .url("https://api.example.com/v1/user/info") // Change the URL to the endpoint for fetching other personal user information
                            .addHeader("Authorization", "Bearer " + spotifyAccessToken)
                            .build();

                    cancelCall();
                    mCall = mOkHttpClient.newCall(request);

                    mCall.enqueue(new Callback() {
                        public void onFailure(Call call, IOException e) {
                            Log.d("HTTP", "Failed to fetch data: " + e);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(firebaseUserManager.this, "Failed to fetch data, watch Logcat for more details",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        @Override
                        public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                            try {
                                final JSONObject jsonObject = new JSONObject(response.body().string());
                                final String userInfo = jsonObject.toString(3); // Adjust parsing according to the response structure

                                // Update UI on the main thread
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Display the user information in the appropriate view
                                        userSpotifyInfo.setText(userInfo); // Change to the appropriate TextView
                                        System.out.println(userInfo);
                                    }
                                });
                            } catch (JSONException e) {
                                Log.d("JSON", "Failed to parse data: " + e);
                                Toast.makeText(firebaseUserManager.this, "Failed to parse data, watch Logcat for more details",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    // Handle the case where no Spotify access token was found
                    Toast.makeText(firebaseUserManager.this, "No Spotify access token found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

     */


    // This Code Comment Works
    /*
    public void onGetUserProfileClicked() {
        // Retrieve the Spotify access token from Firebase
        retrieveSpotifyAccessTokenFromUserProfile(new OnTokenRetrievedListener() {
            @Override
            public void onTokenRetrieved(String spotifyAccessToken) {
                if (spotifyAccessToken != null) {
                    // Use the Spotify access token retrieved from Firebase

                    // Create a request to get the user profile
                    final Request request = new Request.Builder()
                            .url("https://api.spotify.com/v1/me")
                            .addHeader("Authorization", "Bearer " + spotifyAccessToken)
                            .build();

                    cancelCall();
                    mCall = mOkHttpClient.newCall(request);

                    mCall.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.d("HTTP", "Failed to fetch data: " + e);
                            Toast.makeText(firebaseUserManager.this, "Failed to fetch data, watch Logcat for more details",
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                            try {
                                final JSONObject jsonObject = new JSONObject(response.body().string());
                                final String userProfileInfo = jsonObject.toString(3);

                                // Update UI on the main thread
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Display the user profile info in the userSpotifyInfo TextView
                                        userSpotifyInfo.setText(userProfileInfo);
                                    }
                                });
                            } catch (JSONException e) {
                                Log.d("JSON", "Failed to parse data: " + e);
                                Toast.makeText(firebaseUserManager.this, "Failed to parse data, watch Logcat for more details",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    // Handle the case where no Spotify access token was found
                    Toast.makeText(firebaseUserManager.this, "No Spotify access token found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

     */





    /////////////////////////       END OF User  //////////////////////////////





    /////////////////////////      HomePage Actions  //////////////////////////////


    /*
        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), authentication.class);
            intent.putExtra("userAction", "LogIn");
            startActivity(intent);
            finish();
        }
        String action = getIntent().getStringExtra("userAction");

        if (action != null) {
            if (action.equals("accountSettings")) {
                setContentView(R.layout.account_setting);
                signOut = findViewById(R.id.signOutAccountSettings);
                deleteAccount = findViewById(R.id.deleteAccountSettings);
                changeInfo = findViewById(R.id.changeInfoAccountSettings);
                changeUserEmail = findViewById(R.id.changeEmail);
                changePassword = findViewById(R.id.changePass);
                connectSpotify = findViewById(R.id.ChangeSpotifyAccountSettings);
                oldPassword = findViewById(R.id.currentPassword);

                changeInfo.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View v) {
                        String email, password, oldEm, oldPass;

                        email = changeUserEmail.getText().toString();
                        password = changePassword.getText().toString();
                        oldPass = oldPassword.getText().toString();

                        updateUserInfo(email, password, oldPass);

                        changeUserEmail.setText("New Email");

                        changePassword.setText("New Password");
                    }
                });

                connectSpotify.setOnClickListener((v) -> {
                    getToken();
                        //addSpotifyAccessTokenToUserProfile(mAccessToken);
                });

                deleteAccount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deleteUserAccount();
                        Intent sign = new Intent(getApplicationContext(), applicationCore.class);
                        startActivity(sign);
                    }
                });

                signOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userSignOut();
                        Intent sign = new Intent(getApplicationContext(), firebaseUserManager.class);
                        String authentication = "login";
                        sign.putExtra("userAction", authentication);
                        startActivity(sign);
                    }
                });
            } else if (action.equals("homepage")) {
                setContentView(R.layout.homepage);
            } else if (action.equals("gamepage")) {
                setContentView(R.layout.game);
            }
        }
        */

        /*
    ───░█ ░█▀▀█ █▀▀█ █▀▀▄ █▀▀
    ─▄─░█ ░█─── █──█ █──█ █▀▀
    ░█▄▄█ ░█▄▄█ ▀▀▀▀ ▀▀▀─ ▀▀▀
     */

    /*
    private String[][] getWrapData(String Token) throws IOException, InterruptedException {
        String[][] stuff = new String[2][5];
        int count = 0;

        Log.d("User_Token", Token);

        if (Token == null) {
            Toast.makeText(this, "You need to get an access token first!", Toast.LENGTH_SHORT).show();
            return null;
        }

        // Create a request to get the user profile
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/me/player/recently-played")
                .addHeader("Authorization", "Bearer " + Token)
                .build();
        cancelCall();
        mCall = mOkHttpClient.newCall(request);

        Run(mCall);

        while(waiting()) {
            continue;
        }

        data = Arrays.toString(data).split("\"id\": \"");
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].split("\"", 2)[0];
        }

        HashSet<String> IDs = new HashSet<String>(Arrays.asList(data));
        data = null;

        for (String ID : IDs) {
            request = new Request.Builder()
                    .url("https://api.spotify.com/v1/tracks/" + ID)
                    .addHeader("Authorization", "Bearer " + Token)
                    .build();
            cancelCall();
            mCall = mOkHttpClient.newCall(request);
            data = null;
            Run(mCall);

            //Log.d("data", Arrays.toString(data));
            if (Arrays.toString(data).contains("error")) {
                continue;
            }

            if (count < 5 && stuff[0][count] == null) {
                String[] songData = Arrays.toString(data).split("\"name\": \"");
                //stuff[0][count] = songData[songData.length - 1].split("\"",2)[0];
                //stuff[1][count] = songData[songData.length - 2].split("\"",2)[0];
                //stuff[2][count] = Arrays.toString(data).split("\"preview_url\": \"")[1].split("\"",2)[0];
                count++;
                if (count == 5) {
                    return stuff;
                }
            }
        }
        Log.d("WWWWWWWWWW", "songs retreived");
        return stuff;
    }

    private void Run(Call mCall) throws IOException {
        mCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("HTTP", "Failed to fetch data: " + e);
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {

                    final JSONObject jsonObject = new JSONObject(response.body().string());
                    data = new String[]{jsonObject.toString(0)};

                } catch (JSONException e) {
                    Log.d("JSON", "Failed to parse data: " + e);
                }
            }
        });
        return;
    }

    private boolean waiting() {
        return data == null;
    }
     */

    /*
    private String[][] getWrapData(String Token) throws IOException, InterruptedException {
        String[][] stuff = new String[3][5];
        int count = 0;

        if (Token == null) {
            Toast.makeText(this, "You need to get an access token first!", Toast.LENGTH_SHORT).show();
            return null;
        }
        // Create a request to get the user profile
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/me/player/recently-played")
                .addHeader("Authorization", "Bearer " + Token)
                .build();
        cancelCall();
        mCall = mOkHttpClient.newCall(request);

        Run(mCall);

        while(waiting()) {
            continue;
        }

        data = Arrays.toString(data).split("\"id\": \"");
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].split("\"", 2)[0];
        }

        HashSet<String> IDs = new HashSet<String>(Arrays.asList(data));

        data = null;

        for (String ID : IDs) {
            request = new Request.Builder()
                    .url("https://api.spotify.com/v1/tracks/" + ID)
                    .addHeader("Authorization", "Bearer " + Token)
                    .build();
            cancelCall();
            mCall = mOkHttpClient.newCall(request);

            data = null;
            Run(mCall);

            while(waiting()) {
                continue;
            }
            if (Arrays.toString(data).contains("error")) {
                continue;
            }

            if (count < 5 && stuff[0][count] == null) {
                String[] songData = Arrays.toString(data).split("\"name\": \"");

                stuff[0][count] = songData[songData.length - 1].split("\"",2)[0];
                stuff[1][count] = songData[songData.length - 2].split("\"",2)[0];
                stuff[2][count] = Arrays.toString(data).split("\"preview_url\": \"")[1].split("\"",2)[0];
                count++;

                if (count == 5) {
                    return stuff;
                }
            }
        }

        return stuff;
    }

    private void Run(Call mCall) throws IOException {
        mCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("HTTP", "Failed to fetch data: " + e);

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    final JSONObject jsonObject = new JSONObject(response.body().string());

                    data = new String[]{jsonObject.toString(0)};

                } catch (JSONException e) {
                    Log.d("JSON", "Failed to parse data: " + e);
                }
            }
        });

        return;
    }
    */
    /*
    private void playMusic(String musicUrl) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(musicUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle any errors that occur during playback
        }
    }


    private boolean waiting() {
        return data == null;
    }

    private void onClick(View v) {
        ongeneratewrap();
        cadapter = new CustomAdapter(this, wrap);
        listView.setAdapter(adapter);
    }

    private void ongeneratewrap(){
        try {
            Log.d("ggez","in try");
            wrap = getWrapData(mAccessToken);
            Log.d("testing1", wrap[0][0]);
            Log.d("testing2", wrap[0][1]);
            Log.d("testing3",wrap[0][2]);
            Log.d("testing4",wrap[0][3]);
            Log.d("testing5",wrap[0][4]);
            Log.d("testing7",wrap[1][0]);
            Log.d("testing8",wrap[2][0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
     */
    /*
    private void ongeneratewrap(){
        try {
            wrap = getWrapData(mAccessToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void onClick(View v) {
        ongeneratewrap();
        cadapter = new CustomAdapter(this, wrap);
        listView.setAdapter(adapter);
    }
     */


}
