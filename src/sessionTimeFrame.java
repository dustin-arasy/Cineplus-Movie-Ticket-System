import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class SessionTime extends JFrame implements ActionListener{

    Container container = getContentPane();
    private JPanel bgPhoto = new JPanel();
    private JCalendar calendar = new JCalendar();
    private JComboBox<String> sessionComboBox = new JComboBox<>(new String[]{"10:00 AM", "2:00 PM", "6:00 PM", "10:00 PM"});
    private int totalSeats = 0;
    private JLabel seatLabel = new JLabel(String.valueOf(totalSeats));
    private JPanel seatPanel = new JPanel();
    private JButton incrementButton = new JButton("+");
    private JButton decrementButton = new JButton("-");
    private JButton nextButton = new JButton("Next");
    private JButton backButton = new JButton("Back");
    private ArrayList<User> Users;
//    private ArrayList<filmListFrame> filmList = new ArrayList<>();
    private ArrayList<String> savedDate = new ArrayList<String>();
    private ArrayList<String> savedSession = new ArrayList<String>();
    private ArrayList<Integer> savedSeat = new ArrayList<Integer>();
    private ArrayList<JButton> bookedSeat = new ArrayList<JButton>();
    private ArrayList<String> citylist;
    private ArrayList<String> bioskopList;
    private ArrayList<String> filmList;




    public SessionTime(ArrayList<User> users, ArrayList<String> listCity, ArrayList<String> listBioskop, ArrayList<String> listFilm){
        this.savedDate = savedDate;
        this.savedSession = savedSession;
        this.savedSeat = savedSeat;
        Users = users;
        citylist = listCity;
        bioskopList = listBioskop;
        filmList = listFilm;
        setTitle("Session Time");
        setBgPhoto();
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
        sessionComboBox.setBounds(215,570,320,40);
        seatLabel.setBounds(788,267,70,42);
        seatPanel.setBounds(765,267,132,41);
        incrementButton.setBounds(898,266,50,21);
        decrementButton.setBounds(898,287,50,21);
        nextButton.setBounds(55,730,120,50);
        backButton.setBounds(418, 730, 120,50);
        calendar.setBounds(155,225,350,300);
        calendar.setFont(new Font("Space Grotesk", Font.BOLD, 15));
    }

    public void addComponentsToContainer(){
        container.add(sessionComboBox);
        container.add(seatLabel);
        container.add(seatPanel);
        container.add(incrementButton);
        container.add(decrementButton);
        container.add(nextButton);
        container.add(backButton);
        container.add(calendar);
        container.add(bgPhoto);
    }

    public void addActionEvent(){
        decrementButton.addActionListener(this);
        incrementButton.addActionListener(this);
        nextButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    private void setBgPhoto(){
        bgPhoto.setBounds(-20,0,1650,1080);
        ImageIcon image = new ImageIcon("src/Images/sessionTime.png");
        JLabel imageLabel = new JLabel(image);
        bgPhoto.add(imageLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextButton){
            String date = String.format("%tF", calendar.getDate());
            String selectedSession = (String) sessionComboBox.getSelectedItem();
//            System.out.println("Selected session: " + selectedSession);
            String selected = date + " " + selectedSession + " " + totalSeats + " seat";

            // Add selected data to the list
            savedDate.add(date);
            savedSession.add(selectedSession);
            savedSeat.add(totalSeats);

            if(totalSeats == 0){
                JOptionPane.showMessageDialog(this, "Please select total seat!");
            } else{
                // Show message to the user
                JOptionPane.showMessageDialog(this, "Selected data: " + selected);
                // move to next screen
                new Seat(filmList, Users, citylist, bioskopList, savedDate, savedSession, savedSeat, bookedSeat, totalSeats);
                dispose();
            }
        }
        if (e.getSource() == backButton) {
//            new filmListFrame(filmList, users);
            dispose();
        }
        if (e.getSource() == incrementButton) {
                totalSeats++;
        } else if (e.getSource() == decrementButton) {
                totalSeats--;
        }
        seatLabel.setText(String.valueOf(totalSeats));
    }
}

public class sessionTimeFrame {
//    public static void main(String[] args) {
//        Database datas = new Database();
//        new SessionTime(datas.getFilmList(), datas.getUsers());
//    }
}
