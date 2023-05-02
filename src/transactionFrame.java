import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Transaction extends JFrame implements ActionListener {

    Container container = getContentPane();
    private JLabel transactionTitle = new JLabel("CINEPLUS+ TRANSACTION REPORT");
    private JLabel filmTitle = new JLabel("Film Name : " + "Test");
    private JLabel sessionTitle = new JLabel("Session Time : " + "Test");
    private JLabel qtyTitle = new JLabel("Quantity : " + "Test");
    private JLabel seatTitle = new JLabel("Number Seat : " + "Test");
    private JLabel priceTitle = new JLabel("Ticket Price : " + "Test");
    private JLabel totalPriceTitle = new JLabel("Total Price : " + "Test");
    private JLabel moneyDeposit = new JLabel("Money Deposit ");
    private JTextField depositMoneyTextfield = new JTextField();
    private JLabel moneyChange = new JLabel("Money Change : " + "Test");
    private JButton payButton = new JButton("PAY");
    private JButton nextButton = new JButton("NEXT");
    private ArrayList<User> users = new ArrayList<>();

    Transaction(ArrayList<User> users){
        this.users = users;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager(){
        container.setLayout(null);
    }

    public void setLocationAndSize(){
        transactionTitle.setBounds(350, 30, 300, 30);
        filmTitle.setBounds(120, 80, 200, 30);
        sessionTitle.setBounds(600, 80, 200, 30);
        qtyTitle.setBounds(120, 150, 200, 30);
        seatTitle.setBounds(600, 150, 200, 30);
        priceTitle.setBounds(120, 220, 200, 30);
        totalPriceTitle.setBounds(600, 220, 200, 30);
        moneyDeposit.setBounds(120, 290, 200, 30);
        depositMoneyTextfield.setBounds(270, 290, 150, 30);
        moneyChange.setBounds(600, 290, 200, 30);
        payButton.setBounds(120, 360, 100, 30);
        nextButton.setBounds(600, 360, 100, 30);
    }

    public void addComponentsToContainer(){
        container.add(transactionTitle);
        container.add(filmTitle);
        container.add(sessionTitle);
        container.add(qtyTitle);
        container.add(seatTitle);
        container.add(priceTitle);
        container.add(totalPriceTitle);
        container.add(moneyDeposit);
        container.add(depositMoneyTextfield);
        container.add(moneyChange);
        container.add(payButton);
        container.add(nextButton);
    }

    public void addActionEvent(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

public class transactionFrame {

    public transactionFrame(ArrayList<User> users){
        Transaction frame = new Transaction(users);
        frame.setTitle("CINEPLUS+");
        frame.setVisible(true);
        frame.setBounds(10, 10, 1650, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        Database datas = new Database();
        new transactionFrame(datas.getUsers());

    }

}
