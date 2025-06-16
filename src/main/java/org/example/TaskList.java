package org.example;

import org.example.linkedlist.SingleLinkedList;

//Includes methods to add a task, mark a task as completed, and print all tasks.

public class TaskList {
    private SingleLinkedList taskList;

    public TaskList(Task firstTask){
        this.taskList.createSingleLinkedlist(firstTask);
    }

    public void addTask(Task task){
        this.taskList.insertLinkedList(task, this.taskList.getSize());
    }

    public void setAsComplete(int locationIndex){
        taskList.searchNode(locationIndex).value.setDoneStatus(true);
    }

    public String toString(){
        return taskList.traverseLinkedList();
    }
}
