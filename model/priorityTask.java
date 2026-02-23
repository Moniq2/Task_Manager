package model;

public class priorityTask extends Task{
    private Boolean priority = true;

    public priorityTask(String name){
        super(name);
    }

    public Boolean getPriority() {
        return priority;
    }
}
