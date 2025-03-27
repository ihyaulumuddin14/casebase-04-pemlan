import java.util.ArrayList;
import java.util.List;

public class Library {
    private Inventory<Book> books = new Inventory<>();
    private Inventory<String> authors = new Inventory<>();
    private Inventory<String> titles = new Inventory<>();

    public Inventory<Book> getBooks() {
        return this.books;
    }

    public void addBook(Book book) {
        this.books.addItem(book);
        this.authors.addItem(book.getAuthor());
        this.titles.addItem(book.getTitle());
    }

    public void removeBook(Book book) {
        try {
            this.books.removeItem(book);
            this.authors.removeItem(book.getAuthor());
            this.titles.removeItem(book.getTitle());
        } catch (ItemTidakDItemukanException e) {
            System.out.println("ItemTidakDItemukanException: " + e.getMessage());
        }
    }

    public void searchBooks(String keyword) {
        try {
            List<Integer> indeks = new ArrayList<>();

            if (this.titles.getItems().contains(keyword)) {
                indeks = this.titles.searchItems(keyword);
            } else if (this.authors.getItems().contains(keyword)) {
                indeks = this.authors.searchItems(keyword);
            }

            for (Integer index : indeks) {
                this.books.getItems().get(index).printBook();
            }
        } catch (ItemTidakDItemukanException e) {
            System.out.println("ItemTidakDItemukanException: " + e.getMessage());
        }
    }

    public void updateStock(Book book, int quantity) {
        try {
            List<Book> bookList = this.books.getItems();
            int bookIndex = bookList.indexOf(book);
    
            bookList.get(bookIndex).setStock(quantity);
        } catch (AngkaStokException e) {
            System.out.println("AngkaStokException: " + e.getMessage());
        }
    }

    public void printAllBooks() {
        for (Book book : this.books.getItems()) {
            book.printBook();
        }
    }

    public Book getBookFromKeyword(String keyword) {
        try {
            return this.books.getItems().get(this.titles.searchItems(keyword).get(0));
        } catch (ItemTidakDItemukanException e) {
            System.out.println("ItemTidakDItemukanException: " + e.getMessage());
            return null;
        }
    }
}
