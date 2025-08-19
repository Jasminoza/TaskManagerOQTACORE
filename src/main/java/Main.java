
public class Main {

    /**
     * Необходимо отвести свою ветку от main.
     * <p>
     * Напишите классы для управления списком задач (TaskManager).
     * <p>
     *
     * <br>
     * Требования:
     * <p>
     * 1) Не может быть задач с одинаковыми идентификаторами.
     * <p>
     * 2) Каждая задача (Task) имеет:
     * <p> уникальный идентификатор (int id), описание (String description), статус (enum Status: NEW, IN_PROGRESS, DONE).
     * <p>
     * 3) Класс Task с полями, конструктором со всеми полями, геттерами и сеттерами.
     * <p>
     * 4) Enum Status с тремя значениями: NEW, IN_PROGRESS, DONE.
     * <p>
     * 5) Класс TaskManager с методами:
     * <p>
     * void addTask(Task task) — добавить задачу.
     * <p>
     * Task getTaskById(int id) — получить задачу по ID.
     * <p>
     * List<Task> getTasksByStatus(Status status) — вернуть список задач с указанным статусом.
     * <p>
     * void updateStatus(int id, Status status) — обновить статус задачи по ID.
     * <p>
     * 6) Методы должны выбрасывать ошибки в необходимых случаях (но не возвращать null).
     * <p>
     * 7) Напишите тесты для метода addTask().
     */

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

