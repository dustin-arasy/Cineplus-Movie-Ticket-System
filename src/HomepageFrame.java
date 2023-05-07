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
        bgphoto.setBounds(-57, 0, 1650, 1080);
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
        registButton.setBounds(610, 315, 310, 80);
        loginButton.setBounds(610, 515, 310, 80);
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
        frame.setVisible(true);
        frame.setSize(1650, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLocation(-6, 0);
    }

}
