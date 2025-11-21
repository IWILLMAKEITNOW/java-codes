import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame implements ActionListener{
    
    private JTextField nameField, mobileField,dobDayField,dobYearField;
    private JComboBox<String> dobMonthCombo;
    private JTextArea addressArea;
    private JRadioButton maleRadio, femaleRadio;
    private ButtonGroup genderGroup;
    private JCheckBox termsCheck;
    private JButton submitBtn, resetBtn;

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(350,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,2,10,10));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Mobile:"));
        mobileField = new JTextField();
        add(mobileField);

        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        add(genderPanel);

        add(new JLabel("DOB:"));
        JPanel dobPanel = new JPanel(new FlowLayout());
        dobDayField = new JTextField(2);
        String[] months ={"Jan","Feb","Mar","Apr","May","June","July","Aug",
                "Sep","Oct","Nov","Dec"};
                dobMonthCombo = new JComboBox<>(months);
                dobYearField = new JTextField(4);
                dobPanel.add(dobMonthCombo);
                dobPanel.add(dobDayField);
                dobPanel.add(dobYearField);
                add(dobPanel);

                add(new JLabel("Address:"));
                addressArea = new JTextArea(3,20);
                add(new JScrollPane(addressArea));

                add(new JLabel(""));
                termsCheck = new JCheckBox("Accept Terms And Conditions.");
                add(termsCheck);


            add(new JLabel(""));
            JPanel buttonPanel = new JPanel();
            submitBtn = new JButton("Submit");
            resetBtn = new JButton("Reset");
            submitBtn.addActionListener(this);
            resetBtn.addActionListener(this);
            buttonPanel.add(submitBtn);
            buttonPanel.add(resetBtn);
            add(buttonPanel);

            setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == resetBtn){
            nameField.setText("");
            mobileField.setText("");
            genderGroup.clearSelection();
            dobDayField.setText("");
            dobMonthCombo.setSelectedIndex(0);
            dobYearField.setText("");
            addressArea.setText("");
        }else if (e.getSource() == submitBtn){

            if(!termsCheck.isSelected()){
                JOptionPane.showMessageDialog(this, "Please accept Terms and Conditions.");
                return;
            }

            String name = nameField.getText();
            String mobile = mobileField.getText();
            String gender = maleRadio.isSelected() ?"Male" : femaleRadio.isSelected()? "Female": "Not Specified";
            String dob = dobDayField.getText() + "" +dobMonthCombo.getSelectedItem() +"" + dobYearField.getText();
            String address = addressArea.getText();

            String message = "Registration Details:\n" + 
           "Name:" + name + "\n" +
            "Mobile:" + mobile + "\n" +
            "Gender:" + gender + "\n" +
            "DOB:" + dob + "\n" +
            "Address:" + address;
            JOptionPane.showMessageDialog(this, message);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegistrationForm::new);
    }
    }

    







