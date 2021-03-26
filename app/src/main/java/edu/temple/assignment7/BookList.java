package edu.temple.assignment7;

import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.stream.Stream;

public class BookList extends ArrayList<Parcelable>
{

    private ArrayList<Book> list;

    public BookList()
    {
        list = new ArrayList<Book>();
    }
    public void RemoveBook(Book book)
    {
        list.remove(book);
    }
    public void AddBook(Book book)
    {
        list.add(book);
    }
    public Book get(int position)
    {
        return list.get(position);
    }
    public int size()
    {
        return list.size();
    }

    @NonNull
    @Override
    public Stream<Parcelable> stream()
    {
        return null;
    }
}