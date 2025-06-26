
import java.awt.*;
import javax.swing.*;

public class ManagePanel extends JPanel {

    public ManagePanel(Library lib, ViewPanel view) {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel idL = new JLabel("ID:");
        JTextField idF = new JTextField();
        JLabel tL = new JLabel("Title:");
        JTextField tF = new JTextField();
        JLabel aL = new JLabel("Author:");
        JTextField aF = new JTextField();

        JButton add = new JButton("Add");
        JButton del = new JButton("Delete");
        JButton iss = new JButton("Issue");
        JButton ret = new JButton("Return");

        c.gridx = 0;
        c.gridy = 0;
        add(idL, c);
        c.gridx = 1;
        add(idF, c);
        c.gridx = 0;
        c.gridy = 1;
        add(tL, c);
        c.gridx = 1;
        add(tF, c);
        c.gridx = 0;
        c.gridy = 2;
        add(aL, c);
        c.gridx = 1;
        add(aF, c);

        JPanel bp = new JPanel(new FlowLayout());
        bp.add(add);
        bp.add(del);
        bp.add(iss);
        bp.add(ret);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        add(bp, c);

        add.addActionListener(e -> {
            boolean ok = lib.add(new Book(Integer.parseInt(idF.getText()), tF.getText(), aF.getText()));
            JOptionPane.showMessageDialog(this, ok ? "Added" : "ID exists");
            view.refresh();  // 👈 ADD THIS
        });

        del.addActionListener(e -> {
            boolean ok = lib.delete(Integer.parseInt(idF.getText()));
            JOptionPane.showMessageDialog(this, ok ? "Deleted" : "Not found");
            view.refresh();
        });
        iss.addActionListener(e -> {
            boolean ok = lib.issue(Integer.parseInt(idF.getText()));
            JOptionPane.showMessageDialog(this, ok ? "Issued" : "Cannot issue");
            view.refresh();
        });

        ret.addActionListener(e -> {
            boolean ok = lib.returnBook(Integer.parseInt(idF.getText()));
            JOptionPane.showMessageDialog(this, ok ? "Returned" : "Cannot return");
            view.refresh();
        });

    }
}
