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
    private JLabel mallLabel = new JLabel("Mall");
    String[] city = {"Bandung" ,"Bogor","Denpasar" ,"Jakarta" ,"Malang","Makassar",
            "Medan" , "Padang" ,"Palembang", "Pontianak" ,"Semarang","Surabaya"};
    private JComboBox cityList = new JComboBox<>(city);
    private JComboBox bioskopList = new JComboBox();
    private JButton nextButton = new JButton("NEXT");
    private JButton backButton = new JButton("BACK");
    private JButton exitButton = new JButton("⛔");
    private JPanel bgphoto = new JPanel();

    public String getTemp() {
        return temp;
    }

    private String temp = "Testing";
    private String temp1;

    private ArrayList<String> listCity = new ArrayList<String>();

    private ArrayList<String> listBioskop = new ArrayList<String>();
    private ArrayList<User> users = new ArrayList<>();
    public ArrayList<String> getListCity() {
        return listCity;
    }
    public ArrayList<String> getListBioskop() {
        return listBioskop;
    }

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
        backButton.setContentAreaFilled(true);
        backButton.setBorderPainted(false);
        backButton.setFocusable(false);
        titlelabel1.setForeground(Color.white);
        titleLabel.setForeground(Color.white);
        nextButton.setBackground(Color.white);
        nextButton.setForeground(Color.black);
        backButton.setBackground(Color.white);
        backButton.setForeground(Color.black);
        nameLabel.setForeground(Color.white);
        mallLabel.setForeground(Color.white);
        cityList.setBorder(null);
        bioskopList.setBorder(null);
        exitButton.setBackground(Color.white);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(true);
        exitButton.setFocusable(false);
    }

    private void setTextComponent() {
        nameLabel.setFont(new Font("Space Grotesk", Font.BOLD, 30));
        mallLabel.setFont(new Font("Space Grotesk", Font.BOLD, 30));
        nextButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        backButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        titlelabel1.setFont(new Font("Space Grotesk", Font.BOLD, 40));
        titleLabel.setFont(new Font("Space Grotesk", Font.PLAIN, 30));
        cityList.setFont(new Font("Space Grotesk", Font.PLAIN, 20));
        bioskopList.setFont(new Font("Space Grotesk", Font.PLAIN, 20));
        exitButton.setFont(new Font("Space Grotesk", Font.BOLD, 30));
    }

    private void setBgphoto() {
        bgphoto.setBounds(-14, -15, 1650, 1080);
        ImageIcon images = new ImageIcon("src/Images/cityList.png");
        JLabel label = new JLabel(images);
        bgphoto.add(label);
    }


    private void addActionEvent() {
        nextButton.addActionListener(this);
        backButton.addActionListener(this);
        cityList.addActionListener(this);
        exitButton.addActionListener(this);
    }

    private void addComponentsToContainer() {
        container.add(titlelabel1);
        container.add(titleLabel);
        container.add(nameLabel);
        container.add(mallLabel);
        container.add(cityList);
        container.add(bioskopList);
        container.add(nextButton);
        container.add(backButton);
        container.add(exitButton);
        container.add(bgphoto);
    }

    private void setLocationAndSize() {
        titlelabel1.setBounds(140, 20, 600, 230);
        titleLabel.setBounds(140, 60, 600, 230);
        nameLabel.setBounds(120, 220, 100, 40);
        mallLabel.setBounds(120,500,100,40);
        cityList.setBounds(220, 220, 220, 40);
        bioskopList.setBounds(220,500,220,40);
        nextButton.setBounds(100, 700, 210, 40);
        backButton.setBounds(340, 700, 210, 40);
        exitButton.setBounds(1450,10,65,65);
    }

    private void setLayoutManager() {
        container.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton){
            listCity.add(cityList.getSelectedItem().toString());
            temp = cityList.getSelectedItem().toString();
            temp1 = bioskopList.getSelectedItem().toString();
            listBioskop.add(temp1);
            JOptionPane.showMessageDialog(this,"City Selected : " + temp + "\n" + "Mall Selected : " + temp1, "CITY LIST", JOptionPane.INFORMATION_MESSAGE);
            new filmListFrame(users, listCity, listBioskop);
            dispose();
        }
        if (e.getSource() == backButton) {
            int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure want to Log Out?","LOG OUT", JOptionPane.YES_NO_OPTION);
            if(dialogButton == JOptionPane.YES_OPTION){
                new LoginFrame(users);
                dispose();
            }
        }
        if (e.getSource() == cityList) {
            String typeText = ((JTextField)cityList.getEditor().getEditorComponent()).getText();
            if (typeText.equals("Bandung")){
                bioskopList.removeAllItems();
                bioskopList.addItem("Bandung Indah Plaza");
                bioskopList.addItem("Festival Citylink");
                bioskopList.addItem("Paris Van Java");
            }
            if (typeText.equals("Bogor")) {
                bioskopList.removeAllItems();
                bioskopList.addItem("AEON Mall");
                bioskopList.addItem("Botani Square");
                bioskopList.addItem("Bogor Trade Mall");
            }
            if (typeText.equals("Denpasar")) {
                bioskopList.removeAllItems();
                bioskopList.addItem("Plza Renon");
                bioskopList.addItem("Living World Denpasar");
                bioskopList.addItem("Graha Plaza Bali");
            }
            if (typeText.equals("Jakarta")) {
                bioskopList.removeAllItems();
                bioskopList.addItem("Grand Indonesia");
                bioskopList.addItem("Plaza Senayan");
                bioskopList.addItem("Blok M Square");
                bioskopList.addItem("Pondok Indah Mall");
            }
            if (typeText.equals("Malang")) {
                bioskopList.removeAllItems();
                bioskopList.addItem("Malang Plaza");
                bioskopList.addItem("Malang Town Square");
                bioskopList.addItem("Mall Dinoyo City");
            }
            if (typeText.equals("Makassar")) {
                bioskopList.removeAllItems();
                bioskopList.addItem("New Makassar Mall");
                bioskopList.addItem("Nipah Mall");
                bioskopList.addItem("Mal Ratu Indah");
            }
            if (typeText.equals("Medan")) {
                bioskopList.removeAllItems();
                bioskopList.addItem("Medan Mall");
                bioskopList.addItem("Sun Plaza");
                bioskopList.addItem("DeliPark Mall");
            }
            if (typeText.equals("Padang")) {
                bioskopList.removeAllItems();
                bioskopList.addItem("Plaza Andalas");
                bioskopList.addItem("Damar Plaza");
                bioskopList.addItem("Lippo Padang");
            }
            if (typeText.equals("Palembang")) {
                bioskopList.removeAllItems();
                bioskopList.addItem("Palembang Icon Mall");
                bioskopList.addItem("Social Market");
                bioskopList.addItem("Opi Mall");
                bioskopList.addItem("Palembang Square");
                bioskopList.addItem("PTC");
            }
            if (typeText.equals("Pontianak")) {
                bioskopList.removeAllItems();
                bioskopList.addItem("Pontianak Mall");
                bioskopList.addItem("Ayani Megamall");
                bioskopList.addItem("Mal Pontianak");
            }
            if (typeText.equals("Semarang")) {
                bioskopList.removeAllItems();
                bioskopList.addItem("Sentraland Mall");
                bioskopList.addItem("Mall Ciputra");
                bioskopList.addItem("Paragon City");
            }
            if (typeText.equals("Surabaya")) {
                bioskopList.removeAllItems();
                bioskopList.addItem("Tunjungan Plaza");
                bioskopList.addItem("Pakuwon Trade Center");
                bioskopList.addItem("Delta Plaza");
                bioskopList.addItem("Cikutra Mall");
            }
            String selectedMall = bioskopList.getSelectedItem().toString();
            listBioskop.add(selectedMall);
        }

        if(e.getSource() == exitButton){
            int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure want to Log Out?","LOG OUT", JOptionPane.YES_NO_OPTION);
            if(dialogButton == JOptionPane.YES_OPTION){
                new LoginFrame(users);
                dispose();
            }
        }
    }

}

public class cityListFrame {
    public cityListFrame(ArrayList<User> users) {
        cityList frame = new cityList(users);
        frame.setTitle("CINEPLUS+");
        frame.setVisible(true);
        frame.setBounds(10, 10, 1650, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        frame.setLocation(-6, 0);
    }
}
