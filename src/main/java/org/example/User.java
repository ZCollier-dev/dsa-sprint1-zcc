package org.example;


//Includes methods to add a task, mark a task as completed, and print all tasks.

public class User {
    private String userName;
    private TaskList taskList;

    public User(String userName, Task firstTask){
        this.userName = userName;
        this.taskList = new TaskList(firstTask);
    }
}
