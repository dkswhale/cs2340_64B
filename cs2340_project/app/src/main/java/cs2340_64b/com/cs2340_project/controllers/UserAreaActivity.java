package cs2340_64b.com.cs2340_project.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cs2340_64b.com.cs2340_project.controllers.OpeningActivity;
import cs2340_64b.com.cs2340_project.R;
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

}
