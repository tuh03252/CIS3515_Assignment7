package edu.temple.assignment7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class Fragment_BookList extends Fragment
{

    private static final String LIST = "param1";

    private BookList list;

    public Fragment_BookList()
    {

    }

    public static Fragment_BookList newInstance(BookList list)
    {
        Fragment_BookList f = new Fragment_BookList();
        Bundle b = new Bundle();
        b.putParcelableArrayList(LIST, list);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            list = (BookList) getArguments().getParcelableArrayList(LIST);
        }
        else{
            list = new BookList();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        ListView view = (ListView) inflater.inflate(R.layout.book_list, container, false);
        view.setAdapter(new BookAdapter(getActivity(), android.R.layout.simple_list_item_1, list));
        view.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ((Fragment_BookListInterface) getActivity()).bookClicked(position);
            }
        });
        return view;
    }

    interface Fragment_BookListInterface
    {
        public void bookClicked(int position);
    }

}