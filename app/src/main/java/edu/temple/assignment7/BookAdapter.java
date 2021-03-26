package edu.temple.assignment7;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BookAdapter extends ArrayAdapter
{

    Context context;

    public BookAdapter(@NonNull Context context, int resource, @NonNull List objects)
    {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        TextView titleTextView;
        TextView authorTextView;
        LinearLayout layout;
        String tit = ((Book)(getItem(position))).getTitle();
        String aut = ((Book)(getItem(position))).getAuthor();
        if(convertView == null)
        {
            layout = new LinearLayout(context);
            titleTextView = new TextView(context);
            titleTextView.setTextSize(22);
            titleTextView.setPadding(15,20,0,20);
            authorTextView = new TextView(context);
            authorTextView.setTextSize(19);
            authorTextView.setPadding(15,20,0,20);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.addView(titleTextView);
            layout.addView(authorTextView);
        }
        else
        {
            layout = (LinearLayout) convertView;
            titleTextView = (TextView) layout.getChildAt(0);
            authorTextView = (TextView) layout.getChildAt(1);
        }

        titleTextView.setText(tit);
        authorTextView.setText(aut);
        return layout;
    }
}