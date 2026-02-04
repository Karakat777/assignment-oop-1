package http;
import database.UniversityDAO;
import models.University;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
public class UniversityHandler extends BaseHandler {
    private final UniversityDAO universityDAO = new UniversityDAO();
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();
        try {
            switch (method) {
                case "GET":    handleGet(exchange); break;
                case "POST":   handlePost(exchange); break;
                case "PUT":    handlePut(exchange); break;
                case "DELETE": handleDelete(exchange, path); break;
                default:
                    sendResponse(exchange, "Method Not Allowed", 405, "text/plain");
            }
        } catch (Exception e) {
            sendResponse(exchange, "Error: " + e.getMessage(), 500, "text/plain");
        }
    }
    private void handleGet(HttpExchange exchange) throws IOException {
        List<University> list = universityDAO.getAllUniversities();
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            University u = list.get(i);
            json.append(String.format("{\"id\":%d, \"name\":\"%s\", \"location\":\"%s\", \"rank\":%d, \"students\":%d}",
                    u.getId(), u.getUniversityName(), u.getLocation(), u.getWorldRanking(), u.getTotalStudents()));
            if (i < list.size() - 1) json.append(",");
        }
        json.append("]");
        sendResponse(exchange, json.toString(), 200, "application/json");
    }
    private void handlePost(HttpExchange exchange) throws IOException {
        Map<String, String> params = parseFormData(getRequestBody(exchange));
        String name = params.get("name");
        String location = params.get("location");
        int rank = Integer.parseInt(params.getOrDefault("rank", "0"));
        int students = Integer.parseInt(params.getOrDefault("students", "0"));
        if (universityDAO.addUniversity(new University(name, location, rank, students))) {
            sendResponse(exchange, "Created", 201, "text/plain");
        } else {
            sendResponse(exchange, "Failed to add university", 500, "text/plain");
        }
    }
    private void handlePut(HttpExchange exchange) throws IOException {
        Map<String, String> params = parseFormData(getRequestBody(exchange));
        universityDAO.updateRanking(params.get("name"), Integer.parseInt(params.get("rank")));
        sendResponse(exchange, "Updated", 200, "text/plain");
    }
    private void handleDelete(HttpExchange exchange, String path) throws IOException {
        String name = path.substring(path.lastIndexOf("/") + 1);
        String decodedName = URLDecoder.decode(name, StandardCharsets.UTF_8);
        if (universityDAO.deleteUniversity(decodedName)) {
            sendResponse(exchange, "Deleted", 200, "text/plain");
        } else {
            sendResponse(exchange, "Not Found", 404, "text/plain");
        }
    }
}