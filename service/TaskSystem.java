package service;
import model.Task;
import java.util.Scanner;
import java.util.ArrayList;

public class TaskSystem {
    public ArrayList<Task> TaskList = new ArrayList<>();
    
    int id = 100;

    public void addTask(String taskName) {
        Task task = new Task(taskName);
        task.id = id++;
        TaskList.add(task);
    }

    public void removeTask(int id) {
        Task aux = null;
        for (Task task : TaskList) {
            if (task.id == id) {
                aux = task;
            }
        }
        if (aux == null) {
            return;
        }
        TaskList.remove(aux);
    } 

    public void checkTask(int n){
        TaskList.get(n - 1).concluded = true;
    }

    public void resetList(){
        TaskList.clear();
    }
}