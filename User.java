import java.util.HashMap;
import java.util.Map;

public class User {
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, String> roles = new HashMap<>(); // Store roles separately (student/admin)

    // Handle Registration
    public static String handleRegistration(String formData) {
        Map<String, String> params = parseFormData(formData);

        String username = params.get("username");
        String password = params.get("password");
        String role = params.get("role");

        if (username == null || password == null || role == null) {
            return "Registration failed. Missing data.";
        }

        users.put(username, password);
        roles.put(username, role);
        return "Registration successful for " + username + " as " + role + ".";
    }

    // Handle Login
    public static String handleLogin(String formData) {
        Map<String, String> params = parseFormData(formData);

        String username = params.get("username");
        String password = params.get("password");

        if (users.containsKey(username) && users.get(username).equals(password)) {
            String role = roles.get(username);
            if ("student".equals(role)) {
                return "Login successful! Welcome, Student!";
            } else if ("admin".equals(role)) {
                return "Login successful! Welcome, Admin!";
            }
        }
        return "Login failed. Invalid username or password.";
    }

    // Parse Form Data
    private static Map<String, String> parseFormData(String formData) {
        Map<String, String> params = new HashMap<>();
        String[] pairs = formData.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                params.put(keyValue[0], keyValue[1]);
            }
        }
        return params;
    }
}
