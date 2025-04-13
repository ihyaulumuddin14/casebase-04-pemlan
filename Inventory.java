import java.util.ArrayList;
import java.util.List;

public class Inventory<T> {
    // T = Type, Bisa diganti sesuai kebutuhan
    public List<T> items = new ArrayList<>();

    //Untuk menambah Item
    public void addItem(T item) {
        this.items.add(item);
    }

    //Untuk menghapus sebuah item dari List
    public void removeItem(T item) throws ItemTidakDItemukanException {
        if (!this.items.contains(item)) throw new ItemTidakDItemukanException("Item tidak ditemukan, tidak bisa dihapus.");
        this.items.remove(item);
    }

    // GETTER Field Items
    public List<T> getItems() {
        return this.items;
    }

    /*
     * Search Items, dari keyword yang diinput untuk mengembalikan list of index dari item yang cocok
     * karena keyword yang berpotensi muncul bertipe data String judul buku atau penulis buku
     */
    public List<Integer> searchItems(String keyword) throws ItemTidakDItemukanException {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < this.items.size(); i++) {
            T item = this.items.get(i);
            if (item.toString().equalsIgnoreCase(keyword)) {
                results.add(i);
                System.out.println(i);
            }
        }

        if (results.isEmpty()) {
            throw new ItemTidakDItemukanException("Item dengan kata kunci " + keyword + " tidak ditemukan.");
        } 
        
        return results;
    }
}
