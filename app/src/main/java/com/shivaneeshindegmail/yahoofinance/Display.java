package com.shivaneeshindegmail.yahoofinance;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class Display extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        final TextView bcStartDate=(TextView)findViewById(R.id.a);
        final TextView bcEndDate=(TextView)findViewById(R.id.b);
        final TextView applicableMargin=(TextView)findViewById(R.id.c);
        final TextView averagePrice=(TextView)findViewById(R.id.d);

        Intent intent = getIntent();
        final String a = intent.getStringExtra("bcStartDate");
        final String b = intent.getStringExtra("bcEndDate");
        final int c = intent.getIntExtra("applicableMargin",-1);
        final int d = intent.getIntExtra("averagePrice",-1);

        bcStartDate.setText(a);
        bcEndDate.setText(b);
        applicableMargin.setText(c);
        averagePrice.setText(d);
    }
}
