import java.util.ArrayList;

public class Database {

    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<cityListFrame> getListCity() {
        return listCity;
    }

    public ArrayList<filmListFrame> getFilmList() {
        return filmList;
    }

    private ArrayList<cityListFrame> listCity = new ArrayList<>();

    private ArrayList<filmListFrame> filmList = new ArrayList<>();


}
