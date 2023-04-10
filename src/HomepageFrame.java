import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Homepage extends JFrame implements ActionListener {

    Container container = getContentPane();
    private JLabel titlePage = new JLabel("CINEMA TICKET SYSTEM");
    private JLabel orLabel = new JLabel("or");
    private JButton registButton = new JButton("REGISTER");
    private JButton loginButton = new JButton("LOGIN");
    private ArrayList<User> users = new ArrayList<>();

    Homepage(ArrayList<User> users){
        this.users = users;
        setLayoutManager();
        setLocationandSize();
        addActionEvent();
        addComponentToContainer();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }
    public void addComponentToContainer(){
        container.add(titlePage);
        container.add(orLabel);
        container.add(registButton);
        container.add(loginButton);
    }

    public void setLocationandSize(){
        titlePage.setBounds(80, 40, 200, 30);
        registButton.setBounds(50, 110, 200, 30);
        orLabel.setBounds(150, 160, 200, 30);
        loginButton.setBounds(50, 210, 200, 30);
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
    public static void main(String[] args) {
        Database datas = new Database();
        new HomepageFrame(datas.getUsers());
    }

    public HomepageFrame(ArrayList<User> users){
        Homepage frame = new Homepage(users);
        frame.setTitle("Homepage");
        frame.setSize(350, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
