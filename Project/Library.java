import java.util.*;

public class Library {
    private Map<Integer, Book> books;

    public Library() {
        books = DataStore.load();
    }

    public List<Book> getAll() { return new ArrayList<>(books.values()); }
    public List<Book> search(String kw) {
        List<Book> result = new ArrayList<>();
        for (Book b : books.values()) {
            if (b.getTitle().toLowerCase().contains(kw.toLowerCase())) result.add(b);
        }
        return result;
    }
    public boolean add(Book b) {
        if (books.containsKey(b.getId())) return false;
        books.put(b.getId(), b);
        DataStore.save(books);
        return true;
    }
    public boolean delete(int id) {
        if (books.remove(id) != null) {
            DataStore.save(books);
            return true;
        }
        return false;
    }
    public boolean issue(int id) {
        Book b = books.get(id);
        if (b != null && !b.isIssued()) {
            b.setIssued(true);
            DataStore.save(books);
            return true;
        }
        return false;
    }
    public boolean returnBook(int id) {
        Book b = books.get(id);
        if (b != null && b.isIssued()) {
            b.setIssued(false);
            DataStore.save(books);
            return true;
        }
        return false;
    }
}
