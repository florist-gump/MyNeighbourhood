package Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hci.glasgow.myneighbourhood.R;
import models.Post;
import models.PostReplies;


/**
 * Created by Flo on 17/10/15.
 */
public class Replies extends ArrayAdapter<PostReplies> {

    public Replies(Context context, ArrayList<PostReplies> replies) {
        super(context, 0, replies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.replies, null);
        }

        PostReplies replies = getItem(position);

        if (replies != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.reply_text);


            if (tt1 != null) {
                tt1.setText(replies.getAuthor().getFirstName() + ": " +  replies.getText());
            }

        }
        return v;
    }

    @Override
    public boolean isEnabled (int position) {
        return false;
    }
}
