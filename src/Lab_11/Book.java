package Lab_11;

public class Book {
    private String title;
    private String author;

    public Book() {
        title = "Test";
        author = null;
    }

    public Book(String aTitle, String anAuthor) {
        title = aTitle;
        author = anAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String aTitle) {
        title = aTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String anAuthor) {
        author = anAuthor;
    }

    public String toString() {
        return String.format("\"%s\" by %s", title, author);
    }
}
