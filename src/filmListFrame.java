import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Film extends JFrame implements ActionListener{

    Container container = getContentPane();

    private JLabel titlelabel1 = new JLabel("LIST FILM CINEPLUS");
    private JLabel nameLabel = new JLabel("FILM : ");
    String[] film = {"Waktu Maghrib" ,"Shazam" ,"Fast X" ,"Little Mermaid","Titanic","Mario Bross","Sewu Dino","Aquaman"};
    private JComboBox listFilm = new JComboBox<>(film);
    private JLabel film1 = new JLabel("<html>WAKTU MAGHRIB<br>120 MINUTES<br>HORROR<html>");
    private JLabel film2 = new JLabel("<html>SHAZAM<br>151 MINUTES <br>ACTION<html");
    private JLabel film3 = new JLabel("<html>FAST X<br>90 MINUTES <br>ACTION<html");
    private JLabel film4 = new JLabel("<html>LITTLE MERMAID<br>110 MINUTES <br>FANTASY<html");
    private JLabel film5 = new JLabel("<html>TITANIC<br>150 MINUTES<br>ROMANCE<html>");
    private JLabel film6 = new JLabel("<html>MARIO BROSS<br>100 MINUTES <br>FANTASY<html");
    private JLabel film7 = new JLabel("<html>SEWU DINO<br>135 MINUTES <br>HORROR<html");
    private JLabel film8 = new JLabel("<html>AQUAMAN<br>104 MINUTES <br>ACTION<html");
    private JButton nextButton = new JButton("NEXT");
    private JButton backButton = new JButton("BACK");
    private JPanel bgfilm1 = new JPanel();
    private JPanel bgfilm2 = new JPanel();
    private JPanel bgfilm3 = new JPanel();
    private JPanel bgfilm4 = new JPanel();
    private JPanel bgfilm5 = new JPanel();
    private JPanel bgfilm6 = new JPanel();
    private JPanel bgfilm7 = new JPanel();
    private JPanel bgfilm8 = new JPanel();
    private JPanel bgphoto = new JPanel();

    private ArrayList<String> filmList = new ArrayList<String>();
    private ArrayList<String> citylist;
    private ArrayList<String> bioskopList;
    private ArrayList<User> users = new ArrayList<>();

    Film (ArrayList<User> users, ArrayList<String> listCity, ArrayList<String> listBioskop){
        this.users = users;
        this.filmList = filmList;
        citylist = listCity;
        bioskopList = listBioskop;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setBgphoto();
        setBgFilm();
        setBgfilm2();
        setBgfilm3();
        setBgfilm4();
        setBgFilm5();
        setBgfilm6();
        setBgfilm7();
        setBgfilm8();
        setTextComponent();
        setAllButton();
    }


    private void setAllButton() {
        nextButton.setBorderPainted(false);
        nextButton.setFocusable(false);
        nextButton.setContentAreaFilled(true);
        backButton.setContentAreaFilled(true);
        backButton.setFocusable(false);
        backButton.setBorderPainted(false);
        titlelabel1.setForeground(Color.WHITE);
        film1.setForeground(Color.WHITE);
        film2.setForeground(Color.WHITE);
        film3.setForeground(Color.WHITE);
        film4.setForeground(Color.WHITE);
        film5.setForeground(Color.WHITE);
        film6.setForeground(Color.WHITE);
        film7.setForeground(Color.WHITE);
        film8.setForeground(Color.WHITE);
        nextButton.setBackground(Color.WHITE);
        nextButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        nameLabel.setForeground(Color.WHITE);
        listFilm.setBorder(null);
    }

    private void setTextComponent() {
        nameLabel.setFont(new Font("Space Grotesk", Font.BOLD, 20));
        nextButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        backButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        titlelabel1.setFont(new Font("Space Grotesk", Font.BOLD, 20));
        listFilm.setFont(new Font("Space Grotesk", Font.BOLD, 20));
        film1.setFont(new Font("Space Grotesk", Font.BOLD, 15));
        film2.setFont(new Font("Space Grotesk", Font.BOLD, 15));
        film3.setFont(new Font("Space Grotesk", Font.BOLD, 15));
        film4.setFont(new Font("Space Grotesk", Font.BOLD, 15));
        film5.setFont(new Font("Space Grotesk", Font.BOLD, 15));
        film6.setFont(new Font("Space Grotesk", Font.BOLD, 15));
        film7.setFont(new Font("Space Grotesk", Font.BOLD, 15));
        film8.setFont(new Font("Space Grotesk", Font.BOLD, 15));
    }

    private void setBgphoto() {
        bgphoto.setBounds(-14, -15, 1650, 1080);
        ImageIcon images = new ImageIcon("src/Images/bgFilm.png");
        JLabel label = new JLabel(images);
        bgphoto.add(label);
    }

    private void setBgFilm() {
        bgfilm1.setBounds(320, 100, 190, 273);
        ImageIcon images = new ImageIcon("src/Images/film1.png");
        JLabel film1 = new JLabel(images);
        bgfilm1.add(film1);

    }
    private void setBgfilm2(){
        bgfilm2.setBounds(620,100,190,273);
        ImageIcon images = new ImageIcon("src/Images/film2.png");
        JLabel film2 = new JLabel(images);
        bgfilm2.add(film2);
    }
    private void setBgfilm3() {
        bgfilm3.setBounds(920,100,190,273);
        ImageIcon images = new ImageIcon("src/Images/film3.png");
        JLabel film3 = new JLabel(images);
        bgfilm3.add(film3);
    }
    private void setBgfilm4() {
        bgfilm4.setBounds(1220,100,190,273);
        ImageIcon images = new ImageIcon("src/Images/film4.png");
        JLabel film4 = new JLabel(images);
        bgfilm4.add(film4);
    }

    private void setBgFilm5() {
        bgfilm5.setBounds(320, 480, 190, 273);
        ImageIcon images = new ImageIcon("src/Images/film5.png");
        JLabel film5 = new JLabel(images);
        bgfilm5.add(film5);

    }
    private void setBgfilm6(){
        bgfilm6.setBounds(620,480,190,273);
        ImageIcon images = new ImageIcon("src/Images/film6.png");
        JLabel film6 = new JLabel(images);
        bgfilm6.add(film6);
    }
    private void setBgfilm7() {
        bgfilm7.setBounds(920,480,190,273);
        ImageIcon images = new ImageIcon("src/Images/film7.png");
        JLabel film7 = new JLabel(images);
        bgfilm7.add(film7);
    }
    private void setBgfilm8() {
        bgfilm8.setBounds(1220,480,190,273);
        ImageIcon images = new ImageIcon("src/Images/film8.png");
        JLabel film8 = new JLabel(images);
        bgfilm8.add(film8);
    }

    private void addActionEvent() {
        nextButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    private void addComponentsToContainer() {
        container.add(titlelabel1);
        container.add(film1);
        container.add(film2);
        container.add(film3);
        container.add(film4);
        container.add(film5);
        container.add(film6);
        container.add(film7);
        container.add(film8);
        container.add(nameLabel);
        container.add(listFilm);
        container.add(nextButton);
        container.add(backButton);
        container.add(bgfilm1);
        container.add(bgfilm2);
        container.add(bgfilm3);
        container.add(bgfilm4);
        container.add(bgfilm5);
        container.add(bgfilm6);
        container.add(bgfilm7);
        container.add(bgfilm8);
        container.add(bgphoto);
    }

    private void setLocationAndSize() {
        titlelabel1.setBounds(400,40,400,30);
        nameLabel.setBounds(120 , 110 , 400 , 30);
        film1.setBounds(320,370,180,80);
        film2.setBounds(630,370 , 180 , 80);
        film3.setBounds(920,370,180,80);
        film4.setBounds(1220,370,180,80);
        film5.setBounds(320,750,180,80);
        film6.setBounds(630,750 , 180 , 80);
        film7.setBounds(920,750,180,80);
        film8.setBounds(1220,750,180,80);
        listFilm.setBounds(50, 160, 200, 50);
        nextButton.setBounds(50, 600, 200, 50);
        backButton.setBounds(50, 700, 200, 50);
    }

    private void setLayoutManager() {
        container.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == nextButton){
            String selectedFilm = listFilm.getSelectedItem().toString();
            filmList.add(selectedFilm);
            JOptionPane.showMessageDialog(this,"Film Selected : " + selectedFilm);
            new transactionFrame(users, citylist, bioskopList, filmList);
            dispose();
        }
        if (e.getSource() == backButton) {
            new cityListFrame(users);
            dispose();
        }
    }
}



public class filmListFrame {

    public filmListFrame(ArrayList<User> users, ArrayList<String> listCity, ArrayList<String> listBioskop) {
        Film frame = new Film(users, listCity, listBioskop);
        frame.setTitle("CINEPLUS+");
        frame.setVisible(true);
        frame.setBounds(10, 10, 1650, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }


}
