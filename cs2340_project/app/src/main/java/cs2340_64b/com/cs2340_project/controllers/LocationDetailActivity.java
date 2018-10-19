package cs2340_64b.com.cs2340_project.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.model.Location;

public class LocationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);

        Location location = (Location) getIntent().getExtras().get("location");
        TextView key = findViewById(R.id.key);
        TextView name = findViewById(R.id.name);
        TextView la = findViewById(R.id.latitude);
        TextView lo = findViewById(R.id.longitude);
        TextView ad = findViewById(R.id.address);
        TextView type = findViewById(R.id.type);
        TextView phone = findViewById(R.id.phonenumber);

        key.setText("Key: " + String.valueOf(location.getKey()));
        name.setText("Name: " + location.getName());
        System.out.println("h");
        la.setText("Latitue: " + String.valueOf(location.getLatitude()));
        lo.setText("Longitude: " + String.valueOf(location.getLongitude()));
        System.out.println("i");
        ad.setText("Address: " + location.getAddress());
        type.setText("Type: " + String.valueOf(location.getType()));
        System.out.println("j");
        phone.setText("Phone Number: " + location.getPhone());
    }
}
