package UI;
import service.*;
import java.util.Scanner;

import model.Task;

public class Menu {
    TaskSystem tSystem = new TaskSystem();

    public void showTasks() {
        int i = 1;
        for (Task task : tSystem.TaskList) {
            
            if (task.concluded) {
                System.out.println(i + "ID: " + task.id + " " + task.name + "(X)");
            }
            else {
                System.out.println(i + "ID: " +task.id + " " + task.name + "( )");
            }
            i++;
        }
    }

    public void start() {
        
        Scanner scan = new Scanner(System.in);
        int opt;
        System.out.println("------- Task Manager -------\n");

        do {
            System.out.println("Choose an option: \n1 - Add new task \n2 - Mark task as completed \n3 - Delete task \n4 - Clear list \n5 - Exit");
            opt = scan.nextInt();
            scan.nextLine();

            String c; //Variável pra controlar o Do While dentro do switch.
            int index;

            if (opt > 5 || opt < 1) {
                System.out.println("Please choose a valid option.");
            }

            switch (opt) {
                case 1:
                    do {
                        System.out.println("New task name: \n");
                        String name = scan.nextLine();
                        tSystem.addTask(name);
                        System.out.println("Do you want to add another task?: \nYes(y) No(n)\n");
                        c = scan.nextLine();
                    } while (c.contains("y") || c.contains("Y"));
                    showTasks(); 
                    break;

                case 2:
                    do {
                        System.out.println("Task number to mark as completed: \n");
                        index = scan.nextInt();
                        scan.nextLine();
                        tSystem.checkTask(index);
                        System.out.println("Do you want to mark another task as completed?: \nYes(y) No(n)");
                        c = scan.nextLine();
                        
                    } while (c.contains("y") || c.contains("Y"));
                    showTasks(); 
                    break;
                
                case 3:
                    do {
                        System.out.println("Type the ID of the task you want to remove: ");
                        int id = scan.nextInt();
                        tSystem.removeTask(id);
                        scan.nextLine();
                        
                        showTasks(); 
                        System.out.println("Do you want to remove another task?: \nYes(y) No(n)");
                        c = scan.nextLine();

                    } while (c.contains("y") || c.contains("Y"));
                    
                    break;
                
                case  4:
                    tSystem.resetList();
                    System.out.println("List reseted.");
                
                default:
                    break;
            }
        } while (opt != 5);
        scan.close();
    }
}
