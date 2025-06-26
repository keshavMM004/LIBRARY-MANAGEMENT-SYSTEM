import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BookTableModel extends AbstractTableModel {
    private final String[] cols = {"ID", "Title", "Author", "Issued"};
    private List<Book> books;

    public BookTableModel(List<Book> books) {
        this.books = books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        fireTableDataChanged();
    }

    @Override public int getRowCount() { return books.size(); }
    @Override public int getColumnCount() { return cols.length; }
    @Override public String getColumnName(int col) { return cols[col]; }
    @Override public Object getValueAt(int row, int col) {
        Book b = books.get(row);
        return switch (col) {
            case 0 -> b.getId();
            case 1 -> b.getTitle();
            case 2 -> b.getAuthor();
            case 3 -> b.isIssued();
            default -> null;
        };
    }
}