import java.awt.*;
import javax.swing.*;

public class ViewPanel extends JPanel {
    private BookTableModel model;
    private JTable table;
    private Library lib;

    public ViewPanel(Library lib) {
        this.lib = lib;
        setLayout(new BorderLayout());

        model = new BookTableModel(lib.getAll());
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel top = new JPanel();
        JTextField search = new JTextField(20);
        JButton btn = new JButton("Search");
        top.add(search);
        top.add(btn);
        add(top, BorderLayout.NORTH);

        btn.addActionListener(e -> model.setBooks(lib.search(search.getText())));
    }
    public void refresh() {
    model.setBooks(lib.getAll());
}

}
