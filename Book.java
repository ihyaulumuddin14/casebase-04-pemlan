public class Book {
    private String title;
    private String author;
    private int year;
    private int stock;

    public Book(String title, String author, int year, int stock) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.stock = stock;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setYear(int year) {
        this.year = year;
    }

    public void setStock(int stock) throws AngkaStokException {
        if (stock < 0) throw new AngkaStokException("Angka stok " + stock + " tidak valid.");
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getStock() {
        return stock;
    }

    public void printBook() {
        System.out.println("Judul: " + this.title);
        System.out.println("Penulis: " + this.author);
        System.out.println("Tahun: " + this.year);
        System.out.println("Stok: " + this.stock);
        System.out.println("----------------\n");
    }
}