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
            "Medan" , "Padang", "Pontianak" ,"Semarang","Surabaya"};
    private JComboBox cityList = new JComboBox<>(city);
    private JComboBox bioskopList = new JComboBox();
    private JButton nextButton = new JButton("NEXT");
    private JButton resetButton = new JButton("BACK");
    private JPanel bgphoto = new JPanel();

    private ArrayList<String> listCity = new ArrayList<String>();

    private ArrayList<String> listBioskop = new ArrayList<String>();
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
        mallLabel.setForeground(Color.white);
        cityList.setBorder(null);
        bioskopList.setBorder(null);
    }

    private void setTextComponent() {
        nameLabel.setFont(new Font("Space Grotesk", Font.BOLD, 30));
        mallLabel.setFont(new Font("Space Grotesk", Font.BOLD, 30));
        nextButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        resetButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        titlelabel1.setFont(new Font("Space Grotesk", Font.BOLD, 40));
        titleLabel.setFont(new Font("Space Grotesk", Font.PLAIN, 30));
        cityList.setFont(new Font("Space Grotesk", Font.PLAIN, 20));
        bioskopList.setFont(new Font("Space Grotesk", Font.PLAIN, 20));
    }

    private void setBgphoto() {
        bgphoto.setBounds(-14, -15, 1650, 1080);
        ImageIcon images = new ImageIcon("src/Images/cityList.png");
        JLabel label = new JLabel(images);
        bgphoto.add(label);
    }


    private void addActionEvent() {
        nextButton.addActionListener(this);
        resetButton.addActionListener(this);
        cityList.addActionListener(this);
    }

    private void addComponentsToContainer() {
        container.add(titlelabel1);
        container.add(titleLabel);
        container.add(nameLabel);
        container.add(mallLabel);
        container.add(cityList);
        container.add(bioskopList);
        container.add(nextButton);
        container.add(resetButton);
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
        resetButton.setBounds(340, 700, 210, 40);
    }

    private void setLayoutManager() {
        container.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton){
            JOptionPane.showMessageDialog(this,"Succesfully!");
            listCity.add(cityList.getSelectedItem().toString());
            new filmListFrame(filmList , users);
            dispose();
            System.out.println(listCity);
            System.out.println(listBioskop);
        }
        if (e.getSource() == resetButton) {
            new LoginFrame(users);
            dispose();
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
                bioskopList.addItem("Pragon City");
            }
            if (typeText.equals("Surabaya")) {
                bioskopList.removeAllItems();
                bioskopList.addItem("Tunjungan Plaza");
                bioskopList.addItem("Pakuwon Trade Center");
                bioskopList.addItem("Delta Plaza");
                bioskopList.addItem("Cikutra Mall");
            }

        }

        String selectedMall = bioskopList.getSelectedItem().toString();

        System.out.println("Selected mall: " + selectedMall);
        listBioskop.add(selectedMall);
        System.out.println(listBioskop);
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
        frame.setBounds(10, 10, 1650, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
