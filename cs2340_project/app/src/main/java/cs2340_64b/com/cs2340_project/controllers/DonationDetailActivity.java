package cs2340_64b.com.cs2340_project.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.model.Donation;

public class DonationDetailActivity extends AppCompatActivity {

    private Donation donation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_detail);

        donation = (Donation) getIntent().getExtras().get("donation");
        TextView location = findViewById(R.id.location);
        TextView time = findViewById(R.id.time);
        TextView shortD = findViewById(R.id.shortD);
        TextView longD = findViewById(R.id.longD);
        TextView valueD = findViewById(R.id.valueD);
        TextView categoryD = findViewById(R.id.categoryD);

        location.setText("Location: " + donation.getLocation());
        time.setText("Time: " + donation.getTime());
        shortD.setText("Short Description: " + donation.getShortDescription());
        longD.setText("Full Description: " + donation.getFullDescription());
        valueD.setText("Value: " + donation.getValue() + " $");
        categoryD.setText("Category: " + donation.getCategory());
    }
}
