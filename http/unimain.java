package http;

public class unimain {
    public static void main(String[] args) {

        try {
            // Вызываем статический метод запуска сервера
            SimpleHttpServer.main(args);
        } catch (Exception e) {
            System.err.println("Критическая ошибка при запуске сервера!");
            e.printStackTrace();
        }
    }
}