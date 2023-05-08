import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Transaction extends JFrame implements ActionListener {

    Database datas = new Database();
    private ArrayList<String> citylist;
    private ArrayList<String> bioskopList;
    private ArrayList<String> filmList;
    private ArrayList<String> savedDates;
    private ArrayList<String> savedSessions;
    private ArrayList<Integer> savedSeats;
    private ArrayList<String> selectedSeats = new ArrayList<String>();
    private ArrayList<JButton> bookedSeats = new ArrayList<JButton>();
    private JButton exitButton = new JButton("⛔");
    private ArrayList<User> Users;
    Container container = getContentPane();
    int check = 0;

    Transaction(ArrayList<User> users, ArrayList<String> listCity, ArrayList<String> listBioskop, ArrayList<String> listFilm, ArrayList<String> savedDate, ArrayList<String> savedSession, ArrayList<Integer> savedSeat, ArrayList<JButton> bookedSeat, ArrayList<String> selectedSeat){
        Users = users;
        citylist = listCity;
        bioskopList = listBioskop;
        filmList = listFilm;
        savedDates = savedDate;
        savedSessions = savedSession;
        savedSeats = savedSeat;
        selectedSeats = selectedSeat;
        bookedSeats = bookedSeat;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setBgphoto();
        setSizeText();
    }

    private JLabel transactionTitle = new JLabel("CINEPLUS+ TRANSACTION REPORT");
    private JLabel cityTitle = new JLabel();
    private JLabel mallTitle = new JLabel();
    private JLabel filmTitle = new JLabel();
    private JLabel sessionTitle = new JLabel();
    private JLabel qtyTitle = new JLabel();
    private JLabel seatTitle = new JLabel();
    private JLabel priceTitle = new JLabel("Ticket Price   : " + "30000");
    private JLabel totalPriceTitle = new JLabel();
    private JLabel moneyDeposit = new JLabel("Money Deposit ");
    private JTextField depositMoneyTextfield = new JTextField();
    private JLabel userTitle = new JLabel( );
    private JButton payButton = new JButton("PAY");
    private JButton nextButton = new JButton("NEXT");
    private JPanel bgphoto = new JPanel();
//    private ArrayList<User> users = new ArrayList<>();

    public void setLayoutManager(){
        container.setLayout(null);
    }
    public void setBgphoto(){
        bgphoto.setBounds(-55, -55, 1650, 1080);
        ImageIcon images = new ImageIcon("src/Images/transactionbg.png");
        JLabel label = new JLabel(images);
        bgphoto.add(label);
    }
    public void setSizeText(){
        transactionTitle.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        cityTitle.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        mallTitle.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        filmTitle.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        sessionTitle.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        qtyTitle.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        seatTitle.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        priceTitle.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        totalPriceTitle.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        moneyDeposit.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        depositMoneyTextfield.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        userTitle.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        payButton.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        nextButton.setFont(new Font("Space Grotesk", Font.BOLD, 22));
        exitButton.setFont(new Font("Space Grotesk", Font.BOLD, 30));
        transactionTitle.setForeground(Color.white);
        cityTitle.setForeground(Color.white);
        mallTitle.setForeground(Color.white);
        filmTitle.setForeground(Color.white);
        sessionTitle.setForeground(Color.white);
        qtyTitle.setForeground(Color.white);
        seatTitle.setForeground(Color.white);
        priceTitle.setForeground(Color.white);
        totalPriceTitle.setForeground(Color.white);
        moneyDeposit.setForeground(Color.white);
        userTitle.setForeground(Color.white);
        userTitle.setText("Operated By      : " + Users.get(0).getName());
        cityTitle.setText("City                 : " + citylist.get(0));
        mallTitle.setText("Mall                    : " + bioskopList.get(1));
        filmTitle.setText("Film Name     : " + filmList.get(0));
        sessionTitle.setText("Session Time    : " + savedSessions.get(0));
        qtyTitle.setText("Quantity         : " + savedSeats.get(0));
        String tempSeat = selectedSeats.toString();
        seatTitle.setText("Number Seat     : " + tempSeat);
        int tempNum = savedSeats.get(0) * 30000;
        totalPriceTitle.setText("Total Price         : " + tempNum);
        payButton.setFocusable(false);
        payButton.setContentAreaFilled(true);
        payButton.setBorderPainted(false);
        payButton.setBackground(Color.white);
        nextButton.setFocusable(false);
        nextButton.setBorderPainted(false);
        nextButton.setContentAreaFilled(true);
        nextButton.setBackground(Color.white);
        exitButton.setBackground(Color.white);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(true);
        exitButton.setFocusable(false);
    }

    public void setLocationAndSize(){
        transactionTitle.setBounds(250, 80, 400, 30);
        cityTitle.setBounds(90, 160, 450, 30);
        mallTitle.setBounds(570, 160, 450, 30);
        filmTitle.setBounds(90, 230, 450, 30);
        sessionTitle.setBounds(570, 230, 450, 30);
        qtyTitle.setBounds(90, 300, 450, 30);
        seatTitle.setBounds(570, 300, 450, 30);
        priceTitle.setBounds(90, 370, 450, 30);
        totalPriceTitle.setBounds(570, 370, 450, 30);
        moneyDeposit.setBounds(90, 440, 450, 30);
        depositMoneyTextfield.setBounds(280, 450, 150, 30);
        userTitle.setBounds(570, 440, 450, 30);
        payButton.setBounds(90, 510, 100, 40);
        nextButton.setBounds(570, 510, 100, 40);
        exitButton.setBounds(1450,10,65,65);
    }

    public void addComponentsToContainer(){
        container.add(transactionTitle);
        container.add(cityTitle);
        container.add(mallTitle);
        container.add(filmTitle);
        container.add(sessionTitle);
        container.add(qtyTitle);
        container.add(seatTitle);
        container.add(priceTitle);
        container.add(totalPriceTitle);
        container.add(moneyDeposit);
        container.add(depositMoneyTextfield);
        container.add(userTitle);
        container.add(payButton);
        container.add(nextButton);
        container.add(exitButton);
        container.add(bgphoto);
    }

    public void addActionEvent(){
        nextButton.addActionListener(this);
        payButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextButton){
            if(check == 0){
                JOptionPane.showMessageDialog(this, "Please pay the ticket first!", "TRANSACTION", JOptionPane.INFORMATION_MESSAGE);
            } else {
            JOptionPane.showMessageDialog(this, "Transaction Successfully!", "TRANSACTION", JOptionPane.INFORMATION_MESSAGE);
            new cityListFrame(Users);
            dispose();
            }
        }

        if(e.getSource() == payButton){
            String moneyDeposit = depositMoneyTextfield.getText();
            int amountMoney = Integer.parseInt(moneyDeposit);
            int tempNum = savedSeats.get(0) * 30000;
            int amountChange = amountMoney - tempNum;
            String moneyAmountChange = Integer.toString(amountChange);
            if(amountChange < 0) {
                JOptionPane.showMessageDialog(this, "Insufficient Amount Money Change!\n" + "Please Input Money Deposit excess of the Total Ticket Price!", "TRANSACTION", JOptionPane.INFORMATION_MESSAGE);
            } else if (amountChange >= 0) {
                JOptionPane.showMessageDialog(this, "The Total Money Change : " + moneyAmountChange, "TRANSACTION", JOptionPane.INFORMATION_MESSAGE);
                check = 1;
            }
        }
        if(e.getSource() == exitButton){
            int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure want to Log Out?","LOG OUT", JOptionPane.YES_NO_OPTION);
            if(dialogButton == JOptionPane.YES_OPTION){
                new LoginFrame(Users);
                dispose();
            }
        }
    }
}

public class transactionFrame {

    public transactionFrame(ArrayList<User> users, ArrayList<String> listCity, ArrayList<String> listBioskop, ArrayList<String> listFilm, ArrayList<String> savedDate, ArrayList<String> savedSession, ArrayList<Integer> savedSeat,ArrayList<JButton> bookedSeat,  ArrayList<String> selectedSeat){

        Transaction frame = new Transaction(users, listCity, listBioskop, listFilm, savedDate, savedSession, savedSeat, bookedSeat, selectedSeat);
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
