package com.example.dontmixit.feature;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;

import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.txt_out);
        tv.setText("Waiting...");


    }

    @Override
    protected void onResume()
    {

        IntentIntegrator it = new IntentIntegrator(new Activity() {
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
                if(result != null)
                    if(result.getContents() == null)
                        tv.setText("Cancelled.");
                    else
                        tv.setText("Scanned: " + result.getContents());
                else
                    tv.setText("Bad stuff...");
            }
        });
        it.initiateScan();

    }
    // Get the results:
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//        if(result != null) {
//            if(result.getContents() == null) {
//                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
//            } else {
//                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }



}
