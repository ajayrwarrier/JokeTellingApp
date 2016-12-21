package com.udacity.gradle.builditbigger;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.myApi.MyApi;

import java.io.IOException;
/**
 * Created by Ajay R Warrier on 20-12-2016.
 */
public class EndpointAsyncTask extends AsyncTask<MainActivity, Void, String> {
    private static MyApi mApiService = null;
    private MainActivity activity;
    @Override
    protected String doInBackground(MainActivity... params) {
        if (mApiService == null) {
            MyApi.Builder builder = new
                    MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://joketellingapp-153116.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?>
                                                       abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            mApiService = builder.build();
        }
        activity = params[0];
        try {
            return mApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
    @Override
    protected void onPostExecute(String result) {
        if (result != null) {
            activity.loadedJoke = result;
            activity.loadJokeActivity();
        }
    }
}
