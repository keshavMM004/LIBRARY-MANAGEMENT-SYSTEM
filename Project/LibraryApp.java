import javax.swing.*;

public class LibraryApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Library Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);

            Library lib = new Library();
            ViewPanel viewPanel = new ViewPanel(lib);
            ManagePanel managePanel = new ManagePanel(lib, viewPanel); // updated constructor

            JTabbedPane tabs = new JTabbedPane();
            tabs.addTab("View/Search", viewPanel);
            tabs.addTab("Manage", managePanel);

            // Refresh ViewPanel when tab is selected
            tabs.addChangeListener(e -> {
                if (tabs.getSelectedComponent() instanceof ViewPanel vp) {
                    vp.refresh();
                }
            });

            frame.add(tabs);
            frame.setVisible(true);
        });
    }
}
