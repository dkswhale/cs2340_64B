package cs2340_64b.com.cs2340_project.controllers;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.model.Location;
import cs2340_64b.com.cs2340_project.model.LoginServiceFacade;

public class LocationDetailFragment extends Fragment {
    public static final String ARG_LOC_KEY = "item_id";

    private Location mItem;

    public LocationDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_LOC_KEY)) {
            int item_id = getArguments().getInt(ARG_LOC_KEY);
            mItem = LoginServiceFacade.getInstance().findLocationByKey(item_id);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_detail, container, false);
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.key)).setText("" + mItem.getKey());
            ((TextView) rootView.findViewById(R.id.name)).setText(mItem.getName());
            ((TextView) rootView.findViewById(R.id.type)).setText(mItem.getType());
            ((TextView) rootView.findViewById(R.id.longitude)).setText(String.valueOf(mItem.getLongitude()));
            ((TextView) rootView.findViewById(R.id.latitude)).setText(String.valueOf(mItem.getLatitude()));
            ((TextView) rootView.findViewById(R.id.address)).setText(mItem.getAddress());
            ((TextView) rootView.findViewById(R.id.phonenumber)).setText(mItem.getPhone());
        }
        return rootView;
    }
}
