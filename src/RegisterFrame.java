import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Register extends JFrame implements ActionListener {

    Container container = getContentPane();
    private JLabel titleLabel = new JLabel("WELCOME TO CINEMA TICKET SYSTEM");
    private JLabel nameLabel = new JLabel("FULL NAME");
    private JLabel userLabel = new JLabel("USERNAME");
    private JLabel passwordLabel = new JLabel("PASSWORD");
    private JLabel conpasswordLabel = new JLabel("CONFIRM PASSWORD");
    private JTextField nameTextField = new JTextField();
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JPasswordField conpasswordField = new JPasswordField();
    private JButton registerButton = new JButton("REGISTER");
    private JButton resetButton = new JButton("RESET");
    private JButton loginButton = new JButton("ALREADY HAVE ACCOUNT? SIGN IN HERE");
    private JCheckBox showPassword = new JCheckBox("Show Password");
    private JCheckBox showConPassword = new JCheckBox("Show Password");
    private ArrayList<User> users = new ArrayList<>();


    Register(ArrayList<User> users) {
        this.users = users;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setLoginButton();

    }

    public void setLoginButton(){
        loginButton.setFocusable(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        loginButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    }
    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        titleLabel.setBounds(130, 40, 400, 30);
        nameLabel.setBounds(120, 100, 100, 30);
        userLabel.setBounds(120, 150, 100, 30);
        passwordLabel.setBounds(120, 190, 100, 30);
        conpasswordLabel.setBounds(60, 260, 170, 30);
        nameTextField.setBounds(220, 100, 150, 30);
        userTextField.setBounds(220, 150, 150, 30);
        passwordField.setBounds(220, 190, 150, 30);
        showPassword.setBounds(220, 220, 150, 30);
        conpasswordField.setBounds(220, 260, 150, 30);
        showConPassword.setBounds(220, 290, 150, 30);
        registerButton.setBounds(90, 350, 100, 30);
        resetButton.setBounds(270, 350, 100, 30);
        loginButton.setBounds(40, 400, 400, 30);


    }

    public void addComponentsToContainer() {
        container.add(titleLabel);
        container.add(nameLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(conpasswordLabel);
        container.add(nameTextField);
        container.add(userTextField);
        container.add(passwordField);
        container.add(conpasswordField);
        container.add(showPassword);
        container.add(showConPassword);
        container.add(registerButton);
        container.add(resetButton);
        container.add(loginButton);
    }

    public void addActionEvent() {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        showConPassword.addActionListener(this);
        loginButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of REGISTER button
        if (e.getSource() == registerButton) {
            String nameText;
            String userText;
            String pwdText;
            String pwdconText;
            nameText = nameTextField.getText();
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            pwdconText = conpasswordField.getText();

            if (nameText.equals("") && userText.equals("") && pwdText.equals("") && pwdconText.equals("")) {
                JOptionPane.showMessageDialog(this, "Name, Username, or Password must not be empty!");
            } else if (!pwdText.equals(pwdconText)){
                JOptionPane.showMessageDialog(this, "Password must be same!");
            } else {
                JOptionPane.showMessageDialog(this, "Register Successful");
                nameTextField.setText("");
                userTextField.setText("");
                passwordField.setText("");
                conpasswordField.setText("");
                users.add(new User(userText, pwdText, nameText));
                new LoginFrame(users);
                dispose();
            }
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            nameTextField.setText("");
            userTextField.setText("");
            passwordField.setText("");
            conpasswordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

        }

        if (e.getSource() == showConPassword) {
            if (showConPassword.isSelected()) {
                conpasswordField.setEchoChar((char) 0);
            } else {
                conpasswordField.setEchoChar('*');
            }

        }

        if (e.getSource() == loginButton) {
//            new LoginFrame();
            dispose();
        }
    }

}

public class RegisterFrame {
    public static void main(String[] a) {
        Database datas = new Database();
        new RegisterFrame(datas.getUsers());
    }

    public  RegisterFrame(ArrayList<User> users){
        Register frame = new Register(users);
        frame.setTitle("Register Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

}