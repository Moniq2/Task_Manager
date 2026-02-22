package service;
import model.Task;
import exceptions.*;
import java.util.ArrayList;

public class TaskSystem {
    public ArrayList<Task> taskList = new ArrayList<>();
    
    int id = 1;
    public void addTask(String taskName) throws IllegalArgumentException{
        Task task = new Task(taskName);
        task.id = id++;
        taskList.add(task);
    }

    public Task findTaskByID(int id) throws TaskNotFoundException {
        for (Task task : taskList) {
            if (task.id == id) {
                return task;
            }
        }
        throw new TaskNotFoundException(id);
    }
        
    public void removeTask(int id) throws TaskNotFoundException {
        if (taskList.isEmpty()) {
            System.out.println("It is not possible to remove any task as the list is empty!");
        }

        Task task = findTaskByID(id);
        taskList.remove(task);
    }

    public void checkTask(int id) throws TaskNotFoundException {
        findTaskByID(id).concluded = true;
    }

    public void resetList(){
        taskList.clear();
    }
}