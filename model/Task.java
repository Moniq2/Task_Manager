package model;

public class Task {
    private String name;
    private Boolean concluded = false;
    private Boolean priority = true;
    private int id;

    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    public Boolean getConcluded() {
        return concluded;
    }

    public Boolean getPriority() {
        return priority;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public void setConcluded(Boolean concluded) {
        this.concluded = concluded;
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
