package cs2340_64b.com.cs2340_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.controllers.dummy.DummyDonation;
import cs2340_64b.com.cs2340_project.controllers.dummy.DummyDonation.DummyDon;
import cs2340_64b.com.cs2340_project.model.DonationManager;

public class DonationActivity extends AppCompatActivity implements DonationFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        DummyDonation.setup(DonationManager.getDonations());

    }

    @Override
    public void onListFragmentInteraction(DummyDon dummy) {
        Intent intent = new Intent(DonationActivity.this, DonationDetailActivity.class);
        intent.putExtra("donation", dummy.donation);
        startActivity(intent);
    }
}
