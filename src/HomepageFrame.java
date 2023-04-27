import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Homepage extends JFrame implements ActionListener {

    Container container = getContentPane();
    private JButton registButton = new JButton();
    private JButton loginButton = new JButton();
    private JPanel bgphoto = new JPanel();
    private ArrayList<User> users = new ArrayList<>();

    Homepage(ArrayList<User> users){
        this.users = users;
        setLayoutManager();
        setLocationandSize();
        addActionEvent();
        addComponentToContainer();
        setBgphoto();
        setButton();
    }
    public void setButton(){
        registButton.setBorderPainted(false);
        registButton.setFocusable(false);
        registButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        loginButton.setFocusable(false);
        loginButton.setContentAreaFilled(false);
    }
    public void setBgphoto(){
        bgphoto.setBounds(-7, -12, 960, 515);
        ImageIcon images = new ImageIcon("src/Images/homepagebg.png");
        JLabel label = new JLabel(images);
        bgphoto.add(label);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }
    public void addComponentToContainer(){
        container.add(registButton);
        container.add(loginButton);
        container.add(bgphoto);
    }

    public void setLocationandSize(){
        registButton.setBounds(375, 200, 200, 30);
        loginButton.setBounds(375, 325, 200, 30);
    }

    public void addActionEvent(){
        registButton.addActionListener(this);
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == registButton){
            new RegisterFrame(users);
            dispose();
        }

        if(e.getSource() == loginButton){
            new LoginFrame(users);
            dispose();
        }
    }

    }

public class HomepageFrame {
    public HomepageFrame(ArrayList<User> users){
        Homepage frame = new Homepage(users);
        frame.setTitle("CINEPLUS+");
        frame.setSize(960, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        Database datas = new Database();
        new HomepageFrame(datas.getUsers());
    }


}
