import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Register extends JFrame implements ActionListener {

    Container container = getContentPane();
    private JLabel titlelabel1 = new JLabel("REGISTER ACCOUNT");
    private JLabel titleLabel = new JLabel("Please fill the required fields below!");
    private JLabel nameLabel = new JLabel("FULL NAME");
    private JLabel userLabel = new JLabel("USERNAME");
    private JLabel passwordLabel = new JLabel("PASSWORD");
    private JLabel conpasswordLabel = new JLabel("<html>CONFIRM<br>PASSWORD</html>");
    private JTextField nameTextField = new JTextField();
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JPasswordField conpasswordField = new JPasswordField();
    private JButton registerButton = new JButton("REGISTER");
    private JButton resetButton = new JButton("RESET");
    private JButton loginButton = new JButton("Already have an account? Sign In.");
    private JCheckBox showPassword = new JCheckBox("Show Password");
    private JCheckBox showConPassword = new JCheckBox("Show Password");
    private JPanel bgphoto = new JPanel();
    private JButton backButton = new JButton();
    private ArrayList<User> users = new ArrayList<>();


    Register(ArrayList<User> users) {
        this.users = users;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setLoginButton();
        setBgphoto();
        setTextComponent();
        setAllButton();

    }
    public void setTextComponent(){
        nameLabel.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        userLabel.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        passwordLabel.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        conpasswordLabel.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        showPassword.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        showConPassword.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        titlelabel1.setFont(new Font("Space Grotesk", Font.BOLD, 20));
        titleLabel.setFont(new Font("Space Grotesk", Font.PLAIN, 14));
        registerButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        loginButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        resetButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
    }
    public void setAllButton(){
        showPassword.setOpaque(false);
        showPassword.setBorderPainted(false);
        showPassword.setContentAreaFilled(false);
        showPassword.setFocusPainted(false);
        showConPassword.setOpaque(false);
        showConPassword.setBorderPainted(false);
        showConPassword.setContentAreaFilled(false);
        showConPassword.setFocusPainted(false);
        registerButton.setBorderPainted(false);
        registerButton.setFocusable(false);
        registerButton.setContentAreaFilled(true);
        resetButton.setContentAreaFilled(true);
        resetButton.setBorderPainted(false);
        resetButton.setFocusable(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        loginButton.setFocusable(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusable(false);
        nameTextField.setBorder(null);
        userTextField.setBorder(null);
        passwordField.setBorder(null);
        conpasswordField.setBorder(null);
        registerButton.setBackground(Color.white);
        registerButton.setForeground(Color.black);
        resetButton.setBackground(Color.white);
        resetButton.setForeground(Color.black);
        titlelabel1.setForeground(Color.white);
        nameLabel.setForeground(Color.white);
        userLabel.setForeground(Color.white);
        passwordLabel.setForeground(Color.white);
        conpasswordLabel.setForeground(Color.white);
        titleLabel.setForeground(Color.white);
        showPassword.setForeground(Color.white);
        showConPassword.setForeground(Color.white);
        loginButton.setForeground(Color.white);
    }
    public void setBgphoto(){
        bgphoto.setBounds(-14, -15, 1000, 500);
        ImageIcon images = new ImageIcon("src/Images/bgregis.png");
        JLabel label = new JLabel(images);
        bgphoto.add(label);
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
        titlelabel1.setBounds(140, 40, 400, 30);
        titleLabel.setBounds(130, 65, 400, 30);
        nameLabel.setBounds(120, 110, 100, 30);
        userLabel.setBounds(120, 160, 100, 30);
        passwordLabel.setBounds(120, 200, 100, 30);
        conpasswordLabel.setBounds(120, 270, 170, 30);
        nameTextField.setBounds(220, 110, 150, 30);
        userTextField.setBounds(220, 160, 150, 30);
        passwordField.setBounds(220, 200, 150, 30);
        showPassword.setBounds(220, 230, 150, 30);
        conpasswordField.setBounds(220, 270, 150, 30);
        showConPassword.setBounds(220, 300, 150, 30);
        registerButton.setBounds(120, 360, 110, 30);
        resetButton.setBounds(260, 360, 110, 30);
        loginButton.setBounds(40, 410, 400, 30);
        backButton.setBounds(10, 5, 50, 30);

    }

    public void addComponentsToContainer() {
        container.add(titlelabel1);
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
        container.add(bgphoto);
        container.add(backButton);
    }

    public void addActionEvent() {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        showConPassword.addActionListener(this);
        loginButton.addActionListener(this);
        backButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
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
        if (e.getSource() == resetButton) {
            nameTextField.setText("");
            userTextField.setText("");
            passwordField.setText("");
            conpasswordField.setText("");
        }
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
            new LoginFrame(users);
            dispose();
        }
        if (e.getSource() == backButton) {
            new HomepageFrame(users);
            dispose();
        }
    }

}

public class RegisterFrame {
    public  RegisterFrame(ArrayList<User> users){
        Register frame = new Register(users);
        frame.setTitle("CINEPLUS+");
        frame.setVisible(true);
        frame.setBounds(10, 10, 1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
    public static void main(String[] a) {
        Database datas = new Database();
        new RegisterFrame(datas.getUsers());
    }



}