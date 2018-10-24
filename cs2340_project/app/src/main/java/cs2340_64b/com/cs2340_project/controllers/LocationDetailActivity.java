package cs2340_64b.com.cs2340_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.model.DonationManager;
import cs2340_64b.com.cs2340_project.model.Location;
import cs2340_64b.com.cs2340_project.model.UserManager;
import cs2340_64b.com.cs2340_project.model.UserRights;

public class LocationDetailActivity extends AppCompatActivity {

    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);

        location = (Location) getIntent().getExtras().get("location");
        TextView name = findViewById(R.id.name);
        TextView la = findViewById(R.id.latitude);
        TextView lo = findViewById(R.id.longitude);
        TextView ad = findViewById(R.id.address);
        TextView type = findViewById(R.id.type);
        TextView phone = findViewById(R.id.phonenumber);

        name.setText("Name: " + location.getName());
        la.setText("Latitue: " + String.valueOf(location.getLatitude()));
        lo.setText("Longitude: " + String.valueOf(location.getLongitude()));
        ad.setText("Address: " + location.getAddress());
        type.setText("Type: " + String.valueOf(location.getType()));
        phone.setText("Phone Number: " + location.getPhone());
    }

    public void onDonatePressed(View view) {
        if (DonationManager.addLocation(location.getName())) {
            Intent intent = new Intent(this, DonateActivity.class);
            startActivity(intent);
        }
    }

    public void onViewDonationPressed(View view) {
        if (UserManager.getCurrentUser().getRights() == UserRights.LOCATION_EMPLOYEE) {
            Intent intent = new Intent(this, DonationActivity.class);
            startActivity(intent);
        }
    }
}
