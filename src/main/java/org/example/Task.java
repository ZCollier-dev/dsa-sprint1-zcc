package org.example;

public class Task {
    private String description;
    private boolean isDone = false;

    public Task(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
    public boolean getDoneStatus(){
        return this.isDone;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public void setDoneStatus(boolean isDone){
        this.isDone = isDone;
    }

    public String toString(){
        String returnString = this.description + ": ";

        if (this.isDone){
            returnString += "Done! :)";
        } else {
            returnString += "Not Done.";
        }

        return returnString;
    }
}
