package cs2340_64b.com.cs2340_project.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.model.UserManager;


public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * logs out user when log out button pressed
     *
     * @param view current view
     */
    public void onLogoutPressed(View view) {
        UserManager.signOut();
        Intent intent = new Intent(this, OpeningActivity.class);
        startActivity(intent);
    }

    /**
     * Re-loads page when load button pressed
     *
     * @param view current view
     */
    public void onLoadButtonPressed(View view) {
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }

    /**
     * Goes to search page when search button pressed
     *
     * @param view current view
     */
    public void onSearchButtonPressed(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    /**
     * Goes to Map page when maps button pressed
     *
     * @param view current view
     */
    public void onMapsButtonPressed(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

}
