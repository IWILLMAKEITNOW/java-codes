import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class regcat2 extends JFrame implements ActionListener {
    
    private JTextField nameField, contactField;
    private JRadioButton maleRadio, femaleRadio;
    private ButtonGroup genderGroup;
    private JTextArea addressArea;
    private JButton exitBtn, registerBtn;
    private JTextArea displayArea;
    private int nextId = 1; // For proper ID generation

    public regcat2() {
        setTitle("Registration Form");
        setSize(800, 500); // Increased width for better layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Create header
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Registration Form");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(headerLabel);
        
        // Create form panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Name field
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);
        
        // Gender field
        formPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        formPanel.add(genderPanel);
        
        // Contact field
        formPanel.add(new JLabel("Contact:"));
        contactField = new JTextField();
        formPanel.add(contactField);
        
        // Address field
        formPanel.add(new JLabel("Address:"));
        addressArea = new JTextArea(3, 20);
        JScrollPane addressScroll = new JScrollPane(addressArea);
        formPanel.add(addressScroll);
        
        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        exitBtn = new JButton("Exit");
        registerBtn = new JButton("Register");
        exitBtn.addActionListener(this);
        registerBtn.addActionListener(this);
        buttonPanel.add(exitBtn);
        buttonPanel.add(registerBtn);
        
        // Create left panel container
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(formPanel, BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Create display area
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane displayScroll = new JScrollPane(displayArea);
        
        // Initialize display header
        displayArea.setText(String.format("%-3s %-15s %-8s %-18s %-12s\n", 
            "ID", "Name", "Gender", "Address", "Contact"));
        displayArea.append("-----------------------------------------------------------------\n");
        
        // Add components to frame
        add(headerPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(displayScroll, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitBtn) {
            int response = JOptionPane.showConfirmDialog(
                this, "Are you sure you want to exit?", 
                "Exit Confirmation", JOptionPane.YES_NO_OPTION
            );
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (e.getSource() == registerBtn) {
            registerUser();
        }
    }
    
    private void registerUser() {
        String name = nameField.getText().trim();
        String gender = maleRadio.isSelected() ? "Male" : 
                       femaleRadio.isSelected() ? "Female" : "Not Selected";
        String address = addressArea.getText().trim();
        String contact = contactField.getText().trim();
        
        // Validation
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter name!");
            nameField.requestFocus();
            return;
        }
        if (contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter contact number!");
            contactField.requestFocus();
            return;
        }
        
        
        int id = nextId++;
        String displayAddress = address.length() > 15 ? address.substring(0, 15) + "..." : address;
        displayArea.append(String.format("%-3d %-15s %-8s %-18s %-12s\n", 
            id, name, gender, displayAddress, contact));
        
        JOptionPane.showMessageDialog(this, "Registration Successful!\nID: " + id);
        clearForm();
    }
    
    private void clearForm() {
        nameField.setText("");
        genderGroup.clearSelection();
        addressArea.setText("");
        contactField.setText("");
        nameField.requestFocus();
    }
    
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Look and feel not supported on this system");
        } catch (ClassNotFoundException e) {
            System.err.println("Look and feel class not found");
        } catch (InstantiationException e) {
            System.err.println("Could not instantiate look and feel");
        } catch (IllegalAccessException e) {
            System.err.println("Access denied to look and feel");
        } catch (Exception e) {
            System.err.println("Error setting look and feel: " + e.getMessage());
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new regcat2();
            }
        });
    }
}