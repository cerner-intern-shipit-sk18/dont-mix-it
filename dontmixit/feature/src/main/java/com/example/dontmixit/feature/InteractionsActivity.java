package com.example.dontmixit.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InteractionsActivity extends AppCompatActivity {

    boolean InteractionOkay = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactions);

        TextView txtView = (TextView)findViewById(R.id.textView);
        txtView.setText(getIntent().getStringExtra("InteractionDetails"));

        InteractionOkay = getIntent().getBooleanExtra("InteractionOkay", false);

        ImageView imgView = (ImageView)findViewById(R.id.imageView);
        if(InteractionOkay)
        {
            imgView.setImageResource(R.drawable.good);
        }
        else
        {
            imgView.setImageResource(R.drawable.bad);
        }

    }

    public void onClickHome(android.view.View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
