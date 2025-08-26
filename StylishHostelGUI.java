import javax.swing.*;
import java.awt.*;

public class StylishHostelGUI extends JFrame {

    public StylishHostelGUI() {
        setTitle("Hostel Management System");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            // Modern Nimbus Look
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Header
        JLabel heading = new JLabel("🏠 Hostel Management System", JLabel.CENTER);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 28));
        heading.setForeground(new Color(41, 128, 185));
        heading.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(heading, BorderLayout.NORTH);

        // Menu Panel (Card Style)
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(2, 2, 20, 20));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        menuPanel.setBackground(new Color(236, 240, 241));

        JButton addBtn = createStyledButton("➕ Add Student", new Color(46, 204, 113));
        JButton viewBtn = createStyledButton("📋 View Students", new Color(52, 152, 219));
        JButton searchBtn = createStyledButton("🔍 Search Student", new Color(241, 196, 15));
        JButton feeBtn = createStyledButton("💰 Manage Fees", new Color(231, 76, 60));

        menuPanel.add(addBtn);
        menuPanel.add(viewBtn);
        menuPanel.add(searchBtn);
        menuPanel.add(feeBtn);

        add(menuPanel, BorderLayout.CENTER);
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StylishHostelGUI().setVisible(true));
    }
}
