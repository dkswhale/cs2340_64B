package cs2340_64b.com.cs2340_project.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.controllers.dummy.DummyDonation;
import cs2340_64b.com.cs2340_project.model.Donation;
import cs2340_64b.com.cs2340_project.model.DonationCategory;
import cs2340_64b.com.cs2340_project.model.DonationManager;

public class SearchActivity extends AppCompatActivity {

    private Spinner overall;
    private Spinner category;
    private Spinner search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        DummyDonation.setup(DonationManager.getDonations());

        overall = findViewById(R.id.spinnerOverall);
        String[] over = {"Search All Locations", "AFD Station 4", "BOYS & GILRS CLUB W.W. WOOLFOLK",
                        "PATHWAY UPPER ROOM CHRISTIAN MINISTRIES", "PAVILION OF HOPE INC",
                        "D&D CONVENIENCE STORE", "KEEP NORTH FULTON BEAUTIFUL"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, over);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        overall.setAdapter(adapter1);

        category = findViewById(R.id.spinnerCategory);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, DonationCategory.values());
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter2);

        search = findViewById(R.id.spinnerSearch);
        String[] sch = {"Name", "Category"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sch);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        search.setAdapter(adapter3);

    }

    /**
     * Searches data when search button pressed
     *
     * @param view current view of search screen
     */
    public void onSearchFinalPressed(View view) {
        TextView text = findViewById(R.id.nameToSearch);
        String searchName = text.getText().toString();
        ArrayList<Donation> don = DonationManager.getDonations();
        int counter = 0;
        TextView a = findViewById(R.id.textView4);
        TextView b = findViewById(R.id.textView5);
        TextView c = findViewById(R.id.textView6);
        TextView d = findViewById(R.id.textView7);
        TextView e = findViewById(R.id.textView8);
        TextView f = findViewById(R.id.textView9);
        TextView results = findViewById(R.id.results);
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
        e.setText("");
        f.setText("");
        results.setText("");
        if (search.getSelectedItem() == "Name") {
            if (overall.getSelectedItem() == "Search All Locations") {
                for (int i = 0; i < don.size(); i++) {
                    if (searchName.equals(don.get(i).getShortDescription())) {
                        if (counter == 0) {
                            a.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                        } else if (counter == 1) {
                            b.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                        } else if (counter == 2) {
                            c.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                        } else if (counter == 3) {
                            d.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                        } else if (counter == 4) {
                            e.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                        } else if (counter == 5) {
                            f.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                        }
                        counter++;
                    }
                }
            } else {
                for (int i = 0; i < don.size(); i++) {
                    if (overall.getSelectedItem().equals(don.get(i).getLocation())) {
                        if (searchName.equals(don.get(i).getShortDescription())) {
                            if (counter == 0) {
                                a.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                            } else if (counter == 1) {
                                b.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                            } else if (counter == 2) {
                                c.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                            } else if (counter == 3) {
                                d.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                            } else if (counter == 4) {
                                e.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                            } else if (counter == 5) {
                                f.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                            }
                            counter++;
                        }
                    }
                }
            }
        } else {
            if (overall.getSelectedItem() == "Search All Locations") {
                for (int i = 0; i < don.size(); i++) {
                    if (category.getSelectedItem().equals(don.get(i).getCategory())) {
                        if (counter == 0) {
                            a.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                        } else if (counter == 1) {
                            b.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                        } else if (counter == 2) {
                            c.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                        } else if (counter == 3) {
                            d.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                        } else if (counter == 4) {
                            e.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                        } else if (counter == 5) {
                            f.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                        }
                        counter++;
                    }
                }
            } else {
                for (int i = 0; i < don.size(); i++) {
                    if (overall.getSelectedItem().equals(don.get(i).getLocation())) {
                        if (category.getSelectedItem().equals(don.get(i).getCategory())) {
                            if (counter == 0) {
                                a.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                            } else if (counter == 1) {
                                b.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                            } else if (counter == 2) {
                                c.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                            } else if (counter == 3) {
                                d.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                            } else if (counter == 4) {
                                e.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                            } else if (counter == 5) {
                                f.setText("$" + don.get(i).getValue() + "   " + don.get(i).getShortDescription() + "   " + don.get(i).getCategory());
                            }
                            counter++;
                        }
                    }
                }
            }

        }
        if (counter == 0) {
            a.setText(R.string.errorMessage_search);
        } else if (counter >= 6) {
            results.setText("+ " + (counter - 5) + " More results");
        }
    }
}
