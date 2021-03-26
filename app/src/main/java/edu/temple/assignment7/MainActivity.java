package edu.temple.assignment7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;

public class MainActivity extends AppCompatActivity implements Fragment_BookList.Fragment_BookListInterface{

    int position;
    BookList list;
    Fragment_BookDetails details;
    Parcelable p;
    boolean ifContainer2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ifContainer2 = findViewById(R.id.container2) != null;
        list = new BookList();
        list.AddBook(new Book("Author 1", "Book Title 1"));
        list.AddBook(new Book("Author 2", "Book Title 2"));
        list.AddBook(new Book("Author 3", "Book Title 3"));
        list.AddBook(new Book("Author 4", "Book Title 4"));
        list.AddBook(new Book("Author 5", "Book Title 5"));
        list.AddBook(new Book("Author 6", "Book Title 6"));
        list.AddBook(new Book("Author 7", "Book Title 7"));
        list.AddBook(new Book("Author 8", "Book Title 6"));
        list.AddBook(new Book("Author 9", "Book Title 9"));
        list.AddBook(new Book("Author 10", "Book Title 10"));

        if(!ifContainer2){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_1, Fragment_BookList.newInstance(list))
                    .commit();
        }
        else if(ifContainer2){
            details = new Fragment_BookDetails();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container2, details)
                    .commit();
        }
    }

    @Override
    public void bookClicked(int position) {
        if(!ifContainer2) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_1, Fragment_BookDetails.newInstance(list.get(position)))
                    .addToBackStack(null)
                    .commit();
        }
        else{
            details.changeBook(list.get(position));
            this.position = position;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}