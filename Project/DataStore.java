import java.io.*;
import java.util.*;

public class DataStore {
    private static final String DATA_FILE = "library.dat";

    public static void save(Map<Integer, Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<Integer, Book> load() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return new LinkedHashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Map<Integer, Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new LinkedHashMap<>();
        }
    }
}
