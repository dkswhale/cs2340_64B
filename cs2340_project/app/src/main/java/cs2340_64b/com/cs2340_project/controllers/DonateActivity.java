package cs2340_64b.com.cs2340_project.controllers;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        categorySpinner = findViewById(R.id.category);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, DonationCategory.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);
    }

    /**
     * Checks to see if the information entered is valid.
     * If donation is valid, adds it to the category list
     *
     * @param view the current view being displayed
     */
    public void onDonateButtonPressed(View view) {
        EditText valueField = findViewById(R.id.value);
        EditText shortDField = findViewById(R.id.shortDescription);
        EditText fullDField = findViewById(R.id.fullDescription);
        TextView error = findViewById(R.id.errorText);
        error.setText("");

        Double value = Double.parseDouble(valueField.getText().toString());
        String shortD = shortDField.getText().toString();
        String fullD = fullDField.getText().toString();
        DonationCategory category = DonationCategory.donationCategory(categorySpinner.getSelectedItem().toString());

        if (DonationManager.doDonate(shortD, fullD, value, category)) {
            Intent intent = new Intent(this, UserAreaActivity.class);
            startActivity(intent);
        } else {
            valueField.setText("");
            shortDField.setText("");
            fullDField.setText("");
            error.setText(R.string.errorMessage_donate);
        }
    }

    /**
     * Cancels the current donation and goes back to the home screen
     *
     * @param view the current view being displayed
     */
    public void onCancelButtonPressed(View view) {
        DonationManager.cancelDonation();
        finish();
    }
}
