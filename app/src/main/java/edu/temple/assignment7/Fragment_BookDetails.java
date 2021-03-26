package edu.temple.assignment7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment_BookDetails extends Fragment
{

    private static final String BOOK = "param1";
    TextView titleTextView;
    TextView authorTextView;
    private Book book;

    public Fragment_BookDetails()
    {

    }

    public static Fragment_BookDetails newInstance(Book book)
    {
        Fragment_BookDetails f = new Fragment_BookDetails();
        Bundle b = new Bundle();
        b.putParcelable(BOOK, book);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            book = getArguments().getParcelable(BOOK);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View l = inflater.inflate(R.layout.book_details, container, false);

        titleTextView = l.findViewById(R.id.titleTextView);
        authorTextView = l.findViewById(R.id.authorTextView);

        if(book != null)
        {
            changeBook(book);
        }
        return l;
    }

    public void changeBook(Book book)
    {
        titleTextView.setText(book.getTitle());
        authorTextView.setText(book.getAuthor());

    }

}