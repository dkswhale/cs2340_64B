package cs2340_64b.com.cs2340_project.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.model.Location;

public class LocationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putInt(LocationDetailFragment.ARG_LOC_KEY,
                    getIntent().getIntExtra(LocationDetailFragment.ARG_LOC_KEY, 1000));
            LocationDetailFragment fragment = new LocationDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.location_detail_container, fragment)
                    .commit();
        }
    }
}
