import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class cityList extends JFrame implements ActionListener {

    Container container = getContentPane();
    private JLabel titlelabel1 = new JLabel("CITY LIST CINEPLUS+");
    private JLabel titleLabel = new JLabel("Please Choose Your City");
    private JLabel nameLabel = new JLabel("City");
    String[] city = {"Aceh" ,"Bandung" ,"Bogor","Denpasar" ,"Jakarta" ,"Malang","Makassar",
            "Medan" , "Padang", "Pontianak" ,"Semarang","Surabaya"};
    private JComboBox cityList = new JComboBox<>(city);
    private JButton nextButton = new JButton("NEXT");
    private JButton resetButton = new JButton("BACK");
    private JPanel bgphoto = new JPanel();

    private ArrayList<cityListFrame> listCity = new ArrayList<>();
    private ArrayList<filmListFrame> filmList = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    cityList(ArrayList<User> users) {
        this.users = users;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setBgphoto();
        setTextComponent();
        setAllButton();

    }

    private void setAllButton() {
        nextButton.setBorderPainted(false);
        nextButton.setFocusable(false);
        nextButton.setContentAreaFilled(true);
        resetButton.setContentAreaFilled(true);
        resetButton.setBorderPainted(false);
        resetButton.setFocusable(false);
        titlelabel1.setForeground(Color.white);
        titleLabel.setForeground(Color.white);
        nextButton.setBackground(Color.white);
        nextButton.setForeground(Color.black);
        resetButton.setBackground(Color.white);
        resetButton.setForeground(Color.black);
        nameLabel.setForeground(Color.white);
        cityList.setBorder(null);
    }

    private void setTextComponent() {
        nameLabel.setFont(new Font("Space Grotesk", Font.BOLD, 20));
        nextButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        resetButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        titlelabel1.setFont(new Font("Space Grotesk", Font.BOLD, 20));
        titleLabel.setFont(new Font("Space Grotesk", Font.PLAIN, 14));
    }

    private void setBgphoto() {
        bgphoto.setBounds(-14, -15, 1000, 500);
        ImageIcon images = new ImageIcon("src/Images/cityList.png");
        JLabel label = new JLabel(images);
        bgphoto.add(label);
    }


    private void addActionEvent() {
        nextButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    private void addComponentsToContainer() {
        container.add(titlelabel1);
        container.add(titleLabel);
        container.add(nameLabel);
        container.add(cityList);
        container.add(nextButton);
        container.add(resetButton);
        container.add(bgphoto);
    }

    private void setLocationAndSize() {
        titlelabel1.setBounds(140, 40, 400, 30);
        titleLabel.setBounds(140, 65, 400, 30);
        nameLabel.setBounds(120, 110, 100, 30);
        cityList.setBounds(220, 110, 150, 30);
        nextButton.setBounds(120, 300, 110, 30);
        resetButton.setBounds(260, 300, 110, 30);
    }

    private void setLayoutManager() {
        container.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton){
            JOptionPane.showMessageDialog(this,"Succesfully!");
            new filmListFrame(filmList , users);
        }
        if (e.getSource() == resetButton) {
            new LoginFrame(users);
            dispose();
        }
    }
}
public class cityListFrame {


    public static void main(String[] args) {
        Database datas = new Database();
        new cityListFrame(datas.getUsers());
    }

    public cityListFrame(ArrayList<User> users) {
        cityList frame = new cityList(users);
        frame.setTitle("CINEPLUS+");
        frame.setVisible(true);
        frame.setBounds(10, 10, 1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
