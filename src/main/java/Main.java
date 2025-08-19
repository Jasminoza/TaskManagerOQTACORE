
public class Main {

    /**
     * Напишите классы для управления списком задач (TaskManager).
     * <p>
     * Каждая задача (Task) имеет:
     * <p>
     * уникальный идентификатор (int id), описание (String description), статус (enum Status: NEW, IN_PROGRESS, DONE).
     * <p>
     * Требования:
     * <p>
     * 1) Класс Task с полями, конструктором, геттерами и сеттерами.
     * <p>
     * 2) Enum Status с тремя значениями: NEW, IN_PROGRESS, DONE.
     * <p>
     * 3) Класс TaskManager с методами:
     * <p>
     * void addTask(Task task) — добавить задачу.
     * <p>
     * Task getTaskById(int id) — получить задачу по ID.
     * <p>
     * List<Task> getTasksByStatus(Status status) — вернуть список задач с указанным статусом.
     * <p>
     * void updateStatus(int id, Status status) — обновить статус задачи по ID.
     * <p>
     * Все ошибки в данных должны выбрасывать исключения. Напишите тесты для метода addTask().
     */

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

