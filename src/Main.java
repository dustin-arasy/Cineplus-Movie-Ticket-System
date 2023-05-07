public class Main {
    public static void main(String[] args) {
        Database datas = new Database();
        new HomepageFrame(datas.getUsers());
    }
}
