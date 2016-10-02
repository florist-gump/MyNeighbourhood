package Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

import hci.glasgow.myneighbourhood.R;
import models.Neighbourhood;


/**
 * Created by Flo on 17/10/15.
 */
public class NeighbourhoodAdapter extends ArrayAdapter<Neighbourhood> {

    public NeighbourhoodAdapter(Context context, ArrayList<Neighbourhood> neighbourhood) {
        super(context, 0, neighbourhood);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.myneighbourhood_list_view, null);
        }

        Neighbourhood neighbourhood = getItem(position);

        if (neighbourhood != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.neighbourhood_text);


            if (tt1 != null) {
                tt1.setText(neighbourhood.getName());
            }

        }
        return v;
    }

    @Override
    public boolean isEnabled (int position) {
        return true;
    }
}
