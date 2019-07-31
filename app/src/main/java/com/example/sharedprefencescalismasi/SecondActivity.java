package com.example.sharedprefencescalismasi;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sp= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        textView=findViewById(R.id.textView);

        textView.setText(sp.getString("mesaj",""));
    }
}
