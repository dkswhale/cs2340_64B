package cs2340_64b.com.cs2340_project.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cs2340_64b.com.cs2340_project.controllers.UserAreaActivity;
import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.model.LoginServiceFacade;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

    public void onSignInPressed(View view) {
        EditText usernameField = findViewById(R.id.username);
        EditText passwordField = findViewById(R.id.password);
        TextView error = findViewById(R.id.error_text);
        error.setText("");
        LoginServiceFacade model = LoginServiceFacade.getInstance();
        if (model.doLogin(usernameField.getText().toString(), passwordField.getText().toString())) {
            Intent intent = new Intent(this, UserAreaActivity.class);
            startActivity(intent);
        } else {
            usernameField.setText("");
            passwordField.setText("");
            error.setText("Invalid username or password Try again");
        }

    }

    public void onCancelPressed(View view) {
        Intent intent = new Intent(this, OpeningActivity.class);
        startActivity(intent);
    }

}
