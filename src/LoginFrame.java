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
        bgphoto.setBounds(-60, -60, 1650, 1080);
        ImageIcon images = new ImageIcon("src/Images/loginbg.png");
        JLabel label = new JLabel(images);
        bgphoto.add(label);
    }

    public void setLayoutManager() {

        container.setLayout(null);
    }
    public void setTextComponent(){
        userLabel.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        passwordLabel.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        showPassword.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        titlelabel1.setFont(new Font("Space Grotesk", Font.BOLD, 30));
        titleLabel.setFont(new Font("Space Grotesk", Font.PLAIN, 22));
        loginButton.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        resetButton.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        regisButton.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        userTextField.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        passwordField.setFont(new Font("Space Grotesk", Font.BOLD, 22));
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
        userLabel.setBackground(Color.black);
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
        titlelabel1.setBounds(180, 50, 500, 130);
        titleLabel.setBounds(140, 160, 400, 30);
        userLabel.setBounds(100, 270, 200, 50);
        passwordLabel.setBounds(100, 400, 200, 50);
        userTextField.setBounds(270, 270, 220, 50);
        passwordField.setBounds(270, 400, 220, 50);
        showPassword.setBounds(270, 450, 250, 50);
        loginButton.setBounds(100, 530, 160, 50);
        resetButton.setBounds(330, 530, 160, 50);
        regisButton.setBounds(40, 590, 500, 50);
        backButton.setBounds(47, 7, 85, 40);
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
                    JOptionPane.showMessageDialog(this, "Login Successful","LOGIN ACCOUNT", JOptionPane.INFORMATION_MESSAGE);
                    new cityListFrame(users);
                    dispose();
                    break;
                } else if(!userText.equals(users.get(i).getUsername()) || !pwdText.equals(users.get(i).getPassword())) {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password","LOGIN ACCOUNT", JOptionPane.INFORMATION_MESSAGE);
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
    public LoginFrame(ArrayList<User> users){
        Login frame = new Login(users);
        frame.setTitle("CINEPLUS+");
        frame.setVisible(true);
        frame.setBounds(0, 0, 1650, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLocation(-6, 0);
    }
//    public static void main(String[] a) {
//        Database datas = new Database();
//        new LoginFrame(datas.getUsers());
//    }


}