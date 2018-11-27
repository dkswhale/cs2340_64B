package cs2340_64b.com.cs2340_project.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.controllers.DonationFragment;
import cs2340_64b.com.cs2340_project.controllers.DonationFragment.OnListFragmentInteractionListener;
import cs2340_64b.com.cs2340_project.controllers.dummy.DummyDonation.DummyDon;

/**
 *
 */

public class DonationRecyclerViewAdapter extends RecyclerView.Adapter<DonationRecyclerViewAdapter.ViewHolder> {

    private final List<DummyDon> mDonations;
    private final OnListFragmentInteractionListener mListener;

    /**
     * This sets the listener and sets donation
     * @param items - items in donation
     * @param listener - something that listens to donations
     */
    public DonationRecyclerViewAdapter(List<DummyDon> items,
                                       DonationFragment.OnListFragmentInteractionListener listener) {
        mDonations = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_donation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mDonation = mDonations.get(position);
        holder.mIdView.setText(mDonations.get(position).id);
        holder.mContentView.setText(mDonations.get(position).donation.getShortDescription());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mDonation);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDonations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mIdView;
        final TextView mContentView;
        DummyDon mDonation;

        /**
         * this is the view holder of the donation
         * @param view - this views the donations and it's holder
         */
        ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.itemDescription);
            mContentView = view.findViewById(R.id.itemValue);
        }

        @Override
        public String toString() {
            return super.toString() + "'" + mContentView.getText() + "'";
        }
    }
}
