import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.DBConnection;   // Import DB utility

public class AddStudentForm extends JFrame {
    public AddStudentForm() {
        setTitle("Add Student");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 10, 10));
        setLocationRelativeTo(null);

        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField contactField = new JTextField();
        JTextField roomField = new JTextField();
        String[] statusOptions = {"Paid", "Due"};
        JComboBox<String> feeStatusBox = new JComboBox<>(statusOptions);

        JButton saveBtn = new JButton("Save");

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Age:"));
        add(ageField);
        add(new JLabel("Contact:"));
        add(contactField);
        add(new JLabel("Room No:"));
        add(roomField);
        add(new JLabel("Fee Status:"));
        add(feeStatusBox);
        add(new JLabel(""));
        add(saveBtn);

        saveBtn.addActionListener(e -> {
            String name = nameField.getText();
            String ageText = ageField.getText();
            String contact = contactField.getText();
            String roomText = roomField.getText();
            String feeStatus = (String) feeStatusBox.getSelectedItem();

            if (name.isEmpty() || ageText.isEmpty() || contact.isEmpty() || roomText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "⚠️ Please fill all fields!");
                return;
            }

            try {
                int age = Integer.parseInt(ageText);
                int roomNo = Integer.parseInt(roomText);

                try (Connection con = DBConnection.getConnection()) {
                    String sql = "INSERT INTO student(name, age, contact, room_no, fee_status) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setInt(2, age);
                    ps.setString(3, contact);
                    ps.setInt(4, roomNo);
                    ps.setString(5, feeStatus);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(this, "✅ Student added successfully!");
                    dispose();
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "⚠️ Age and Room No must be numbers!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "❌ Error: " + ex.getMessage());
            }
        });
    }
}
