package controller;
import model.*;
import exceptions.TaskNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TaskSystem {
    private ArrayList<Task> taskList = new ArrayList<>();
    private int id = 1;

    public List<Task> getTaskList() {
        return taskList;
    }

    public void addTask(String taskName, Boolean priority) throws IllegalArgumentException{ //Adds new task
        Task task;
        if (priority) {
            task = new PriorityTask(taskName);
        }
        else {
            task = new Task(taskName);
        }
        task.setId(id++);
        taskList.add(task);
    }

    public Task findTaskByID(int id) throws TaskNotFoundException { //Find task using id given by user
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new TaskNotFoundException(id);
    }
        
    public void removeTask(int id) throws TaskNotFoundException { //remove task
        if (taskList.isEmpty()) {
            System.out.println("It is not possible to remove any task as the list is empty!");
        }

        Task task = findTaskByID(id);
        taskList.remove(task);
    }

    public boolean isConcluded(Task task){ //Checks if a task is concluded.
        if (task.getConcluded()) {
            return true;
        } else {
            return false;
        }
    }

    public void checkTask(int id) throws TaskNotFoundException { //Marks task as concluded
        findTaskByID(id).setConcluded(true); 
    }

    public void resetList(){ //Resets the tasks array list
        taskList.clear();
    }
}