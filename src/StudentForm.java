import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class StudentForm extends JFrame {
    Connection conn;
    Statement stmt;
    private JTextField fullNameField, phoneField, dobField, fatherNameField, motherNameField, nationalityField, addressField, emailField, departmentField, semesterField;
    private JRadioButton maleButton, femaleButton, othersButton;
    private JButton addButton, browseButton;

    void getConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
            stmt = conn.createStatement();
            System.out.println("Connection successful.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public StudentForm() {
        getConnection();
        setTitle("Add Students");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        // Labels and TextFields
        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setBounds(50, 20, 100, 25);
        add(fullNameLabel);
        fullNameField = new JTextField();
        fullNameField.setBounds(200, 20, 300, 25);
        add(fullNameField);

        JLabel phoneLabel = new JLabel("Phone no.:");
        phoneLabel.setBounds(50, 60, 100, 25);
        add(phoneLabel);
        phoneField = new JTextField();
        phoneField.setBounds(200, 60, 300, 25);
        add(phoneField);

        JLabel dobLabel = new JLabel("DoB:");
        dobLabel.setBounds(50, 100, 100, 25);
        add(dobLabel);
        dobField = new JTextField();
        dobField.setBounds(200, 100, 300, 25);
        add(dobField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 140, 100, 25);
        add(genderLabel);
        maleButton = new JRadioButton("Male");
        maleButton.setBounds(200, 140, 70, 25);
        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(270, 140, 80, 25);
        othersButton = new JRadioButton("Others");
        othersButton.setBounds(350, 140, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(othersButton);
        add(maleButton);
        add(femaleButton);
        add(othersButton);

        JLabel fatherNameLabel = new JLabel("Father name:");
        fatherNameLabel.setBounds(50, 180, 100, 25);
        add(fatherNameLabel);
        fatherNameField = new JTextField();
        fatherNameField.setBounds(200, 180, 300, 25);
        add(fatherNameField);

        JLabel motherNameLabel = new JLabel("Mother name:");
        motherNameLabel.setBounds(50, 220, 100, 25);
        add(motherNameLabel);
        motherNameField = new JTextField();
        motherNameField.setBounds(200, 220, 300, 25);
        add(motherNameField);

        JLabel nationalityLabel = new JLabel("Nationality:");
        nationalityLabel.setBounds(50, 260, 100, 25);
        add(nationalityLabel);
        nationalityField = new JTextField();
        nationalityField.setBounds(200, 260, 300, 25);
        add(nationalityField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 300, 100, 25);
        add(addressLabel);
        addressField = new JTextField();
        addressField.setBounds(200, 300, 300, 25);
        add(addressField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 340, 100, 25);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(200, 340, 300, 25);
        add(emailField);

        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(50, 380, 100, 25);
        add(departmentLabel);
        departmentField = new JTextField();
        departmentField.setBounds(200, 380, 300, 25);
        add(departmentField);

        JLabel semesterLabel = new JLabel("Semester:");
        semesterLabel.setBounds(50, 420, 100, 25);
        add(semesterLabel);
        semesterField = new JTextField();
        semesterField.setBounds(200, 420, 300, 25);
        add(semesterField);

        JLabel photoLabel = new JLabel("Add Photo:");
        photoLabel.setBounds(50, 460, 100, 25);
        add(photoLabel);
        browseButton = new JButton("Browse photo");
        browseButton.setBounds(200, 460, 150, 25);
        add(browseButton);

        addButton = new JButton("Add");
        addButton.setBounds(200, 500, 100, 30);
        add(addButton);

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    Label imagePathField = null;
                    imagePathField.setText(selectedFile.getAbsolutePath());
                }
            }
        });


//        insert
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String name = fullNameLabel.getText().toString();
                String phone = phoneLabel.getText().toString();
                String dob = dobLabel.getText().toString();
                String gender = genderLabel.getText().toString();
                String fatherName = fatherNameLabel.getText().toString();
                String motherName = motherNameLabel.getText().toString();
                String nationality = nationalityLabel.getText().toString();
                String address = addressLabel.getText().toString();
                String email = emailLabel.getText().toString();
                String department = departmentLabel.getText().toString();
                String semester = semesterLabel.getText().toString();

//                try {
//                    String sql = "Insert into students (id, Full_Name, Phone_no, DoB, Gender, Father_Name, Mother_Name, Nationality, Address, Email, Department, Semester, image_data )" + "VALUES('" + id + "','" + name + "',' " + address + "')";
//                    stmt.execute(sql);
//                    JOptionPane.showMessageDialog(null, "Data inserted successfully");
//                } catch (Exception e1) {
//                    JOptionPane.showMessageDialog(null, e1);
//                }

            }
        });
    }
    public static void main(String[] args){
        StudentForm studentForm = new StudentForm();
    }
}