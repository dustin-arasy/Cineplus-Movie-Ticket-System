import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class SessionTime extends JFrame implements ActionListener{

    Container container = getContentPane();

    private JLabel titleLabel =  new JLabel("Session Time");
    private JLabel dateLabel = new JLabel("Date");
    private JCalendar calendar = new JCalendar();
    private JLabel sessionLabel = new JLabel("Session");
    private JComboBox<String> sessionComboBox = new JComboBox<>(new String[]{"10:00 AM", "2:00 PM", "6:00 PM", "10:00 PM"});
    private JButton nextButton = new JButton("Next");
    private JButton backButton = new JButton("Back");


    public ArrayList<String> getSelectedData() {
        return selectedData;
    }

    private ArrayList<String> selectedData = new ArrayList<String>();

    public SessionTime(){
        setTitle("Session Time");
        setSize(1000, 500);
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
        titleLabel.setBounds(150,40,100,30);
        dateLabel.setBounds(50,100,100,30);
        sessionLabel.setBounds(50,320,100,30);
        sessionComboBox.setBounds(100,320,250,30);
        nextButton.setBounds(50,380,100,30);
        backButton.setBounds(250, 380, 100,30);
        calendar.setBounds(100,100,250,200);
    }

    public void addComponentsToContainer(){
        container.add(titleLabel);
        container.add(dateLabel);
        container.add(sessionLabel);
        container.add(sessionComboBox);
        container.add(nextButton);
        container.add(backButton);
        container.add(calendar);
    }

    public void addActionEvent(){
        nextButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextButton){
            String date = String.format("%tF", calendar.getDate());
            String selectedSession = (String) sessionComboBox.getSelectedItem();
//            System.out.println("Selected session: " + selectedSession);
            String selected = date + " " + selectedSession;

            // Add selected data to the list
            selectedData.add(selected);

            // Show message to the user
            JOptionPane.showMessageDialog(this, "Selected data: " + selected);
            // move to next screen

        }
    }
}

public class sessionTimeFrame {
    public static void main(String[] args) {
        new SessionTime();
    }
}
