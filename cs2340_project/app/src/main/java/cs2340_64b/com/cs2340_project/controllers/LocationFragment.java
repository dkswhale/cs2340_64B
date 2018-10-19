package cs2340_64b.com.cs2340_project.controllers;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.controllers.dummy.DummyContent;
import cs2340_64b.com.cs2340_project.model.Location;
import cs2340_64b.com.cs2340_project.model.LocationRecyclerViewAdapter;

import static cs2340_64b.com.cs2340_project.controllers.dummy.DummyContent.*;

public class LocationFragment extends Fragment {
    public static final String ARG_LOC_KEY = "item_key";
    private int mItemKey = 1;
    private OnListFragmentInteractionListener mListener;

    public LocationFragment() {
    }

    @SuppressWarnings("unused")
    public static LocationFragment newInstance(int itemKey) {
        LocationFragment frag = new LocationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_LOC_KEY, itemKey);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mItemKey = getArguments().getInt(ARG_LOC_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_location_list, container, false);
        if (rootView instanceof RecyclerView) {
            Context context = ((RecyclerView) rootView).getContext();
            RecyclerView recyclerView = (RecyclerView) rootView;
            if (mItemKey < 2) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mItemKey));
            }
            recyclerView.setAdapter(new LocationRecyclerViewAdapter(DummyContent.ITEMS, mListener));
        }
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + "must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(DummyItem dummy);
    }
}
