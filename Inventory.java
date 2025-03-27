import java.util.ArrayList;
import java.util.List;

public class Inventory<T> {
    public List<T> items = new ArrayList<>();

    public void addItem(T item) {
        this.items.add(item);
    }

    public void removeItem(T item) throws ItemTidakDItemukanException {
        if (!this.items.contains(item)) throw new ItemTidakDItemukanException("Item tidak ditemukan, tidak bisa dihapus.");
        this.items.remove(item);
    }

    public List<T> getItems() {
        return this.items;
    }

    public List<Integer> searchItems(String keyword) throws ItemTidakDItemukanException {
        List<Integer> results = new ArrayList<>();

        for (T item : this.items) {
            if (item.toString().equalsIgnoreCase(keyword)) {
                results.add(this.items.indexOf(item));
            }
        }

        if (results.isEmpty()) {
            throw new ItemTidakDItemukanException("Item dengan kata kunci " + keyword + " tidak ditemukan.");
        } 
        
        return results;
    }
}
