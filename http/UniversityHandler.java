package http;

import database.UniversityDAO;
import models.University;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.util.List;

public class UniversityHandler extends BaseHandler {
    private final UniversityDAO universityDAO = new UniversityDAO();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();

        switch (method) {
            case "GET":
                handleGet(exchange);
                break;
            case "POST":
                handlePost(exchange);
                break;
            case "PUT":
                handlePut(exchange);
                break;
            case "DELETE":
                handleDelete(exchange, path);
                break;
            default:
                sendResponse(exchange, "Method Not Allowed", 405, "text/plain");
        }
    }

    private void handleGet(HttpExchange exchange) throws IOException {
        List<University> list = universityDAO.getAllUniversities();
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            University u = list.get(i);
            json.append(String.format("{\"id\":%d, \"name\":\"%s\", \"rank\":%d}",
                    u.getId(), u.getUniversityName(), u.getWorldRanking()));
            if (i < list.size() - 1) json.append(",");
        }
        json.append("]");
        sendResponse(exchange, json.toString(), 200, "application/json");
    }

    private void handlePost(HttpExchange exchange) throws IOException {
        String[] p = getRequestBody(exchange).split(",");
        universityDAO.addUniversity(new University(p[0], p[1], Integer.parseInt(p[2]), Integer.parseInt(p[3])));
        sendResponse(exchange, "Created", 201, "text/plain");
    }

    private void handlePut(HttpExchange exchange) throws IOException {
        String[] p = getRequestBody(exchange).split(",");
        universityDAO.updateRanking(p[0], Integer.parseInt(p[1]));
        sendResponse(exchange, "Updated", 200, "text/plain");
    }

    private void handleDelete(HttpExchange exchange, String path) throws IOException {
        String name = path.substring(path.lastIndexOf("/") + 1);
        universityDAO.deleteUniversity(name);
        sendResponse(exchange, "Deleted", 200, "text/plain");
    }
}