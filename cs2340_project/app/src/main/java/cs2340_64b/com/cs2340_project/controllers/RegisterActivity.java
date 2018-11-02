package cs2340_64b.com.cs2340_project.controllers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.model.DonationManager;
import cs2340_64b.com.cs2340_project.model.UserManager;
import cs2340_64b.com.cs2340_project.model.UserRights;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameField;
    private EditText passwordField;
    private EditText nameField;
    private Spinner typeSpinner;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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

        typeSpinner = findViewById(R.id.typeSpinner_reg);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, UserRights.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

    }

    public void onRegisterPressed_reg(View view) {
        UserManager userManager = new UserManager();
        usernameField = findViewById(R.id.username_reg);
        passwordField = findViewById(R.id.password_reg);
        nameField = findViewById(R.id.name_reg);
        error = findViewById(R.id.error_text_reg);
        error.setText("");

        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        String name = nameField.getText().toString();
        UserRights type = UserRights.userRights(typeSpinner.getSelectedItem().toString());



        if (UserManager.registerUser(username, password, name, type)) {
            Intent intent = new Intent(this, UserAreaActivity.class);
            startActivity(intent);
        } else {
            usernameField.setText("");
            passwordField.setText("");
            nameField.setText("");
            error.setText("Username already exists. Try again");
        }



    }

    public void onCancelPressed_reg(View view) {
        finish();
    }

}
