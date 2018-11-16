package cs2340_64b.com.cs2340_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.InputStream;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.controllers.dummy.DummyContent;
import cs2340_64b.com.cs2340_project.controllers.dummy.DummyContent.DummyItem;
import cs2340_64b.com.cs2340_project.controllers.LocationFragment;
import cs2340_64b.com.cs2340_project.model.LocationData;

public class LocationActivity extends AppCompatActivity implements LocationFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        InputStream inputStream = getResources().openRawResource(R.raw.location_data);
        @SuppressWarnings("unused") LocationData data = new LocationData(inputStream);
        DummyContent.setup(LocationData.getLocations());

    }

    @Override
    public void onListFragmentInteraction(DummyItem dummy) {
        Intent intent = new Intent(LocationActivity.this, LocationDetailActivity.class);
        intent.putExtra("location", dummy.location);
        startActivity(intent);
    }
}
