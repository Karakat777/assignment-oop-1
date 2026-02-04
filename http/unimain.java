package http;
public class unimain {
    public static void main(String[] args) {
        try {
            SimpleHttpServer.main(args);
        } catch (Exception e) {
            System.err.println("critic error");
            e.printStackTrace();
        }
    }
}