package cs2340_64b.com.cs2340_project.controllers;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.model.Location;
import cs2340_64b.com.cs2340_project.model.LoginServiceFacade;


public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onLogoutPressed(View view) {
        LoginServiceFacade model = LoginServiceFacade.getInstance();
        model.logout();
        Intent intent = new Intent(this, OpeningActivity.class);
        startActivity(intent);
    }

    public void onLoadButtonPressed(View view) {
        readCSVFile();
        Intent intent = new Intent(this, LocationListActivity.class);
        startActivity(intent);
    }

    public static final int NAME_POSITION = 1;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void readCSVFile() {
        LoginServiceFacade model = LoginServiceFacade.getInstance();

        try {
            InputStream is = getResources().openRawResource(R.raw.location_data);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                int key = Integer.parseInt(tokens[0]);
                long la = Long.parseLong(tokens[2]);
                long lo = Long.parseLong(tokens[3]);
                model.addLocation(new Location(key, tokens[NAME_POSITION], la, lo, tokens[4], tokens[8], tokens[9]));
            }
            br.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

}
