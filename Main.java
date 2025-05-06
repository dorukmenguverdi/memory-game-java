import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Set system look and feel for the GUI
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Launch GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("🐾 Memory Game - Hayvanlar");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700,900);
            frame.setLocationRelativeTo(null); // ortala
            frame.setResizable(false);

            frame.add(new GameBoard());

            frame.setVisible(true);
        });


    }
}