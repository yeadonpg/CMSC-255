package Labs.Lab_11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Lab11Test {


    Book[] myBooks = { new Book("Wilson", "A. Scott Burg" ),
            new Book("Nixonland", "Rick Perlstein"),
            new Book("Team of Rivals", "Doris Kearns Goodwin" ),
            new Book("What If?", "Randall Munroe" ),
            new Book("The Art of Power", "Jon Meacham") };

    // Book Tests

    @Test
    public void bookInstanceVariablesTest() {
        Book defaultBook = new Book();
        @SuppressWarnings("rawtypes")
        Class c = defaultBook.getClass();

        try {
            c.getDeclaredField("title");
            c.getDeclaredField("author");

            assertEquals("You must make your instance variables private.", true,
                    Modifier.isPrivate(c.getDeclaredField("title").getModifiers()));
            assertEquals("You must make your instance variables private.", true,
                    Modifier.isPrivate(c.getDeclaredField("author").getModifiers()));

            assertEquals("You must make your title instance variable of type String.", "".getClass(),
                    c.getDeclaredField("title").getType());
            assertEquals("You must make your authors instance variable of type String.", "".getClass(),
                    c.getDeclaredField("author").getType());

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage().toString() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void bookDefaultConstructorTest() {
        Book testBook = new Book();
        @SuppressWarnings("rawtypes")
        Class c = testBook.getClass();
        try {
            Field name = c.getDeclaredField("title");
            name.setAccessible(true);
            String nameValue = (String) name.get(testBook);
            assertEquals("When checking the value of title we", "Test", nameValue);

            Field date = c.getDeclaredField("author");
            date.setAccessible(true);
            String authorValue = (String) date.get(testBook);
            assertNull("When checking the value of author we", authorValue);

        } catch (Exception e) {
            fail(e.toString());
        }
    }

    @Test
    public void parameterizedBookConstructor() {
        String author = "Author";
        Book customBook = new Book("My Book", author);
        @SuppressWarnings("rawtypes")
        Class c = customBook.getClass();
        try {
            Field name = c.getDeclaredField("title");
            name.setAccessible(true);
            String nameValue = (String) name.get(customBook);
            assertEquals("When checking the value of title we", "My Book", nameValue);

            Field authorField = c.getDeclaredField("author");
            authorField.setAccessible(true);
            String authorValue = (String) authorField.get(customBook);
            assertEquals(author, authorValue);

        } catch (Exception e) {
            fail(e.toString());
        }
    }


    @Test
    public void getBookTitle() {
        String author = "Alexander Hamilton";
        Book customBook = new Book("The Federilist Papers", author);
        assertEquals("When calling the Book object's getBook method, we", "The Federilist Papers",
                customBook.getTitle());
    }

    @Test
    public void getBookAuthor() {
        String author = "Alexander Hamilton";
        Book customBook = new Book("Hello", author);
        try {
            assertEquals("Book's getAuthors method returned a String, we", author,
                    customBook.getAuthor());
        } catch (NullPointerException e) {
            fail("Book's getAuthors method returned null when it should have returned an initalized String array");
        } catch (Exception e) {
            fail("Something unknown went wrong");
        }
    }

    @Test
    public void setBookTitle() {
        String author = "Author";
        Book customBook = new Book("My Book", author);
        customBook.setTitle("New Title");
        @SuppressWarnings("rawtypes")
        Class c = customBook.getClass();
        try {
            Field name = c.getDeclaredField("title");
            name.setAccessible(true);
            String nameValue = (String) name.get(customBook);
            assertEquals("After calling Book's setTitle method, for the value of title we", "New Title", nameValue);
        } catch (Exception e) {
            fail(e.toString());
        }
    }

    @Test
    public void setBookAuthor() {
        String author = "CustomerPerson";
        String newAuthor = "Xerox Alto";
        Book customBook = new Book("Another Book", author);
        customBook.setAuthor(newAuthor);
        @SuppressWarnings("rawtypes")
        Class c = customBook.getClass();
        try {
            Field authorField = c.getDeclaredField("author");
            authorField.setAccessible(true);
            String authorValue = (String) authorField.get(customBook);
            assertEquals("After calling Book's setAuthors method, for the value of author we",
                    newAuthor, authorValue);

        } catch (Exception e) {
            fail(e.toString());
        }

    }

    @Test
    public void bookToStringAuthor() {
        String author = "Rick Perlstein";
        Book myBook = new Book("Nixonland", author);
        assertEquals("\"Nixonland\" by Rick Perlstein", myBook.toString());
    }


    // Bookshelf tests

    @Test
    public void defaultBookshelfConstructor() {
        Bookshelf mybook = new Bookshelf();
        @SuppressWarnings("rawtypes")
        Class c = mybook.getClass();
        try {
            Field size = c.getDeclaredField("size");
            size.setAccessible(true);
            int sizeValue = (int) size.get(mybook);
            assertEquals("When checking the value of size we", 2, sizeValue);

            Field books = c.getDeclaredField("books");
            books.setAccessible(true);
            @SuppressWarnings("unchecked")
            ArrayList<Book> bookValue = (ArrayList<Book>) books.get(mybook);
            assertEquals("When checking the size of the ArrayList referenced in book we", 0, bookValue.size());
        } catch (Exception e) {
            fail(e.toString());
        }
    }

    @Test
    public void parameterizedBookshelfConstructor() {
        Bookshelf mybook = new Bookshelf(10);
        @SuppressWarnings("rawtypes")
        Class c = mybook.getClass();
        try {
            Field size = c.getDeclaredField("size");
            size.setAccessible(true);
            int sizeValue = (int) size.get(mybook);
            assertEquals("When checking the value of size we", 10, sizeValue);

            Field books = c.getDeclaredField("books");
            books.setAccessible(true);
            @SuppressWarnings("unchecked")
            ArrayList<Book> bookValue = (ArrayList<Book>) books.get(mybook);
            assertEquals("When checking the size of the ArrayList referenced in book we", 0, bookValue.size());
        } catch (Exception e) {
            fail(e.toString());
        }
    }

    @Test
    public void getBookshelfSize() {
        Bookshelf mybook = new Bookshelf(5);
        assertEquals("When calling the Bookshelf object's getSize method, we", 5, mybook.getSize());
    }

    @Test
    public void getBookshelfBooks() {
        Bookshelf mybook = new Bookshelf(2);
        ArrayList<Book> newBooks = new ArrayList<Book>();
        newBooks.add(myBooks[0]);
        newBooks.add(myBooks[1]);
        @SuppressWarnings("rawtypes")
        Class c = mybook.getClass();
        try {
            Field books = c.getDeclaredField("books");
            books.setAccessible(true);
            books.set(mybook, newBooks);
        } catch (Exception e) {
            fail(e.toString());
        }
        assertEquals("Bookshelf's getBooks method returned a ArrayList and at index 0, we", myBooks[0],
                mybook.getBooks().get(0));
        assertEquals("Bookshelf's getBooks method returned a ArrayList and at index 1, we", myBooks[1],
                mybook.getBooks().get(1));
    }

    @Test
    public void addBooksToBookshelf() {
        Bookshelf mybook = new Bookshelf();
        mybook.addBook(myBooks[0]);
        mybook.addBook(myBooks[1]);
        @SuppressWarnings("rawtypes")
        Class c = mybook.getClass();
        try {
            Field books = c.getDeclaredField("books");
            books.setAccessible(true);
            @SuppressWarnings("unchecked")
            ArrayList<Book> bookValue = (ArrayList<Book>) books.get(mybook);
            assertEquals("After calling Bookshelf's addBook method, for the value of book at index 0 we", myBooks[0],
                    bookValue.get(0));
            assertEquals("After calling Bookshelf's addBook method, for the value of book at index 1 we", myBooks[1],
                    bookValue.get(1));
        } catch (Exception e) {
            fail(e.toString());
        }
    }

    @Test
    public void addTooManyBooksToBookshelf() {
        Bookshelf mybook = new Bookshelf(3);
        mybook.addBook(myBooks[0]);
        mybook.addBook(myBooks[1]);
        mybook.addBook(myBooks[2]);
        mybook.addBook(myBooks[3]);

        @SuppressWarnings("rawtypes")
        Class c = mybook.getClass();
        try {
            Field size = c.getDeclaredField("size");
            size.setAccessible(true);
            int sizeValue = (int) size.get(mybook);

            Field books = c.getDeclaredField("books");
            books.setAccessible(true);
            @SuppressWarnings("unchecked")
            ArrayList<Book> bookValue = (ArrayList<Book>) books.get(mybook);

            assertEquals(myBooks[0], bookValue.get(0));
            assertEquals(myBooks[1], bookValue.get(1));
            assertEquals(myBooks[2], bookValue.get(2));
            assertEquals(3, sizeValue);

        } catch (Exception e) {
            fail(e.toString());
        }

    }

    @Test
    public void removeSomeBooksFromBookshelf() {
        Bookshelf mybook = new Bookshelf(4);

        ArrayList<Book> newBooks = new ArrayList<Book>();
        newBooks.add(myBooks[0]);
        newBooks.add(myBooks[1]);
        newBooks.add(myBooks[2]);
        newBooks.add(myBooks[3]);
        @SuppressWarnings("rawtypes")
        Class c = mybook.getClass();
        try {
            Field books = c.getDeclaredField("books");
            books.setAccessible(true);
            books.set(mybook, newBooks);
        } catch (Exception e) {
            fail(e.toString());
        }

        mybook.removeBook();
        mybook.removeBook();

        try {
            Field size = c.getDeclaredField("size");
            size.setAccessible(true);
            int sizeValue = (int) size.get(mybook);

            Field books = c.getDeclaredField("books");
            books.setAccessible(true);
            @SuppressWarnings("unchecked")
            ArrayList<Book> bookValue = (ArrayList<Book>) books.get(mybook);

            assertEquals(myBooks[2], bookValue.get(0));
            assertEquals(myBooks[3], bookValue.get(1));
            assertEquals(4, sizeValue);

        } catch (Exception e) {
            fail(e.toString());
        }

    }

    @Test
    public void emptyBookshelf() {
        // Create a new Bookshelf object
        Bookshelf mybook = new Bookshelf(4);
        // Create a new ArrayList and place book objects into it
        ArrayList<Book> newBooks = new ArrayList<Book>();
        newBooks.add(myBooks[0]);
        newBooks.add(myBooks[1]);
        newBooks.add(myBooks[2]);
        newBooks.add(myBooks[3]);
        // This try catch block gets the book instance variable in Bookshelf and sets it
        // equal to
        // the newBooks ArrayList
        @SuppressWarnings("rawtypes")
        Class c = mybook.getClass();
        try {
            Field books = c.getDeclaredField("books");
            books.setAccessible(true);
            books.set(mybook, newBooks);
        } catch (Exception e) {
            fail(e.toString());
        }
        // Call our method
        mybook.emptyBookshelf();
        // Test the instance variables for correctness
        try {
            Field size = c.getDeclaredField("size");
            size.setAccessible(true);
            int sizeValue = (int) size.get(mybook);

            Field books = c.getDeclaredField("books");
            books.setAccessible(true);
            @SuppressWarnings("unchecked")
            ArrayList<Book> bookValue = (ArrayList<Book>) books.get(mybook);

            assertEquals(0, bookValue.size());
            assertEquals(4, sizeValue);

        } catch (Exception e) {
            fail(e.toString());
        }
    }
}