package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
/**
 * Created by Ajay R Warrier on 20-12-2016.
 */

@RunWith(AndroidJUnit4.class)
public class EndpointTest {
    @Test
    public void testDoInBackground() throws Exception {
        com.udacity.gradle.builditbigger.MainActivity activity = new com.udacity.gradle.builditbigger.MainActivity();
        activity.testFlag = true;
        new EndpointAsyncTask().execute(activity);
        Thread.sleep(5000);
        assertTrue("Error: Fetched Joke = " + activity.loadedJoke, activity.loadedJoke != null);
    }
}
