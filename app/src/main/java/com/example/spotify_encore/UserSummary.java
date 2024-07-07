package com.example.spotify_encore;

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

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
public class UserSummary extends AppCompatActivity {

    public static final String CLIENT_ID = "c2c0e4869066464c83c7079239bc885e";
    public static final String REDIRECT_URI = "com.example.spotiifyencore://auth";
    public static final int AUTH_TOKEN_REQUEST_CODE = 0;
    public static final int AUTH_CODE_REQUEST_CODE = 1;
    private final OkHttpClient mOkHttpClient = new OkHttpClient();
    private String mAccessToken, mAccessCode;
    private Call mCall;

    AppCompatButton sumGoHome;
    ListView wrapListView;
    Button generateWrap, gettoken;
    Wrap wrap4song;
    private ListView listView;

    FirebaseAuth auth;
    FirebaseDatabase FdataBase;

    FirebaseUser user;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        FdataBase = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        setContentView(R.layout.summary);

        sumGoHome = findViewById(R.id.homeNavButton);
        wrapListView = findViewById(R.id.wrapListView);
        generateWrap = findViewById(R.id.generateButton);
        gettoken = findViewById(R.id.gettoken);
        listView = findViewById(R.id.wrapListView);
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

        sumGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), firebaseUserManager.class);
                intent.putExtra("userAction", "homepage");
                startActivity(intent);
                finish();
            }
        });

    }
}


    private void onClick(View v) {
        // Initiate the API call
        getWrapData(mAccessToken);
    }

    private void getWrapData(String Token) {
        if (Token == null) {
            Toast.makeText(this, "You need to get an access token first!", Toast.LENGTH_SHORT).show();
            return;
        }

        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/me/player/recently-played")
                .addHeader("Authorization", "Bearer " + Token)
                .build();

        cancelCall();
        mCall = mOkHttpClient.newCall(request);

        mCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("HTTP", "Failed to fetch data: " + e);
                // Handle failure (e.g., show an error message)
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String responseBody = response.body().string();
                    // Parse the JSON response and process the data
                    Log.d("RESPONSE ", responseBody);
                    processResponseData(responseBody);
                } catch (IOException | JSONException e) {
                    Log.d("HTTP", "Failed to process response: " + e);
                    // Handle failure (e.g., show an error message)
                }
            }
        });
    }

    private void processResponseData(String responseBody) throws JSONException {
        JSONObject jsonObject = new JSONObject(responseBody);

        Log.d("Response Body", responseBody);

        // Check if the response contains the 'items' key
        if (!jsonObject.has("items")) {
            Log.d("HTTP", "No 'items' key found in the response");
            // Handle this case appropriately (e.g., show an error message)
            return;
        }

        JSONArray itemsArray = jsonObject.getJSONArray("items");

        // Create a 2D array to store track information
        String[][] stuff = new String[3][itemsArray.length()];

        // Loop through each item in the 'items' array
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject item = itemsArray.getJSONObject(i);
            JSONObject trackObject = item.getJSONObject("track");

            // Extract track name
            String trackName = trackObject.getString("name");
            stuff[0][i] = trackName;

            // Extract artist(s) information
            JSONArray artistsArray = trackObject.getJSONArray("artists");
            StringBuilder artistsBuilder = new StringBuilder();
            for (int j = 0; j < artistsArray.length(); j++) {
                JSONObject artistObject = artistsArray.getJSONObject(j);
                String artistName = artistObject.getString("name");
                artistsBuilder.append(artistName);
                if (j < artistsArray.length() - 1) {
                    artistsBuilder.append(", "); // Add comma between artists
                }
            }
            String artists = artistsBuilder.toString();
            stuff[1][i] = artists;

            // Extract preview URL (if available)
            String previewUrl = trackObject.optString("preview_url", ""); // Opt for an empty string if preview_url is null
            stuff[2][i] = previewUrl;
        }

        // Now, the 'stuff' array contains the required track information
        // You can use it to populate your UI or perform further processing

        // Example: update UI with 'stuff' data
        runOnUiThread(() -> {
            cadapter = new CustomAdapter(this, stuff);
            listView.setAdapter(adapter);
        });
    }
*/
    /*
    private void processResponseData(String responseBody) throws JSONException {
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONArray itemsArray = jsonObject.getJSONArray("items");

        // Process the items array and extract the required data
        String[][] stuff = new String[2][5];
        for (int i = 0; i < Math.min(itemsArray.length(), 5); i++) {
            JSONObject item = itemsArray.getJSONObject(i);
            JSONObject track = item.getJSONObject("track");

            // Extract relevant information from the track object
            String name = track.getString("name");
            String artist = track.getJSONArray("artists").getJSONObject(0).getString("name");
            String previewUrl = track.getString("preview_url");

            // Populate the stuff array
            stuff[0][i] = name;
            stuff[1][i] = artist;
            stuff[2][i] = previewUrl;
        }

        // Update the UI or perform further actions with the retrieved data
        // For example, you can update the ListView adapter here
        runOnUiThread(() -> {
            cadapter = new CustomAdapter(this, stuff);
            listView.setAdapter(adapter);
        });
    }
     */

    /*
    private String[][] getWrapData(String Token) throws IOException, InterruptedException {
        String[][] stuff = new String[2][5];
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

     */

/*
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

    private AuthorizationRequest getAuthenticationRequest(AuthorizationResponse.Type type) {
        return new AuthorizationRequest.Builder(CLIENT_ID, type, getRedirectUri().toString())
                .setShowDialog(true)
                .setScopes(new String[] { "user-read-email" }) // <--- Change the scope of your requested token here
                .setCampaign("your-campaign-token")
                .build();
    }

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
    */
