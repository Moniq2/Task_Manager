package service;
import model.Task;
import exceptions.*;
import java.util.ArrayList;
import java.util.List;

public class TaskSystem {
    private ArrayList<Task> taskList = new ArrayList<>();
    private int id = 1;

    public List<Task> getTaskList() {
        return taskList;
    }

    public boolean isConcluded(Task task){
        if (task.getConcluded()) {
            return true;
        } else {
            return false;
        }
    }

    public void addTask(String taskName) throws IllegalArgumentException{
        Task task = new Task(taskName);
        task.setId(id++);
        taskList.add(task);
    }

    public Task findTaskByID(int id) throws TaskNotFoundException {
        for (Task task : taskList) {
            if (task.getId() == id) {
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
        findTaskByID(id).setConcluded(true);
    }

    public void resetList(){
        taskList.clear();
    }
}