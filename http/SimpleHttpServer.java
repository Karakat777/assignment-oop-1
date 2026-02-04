package http;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class SimpleHttpServer {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Создаем сервер на порту 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        // --- Регистрация API маршрутов ---
        server.createContext("/api/courses", new CourseHandler());
        server.createContext("/api/professors", new ProfessorHandler());
        server.createContext("/api/universities", new UniversityHandler());

        // --- Статические файлы (Фронтенд) ---
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String path = exchange.getRequestURI().getPath();

                // Если корень, отдаем index.html
                if (path.equals("/")) {
                    path = "/index.html";
                }

                // Ищем файл в папке src/web
                File file = new File("src/web" + path);

                if (file.exists() && !file.isDirectory()) {
                    byte[] content = Files.readAllBytes(file.toPath());

                    // Устанавливаем правильный Content-Type
                    String contentType = getContentType(path);
                    exchange.getResponseHeaders().set("Content-Type", contentType + "; charset=UTF-8");

                    exchange.sendResponseHeaders(200, content.length);
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(content);
                    }
                } else {
                    // Если файл не найден
                    String res = "404 Not Found";
                    exchange.sendResponseHeaders(404, res.length());
                    exchange.getResponseBody().write(res.getBytes());
                }
            }

            private String getContentType(String p) {
                if (p.endsWith(".html")) return "text/html";
                if (p.endsWith(".css")) return "text/css";
                if (p.endsWith(".js")) return "application/javascript";
                if (p.endsWith(".png")) return "image/png";
                return "text/plain";
            }
        });



        System.out.println("http://localhost:" + PORT);


        server.setExecutor(null); // использует дефолтный экзекутор
        server.start();
    }
}