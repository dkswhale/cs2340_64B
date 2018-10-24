package cs2340_64b.com.cs2340_project.controllers;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.model.DonationCategory;
import cs2340_64b.com.cs2340_project.model.DonationManager;

public class DonateActivity extends AppCompatActivity {

    private Spinner categorySpinner;
    private EditText valueField;
    private EditText shortDField;
    private EditText fullDField;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        //DonationFragment fragment = new DonationFragment();
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.add(R.id.donation, fragment);
        //fragmentTransaction.commit();

        categorySpinner = findViewById(R.id.category);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, DonationCategory.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);
    }

    public void onDonateButtonPressed(View view) {
        valueField = findViewById(R.id.value);
        shortDField = findViewById(R.id.shortDescription);
        fullDField = findViewById(R.id.fullDescription);
        error = findViewById(R.id.errorText);
        error.setText("");

        int value = Integer.parseInt(valueField.getText().toString());
        String shortD = shortDField.getText().toString();
        String fullD = fullDField.getText().toString();
        DonationCategory category = (DonationCategory) categorySpinner.getSelectedItem();

        if (DonationManager.doDonate(shortD, fullD, value, category)) {
            Intent intent = new Intent(this, UserAreaActivity.class);
            startActivity(intent);
        } else {
            valueField.setText("");
            shortDField.setText("");
            fullDField.setText("");
            error.setText("Please check the information again");
        }
    }

    public void onCancelButtonPressed(View view) {
        DonationManager.cancelDonation();
        finish();
    }
}
