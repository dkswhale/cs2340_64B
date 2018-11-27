package cs2340_64b.com.cs2340_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.model.DonationManager;
import cs2340_64b.com.cs2340_project.model.Location;

/**
 * Handles location data and activity
 */

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

        name.setText(location.getName());
        la.setText(String.valueOf(location.getLatitude()));
        lo.setText(String.valueOf(location.getLongitude()));
        ad.setText(location.getAddress());
        type.setText(String.valueOf(location.getType()));
        phone.setText(location.getPhone());
    }

    /**
     * Adds the donation to the list of current donations
     *
     * @param view the current view being displayed
     */
    public void onDonatePressed(View view) {
        if (DonationManager.addLocation(location.getName())) {
            Intent intent = new Intent(this, DonateActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Changes the display to show the donations
     *
     * @param view the current view being displayed
     */
    public void onViewDonationPressed(View view) {
        Intent intent = new Intent(this, DonationActivity.class);
        startActivity(intent);
    }
}
