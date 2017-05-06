package com.example.android.bavariaquiz;

import android.app.ActionBar;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.value;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void goToQuiz(View view) {
        EditText nameText = (EditText) findViewById(R.id.name);
        String name = nameText.getText().toString();
        if (name.matches("")) {
            Toast.makeText(this, getString(R.string.enterName), Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(getApplicationContext(), Questions.class);
        intent.putExtra("givenname", name);
        startActivity(intent);
    }


}
