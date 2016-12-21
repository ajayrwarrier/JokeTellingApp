package com.example.jokecentre;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class ShowJokeActivity extends AppCompatActivity {
    TextView jokeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);
        jokeView = (TextView) findViewById(R.id.jokeView);
        String  joke = getIntent().getStringExtra(getString(R.string.joke));
        if(joke!=null){
            jokeView.setText(joke);
        }
        else {
            jokeView.setText(getString(R.string.no_joke));
        }
    }
}
