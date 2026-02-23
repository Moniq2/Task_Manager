package UI;
import controller.TaskSystem;
import model.Task;
import model.priorityTask;
import utils.SafeInput;
import java.util.Scanner;
import exceptions.TaskNotFoundException;

public class Menu {
    TaskSystem taskSystem = new TaskSystem();
    SafeInput inputService = new SafeInput();

    public void showTasks() {
        System.out.println("\n--TASK LIST--\n");
        for (Task task : taskSystem.getTaskList()) {
            
            if (taskSystem.isConcluded(task)) {
                System.out.println("(X)" + task.getName() + "\nID: " + task.getId());
            }
            else {
                System.out.println("( )" + task.getName() + " ID: " + task.getId());
            }

            if (task instanceof priorityTask) {
                System.out.println("[PRIORITY!]");
            }
        }
    }

    private boolean askContinue(Scanner scan) {
        String choice = scan.nextLine();
        return choice.contains("y") || choice.contains("Y");
    }

    public void start() {  

        //Variables
        Scanner scan = new Scanner(System.in);
        int option; //Controls the switch.
        int id; //Store received id

        System.out.println("------- Task Manager -------");

        do {
            System.out.println("\n1 - Add new task \n2 - Mark task as completed \n3 - Delete task \n4 - Clear list \n5 - Exit\nChoose an option: ");
            option = inputService.readInt();

            if (option > 5 || option < 1) {
                System.out.println("Please choose a valid option.");
            }

            switch (option) {
                case 1:
                    do {
                        System.out.println("New task name: ");
                        String name = scan.nextLine();

                        System.out.println("Mark as high priority? (y/N)");
                        String opt = scan.nextLine();
                        Boolean priority = false;
                        if (opt.toLowerCase().contains("y")) {
                            priority = true;
                        } 
                      
                        try {
                            taskSystem.addTask(name, priority);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        
                        System.out.println("Do you want to add another task?: \nYes(y) No(n)\n");
                    } while (askContinue(scan));
                    showTasks(); 
                    break;

                case 2:
                    do {
                        System.out.println("Type the id of the task you want to mark as completed: \n");
                        id = inputService.readInt();

                        try {
                            taskSystem.checkTask(id);
                        } catch (TaskNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        
                        System.out.println("\nDo you want to mark another task as completed?: \nYes(y) No(n)");
                    } while (askContinue(scan));
                    showTasks(); 
                    break;
                
                case 3:
                    do {
                        System.out.println("\nType the ID of the task you want to remove: ");
                        id = inputService.readInt();
    
                        try {
                            taskSystem.removeTask(id);
                            System.out.println("Task removed!");
                        } catch (TaskNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        
                        System.out.println("\nDo you want to remove another task?: \nYes(y) No(n)");
                    } while (askContinue(scan));
                    showTasks();
                    break;
                
                case  4:
                    taskSystem.resetList();
                    System.out.println("List reseted.\n");
                
                default:
                    break;
            }
        } while (option != 5);
        scan.close();
        inputService.close();
    }
}
