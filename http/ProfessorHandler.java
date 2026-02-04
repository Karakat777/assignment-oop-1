package http;
import database.ProfessorDAO;
import models.Professor;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.util.List;
import java.util.Map;
public class ProfessorHandler extends BaseHandler {
    private final ProfessorDAO professorDAO = new ProfessorDAO();
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
                    sendResponse(exchange, "Метод не поддерживается", 405, "text/plain");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sendResponse(exchange, "Ошибка: " + e.getMessage(), 500, "text/plain");
        }
    }
    private void handleGet(HttpExchange exchange) throws IOException {
        List<Professor> list = professorDAO.getTenuredProfessors();
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            Professor p = list.get(i);
            json.append(String.format("{\"id\":%d,\"name\":\"%s\",\"spec\":\"%s\",\"exp\":%d,\"tenured\":%b}",
                    p.getId(), p.getName(), p.getSpecialty(), p.getYearsOfExperience(), p.isTenured()));
            if (i < list.size() - 1) json.append(",");
        }
        json.append("]");
        sendResponse(exchange, json.toString(), 200, "application/json");
    }
    private void handlePost(HttpExchange exchange) throws IOException {
        Map<String, String> params = parseFormData(getRequestBody(exchange));
        Professor prof = mapToProfessor(params);

        if (professorDAO.addProfessor(prof)) {
            sendResponse(exchange, "Профессор добавлен", 201, "text/plain");
        } else {
            sendResponse(exchange, "Ошибка БД", 500, "text/plain");
        }
    }
    private void handlePut(HttpExchange exchange) throws IOException {
        Map<String, String> params = parseFormData(getRequestBody(exchange));
        Professor prof = mapToProfessor(params);

        if (params.get("id") == null) {
            sendResponse(exchange, "ID обязателен", 400, "text/plain");
            return;
        }
        prof.setId(Integer.parseInt(params.get("id")));

        if (professorDAO.updateProfessor(prof)) {
            sendResponse(exchange, "Данные обновлены", 200, "text/plain");
        } else {
            sendResponse(exchange, "Профессор не найден", 404, "text/plain");
        }
    }
    private void handleDelete(HttpExchange exchange, String path) throws IOException {
        String idStr = path.substring(path.lastIndexOf("/") + 1);
        if (professorDAO.deleteProfessor(Integer.parseInt(idStr))) {
            sendResponse(exchange, "Удалено", 200, "text/plain");
        } else {
            sendResponse(exchange, "ID не найден", 404, "text/plain");
        }
    }
    private Professor mapToProfessor(Map<String, String> params) {
        String name = params.getOrDefault("name", "Unknown");
        String spec = params.getOrDefault("spec", "None");
        int exp = Integer.parseInt(params.getOrDefault("exp", "0"));
        boolean tenured = Boolean.parseBoolean(params.getOrDefault("tenured", "false"));
        return new Professor(name, spec, exp, tenured);
    }
}
