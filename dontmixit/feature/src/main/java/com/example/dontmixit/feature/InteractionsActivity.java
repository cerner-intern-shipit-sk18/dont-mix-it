package com.example.dontmixit.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InteractionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactions);

        TextView txtView = (TextView)findViewById(R.id.textView);
        txtView.setText(getIntent().getStringExtra("InteractionDetails"));
    }

    public void onClickHome(android.view.View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
