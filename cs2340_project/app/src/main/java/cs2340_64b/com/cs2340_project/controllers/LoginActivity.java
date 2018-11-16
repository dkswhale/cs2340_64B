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

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.model.UserManager;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
     * When sign in is pressed, either sign the user in, or return an error
     *
     * @param view the current view of the login screen with the username
     * and password fields filled in
     */
    public void onSignInPressed(View view) {
        EditText usernameField = findViewById(R.id.username);
        EditText passwordField = findViewById(R.id.password);
        TextView error = findViewById(R.id.error_text);
        error.setText("");
        if (UserManager.signIn(usernameField.getText().toString(), passwordField.getText().toString())) {
            Intent intent = new Intent(this, UserAreaActivity.class);
            startActivity(intent);
        } else {
            usernameField.setText("");
            passwordField.setText("");
            error.setText(R.string.errorMessage_signin);
        }

    }

    /**
     * When cancel is pressed, cancel the login activity
     *
     * @param view the current view of the login screen
     */
    public void onCancelPressed(View view) {
        Intent intent = new Intent(this, OpeningActivity.class);
        startActivity(intent);
    }

}
