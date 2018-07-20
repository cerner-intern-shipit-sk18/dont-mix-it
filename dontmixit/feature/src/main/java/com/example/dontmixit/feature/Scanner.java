package com.example.dontmixit.feature;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Scanner extends Activity {

    private TextView tv;

    Scanner(TextView tv)
    {
        this.tv = tv;
    }

    @Override
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



}