package com.shivaneeshindegmail.yahoofinance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import helper.SessionManager;
import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Startingpoint extends AppCompatActivity {


    private Button appllink;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startingpoint);
        final Button appllink= (Button) findViewById(R.id.btn);
        final EditText name=(EditText) findViewById(R.id.txt);
        final TextView out = (TextView)findViewById(R.id.out);

        appllink.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                final String name="APPL";

                // Response received from the server
                Response.Listener<String> responseListener= new Response.Listener<String>(){
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success= jsonResponse.getBoolean("success");

                            if(success){

                                JSONObject reader = new JSONObject(response);
                                JSONObject sys  = reader.getJSONObject("price");
                                String bcStartDate = sys.getString("bcStartDate");
                                String bcEndDate = sys.getString("bcEndDate");
                                int applicableMargin = sys.getInt("applicableMargin");
                                int averagePrice = sys.getInt("averagePrice");

                                Intent intent= new Intent(Startingpoint.this,Display.class);
                                intent.putExtra("bcStartDate",bcStartDate);
                                intent.putExtra("bcEndDate",bcEndDate);
                                intent.putExtra("applicableMargin",applicableMargin);
                                intent.putExtra("averagePrice",averagePrice);
                                Startingpoint.this.startActivity(intent);
                            }else {
                                AlertDialog.Builder builder= new AlertDialog.Builder(Startingpoint.this);
                                builder.setMessage("retriving data was Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }

                        } catch(JSONException e) {
                            e.printStackTrace();

                        }

                    }
                };

                Fetch fetch_request=new Fetch(name,responseListener);
                RequestQueue queue= Volley.newRequestQueue(Startingpoint.this);
                queue.add(fetch_request);
            }

        });
    }
}
