package com.example.intentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText theme;
    private EditText text;

    @SuppressLint({"QueryPermissionsNeeded", "IntentReset"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.send_btn).setOnClickListener(view -> {
            email = findViewById(R.id.email);
            theme = findViewById(R.id.theme);
            text = findViewById(R.id.text);

            Intent gmail = new Intent(Intent.ACTION_SEND);
            gmail.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
            gmail.setData(Uri.parse(email.getText().toString()));
            gmail.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
            gmail.setType("plain/text");
            gmail.putExtra(Intent.EXTRA_TEXT, text.getText().toString());
            startActivity(Intent.createChooser(gmail, text.getText().toString()));
        });
    }
}