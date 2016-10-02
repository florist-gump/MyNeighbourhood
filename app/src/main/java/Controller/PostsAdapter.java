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
import models.Post;


/**
 * Created by Flo on 17/10/15.
 */
public class PostsAdapter extends ArrayAdapter<Post> {

    public PostsAdapter(Context context, ArrayList<Post> post) {
        super(context, 0, post);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.posts_list_view, null);
        }

        Post post = getItem(position);

        if (post != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.posts_text);


            if (tt1 != null) {
                tt1.setText(post.getAuthor().getFirstName() + ": " +  post.getDescription());
            }

        }
        return v;
    }

    @Override
    public boolean isEnabled (int position) {
        return true;
    }
}
