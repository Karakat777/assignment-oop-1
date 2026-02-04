package http;
import database.CourseDAO;
import models.Course;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
public class CourseHandler extends BaseHandler {
    private final CourseDAO courseDAO = new CourseDAO();
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();
        try {
            switch (method) {
                case "GET":    handleGet(exchange); break;
                case "POST":   handlePost(exchange); break;
                case "DELETE": handleDelete(exchange, path); break;
                default:
                    sendResponse(exchange, "Method Not Allowed", 405, "text/plain");
            }
        } catch (Exception e) {
            sendResponse(exchange, "Error: " + e.getMessage(), 500, "text/plain");
        }
    }
    private void handleGet(HttpExchange exchange) throws IOException {
        List<Course> list = courseDAO.getAllCourses();
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            Course c = list.get(i);
            json.append(String.format("{\"id\":%d,\"code\":\"%s\",\"name\":\"%s\",\"credits\":%d,\"type\":\"%s\"}",
                    c.getId(), c.getCourseCode(), c.getCourseName(), c.getCredits(), c.getCourseType()));
            if (i < list.size() - 1) json.append(",");
        }
        json.append("]");
        sendResponse(exchange, json.toString(), 200, "application/json");
    }
    private void handlePost(HttpExchange exchange) throws IOException {
        Map<String, String> params = parseFormData(getRequestBody(exchange));

        String code = params.get("code");
        String name = params.get("name");
        int credits = Integer.parseInt(params.getOrDefault("credits", "0"));
        String type = params.getOrDefault("type", "General");

        if (code != null && name != null) {
            Course newCourse = new Course(code, name, credits, 0, type);
            if (courseDAO.addCourse(newCourse)) {
                sendResponse(exchange, "Course Added Successfully", 201, "text/plain");
                return;
            }
        }
        sendResponse(exchange, "Invalid Data or DB Error", 400, "text/plain");
    }
    private void handleDelete(HttpExchange exchange, String path) throws IOException {
        String code = path.substring(path.lastIndexOf("/") + 1);
        String decodedCode = URLDecoder.decode(code, StandardCharsets.UTF_8);

        if (courseDAO.deleteCourse(decodedCode)) {
            sendResponse(exchange, "Course Deleted", 200, "text/plain");
        } else {
            sendResponse(exchange, "Course Not Found", 404, "text/plain");
        }
    }
}
