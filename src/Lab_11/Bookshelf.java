package Lab_11;

import java.util.ArrayList;

public class Bookshelf {
    private int size;
    private ArrayList<Book> books;

    public Bookshelf() {
        size = 2;
        books = new ArrayList<>();
    }

    public Bookshelf(int aSize) {
        size = aSize;
        books = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book aBook) {
        books.add(aBook);
    }

    public void removeBook() {
        books.remove(0);
    }

    public void emptyBookshelf() {
        books.clear();
    }
}
