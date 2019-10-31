package Lab_11;

public class Lab11 {
    public static void main(String[] args) {
        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien");
        Book book2 = new Book("Nixonland", "Rick Perlstein");
        Book book3 = new Book("The Diamond Age: Or, A Young Lady's Illustrated Primer", "Neal Stephenson");

        Bookshelf bookShelf = new Bookshelf(3);
        bookShelf.addBook(book1);
        bookShelf.addBook(book2);
        bookShelf.addBook(book3);

        for (Book elem : bookShelf.getBooks()) {
            System.out.println(elem.toString());
        }
    }
}
