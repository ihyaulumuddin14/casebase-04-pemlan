import java.util.Scanner;

public class AppRun {
    private static Library library = new Library();
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean next = true;
        while (next) {
            System.out.println("\n===== MENU PERPUSTAKAAN =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Perbarui Stok Buku");
            System.out.println("5. Tampilkan Semua Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int choice = inputValidation();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> searchBook();
                case 4 -> updateStock();
                case 5 -> printAllBooks();
                case 0 -> {
                    next = false;
                    System.out.println("Keluar dari program perpustakaan...");
                    in.close();
                }
                default -> System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    //Untuk menambah buku di perpustakaan
    private static void addBook() {
        System.out.print("Masukkan judul buku: ");
        String title = in.nextLine();
        System.out.print("Masukkan penulis buku: ");
        String author = in.nextLine();
        System.out.print("Masukkan tahun terbit: ");
        int year = in.nextInt();
        System.out.print("Masukkan stok buku: ");
        int stock = in.nextInt();
        in.nextLine();

        Book newBook = new Book(title, author, year, stock);
        library.addBook(newBook);
        System.out.println("Buku berhasil ditambahkan!");
    }

    //Untuk menghapus buku berdasarkan judul buku
    private static void removeBook() {
        System.out.print("Masukkan judul buku yang ingin dihapus: ");
        String removeTitle = in.nextLine();
    
        Book bookToRemove = library.getBookFromKeyword(removeTitle);
    
        if (bookToRemove != null) {
            System.out.println("Buku ditemukan:");
            bookToRemove.printBook();
            System.out.print("Apakah Anda yakin ingin menghapus buku ini? (y/n): ");
            String confirmation = in.nextLine().trim().toLowerCase();
    
            if (confirmation.equals("y") || confirmation.isEmpty()) {
                library.removeBook(bookToRemove);
                System.out.println("Buku berhasil dihapus!");
            } else {
                System.out.println("Penghapusan dibatalkan.");
            }
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    //Mencari buku berdasarkan kata kunci penulis buku/judul buku
    private static void searchBook() {
        System.out.print("Masukkan kata kunci pencarian (judul/penulis): ");
        String keyword = in.nextLine();
        library.searchBooks(keyword);
    }

    //Memperbarui stok
    private static void updateStock() {
        System.out.print("Masukkan judul buku yang ingin diperbarui stoknya: ");
        String bookTitle = in.nextLine();
    
        Book bookToUpdate = library.getBookFromKeyword(bookTitle);
    
        if (bookToUpdate != null) {
            System.out.println("Buku ditemukan:");
            bookToUpdate.printBook();
    
            System.out.print("Masukkan jumlah stok baru: ");
            int newStock = in.nextInt();
            in.nextLine();
    
            library.updateStock(bookToUpdate, newStock);
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    //Mencetak semua informasi buku-buku
    private static void printAllBooks() {
        library.printAllBooks();
    }

    //Validasi pilihan menu agar hanya menginputkan angka yang ada di pilihan
    private static int inputValidation() {
        while (true) {
            try {
                int input = Integer.parseInt(in.nextLine().trim());
                if (input < 0) {
                    System.out.print("Input tidak boleh negatif! Masukkan angka lagi: ");
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.print("Harap masukkan angka yang valid: ");
            }
        }
    }
}
