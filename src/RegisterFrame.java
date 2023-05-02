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
        nameLabel.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        userLabel.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        passwordLabel.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        conpasswordLabel.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        showPassword.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        showConPassword.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        titlelabel1.setFont(new Font("Space Grotesk", Font.BOLD, 30));
        titleLabel.setFont(new Font("Space Grotesk", Font.PLAIN, 22));
        registerButton.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        loginButton.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        resetButton.setFont(new Font("Space Grotesk", Font.BOLD, 22));
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
        bgphoto.setBounds(-55, -55, 1650, 1080);
        ImageIcon images = new ImageIcon("src/Images/registerbg.png");
        JLabel label = new JLabel(images);
        bgphoto.add(label);
    }

    public void setLoginButton(){
        loginButton.setFocusable(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        loginButton.setFont(new Font("Space Grotesk", Font.PLAIN, 14));
    }
    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        titlelabel1.setBounds(120, 40, 500, 130);
        titleLabel.setBounds(110, 130, 500, 30);
        nameLabel.setBounds(90, 200, 200, 50);
        userLabel.setBounds(90, 300, 200, 50);
        passwordLabel.setBounds(90, 400, 200, 50);
        conpasswordLabel.setBounds(90, 530, 270, 50);
        nameTextField.setBounds(260, 200, 220, 50);
        userTextField.setBounds(260, 300, 220, 50);
        passwordField.setBounds(260, 400, 220, 50);
        showPassword.setBounds(260, 450, 250, 50);
        conpasswordField.setBounds(260, 530, 220, 50);
        showConPassword.setBounds(260, 580, 250, 50);
        registerButton.setBounds(90, 660, 160, 50);
        resetButton.setBounds(320, 660, 160, 50);
        loginButton.setBounds(60, 720, 450, 50);
        backButton.setBounds(35, 5, 90, 40);

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
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
//        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setBounds(0, 0, 1650, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setLocation(-6, 0);
    }
    public static void main(String[] a) {
        Database datas = new Database();
        new RegisterFrame(datas.getUsers());
    }



}