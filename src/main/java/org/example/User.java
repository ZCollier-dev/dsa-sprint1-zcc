package org.example;

public class User {
    private String userName;
    private TaskList taskList;

    public User(String userName, Task firstTask){
        this.userName = userName;
        this.taskList = new TaskList(firstTask);
    }

    public String getUserName(){
        return this.userName;
    }

    public void addTask(Task task){
        this.taskList.addTask(task);
    }

    public void setAsComplete(int locationIndex){
        this.taskList.setAsComplete(locationIndex);
    }

    public String toString(){
        String returnString = "Hello " + this.userName + "! Here's your to-do list:\n";
        returnString += this.taskList.toString();
        return returnString;
    }
}
