import java.util.HashMap;
import java.util.Map;

public class EntryPoint {
    private static Map<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        // Example test with a sample student
        String studentName = "John Doe";
        String subject = "Mathematics";
        registerUser(studentName, subject);
        
        // Simulating the preliminary exam
        int score = startPreliminaryExam(new int[]{12, 8, 100}, new String[]{"New Delhi", "Shakespeare"});
        System.out.println("Student's Exam Score: " + score + "/5");

        // Display student dashboard
        displayDashboard(studentName);
    }

    public static void registerUser(String name, String subject) {
        Student student = new Student(name, subject);
        students.put(name, student);
        System.out.println("Registered: " + name + " for subject " + subject);
    }

    public static int startPreliminaryExam(int[] numericAnswers, String[] textAnswers) {
        int score = 0;

        // Simple exam questions (for testing)
        if (numericAnswers[0] == 12) score++;
        if (textAnswers[0].equalsIgnoreCase("New Delhi")) score++;
        if (numericAnswers[1] == 8) score++;
        if (textAnswers[1].equalsIgnoreCase("Shakespeare")) score++;
        if (numericAnswers[2] == 100) score++;

        return score;
    }

    public static void displayDashboard(String studentName) {
        Student student = students.get(studentName);
        if (student != null) {
            System.out.println("Student Dashboard:");
            System.out.println("Name: " + student.getName());
            System.out.println("Subject: " + student.getSubject());
            System.out.println("Exam Result: " + (student.getExamResult() == null ? "No exams taken yet" : student.getExamResult()));
        } else {
            System.out.println("No student found.");
        }
    }
}

class Student {
    private String name;
    private String subject;
    private String examResult;

    public Student(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getExamResult() {
        return examResult;
    }

    public void setExamResult(String examResult) {
        this.examResult = examResult;
    }
}
