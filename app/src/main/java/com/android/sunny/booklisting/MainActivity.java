package com.android.sunny.booklisting;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.search_editText_view);

        Button button = (Button) findViewById(R.id.search_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (networkAvailable()) {

                    //  Log.v(LOG_TAG, "Search Parameter : " + editText.getText().toString());
                    BookGetApiData bookGetApiData = new BookGetApiData();
                    bookGetApiData.execute(editText.getText().toString());
                }
            }
        });
    }

    public boolean networkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public class BookGetApiData extends AsyncTask<String, Void, ArrayList<Books>> {

        private final String LOG_TAG = BookGetApiData.class.getSimpleName();

        @Override
        protected ArrayList<Books> doInBackground(String... params) {
            String api_key = getResources().getString(R.string.api_key);
            String booksJsonData = null;

            if (params.length != 0) {

                HttpURLConnection urlConnection = null;
                BufferedReader bufferedReader = null;

                try {

                    final String BOOKAPI_BASE_URL = "https://www.googleapis.com/books/v1/volumes?";
                    final String API_KEY_PARAM = "key";
                    final String SEARCH_PARAM = "q";

                    //  Log.v(LOG_TAG, "Search Parameter : " + params[0]);

                    Uri uri = Uri.parse(BOOKAPI_BASE_URL).buildUpon()
                            .appendQueryParameter(SEARCH_PARAM, params[0])
                            .appendQueryParameter(API_KEY_PARAM, api_key)
                            .build();

                    //  Log.v(LOG_TAG, "Built URI " + uri.toString());


                    URL url = new URL(uri.toString());
                    //URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=dann+brown&key=AIzaSyDNxY-omLm2VMqrnxRFUwOOxCb5Nr5uAeU");

                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuffer stringBuffer = new StringBuffer();

                    if (inputStream == null) {
                        return null;
                    }

                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuffer.append(line + "\n");
                    }

                    if (stringBuffer.length() == 0) {
                        return null;
                    }

                    booksJsonData = stringBuffer.toString();

                    //  Log.v(LOG_TAG, "Book Data : " + booksJsonData);

                } catch (Exception e) {
                    Log.e(LOG_TAG, "Error : ", e);
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            Log.e(LOG_TAG, "Error closing stream : ", e);
                        }
                    }
                }

            }
            if (booksJsonData != null) {
                try {
                    return JsonDataParser(booksJsonData);
                } catch (Exception e) {
                    Log.e(LOG_TAG, "JSON Parsing error : ", e);
                    return null;
                }
            } else {
                Log.e(LOG_TAG, "No data returned from API");
                return null;
            }
        }

        private ArrayList<Books> JsonDataParser(String booksJsonData) {

            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Books> books) {
            super.onPostExecute(books);
        }
    }

}
