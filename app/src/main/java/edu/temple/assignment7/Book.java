package edu.temple.assignment7;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable
{
    private String author, title;

    Book(String author, String title)
    {
        this.author = author;
        this.title = title;
    }

    protected Book(Parcel p)
    {
        author = p.readString();
        title = p.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>()
    {
        @Override
        public Book createFromParcel(Parcel p)
        {
            return new Book(p);
        }
        @Override
        public Book[] newArray(int size)
        {
            return new Book[size];
        }
    };

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getTitle()
    {
        return title;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(author);
        dest.writeString(title);
    }
}