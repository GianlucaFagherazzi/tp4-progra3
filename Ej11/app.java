package Ej11;

import javax.swing.SwingUtilities;

public class app {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaskManagerApp app = new TaskManagerApp();
            app.setVisible(true);
        });
    }
}
