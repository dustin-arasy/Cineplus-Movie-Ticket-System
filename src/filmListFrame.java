import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Film extends JFrame implements ActionListener{

    Container container = getContentPane();

    private JLabel titlelabel1 = new JLabel("LIST FILM CINEPLUS");
    private JLabel nameLabel = new JLabel("FILM : ");
    String[] film = {"Waktu Maghrib" ,"Shazam" ,"Fast X" ,"Little Mermaid"};
    private JComboBox listFilm = new JComboBox<>(film);
    private JLabel film1 = new JLabel("<html>WAKTU MAGHRIB<br>120 MINUTES<br>HORROR<html>");
    private JLabel film2 = new JLabel("<html>SHAZAM<br>151 MINUTES <br>ACTION<html");
    private JLabel film3 = new JLabel("<html>FAST X<br>90 MINUTES <br>ACTION<html");
    private JLabel film4 = new JLabel("<html>LITTLE MERMAID<br>110 MINUTES <br>FANTASY<html");
    private JButton nextButton = new JButton("NEXT");
    private JButton resetButton = new JButton("BACK");
    private JPanel bgfilm1 = new JPanel();
    private JPanel bgfilm2 = new JPanel();
    private JPanel bgfilm3 = new JPanel();
    private JPanel bgfilm4 = new JPanel();
    private JPanel bgfilm5 = new JPanel();
    private JPanel bgphoto = new JPanel();

    private ArrayList<filmListFrame> filmList = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    Film(ArrayList<filmListFrame> filmList , ArrayList<User> users){
        this.filmList = filmList;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setBgphoto();
        setBgFilm();
        setBgfilm2();
        setBgfilm3();
        setBgfilm4();
        setTextComponent();
        setAllButton();
    }


    private void setAllButton() {
        nextButton.setBorderPainted(false);
        nextButton.setFocusable(false);
        nextButton.setContentAreaFilled(true);
        resetButton.setContentAreaFilled(true);
        resetButton.setFocusable(false);
        resetButton.setBorderPainted(false);
        titlelabel1.setForeground(Color.WHITE);
        film1.setForeground(Color.WHITE);
        film2.setForeground(Color.WHITE);
        film3.setForeground(Color.WHITE);
        film4.setForeground(Color.WHITE);
        nextButton.setBackground(Color.WHITE);
        nextButton.setForeground(Color.BLACK);
        resetButton.setBackground(Color.WHITE);
        resetButton.setForeground(Color.BLACK);
        nameLabel.setForeground(Color.WHITE);
        listFilm.setBorder(null);
    }

    private void setTextComponent() {
        nameLabel.setFont(new Font("Space Grotesk", Font.BOLD, 20));
        nextButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        resetButton.setFont(new Font("Space Grotesk", Font.BOLD, 14));
        titlelabel1.setFont(new Font("Space Grotesk", Font.BOLD, 20));
        film1.setFont(new Font("Space Grotesk", Font.BOLD, 15));
        film2.setFont(new Font("Space Grotesk", Font.BOLD, 15));
        film3.setFont(new Font("Space Grotesk", Font.BOLD, 15));
        film4.setFont(new Font("Space Grotesk", Font.BOLD, 15));
    }

    private void setBgphoto() {
        bgphoto.setBounds(-14, -15, 1000, 500);
        ImageIcon images = new ImageIcon("src/Images/bgFilm.png");
        JLabel label = new JLabel(images);
        bgphoto.add(label);
    }

    private void setBgFilm() {
        bgfilm1.setBounds(220, 110, 114, 203);
        ImageIcon images = new ImageIcon("src/Images/film1.jpeg");
        JLabel film1 = new JLabel(images);
        bgfilm1.add(film1);

    }
    private void setBgfilm2(){
        bgfilm2.setBounds(400,110,120,203);
        ImageIcon images = new ImageIcon("src/Images/film2.jpg");
        JLabel film2 = new JLabel(images);
        bgfilm2.add(film2);
    }
    private void setBgfilm3() {
        bgfilm3.setBounds(580,110,120,203);
        ImageIcon images = new ImageIcon("src/Images/film3.jpg");
        JLabel film3 = new JLabel(images);
        bgfilm3.add(film3);
    }
    private void setBgfilm4() {
        bgfilm4.setBounds(760,110,120,203);
        ImageIcon images = new ImageIcon("src/Images/film4.png");
        JLabel film4 = new JLabel(images);
        bgfilm4.add(film4);
    }

    private void addActionEvent() {
        nextButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    private void addComponentsToContainer() {
        container.add(titlelabel1);
        container.add(film1);
        container.add(film2);
        container.add(film3);
        container.add(film4);
        container.add(nameLabel);
        container.add(listFilm);
        container.add(nextButton);
        container.add(resetButton);
        container.add(bgfilm1);
        container.add(bgfilm2);
        container.add(bgfilm3);
        container.add(bgfilm4);
        container.add(bgphoto);
    }

    private void setLocationAndSize() {
        titlelabel1.setBounds(400,40,400,30);
        nameLabel.setBounds(120 , 110 , 400 , 30);
        film1.setBounds(220,310,180,80);
        film2.setBounds(400,310 , 180 , 80);
        film3.setBounds(580,310,180,80);
        film4.setBounds(760,310,180,80);
        listFilm.setBounds(50, 160, 150, 30);
        nextButton.setBounds(320, 400, 110, 30);
        resetButton.setBounds(560, 400, 110, 30);
    }

    private void setLayoutManager() {
        container.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == nextButton){
            JOptionPane.showMessageDialog(this,"Succesfully!");
        }
        if (e.getSource() == resetButton) {
            new cityListFrame(users);
            dispose();
        }
    }
}



public class filmListFrame {

    public static void main(String[] args) {
        Database datas = new Database();
        new filmListFrame(datas.getFilmList() , datas.getUsers());
    }

    public filmListFrame(ArrayList<filmListFrame> filmList , ArrayList<User> users) {
        Film frame = new Film(filmList , users);
        frame.setTitle("CINEPLUS+");
        frame.setVisible(true);
        frame.setBounds(10, 10, 1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }


}
