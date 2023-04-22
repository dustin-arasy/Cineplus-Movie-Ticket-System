import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Login extends JFrame implements ActionListener {

    Container container = getContentPane();
    private JLabel titlelabel1 = new JLabel("LOGIN ACCOUNT");
    private JLabel titleLabel = new JLabel("Please fill the required fields below!");
    private JLabel userLabel = new JLabel("USERNAME");
    private JLabel passwordLabel = new JLabel("PASSWORD");
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("LOGIN");
    private JButton resetButton = new JButton("RESET");
    private JButton regisButton = new JButton("Don't have an account yet? Sign Up.");
    private JCheckBox showPassword = new JCheckBox("Show Password");
    private JPanel bgphoto = new JPanel();
    private JButton backButton = new JButton();
    private ArrayList<User> users = new ArrayList<>();

    Login(ArrayList<User> users) {
        this.users = users;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setBgphoto();
        setAllButton();
        setTextComponent();
    }

    public void setBgphoto(){
        bgphoto.setBounds(0, -15, 1000, 500);
        ImageIcon images = new ImageIcon("src/Images/bglogin.png");
        JLabel label = new JLabel(images);
        bgphoto.add(label);
    }

    public void setLayoutManager() {

        container.setLayout(null);
    }
    public void setTextComponent(){
        userLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        showPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
        titlelabel1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        resetButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        regisButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
    }
    public void setAllButton(){
        showPassword.setOpaque(false);
        showPassword.setBorderPainted(false);
        showPassword.setContentAreaFilled(false);
        showPassword.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setFocusable(false);
        loginButton.setContentAreaFilled(true);
        resetButton.setContentAreaFilled(true);
        resetButton.setBorderPainted(false);
        resetButton.setFocusable(false);
        regisButton.setContentAreaFilled(false);
        regisButton.setBorderPainted(false);
        regisButton.setFocusable(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusable(false);
        userTextField.setBorder(null);
        passwordField.setBorder(null);
        loginButton.setBackground(Color.white);
        loginButton.setForeground(Color.black);
        resetButton.setBackground(Color.white);
        resetButton.setForeground(Color.black);
        titlelabel1.setForeground(Color.white);
        userLabel.setForeground(Color.white);
        passwordLabel.setForeground(Color.white);
        titleLabel.setForeground(Color.white);
        showPassword.setForeground(Color.white);
        regisButton.setForeground(Color.white);
    }

    public void setLocationAndSize() {
        titlelabel1.setBounds(160, 50, 500, 30);
        titleLabel.setBounds(140, 80, 400, 30);
        userLabel.setBounds(120, 170, 100, 30);
        passwordLabel.setBounds(120, 240, 100, 30);
        userTextField.setBounds(220, 170, 150, 30);
        passwordField.setBounds(220, 240, 150, 30);
        showPassword.setBounds(217, 270, 150, 30);
        loginButton.setBounds(120, 320, 100, 30);
        resetButton.setBounds(270, 320, 100, 30);
        regisButton.setBounds(40, 370, 400, 30);
        backButton.setBounds(10, 5, 50, 30);
    }

    public void addComponentsToContainer() {
        container.add(titlelabel1);
        container.add(titleLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(regisButton);
        container.add(bgphoto);
        container.add(backButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        regisButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            for (int i = 0; i < users.size(); i++) {
                if (userText.equals(users.get(i).getUsername()) && pwdText.equals(users.get(i).getPassword())) {
                    JOptionPane.showMessageDialog(this, "Login Successful");
                    new HomepageFrame(users);
                    dispose();
                    break;
                } else if(!userText.equals(users.get(i).getUsername()) && !pwdText.equals(users.get(i).getPassword())) {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                }
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
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

        if (e.getSource() == backButton) {
            new HomepageFrame(users);
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
        frame.setBounds(10, 10, 1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        users.add(new User("dustinkun", "1234", "Dustin"));
    }

}