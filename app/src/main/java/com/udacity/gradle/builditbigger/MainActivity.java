package com.udacity.gradle.builditbigger;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.jokecentre.ShowJokeActivity;
public class MainActivity extends ActionBarActivity {
    public boolean testFlag = false;
    public String loadedJoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void tellJoke(View view) {
        new EndpointAsyncTask().execute(this);
    }
    public void loadJokeActivity() {
        if (!testFlag) {
            Intent intent = new Intent(this, ShowJokeActivity.class);
            intent.putExtra(getString(R.string.joke), loadedJoke);
            startActivity(intent);
        }
    }
}
