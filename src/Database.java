import javax.swing.*;
import java.util.ArrayList;

public class Database {

    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<filmListFrame> getFilmList() {
        return filmList;
    }
    private ArrayList<String> listBioskop = new ArrayList<String>();

    private ArrayList<String> listCity = new ArrayList<String>();

    private ArrayList<filmListFrame> filmList = new ArrayList<>();

    public ArrayList<String> getTimeSession() {
        return timeSession;
    }

    private ArrayList<String> timeSession = new ArrayList<>();

    public ArrayList<JButton> getBookedSeat() {
        return bookedSeat;
    }

    private ArrayList<JButton> bookedSeat = new ArrayList<>();

}
