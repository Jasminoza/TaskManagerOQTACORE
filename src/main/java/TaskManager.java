import java.util.List;

public class TaskManager {
    void addTask(Task task);
    Task getTaskById(int id);
    List<Task> getTasksByStatus(Status status);
    void updateStatus(int id, Status status);
    List<Task> getAllTasks();
}
