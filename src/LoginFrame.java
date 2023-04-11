import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Login extends JFrame implements ActionListener {

    Container container = getContentPane();
    private JLabel titleLabel = new JLabel("WELCOME TO CINEMA TICKET SYSTEM");
    private JLabel userLabel = new JLabel("USERNAME");
    private JLabel passwordLabel = new JLabel("PASSWORD");
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("LOGIN");
    private JButton resetButton = new JButton("RESET");
    private JButton regisButton = new JButton("DON'T HAVE ACCOUNT? REGISTER HERE");
    private JCheckBox showPassword = new JCheckBox("Show Password");
    private ArrayList<User> users = new ArrayList<>();



    Login(ArrayList<User> users) {
        this.users = users;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setRegisButton();
    }

    public void setRegisButton(){
        regisButton.setContentAreaFilled(false);
        regisButton.setBorderPainted(false);
        regisButton.setFocusable(false);
        regisButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    }

    public void setLayoutManager() {

        container.setLayout(null);
    }

    public void setLocationAndSize() {
        titleLabel.setBounds(130, 40, 400, 30);
        userLabel.setBounds(120, 150, 100, 30);
        passwordLabel.setBounds(120, 220, 100, 30);
        userTextField.setBounds(220, 150, 150, 30);
        passwordField.setBounds(220, 220, 150, 30);
        showPassword.setBounds(220, 250, 150, 30);
        loginButton.setBounds(120, 300, 100, 30);
        resetButton.setBounds(270, 300, 100, 30);
        regisButton.setBounds(40, 350, 400, 30);
    }

    public void addComponentsToContainer() {
        container.add(titleLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(regisButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        regisButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            for (int i = 0; i < users.size(); i++) {
                if (userText.equals(users.get(i).getUsername()) && pwdText.equals(users.get(i).getPassword())) {
                    JOptionPane.showMessageDialog(this, "Login Successful");
                    new RegisterFrame(users);
                    dispose();
                    break;
                } else if(!userText.equals(users.get(i).getUsername()) && !pwdText.equals(users.get(i).getPassword())) {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                }
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }

        if (e.getSource() == regisButton) {
            new RegisterFrame(users);
            dispose();
        }
    }

}

public class LoginFrame {
    public static void main(String[] a) {
        Database datas = new Database();
        new LoginFrame(datas.getUsers());
    }
    public LoginFrame(ArrayList<User> users){
        Login frame = new Login(users);
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}