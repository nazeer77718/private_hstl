import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 public class Ho extends JFrame {

    public Ho() {
        setTitle("Private Hostel Management System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Hostel Management Dashboard", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        add(heading, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View Students");
        JButton searchBtn = new JButton("Search Student");
        JButton feeBtn = new JButton("Manage Fees");
        JButton exitBtn = new JButton("Exit");

        panel.add(addBtn);
        panel.add(viewBtn);
        panel.add(searchBtn);
        panel.add(feeBtn);
        panel.add(exitBtn);

        add(panel, BorderLayout.CENTER);

        // Action Listeners
        addBtn.addActionListener(e -> openAddStudentForm());
        viewBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "View Students Screen"));
        searchBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Search Student Screen"));
        feeBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Fee Management Screen"));
        exitBtn.addActionListener(e -> System.exit(0));
    }

    private void openAddStudentForm() {
        JFrame addFrame = new JFrame("Add Student");
        addFrame.setSize(400, 300);
        addFrame.setLayout(new GridLayout(6, 2, 10, 10));
        addFrame.setLocationRelativeTo(this);

        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField contactField = new JTextField();
        JTextField roomField = new JTextField();
        String[] statusOptions = {"Paid", "Due"};
        JComboBox<String> feeStatusBox = new JComboBox<>(statusOptions);

        JButton saveBtn = new JButton("Save");

        addFrame.add(new JLabel("Name:"));
        addFrame.add(nameField);
        addFrame.add(new JLabel("Age:"));
        addFrame.add(ageField);
        addFrame.add(new JLabel("Contact:"));
        addFrame.add(contactField);
        addFrame.add(new JLabel("Room No:"));
        addFrame.add(roomField);
        addFrame.add(new JLabel("Fee Status:"));
        addFrame.add(feeStatusBox);
        addFrame.add(new JLabel(""));
        addFrame.add(saveBtn);

        saveBtn.addActionListener(e -> {
            String name = nameField.getText();
            String age = ageField.getText();
            String contact = contactField.getText();
            String room = roomField.getText();
            String feeStatus = (String) feeStatusBox.getSelectedItem();

            JOptionPane.showMessageDialog(addFrame, 
                "Saved Student: " + name + ", " + age + ", " + contact + ", Room " + room + ", Fee: " + feeStatus);
        });

        addFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ho().setVisible(true);
        });
    }
}
