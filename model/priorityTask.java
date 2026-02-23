package model;

public class PriorityTask extends Task{
    private Boolean priority = true;

    public PriorityTask(String name){
        super(name);
    }

    public Boolean getPriority() {
        return priority;
    }
}
