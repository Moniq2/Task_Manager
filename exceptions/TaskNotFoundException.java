package exceptions;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(int id) {
        super("Task with id " + id + " not found.\n");
    }
}

