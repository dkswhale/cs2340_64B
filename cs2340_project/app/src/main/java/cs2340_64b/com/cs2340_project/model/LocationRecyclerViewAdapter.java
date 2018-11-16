package cs2340_64b.com.cs2340_project.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cs2340_64b.com.cs2340_project.R;
import cs2340_64b.com.cs2340_project.controllers.dummy.DummyContent.DummyItem;
import cs2340_64b.com.cs2340_project.controllers.LocationFragment.OnListFragmentInteractionListener;

public class LocationRecyclerViewAdapter extends RecyclerView.Adapter<LocationRecyclerViewAdapter.ViewHolder> {
    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    /**
     * this is recyling the view adapter
     * @param items - items of the adapter
     * @param listener - adapter listener
     */
    public LocationRecyclerViewAdapter(List<DummyItem> items,
                           OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_location, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).location.getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mIdView;
        final TextView mContentView;
        DummyItem mItem;

        /**
         * this is the view holder that views the location
         * @param view - the view of location
         */
        ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_number);
            mContentView = view.findViewById(R.id.contents);
        }

        @Override
        public String toString() {
            return super.toString() + "'" + mContentView.getText() + "'";
        }
    }
}
