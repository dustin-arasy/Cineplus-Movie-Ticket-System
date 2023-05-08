import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

class Seat extends JFrame implements ActionListener{
    Container container = getContentPane();
    private JLabel labelRegular = new JLabel("Regular 30.000");
    private JLabel labelSweetBox = new JLabel("Sweetbox 35.000");
    private String[] regular = new String[] {

            "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10", "J11", "J12", "J13",
            "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10", "I11", "I12", "I13",
            "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "H11", "H12", "H13",
            "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10", "G11", "G12", "G13",
            "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12", "F13",
            "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10", "E11", "E12", "E13",
            "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13",
            "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13",
            "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B11", "B12", "B13",

    };
    private String[] regularLeft = new String[]{
            "J1", "J2",
            "I1", "I2",
            "H1", "H2",
            "G1", "G2",
            "F1", "F2",
            "E1", "E2",
            "D1", "D2",
            "C1", "C2",
            "B1", "B2",
    };

    private String[] regularRight = new String[]{
            "J14", "J15",
            "I14", "I15",
            "H14", "H15",
            "G14", "G15",
            "F14", "F15",
            "E14", "E15",
            "D14", "D15",
            "C14", "C15",
            "B14", "B15",
    };

    private String[] sweetBox = new String[]{
            "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11",
            "A12", "A13", "A14", "A16", "A17", "A18", "A19", "A20", "A21", "A22"
    };
    private JPanel panel = new JPanel(new GridLayout(9, 12));
    private JPanel panelRegularLeft = new JPanel(new GridLayout(9,2));
    private JPanel panelRegularRight = new JPanel(new GridLayout(9,2));
    private JPanel panelSweetBox = new JPanel(new GridLayout(1, 22));
    private JButton btnRegular[] = new JButton[regular.length];
    private JButton btnRegularLeft[] = new JButton[regularLeft.length];
    private JButton btnRegularRight[] = new JButton[regularRight.length];
    private JButton btnSweetBox[] = new JButton[sweetBox.length];

    private JButton nextButton = new JButton("Next");
//    private JButton backButton = new JButton("Back");

//    for(int i = 0; i < regular.length; i++){
//
//    }

    private ArrayList<User> Users;
//    private ArrayList<filmListFrame> filmList = new ArrayList<>();
    private ArrayList<String> savedDates;
    private ArrayList<String> savedSessions;
    private ArrayList<Integer> savedSeats;
    private ArrayList<String> selectedSeat = new ArrayList<String>();
    private ArrayList<JButton> bookedSeat = new ArrayList<JButton>();
    private ArrayList<String> citylist;
    private ArrayList<String> bioskopList;
    private ArrayList<String> filmList;

    public Seat(ArrayList<String> listFilm , ArrayList<User> users, ArrayList<String> listCity, ArrayList<String> listBioskop, ArrayList<String> savedDate, ArrayList<String> savedSession, ArrayList<Integer> savedSeat, ArrayList<JButton> bookedSeat){
        Users = users;
        citylist = listCity;
        bioskopList = listBioskop;
        filmList = listFilm;
        savedDates = savedDate;
        savedSessions = savedSession;
        savedSeats = savedSeat;
        this.selectedSeat = selectedSeat;
        this.bookedSeat = bookedSeat;
        int a = 0, b = 0, c = 0, d = 0;
        for (String l: regular) {
            btnRegular[a] = new JButton(l);
            btnRegular[a].addActionListener(this);
            btnRegular[a].setBackground(Color.lightGray);
            panel.add(btnRegular[a]);
            a++;
        }
        for (String rl: regularLeft){
            btnRegularLeft[b] = new JButton(rl);
            btnRegularLeft[b].addActionListener(this);
            btnRegularLeft[b].setBackground(Color.lightGray);
            panelRegularLeft.add(btnRegularLeft[b]);
            b++;
        }
        for (String rr: regularRight){
            btnRegularRight[c] = new JButton(rr);
            btnRegularRight[c].addActionListener(this);
            btnRegularRight[c].setBackground(Color.lightGray);
            panelRegularRight.add(btnRegularRight[c]);
            c++;
        }
        for (String s: sweetBox){
            btnSweetBox[d] = new JButton(s);
            btnSweetBox[d].addActionListener(this);
            btnSweetBox[d].setBackground(Color.lightGray);
            panelSweetBox.add(btnSweetBox[d]);
            d++;
        }
        setTitle("Seat");
        setSize(1650, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setVisible(true);
    }

    public void setLayoutManager(){
        container.setLayout(null);
    }

    public void setLocationAndSize(){
        labelRegular.setBounds(725,50,200,30);
        labelSweetBox.setBounds(725,600,200,30);
        panel.setBounds(418,100,700,480);
        panelRegularLeft.setBounds(238,100,120, 480);
        panelRegularRight.setBounds(1178,100,120,480);
        panelSweetBox.setBounds(107,650,1320,40);
        nextButton.setBounds(108,750,100,30);
//        backButton.setBounds(1178, 750, 100, 30);
    }

    public void addComponentsToContainer(){
        container.add(labelRegular);
        container.add(labelSweetBox);
        container.add(nextButton);
        container.add(panel);
        container.add(panelRegularLeft);
        container.add(panelRegularRight);
        container.add(panelSweetBox);
//        container.add(backButton);
    }

    public void addActionEvent(){
        nextButton.addActionListener(this);
//        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        String buttonText = button.getText();
        Color originalColor = button.getBackground();
        int jumlahSeat = 0;

        if(buttonText.equals("Next")){
            for (int i = 0; i < btnRegular.length; i++) {
                if (btnRegular[i].getBackground() == Color.GREEN) {
                    btnRegular[i].setBackground(Color.RED);
                    bookedSeat.add(btnRegular[i]);
                }
            }
            for (int i = 0; i < btnRegularLeft.length; i++){
                if (btnRegularLeft[i].getBackground() == Color.GREEN) {
                    btnRegularLeft[i].setBackground(Color.RED);
                    bookedSeat.add(btnRegularLeft[i]);
                }
            }
            for (int i = 0; i < btnRegularRight.length; i++){
                if (btnRegularRight[i].getBackground() == Color.GREEN) {
                    btnRegularRight[i].setBackground(Color.RED);
                    bookedSeat.add(btnRegularRight[i]);
                }
            }
            for (int i = 0; i < btnSweetBox.length; i++){
                if (btnSweetBox[i].getBackground() == Color.GREEN) {
                    btnSweetBox[i].setBackground(Color.RED);
                    bookedSeat.add(btnSweetBox[i]);
                }
            }
            // Implement the action for the "Next" button
//            new sessionTimeFrame(filmList, users);
//            dispose();
//        } else if (buttonText.equals("Back")) {
//            new SessionTime(filmList, users);
//            dispose();
            new transactionFrame(Users, citylist, bioskopList, filmList, savedDates, savedSessions, savedSeats, bookedSeat, selectedSeat);
            dispose();

        } else if(button.getBackground() != Color.RED){
            // Check which type of seat was selected and handle accordingly
            if(Arrays.asList(regularLeft).contains(buttonText) || Arrays.asList(regular).contains(buttonText)|| Arrays.asList(regularRight).contains(buttonText)){
                if(button.getBackground() == Color.GREEN){
                    int choice = JOptionPane.showConfirmDialog(this, "Do you want to cancel this seat?");
                    if(choice == JOptionPane.YES_OPTION){
                        button.setBackground(Color.LIGHT_GRAY);
                    }
                }
                else{
                    int choice = JOptionPane.showConfirmDialog(this, "Do you want to select this seat?");
                    if(choice == JOptionPane.YES_OPTION){
                        button.setBackground(Color.GREEN);
                        selectedSeat.add(buttonText);
                    }
                }
            }
            else if(Arrays.asList(sweetBox).contains(buttonText)){
                if(button.getBackground() == Color.GREEN){
                    int choice = JOptionPane.showConfirmDialog(this, "Do you want to cancel this seat?");
                    if(choice == JOptionPane.YES_OPTION){
                        button.setBackground(Color.LIGHT_GRAY);
                    }
                }
                else{
                    int choice = JOptionPane.showConfirmDialog(this, "Do you want to select this sweetbox?");
                    if(choice == JOptionPane.YES_OPTION){
                        button.setBackground(Color.GREEN);
                        // Select all the seats in the sweetbox and mark them as reserved
                        for(String s : sweetBox){
                            Component[] components = panel.getComponents();
                            for(Component component : components){
                                if(component instanceof JButton){
                                    JButton btn = (JButton)component;
                                    if(btn.getText().equals(s)){
                                        btn.setBackground(Color.GREEN);
                                        selectedSeat.add(buttonText);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
public class seatFrame {
//    public static void main(String[] args) {
//        Database datas = new Database();
//        new Seat(datas.getFilmList(), datas.getUsers(), datas.getTimeSession(), datas.getBookedSeat());
//    }
}
