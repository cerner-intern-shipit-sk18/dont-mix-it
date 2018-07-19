package com.example.dontmixit.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView txtView = (TextView)findViewById(R.id.txtDetails);
        txtView.setText(getIntent().getStringExtra("DrugDetails"));
    }

    public void onClickBtnBack(android.view.View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
