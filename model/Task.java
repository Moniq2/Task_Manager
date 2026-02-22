package model;

public class Task {
    private String name;
    public Boolean concluded = false;
    public int id;

    public String getName(){
        return name;
    }

    public Task(String name) throws IllegalArgumentException{
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Cannot create task with empty name!!\n");
        }
        else {
            this.name = name;
        }
    }
}
