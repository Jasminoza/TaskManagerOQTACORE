import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskManagerTest {

    TaskManager taskManager = new TaskManagerImpl();

    @BeforeEach
    void setUp() {
        taskManager.getAllTasks().clear();
    }

    @Test
    void testAddTaskDoesNotTrowsException() {
        int id = 1;
        String description = "This is a test";
        Status status = Status.NEW;
        Task task = new Task(id, description, status);
        taskManager.addTask(task);

        assertEquals(1, taskManager.getAllTasks().size());
        Task result = taskManager.getAllTasks().get(0);
        assertEquals(task, result);
        assertEquals(id, result.getId());
        assertEquals(description, result.getDescription());
        assertEquals(status, result.getStatus());
    }

    @Test
    void testAddTaskTrowsExceptionIfAlreadyExists() {
        int id = 1;
        String description = "This is a test";
        Status status = Status.NEW;
        Task task = new Task(id, description, status);
        taskManager.addTask(task);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> taskManager.addTask(task));
        assertEquals("Task already exists", exception.getMessage());
        assertEquals(1, taskManager.getAllTasks().size());
        assertEquals(task, taskManager.getAllTasks().get(0));
        assertEquals(id, task.getId());
        assertEquals(description, task.getDescription());
        assertEquals(status, task.getStatus());
    }

    @Test
    void testAddTaskTrowsExceptionIfTaskIsNull() {
        assertThrows(IllegalArgumentException.class, () -> taskManager.addTask(null));
    }

    @Test
    void testGetTaskByIdReturnsTask() {
        Task task4 = new Task(4, "Test4", Status.NEW);
        taskManager.addTask(task4);
        assertEquals(task4, taskManager.getTaskById(4));
    }

    @Test
    void testGetTaskByIdNotFound() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> taskManager.getTaskById(99));
        assertEquals("No task with id '99' was found", exception.getMessage());
    }

    @Test
    void testGetTasksByStatusReturnsTasks() {
        Task task5 = new Task(5, "Test5", Status.NEW);
        Task task6 = new Task(6, "Test6", Status.NEW);
        Task task7 = new Task(7, "Test7", Status.IN_PROGRESS);
        taskManager.addTask(task5);
        taskManager.addTask(task6);
        taskManager.addTask(task7);

        List<Task> result = taskManager.getTasksByStatus(Status.NEW);
        List<Task> allTasks = taskManager.getAllTasks();

        assertEquals(3, allTasks.size());
        assertEquals(2, result.size());
        assertEquals(task5, result.get(0));
        assertEquals(task6, result.get(1));
    }

    @Test
    void testGetTasksByStatusReturnsEmptyList() {
        List<Task> result = taskManager.getTasksByStatus(Status.NEW);
        List<Task> allTasks = taskManager.getAllTasks();

        assertNotNull(allTasks);
        assertNotNull(result);
        assertEquals(0, allTasks.size());
        assertEquals(0, result.size());
    }

    @Test
    void testGetTasksByStatusReturnsEmptyListIfNull() {
        List<Task> allTasks = taskManager.getAllTasks();
        assertNotNull(allTasks);
        assertEquals(0, allTasks.size());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> taskManager.getTasksByStatus(null));
        assertEquals("Status cannot be null", exception.getMessage());
    }

    @Test
    void testUpdateStatus() {
        Task task8 = new Task(8, "Test8", Status.NEW);
        taskManager.addTask(task8);
        assertEquals(1, taskManager.getAllTasks().size());
        assertEquals(Status.NEW, taskManager.getTaskById(8).getStatus());

        taskManager.updateStatus(8, Status.IN_PROGRESS);

        assertEquals(1, taskManager.getAllTasks().size());
        assertEquals(Status.IN_PROGRESS, taskManager.getTaskById(8).getStatus());
    }

    @Test
    void testUpdateStatusThrowsExceptionIfStatusIsNull() {
        Task task8 = new Task(8, "Test8", Status.NEW);
        taskManager.addTask(task8);
        assertEquals(1, taskManager.getAllTasks().size());
        assertEquals(Status.NEW, taskManager.getTaskById(8).getStatus());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> taskManager.updateStatus(8, null));
        assertEquals("Status cannot be null", exception.getMessage());
    }

    @Test
    void testUpdateStatusThrowsExceptionIfTaskNotFound() {
        assertEquals(0, taskManager.getAllTasks().size());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> taskManager.updateStatus(99, Status.IN_PROGRESS));
        assertEquals("No task with id '99' was found", exception.getMessage());
    }

    @Test
    void testEquals() {
        int id = 1;
        String description = "test1";
        Status status = Status.NEW;
        Task forSaving = new Task(id, description, status);
        Task expected = new Task(id, description, status);

        taskManager.addTask(forSaving);

        Task actual = taskManager.getTaskById(id);

        assertEquals(expected, actual);
    }
}